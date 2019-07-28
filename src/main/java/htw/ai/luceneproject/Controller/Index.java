/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package htw.ai.luceneproject.Controller;

import htw.ai.luceneproject.Service.CustomIndexerProgressMonitor;
import htw.ai.luceneproject.Model.IcdDe;
import htw.ai.luceneproject.Model.TCase;
import htw.ai.luceneproject.Model.TPatient;
import htw.ai.luceneproject.Model.OpsDe;
import htw.ai.luceneproject.Model.TCaseDetails;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;


/**
 * Index 
 * @author Khaled Halabieh
 */
@ManagedBean(name = "indexData")
@SessionScoped

public class Index implements Serializable {   
    
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
    String logText;
    private Integer progress;
    CustomIndexerProgressMonitor monitor;
    
    int document_id=0;
    
    int tCase_cs_case_number = 0;
    int tCase_insurance_identifier = 0;
    int tCase_insurance_number_patient = 0;
    
    
    int tCaseDetails_hd_icd_code=0;
    int tCaseDetails_age_years=0;
    int tCaseDetails_admission_date=0;
    
    int icd_de_icdc_code=0;
    int icd_de_icd_description=0;
    
    int ops_de_opsc_code=0;
    int ops_de_ops_description=0;
    
    int t_patient_pat_number=0;
    int t_patient_pat_first_name=0;
    
    
    int totalSize=0;
    
    /**
     * post construct to calculate Entries size before rendering the page
     */
    @PostConstruct
    public void init() {
        calculateEntitySize();
        
    }
    /**
     * start reindexing all relevant entries
     */
    public void startIndex() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        //Monitor the process bar
        monitor = new CustomIndexerProgressMonitor();
        
        FullTextSession fullTextSession = Search.getFullTextSession(em.unwrap(Session.class));
        
