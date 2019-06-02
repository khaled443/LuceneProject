/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import com.luceneproject.pojo.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author kk
 */
public enum DataService {
    //Making Singletons With Enum in Java
    //Since enums are inherently serializable, we don't need to implement it with a serializable interface.
    INSTANCE;

    List<Fall> falls = new ArrayList<Fall>();
    int FilteredFallSize = 0;

    EntityManagerFactory emff;
    

    
    
    
//    private  EntityManagerFactory emf
//            = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
//    
//    @Inject
//    DataService(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//    
//   @PersistenceContext(unitName="com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU" ) 
//    EntityManager wem;

    public List<Fall> getFallsList(int start, int size, Map<String, Object> filters) {

        List<Fall> falls = new ArrayList<Fall>();
        long startTime = System.currentTimeMillis();

        if (filters != null && filters.size() > 0) {
            falls = getListfromLucene(start, size, filters);
        } else {
            falls = getListFromeHibernate(start, size);

        }
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000F;
        System.out.println("-***TOTAL time (search + createObjects) ********");
        System.out.println(sec + " seconds");
        System.out.println("*****************************");
        return falls;
    }

    public int getFallsTotalCount() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select count(*) From TCase t");
        int size = ((Long) query.getSingleResult()).intValue();
        em.close();
        return size;

    }

    private List<Fall> getListFromeHibernate(int start, int size) {

        EntityManager em = getEntityManager();
//        EntityTransaction transaction = null;

//        transaction = em.getTransaction();
//        transaction.begin();
        TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
        query.setFirstResult(start);
        query.setMaxResults(size);
        Collection<TCase> tcases = query.getResultList();

//        transaction.commit();
        long startTime = System.currentTimeMillis();

        createFallsObjects(tcases);
        long endTime = System.currentTimeMillis();
        System.out.println("*******************");
        System.out.println("time took to create Fall Objects from Hibernate");
        float sec = (endTime - startTime) / 1000F;
        System.out.println(sec + " seconds");

        System.out.println("");
        em.close();

        return falls;
    }

    private List<Fall> getListfromLucene(int start, int size, Map<String, Object> filters) {

        EntityManager em = getEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
//        em.getTransaction().begin();

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        LinkedHashSet<org.apache.lucene.search.Query> filterQueries = new LinkedHashSet<>();

        //filters
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getKey().equals("cs_case_number") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "csCaseNumber"));
            }
            if (entry.getKey().equals("insurance_identifier") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "insuranceIdentifier"));
            }
            if (entry.getKey().equals("insurance_number_patient") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "insuranceNumberPatient"));
            }
            if (entry.getKey().equals("hd_icd_code") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "tCaseDetailsCollection.hdIcdCode"));
            }
            if (entry.getKey().equals("parseInt(fall.age_years)") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getIntegerQuery(qb, entry, "tCaseDetailsCollection.ageYears"));
            }//admission_date

            if (entry.getKey().equals("admission_date") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getDateQuery(qb, entry, "tCaseDetailsCollection.admissionDate"));

            }
            if (entry.getKey().equals("pat_number") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "tPatientId.patNumber"));

            }
            if (entry.getKey().equals("pat_first_name") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tPatientId.patFirstName"));

            }
            if (entry.getKey().equals("icdcCode") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getSimpleQueryString(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdCode"));
            }
            if (entry.getKey().equals("ICD_DESCRIPTION") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdDescription"));

            }
            if (entry.getKey().equals("opscCode") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getSimpleQueryString(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsCode"));
            }
            if (entry.getKey().equals("OPS_DESCRIPTION") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getFuzzySearchQuery(qb, entry, "tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsDescription"));
            }

        }
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
            Collection<TCase> result = jpaQuery.getResultList();
            long startTime = System.currentTimeMillis();
            createFallsObjects(result);
            long endTime = System.currentTimeMillis();

            System.out.println("***************");
            System.out.println("time took to create Fall Objects from Lucene");

            float sec = (endTime - startTime) / 1000F;
            System.out.println(sec + " seconds");
            System.out.println("");
        }

