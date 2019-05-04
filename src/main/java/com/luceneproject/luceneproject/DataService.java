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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author kk
 */
public enum DataService {
    INSTANCE;

    private final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public List<Fall> getFallsList(int start, int size) {
        List<Fall> falls = new ArrayList<Fall>();

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<TCase> query = em.createNamedQuery("TCase.findAll", TCase.class);
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<TCase> tcases = query.getResultList();
        transaction.commit();

        for (TCase tcase : tcases) {
            //Tcase
            Fall fall = new Fall();
            fall.setCs_case_number(tcase.getCsCaseNumber());
            fall.setCs_hospital_ident(tcase.getCsHospitalIdent());
            fall.setInsurance_identifier(tcase.getInsuranceIdentifier());
            fall.setInsurance_identifier_patient(tcase.getInsuranceNumberPatient());

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
        return falls;
    }
    
      public int getFallsTotalCount() {
      EntityManager em = emf.createEntityManager();
      Query query = em.createQuery("Select count(*) From TCase t");
      return ((Long)query.getSingleResult()).intValue();
  }
}
