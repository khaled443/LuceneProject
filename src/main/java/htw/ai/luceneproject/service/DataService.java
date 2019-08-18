/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package htw.ai.luceneproject.service;

import htw.ai.luceneproject.model.TCaseIcd;
import htw.ai.luceneproject.model.TCaseDepartment;
import htw.ai.luceneproject.model.TCase;
import htw.ai.luceneproject.model.TCaseOps;
import htw.ai.luceneproject.model.TCaseDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author Khaled Halabieh
 */
public enum DataService {
    //Making Singletons With Enum in Java
    //Since enums are inherently serializable, we don't need to implement it with a serializable interface.
    INSTANCE;

    List<Fall> falls = new ArrayList<Fall>();
    int FilteredFallSize = 0;

    EntityManagerFactory emff;

    /**
     * get Patients cases either from Database or from Hibernate Index, it
     * depends on wither the request is with filters or not.
     *
     * @param start int
     * @param size int
     * @param filters filters
     * @return List<Fall>
     */
    public List<Fall> getFallsList(int start, int size, Map<String, Object> filters) {

        List<Fall> falls = new ArrayList<Fall>();
        long startTime = System.currentTimeMillis();
        if ((filters != null && filters.size() > 1) || (filters.size() == 1 && !filters.get("globalFilter").equals(""))) {
            System.out.println("yess its empty");
            falls = getListfromLucene(start, size, filters);
        } else {
            falls = getResultsFromDatabase(start, size);

        }
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000F;
        System.out.println("-***TOTAL time (search + createObjects) ********");
        System.out.println(sec + " seconds");
        System.out.println("*****************************");
        return falls;
    }