//        em.close();

        return falls;
    }

    private void createFallsObjects(Collection<TCase> tCases) {
        falls.clear();

        for (TCase tcase : tCases) {
            //Tcase
            Fall fall = new Fall();
            fall.setCs_case_number(tcase.getCsCaseNumber());
            fall.setInsurance_identifier(tcase.getInsuranceIdentifier());
            fall.setInsurance_number_patient(tcase.getInsuranceNumberPatient());

            //TCaseDetails
//            Collection<TCaseDetails> tcaseDestailses = (Collection<TCaseDetails>) tcase.getTCaseDetailsCollection();
            LinkedHashSet<String> hdIcdCode = new LinkedHashSet<String>();
            LinkedHashSet<Integer> age_years = new LinkedHashSet<Integer>();
            LinkedHashSet<Date> admisstion_date = new LinkedHashSet<Date>();

//            LinkedHashSet<Collection<TCaseDepartment>> tcaseDepartments = new LinkedHashSet<Collection<TCaseDepartment>>();
            LinkedHashSet<String> icds = new LinkedHashSet<String>();
            LinkedHashSet<String> opss = new LinkedHashSet<String>();

            LinkedHashSet<String> icdDescriptions = new LinkedHashSet<String>();
            LinkedHashSet<String> opsDescriptions = new LinkedHashSet<String>();

            for (TCaseDetails tcaseDestailse : tcase.getTCaseDetailsCollection()) {
                hdIcdCode.add(tcaseDestailse.getHdIcdCode());
                age_years.add(tcaseDestailse.getAgeYears());
                admisstion_date.add(tcaseDestailse.getAdmissionDate());
//                tcaseDepartments.add((Collection<TCaseDepartment>) tcaseDestailse.getTCaseDepartmentCollection());

//                for (Collection<TCaseDepartment> tcaseDepartmente :(Collection<TCaseDepartment>) tcaseDestailse.getTCaseDepartmentCollection()) {
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

            fall.setHd_icd_code(hdIcdCode);
            fall.setAge_years(age_years);
            fall.setAdmisstion_date(admisstion_date);

            //TPatient
//            TPatient tpatient = tcase.getTPatientId();
            fall.setPat_number(tcase.getTPatientId().getPatNumber());
            fall.setPat_first_name(tcase.getTPatientId().getPatFirstName());

//            if (tcaseDepartments.size() > 0) {
//                for (Collection<TCaseDepartment> tcaseDepartmente : tcaseDepartments) {
//                    for (TCaseDepartment tdepartment : tcaseDepartmente) {
//
//                        for (TCaseIcd icdCode : tdepartment.getTCaseIcdCollection()) {
//                            icds.add(icdCode.getIcdcCode().getIcdCode());
//                            icdDescriptions.add(icdCode.getIcdcCode().getIcdDescription());
//                        }
//                        for (TCaseOps opsCode : tdepartment.getTCaseOpsCollection()) {
//                            opss.add(opsCode.getOpscCode().getOpsCode());
//                            opsDescriptions.add(opsCode.getOpscCode().getOpsDescription());
//                        }
//                    }
//
//                }
//
//            }
            fall.setIcdcCode(icds);
            fall.setOpscCode(opss);
            fall.setICD_DESCRIPTION(icdDescriptions);
            fall.setOPS_DESCRIPTION(opsDescriptions);

            falls.add(fall);

        }
    }

    public int getFilteredFallSize() {
        return FilteredFallSize;
    }

    public void setFilteredFallSize(int FilteredFallSize) {
        this.FilteredFallSize = FilteredFallSize;
    }

    public EntityManager getEntityManager() {
        if (emff == null) {
            emff
                    = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
        }

        return emff.createEntityManager();
    }

}