        try {
            fullTextSession.createIndexer(TCase.class).progressMonitor(monitor)
                    .startAndWait();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, "Error occurred while Indexing!", ex);
            
        } finally {
            em.close();
        }
    }
    
    /**
     * calculate total entities size
     */
    public void calculateEntitySize() {
        
        document_id= getTableRowsCount("id", TCase.class.getSimpleName());
        
        tCase_cs_case_number=getTableRowsCount("csCaseNumber", TCase.class.getSimpleName());
        tCase_insurance_identifier=getTableRowsCount("insuranceIdentifier", TCase.class.getSimpleName());
        tCase_insurance_number_patient=getTableRowsCount("insuranceNumberPatient", TCase.class.getSimpleName());
        
        tCaseDetails_hd_icd_code=getTableRowsCount("hdIcdCode", TCaseDetails.class.getSimpleName());
        tCaseDetails_age_years=getTableRowsCount("ageYears", TCaseDetails.class.getSimpleName());
        tCaseDetails_admission_date=getTableRowsCount("admissionDate", TCaseDetails.class.getSimpleName());
        
        icd_de_icdc_code=getTableRowsCount("icdCode", IcdDe.class.getSimpleName());
        icd_de_icd_description=getTableRowsCount("icdDescription", IcdDe.class.getSimpleName());
        
        ops_de_opsc_code=getTableRowsCount("opsCode", OpsDe.class.getSimpleName());
        ops_de_ops_description=getTableRowsCount("opsDescription", OpsDe.class.getSimpleName());
        
        t_patient_pat_number=getTableRowsCount("patNumber", TPatient.class.getSimpleName());
        t_patient_pat_first_name=getTableRowsCount("patFirstName", TPatient.class.getSimpleName());
        
        totalSize= document_id+tCase_cs_case_number+tCase_insurance_identifier+tCase_insurance_number_patient+
                tCaseDetails_hd_icd_code+tCaseDetails_age_years+tCaseDetails_admission_date+
                icd_de_icdc_code+icd_de_icd_description+
                ops_de_opsc_code+ops_de_ops_description;
    }
    
    /**
     * Primefaces message on index complete
     */
    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }
    
    /**
     * New Primefaces message
     * @param summary message summary
     * @param detail summary details
     */
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * Get size of table entries
     * @param field field name
     * @param table table name
     * @return int
     */
    public static int getTableRowsCount(String field,String table) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        int count = ((Number) em
                .createQuery(
                        "select count("+field+") "
                                + "from " + table)
                .getSingleResult()).intValue();
        em.close();
        return count;
    }
    
    public Integer getProgress() {
        if (progress == null) {
            progress = 0;
        } else if (monitor != null) {
            progress = monitor.getProcess();
            if (progress > 95) {
                progress = 100;
            }
        }
        return progress;
    }
    
    public void setProgress(Integer progress) {
        this.progress = progress;
    }
    public String getLogText() {
        return logText;
    }
    
    public void setLogText(String logText) {
        this.logText = logText;
    }
    
    public CustomIndexerProgressMonitor getMonitor() {
        return monitor;
    }
    
    public void setMonitor(CustomIndexerProgressMonitor monitor) {
        this.monitor = monitor;
    }
    
    public int getDocument_id() {
        return document_id;
    }
    
    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }
    
    public int gettCase_cs_case_number() {
        return tCase_cs_case_number;
    }
    
    public void settCase_cs_case_number(int tCase_cs_case_number) {
        this.tCase_cs_case_number = tCase_cs_case_number;
    }
    
    public int gettCase_insurance_identifier() {
        return tCase_insurance_identifier;
    }
    
    public void settCase_insurance_identifier(int tCase_insurance_identifier) {
        this.tCase_insurance_identifier = tCase_insurance_identifier;
    }
    
    public int gettCase_insurance_number_patient() {
        return tCase_insurance_number_patient;
    }
    
    public void settCase_insurance_number_patient(int tCase_insurance_number_patient) {
        this.tCase_insurance_number_patient = tCase_insurance_number_patient;
    }
    
    public int gettCaseDetails_hd_icd_code() {
        return tCaseDetails_hd_icd_code;
    }
    
    public void settCaseDetails_hd_icd_code(int tCaseDetails_hd_icd_code) {
        this.tCaseDetails_hd_icd_code = tCaseDetails_hd_icd_code;
    }
    
    public int gettCaseDetails_age_years() {
        return tCaseDetails_age_years;
    }
    
    public void settCaseDetails_age_years(int tCaseDetails_age_years) {
        this.tCaseDetails_age_years = tCaseDetails_age_years;
    }
    
    public int gettCaseDetails_admission_date() {
        return tCaseDetails_admission_date;
    }
    
    public void settCaseDetails_admission_date(int tCaseDetails_admission_date) {
        this.tCaseDetails_admission_date = tCaseDetails_admission_date;
    }
    
    public int getIcd_de_icdc_code() {
        return icd_de_icdc_code;
    }
    
    public void setIcd_de_icdc_code(int icd_de_icdc_code) {
        this.icd_de_icdc_code = icd_de_icdc_code;
    }
    
    public int getIcd_de_icd_description() {
        return icd_de_icd_description;
    }
    
    public void setIcd_de_icd_description(int icd_de_icd_description) {
        this.icd_de_icd_description = icd_de_icd_description;
    }
    
    public int getOps_de_opsc_code() {
        return ops_de_opsc_code;
    }
    
    public void setOps_de_opsc_code(int ops_de_opsc_code) {
        this.ops_de_opsc_code = ops_de_opsc_code;
    }
    
    public int getOps_de_ops_description() {
        return ops_de_ops_description;
    }
    
    public void setOps_de_ops_description(int ops_de_ops_description) {
        this.ops_de_ops_description = ops_de_ops_description;
    }
    
    public int getT_patient_pat_number() {
        return t_patient_pat_number;
    }
    
    public void setT_patient_pat_number(int t_patient_pat_number) {
        this.t_patient_pat_number = t_patient_pat_number;
    }
    
    public int getT_patient_pat_first_name() {
        return t_patient_pat_first_name;
    }
    
    public void setT_patient_pat_first_name(int t_patient_pat_first_name) {
        this.t_patient_pat_first_name = t_patient_pat_first_name;
    }
    
    public int getTotalSize() {
        return totalSize;
    }
    
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
    
    
    
}