    /**
     * count patents cases from Database
     *
     * @return int
     */
    public int getFallsTotalCount() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select count(*) From TCase t");
        int size = ((Long) query.getSingleResult()).intValue();
        em.close();
        return size;

    }

    /**
     * get results from Database
     *
     * @param start int
     * @param size int
     * @return List<Fall>
     */
    private List<Fall> getResultsFromDatabase(int start, int size) {

        EntityManager em = getEntityManager();
        TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
        query.setFirstResult(start);
        query.setMaxResults(size);
        long startTime = System.currentTimeMillis();
        Collection<TCase> tcases = query.getResultList();
        createFallsObjects(tcases);
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000F;
        Logger.getLogger(DataService.class.getName()).log(Level.INFO,
                "Time it took to get Results: " + sec + " Seconds");
        em.close();
        return falls;
    }

    /**
     * get results from Lucene index
     *
     * @param start int
     * @param size int
     * @param filters filters
     * @return List<Fall>
     */
    private List<Fall> getListfromLucene(int start, int size, Map<String, Object> filters) {

        EntityManager em = getEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        /**
         * create native Lucene query unsing the query DSL alternatively you can
         * write the Lucene query using the Lucene query parser or the Lucene
         * programmatic API. The Hibernate Search DSL is recommended though
         */

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        LinkedHashSet<org.apache.lucene.search.Query> filterQueries = new LinkedHashSet<>();

        //filters
        filters.entrySet().stream().map((entry) -> {
            //globalFilter
            if (entry.getKey().equals("globalFilter") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getGlobalSearchQuery(qb, entry));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("cs_case_number") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getAutocompleteQuery(qb, entry, "csCaseNumber"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("insurance_identifier") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getAutocompleteQuery(qb, entry, "insuranceIdentifier"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("insurance_number_patient") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getAutocompleteQuery(qb, entry, "insuranceNumberPatient"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("hd_icd_code") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getAutocompleteQuery(qb, entry, "tCaseDetailsCollection.hdIcdCode"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("parseInt(fall.age_years)") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getIntegerQuery(qb, entry, "tCaseDetailsCollection.ageYears"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("admission_date") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getDateQuery(qb, entry, "tCaseDetailsCollection.admissionDate"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("pat_number") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getAutocompleteQuery(qb, entry, "tPatientId.patNumber"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("pat_first_name") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tPatientId.patFirstName"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("icdcCode") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getSimpleQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdCode"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("ICD_DESCRIPTION") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdDescription"));
            }
            return entry;
        }).map((entry) -> {
            if (entry.getKey().equals("opscCode") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getSimpleQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsCode"));
            }
            return entry;
        }).filter((entry) -> (entry.getKey().equals("OPS_DESCRIPTION") && !entry.getValue().toString().isEmpty())).forEachOrdered((entry) -> {
            filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsDescription"));
        });
        BooleanQuery bq;
        bq = new BooleanQuery();
        if (filterQueries.size() > 0) {
            for (org.apache.lucene.search.Query query : filterQueries) {
                bq.add(new BooleanClause(query, BooleanClause.Occur.MUST));
            }

            // wrap Lucene query in a javax.persistence.Query
            FullTextQuery jpaQuery
                    = fullTextEntityManager.createFullTextQuery(bq, TCase.class)
                            .setFirstResult(start)
                            .setMaxResults(size);

            setFilteredFallSize(jpaQuery.getResultSize());

            // execute search
            long startTime = System.currentTimeMillis();
            Collection<TCase> result = jpaQuery.getResultList();
            createFallsObjects(result);
            long endTime = System.currentTimeMillis();

            float sec = (endTime - startTime) / 1000F;
            Logger.getLogger(DataService.class.getName()).log(Level.INFO,
                    "Time it took to get Results: " + sec + " Seconds");
        }

        em.close();

        return falls;
    }

    /**
     * Get Patients information from Database and create Fall object
     *
     * @param tCases Collection<TCase>, the results from Hibernate Index
     */
    private void createFallsObjects(Collection<TCase> tCases) {
        falls.clear();

        for (TCase tcase : tCases) {
            //Tcase
            Fall fall = new Fall();
            fall.setCs_case_number(tcase.getCsCaseNumber());
            fall.setInsurance_identifier(tcase.getInsuranceIdentifier());
            fall.setInsurance_number_patient(tcase.getInsuranceNumberPatient());

            //TCaseDetails
            LinkedHashSet<String> hdIcdCode = new LinkedHashSet<String>();
            LinkedHashSet<Integer> age_years = new LinkedHashSet<Integer>();
            LinkedHashSet<Date> admisstion_date = new LinkedHashSet<Date>();

            LinkedHashSet<String> icds = new LinkedHashSet<String>();
            LinkedHashSet<String> opss = new LinkedHashSet<String>();

            LinkedHashSet<String> icdDescriptions = new LinkedHashSet<String>();
            LinkedHashSet<String> opsDescriptions = new LinkedHashSet<String>();

            for (TCaseDetails tcaseDestailse : tcase.getTCaseDetailsCollection()) {
                hdIcdCode.add(tcaseDestailse.getHdIcdCode());
                age_years.add(tcaseDestailse.getAgeYears());
                admisstion_date.add(tcaseDestailse.getAdmissionDate());

                for (TCaseDepartment tdepartment : tcaseDestailse.getTCaseDepartmentCollection()) {

                    for (TCaseIcd icdCode : tdepartment.getTCaseIcdCollection()) {
                        icds.add(icdCode.getIcdcCode().getIcdCode());
                        icdDescriptions.add(icdCode.getIcdcCode().getIcdDescription());
                    }
                    for (TCaseOps opsCode : tdepartment.getTCaseOpsCollection()) {
                        opss.add(opsCode.getOpscCode().getOpsCode());
                        opsDescriptions.add(opsCode.getOpscCode().getOpsDescription());
                    }
                }

            }
            try {

                fall.setHd_icd_code(hdIcdCode);
                fall.setAge_years(age_years);
                fall.setAdmisstion_date(admisstion_date);

                //TPatient
                fall.setPat_number(tcase.getTPatientId().getPatNumber());
                fall.setPat_first_name(tcase.getTPatientId().getPatFirstName());
                fall.setIcdcCode(icds);
                fall.setOpscCode(opss);
                fall.setICD_DESCRIPTION(icdDescriptions);
                fall.setOPS_DESCRIPTION(opsDescriptions);
            } catch (Exception e) {
                Logger.getLogger(DataService.class.getName()).log(Level.WARNING, e.getMessage());

            }
            falls.add(fall);

        }
    }

    public int getFilteredFallSize() {
        return FilteredFallSize;
    }

    public void setFilteredFallSize(int FilteredFallSize) {
        this.FilteredFallSize = FilteredFallSize;
    }

    /**
     * create new Entity manager factory when its Null
     *
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        if (emff == null) {
            emff
                    = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
        }

        return emff.createEntityManager();
    }

}
