/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search;

import com.luceneproject.pojos.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author kk
 */
public class DataDAO {
    // Create an EntityManagerFactory when you start the aDataDAOpplication.

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public static List<TCase> getCaseInformation() {
        List<TCase> tcases = null;
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
            query.setFirstResult(0);
            query.setMaxResults(10);
            tcases = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
        }
        return tcases;
    }

    public static List<TCase> getData() {
        List<TCase> tcases = null;
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
//            Query query = manager.createQuery(" SELECT t.csCaseNumber, t.csHospitalIdent , t.insuranceIdentifier , t.insuranceNumberPatient from TCase t");
//            fallData = query.getResultList();
            TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);

//             tcases = query.getResultList();
//            BigDecimal bd = new BigDecimal(12);
//            TypedQuery<TCase> query = em.createNamedQuery("TCase.findById",TCase.class).setParameter("id",bd);
            //            tcases = em.createQuery("SELECT T FROM TCase T LEFT JOIN FETCH T.tCaseDetailsCollection",TCase.class).getResultList();
            tcases = query.getResultList();

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            em.close();
        }
        return tcases;
    }

    public static void main(String[] args) {
//        List fallList = getFallsCount();
//        if (fallList != null) {
//
//            System.out.println("*************");
//            System.out.println(fallList.size());
//
//            for (int i = 0; i < fallList.size(); i++) {
//                System.out.println(fallList.get(i));
//            }
//
//        }

//        fallData = getData("103913sdff60");
//        if (fallData!=null) {
//            System.out.println("******");
//            System.out.println(fallData.size());
//            System.out.println("**********");
//            
//            for (Object[] obj : fallData) {
//                System.out.println(obj[0]);
//                
//            }
//               
//        }
//       
//        List<TCase> tcases = getData();
//        for (TCase tcase : tcases) {
//            System.out.println("case number: " + tcase.getId());
////            System.out.println("Tcase details:");
////            Collection<TCaseDetails> tCaseDetails =  tcase.getTCaseDetailsCollection();
////            for (TCaseDetails tDetails : tCaseDetails) {
////                System.out.println("        Details: "+tDetails.getAgeYears());
////            }
//        }
        List<TCase> tcases = getCaseInformation();
        int i = 0;
        //TCase
        for (TCase tcase : tcases) {
            System.out.println(++i);
            System.out.println("CS_CASE_NNUMBER:" + tcase.getCsCaseNumber() + " CS_HOSPITAL_IDENT: " + tcase.getCsHospitalIdent()
                    + " insurance_identifier: " + tcase.getInsuranceIdentifier() + " insurance_identifier_patient " + tcase.getInsuranceNumberPatient());
                    
            //TCaseDetails
            List<TCaseDetails> tcaseDestailses = (List<TCaseDetails>) tcase.getTCaseDetailsCollection();
            for (TCaseDetails tcaseDestailse : tcaseDestailses) {
                System.out.println("        #####TCASE_DETAILS######");
                System.out.println("        HD_ICD_CODE "+ tcaseDestailse.getHdIcdCode());
                System.out.println("");
                
            }
       

            
        }
        ENTITY_MANAGER_FACTORY.close();

    }

    @PreDestroy
    public void destruct() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
