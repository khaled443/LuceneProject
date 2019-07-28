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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public void addNewFall() {
        TCase tcaseid = null;
        TCase tcasefall = null;
        if (fallNummer != null && fallId != 0) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager();
            Query idQuery = em.createQuery("select t from TCase t where t.id =:iid", TCase.class)
                    .setParameter("iid", fallId);
            try {
                tcaseid = (TCase) idQuery.getSingleResult();
            } catch (Exception e) {
            }
            if (tcaseid != null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler.", "Id: " + fallId + " ist schon vorhanden"));

            } else {
                Query fallQuery = em.createQuery("select t from TCase t where t.csCaseNumber =:iid", TCase.class)
                        .setParameter("iid", fallNummer);
                try {
                    tcasefall = (TCase) fallQuery.getSingleResult();
                } catch (Exception e) {
                }

                if (tcasefall != null) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler.", "Fall Nummer: " + fallNummer + " ist schon vorhanden"));

                } else {
                    try {

                        em.getTransaction().begin();
                        TCase tcase = new TCase();
                        tcase.setId(fallId);
                        tcase.setCsCaseNumber(fallNummer);
                        tcase.setCsHospitalIdent("260101865");
                        tcase.setCsCaseTypeEn("DRG");
                        tcase.setVersion(BigDecimal.ZERO);
                        tcase.setCsStatusEn("NEW");

                        em.persist(tcase);
                        em.getTransaction().commit();
                        em.close();
                        emf.close();
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erfolg ", "Patienten Fall ist hinzugefügt"));

                    } catch (Exception e) {
                        Logger.getLogger(Add.class.getName()).log(Level.SEVERE, "Error occurred while persisting new Entity", e);

                    }
                }
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
