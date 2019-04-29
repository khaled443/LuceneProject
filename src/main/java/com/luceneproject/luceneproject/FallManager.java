/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.luceneproject.pojos.*;
import com.sun.media.jfxmedia.logging.Logger;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author kk
 */
@ManagedBean(name = "fallManager" )
@ApplicationScoped
//@SessionScoped
public class FallManager {

    //this should be global and always on
//    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
//            .createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public List<Fall> getFalls(int first, int last) {
//        List<TCase> tcases = null;
        List<Fall> falls = new ArrayList<Fall>();
//
//        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//
//        try {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//            TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
//            query.setFirstResult(first);
//            query.setMaxResults(last);
//            tcases = query.getResultList();
//            transaction.commit();
//
//            for (TCase tcase : tcases) {
//                //Tcase
//                String cs_case_number ="";
//                String cs_hospital_ident="";
//                String insurance_identifier="";
//                String insuran//                //TCase_details
//                List<String> hd_icd_code = null;
//                List<String> csd_comment=null;
//                List<BigInteger> age_years=null;
//                List<Date> admisstion_date=null;ce_identifier_patient="";
//
//                //TCase_details
                List<String> hd_icd_code = new ArrayList<String>();
                List<String> csd_comment=new ArrayList<String>();
                List<BigInteger> age_years=new ArrayList<BigInteger>();
                List<Date> admisstion_date=new ArrayList<Date>();
//
//                cs_case_number = tcase.getCsCaseNumber();
//                cs_hospital_ident = tcase.getCsHospitalIdent();
//                insurance_identifier = tcase.getInsuranceIdentifier();
//                insurance_identifier_patient = tcase.getInsuranceNumberPatient();
//
//                List<TCaseDetails> tcaseDestailses = (List<TCaseDetails>) tcase.getTCaseDetailsCollection();
//                for (TCaseDetails tcaseDestailse : tcaseDestailses) {
//                      hd_icd_code.add(tcaseDestailse.getHdIcdCode());
//                      csd_comment.add(tcaseDestailse.getCsdComment());
//                      age_years.add(tcaseDestailse.getAgeYears());
//                      admisstion_date.add(tcaseDestailse.getAdmissionDate());
//                }
//                Fall fall = new Fall(cs_case_number, cs_hospital_ident, insurance_identifier, insurance_identifier_patient, hd_icd_code, csd_comment, age_years, admisstion_date);
//                falls.add(fall);
//
//            }
//
//        } catch (Exception e) {
//            //logger
//        }
    

Fall fall = new Fall("test");
falls.add(fall);
return falls;
    }
}
