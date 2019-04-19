/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

/**
 *
 * @author kk
 */
public class Index {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public static void main(String[] args) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

            FullTextSession fullTextSession = Search.getFullTextSession(em.unwrap(Session.class));
            try {
                fullTextSession.createIndexer().startAndWait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            
             }finally{
                  em.close();
                  ENTITY_MANAGER_FACTORY.close();
            }
    }
}
