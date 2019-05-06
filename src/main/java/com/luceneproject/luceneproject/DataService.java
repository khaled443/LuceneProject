/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import com.luceneproject.pojos.TCase;
import com.luceneproject.pojos.TCaseDetails;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
 * @author kk
 */
public enum DataService {
    //Making Singletons With Enum in Java
    //Since enums are inherently serializable, we don't need to implement it with a serializable interface.
    INSTANCE;

    List<Fall> falls = new ArrayList<Fall>();
    int FilteredFallSize = 0;

    private final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public List<Fall> getFallsList(int start, int size, Map<String, Object> filters) {
        List<Fall> falls = new ArrayList<Fall>();

        if (filters != null && filters.size() > 0) {
            falls = getListfromLucene(start, size, filters);
        } else {
            falls = getListFromeHibernate(start, size);

        }
        return falls;
    }

    public int getFallsTotalCount() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select count(*) From TCase t");
        return ((Long) query.getSingleResult()).intValue();
    }

    private List<Fall> getListFromeHibernate(int start, int size) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<TCase> tcases = query.getResultList();

        transaction.commit();

        createFallsObjects(tcases);
        em.close();

        return falls;
    }

    private List<Fall> getListfromLucene(int start, int size, Map<String, Object> filters) {
        System.out.println("till here ************************1***");

        EntityManager em = emf.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        List<org.apache.lucene.search.Query> filterQueries = new ArrayList<>();

        //filters
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getKey().equals("cs_case_number") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "csCaseNumber"));
            }
            if (entry.getKey().equals("cs_hospital_ident") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "csHospitalIdent"));
            }//insurance_identifier
            if (entry.getKey().equals("insurance_identifier") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "insuranceIdentifier"));
            }
             if (entry.getKey().equals("insurance_number_patient") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "insuranceNumberPatient"));
            }
             if (entry.getKey().equals("hd_icd_code") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "tCaseDetailsCollection.hdIcdCode"));
            } 
             if (entry.getKey().equals("csd_comment") && !entry.getValue().toString().isEmpty()) {
                filterQueries.add(QueryManager.getStringsStartsWithQuery(qb, entry, "tCaseDetailsCollection.csdComment"));
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
            List<TCase> result = jpaQuery.getResultList();

            createFallsObjects(result);

        }

        em.close();

        return falls;
    }

    private void createFallsObjects(List<TCase> tCases) {
        falls.clear();

        for (TCase tcase : tCases) {
            //Tcase
            Fall fall = new Fall();
            fall.setCs_case_number(tcase.getCsCaseNumber());
            fall.setCs_hospital_ident(tcase.getCsHospitalIdent());
            fall.setInsurance_identifier(tcase.getInsuranceIdentifier());
            fall.setInsurance_number_patient(tcase.getInsuranceNumberPatient());

            List<TCaseDetails> tcaseDestailses = (List<TCaseDetails>) tcase.getTCaseDetailsCollection();

            List<String> hdIcdCode = new ArrayList<String>();
            List<String> csd_comment = new ArrayList<String>();
            List<BigInteger> age_years = new ArrayList<BigInteger>();
            List<Date> admisstion_date = new ArrayList<Date>();

            for (TCaseDetails tcaseDestailse : tcaseDestailses) {
                hdIcdCode.add(tcaseDestailse.getHdIcdCode());
                csd_comment.add(tcaseDestailse.getCsdComment());
                age_years.add(tcaseDestailse.getAgeYears());
                admisstion_date.add(tcaseDestailse.getAdmissionDate());

            }

            fall.setHd_icd_code(hdIcdCode);
            fall.setCsd_comment(csd_comment);
            fall.setAge_years(age_years);
            fall.setAdmisstion_date(admisstion_date);

            falls.add(fall);

        }
    }

    public int getFilteredFallSize() {
        return FilteredFallSize;
    }

    public void setFilteredFallSize(int FilteredFallSize) {
        this.FilteredFallSize = FilteredFallSize;
    }

}
