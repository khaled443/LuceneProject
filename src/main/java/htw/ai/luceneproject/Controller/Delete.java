/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htw.ai.luceneproject.Controller;

import htw.ai.luceneproject.Service.QueryManager;
import htw.ai.luceneproject.Model.TCase;
import htw.ai.luceneproject.Model.TCaseDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 * delete 
 * @author Khaled Halabieh
 */
@ManagedBean(name = "deleteData")
@SessionScoped
public class Delete implements Serializable{

    /**
     * Autocomplete for deleting Patient Case
     *
     * @param query
     * @return List of suggestions
     */
    EntityManagerFactory emff = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
    private String fallNummer;
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();

        EntityManager em = emff.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        LinkedHashSet<org.apache.lucene.search.Query> filterQueries = new LinkedHashSet<>();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField("csCaseNumber")
                .matching(query.toLowerCase())
                .createQuery();

        FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class, TCaseDetails.class)
                        .setFirstResult(0)
                        .setMaxResults(5);

        // execute search
        List<TCase> tcases = jpaQuery.getResultList();
        for (TCase t : tcases) {
            results.add(t.getCsCaseNumber());
        }
        em.close();
        return results;
    }
    /**
     * patientenfall durch ihre Fallnummer löschen
     */
    public void deleteFall() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (fallNummer != null) {
            TCase tcase = null;
            EntityManager em = emff.createEntityManager();
            Query deleteQuery = em.createQuery("select t from TCase t where t.csCaseNumber =:cscase", TCase.class)
                    .setParameter("cscase", fallNummer);
            try {
                tcase = (TCase) deleteQuery.getSingleResult();
            } catch (NoResultException e) {
                Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, "can't find TCase with the fall number: " + fallNummer, e);
            }
            if (tcase == null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Patientenfall mit dem Nummer " + fallNummer + " könnte nicht gefunden werden!"));
            } else {
                em.getTransaction().begin();
                em.remove(tcase);
                em.getTransaction().commit();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gelöscht.", "Patientenfall mit dem Nummer " + fallNummer + " wird erfolgreich gelöscht"));
            }
            em.close();
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler", "Bitte wählen Sie ein Patientennummer aus"));
        }
    }
    public String getFallNummer() {
        return fallNummer;
    }

    public void setFallNummer(String fallNummer) {
        this.fallNummer = fallNummer;
    }

}
