/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search;

import com.luceneproject.Search.Interfaces.*;
import com.luceneproject.pojos.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author kk
 */
public class SearchManager implements SearchInterface {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory(persistenceUnitName);

    public SearchManager() {

    }

    @Override
    public List getByCsCaseNumber(String number) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("csCaseNumber")
                .matching(number)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
    }

    @Override
    public List getByCsHospitalIdent(String HospitalIdent) {
        
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("csHospitalIdent")
                .matching(HospitalIdent)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
        
    }

    @Override
    public List getByInsuranceIdentifier(String InsuranceIdentifier) {
                
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("insuranceIdentifier")
                .matching(InsuranceIdentifier)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
        
        
    }

    @Override
    public List getByInsuranceNumberPatient(String InsuranceNumberPatient) {
                EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("insuranceNumberPatient")
                .matching(InsuranceNumberPatient)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
    }

    @Override
    public List getByCsdComment(String csdComment) {
        
                        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("tCaseDetailsCollection.csdComment")
                .matching(csdComment)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
    }

    @Override
    public List getByIcdcCode(String icdcCode) {
    
                        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode")
                .matching(icdcCode)
                .createQuery();

// wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
    }

}
