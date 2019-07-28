/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package htw.ai.luceneproject.Controller;

import htw.ai.luceneproject.Model.TCase;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * add
 *
 * @author halabieh
 */
@ManagedBean(name = "addData")
@Stateless
public class Add implements Serializable {
    
    private String fallNummer;
    private int fallId = 0;
    FacesContext context = FacesContext.getCurrentInstance();

    public void addNewFall()  {

        if (fallNummer != null && fallId != 0) {

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
//                BigDecimal bd = new BigDecimal(fallId);
                TCase tcase = new TCase();
                tcase.setId(1231223);
                tcase.setCsCaseNumber(fallNummer);
                tcase.setCsHospitalIdent("260101865");
                tcase.setCsCaseTypeEn("DRG");
                tcase.setVersion(BigDecimal.ZERO);
                tcase.setCsStatusEn("NEW");

                tcase.setCancelFl(new Short("0"));
                tcase.setCreationDate(null);
                tcase.setCreationUser(null);
                tcase.setCsBillingDate(null);
                tcase.setCsDoctorIdent(null);
                tcase.setCsFeeGroupEn(null);
                tcase.setCsKisStatusFl(0);
                tcase.setInsuranceIdentifier("000000");
                tcase.setInsuranceNumberPatient("0000000");
                tcase.setModificationDate(null);
                tcase.setModificationUser(null);
                tcase.setTPatientId(null);

                em.persist(tcase);
                em.getTransaction().commit();
                 em.close();
                emf.close();
            } catch (NumberFormatException e) {
                Logger.getLogger(Add.class.getName()).log(Level.SEVERE, "Error occurred while persisting new Entity", e);
            } 
        }

    }

    public String getFallNummer() {
        return fallNummer;
    }

    public void setFallNummer(String fallNummer) {
        this.fallNummer = fallNummer;
    }

    public int getFallId() {
        return fallId;
    }

    public void setFallId(int fallId) {
        this.fallId = fallId;
    }

}
