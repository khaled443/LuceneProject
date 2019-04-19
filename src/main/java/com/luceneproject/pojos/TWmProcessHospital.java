/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_wm_process_hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmProcessHospital.findAll", query = "SELECT t FROM TWmProcessHospital t")
    , @NamedQuery(name = "TWmProcessHospital.findById", query = "SELECT t FROM TWmProcessHospital t WHERE t.id = :id")
    , @NamedQuery(name = "TWmProcessHospital.findByAuditDataRecCorrDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.auditDataRecCorrDeadline = :auditDataRecCorrDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByAuditPrelProcAnsDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.auditPrelProcAnsDeadline = :auditPrelProcAnsDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByAuditPrelProcClDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.auditPrelProcClDeadline = :auditPrelProcClDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByIsClosed", query = "SELECT t FROM TWmProcessHospital t WHERE t.isClosed = :isClosed")
    , @NamedQuery(name = "TWmProcessHospital.findByMdkAuditCompletionDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.mdkAuditCompletionDeadline = :mdkAuditCompletionDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByMdkBillCorrectionDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.mdkBillCorrectionDeadline = :mdkBillCorrectionDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByMdkDocDeliverDeadline", query = "SELECT t FROM TWmProcessHospital t WHERE t.mdkDocDeliverDeadline = :mdkDocDeliverDeadline")
    , @NamedQuery(name = "TWmProcessHospital.findByProcessTopic", query = "SELECT t FROM TWmProcessHospital t WHERE t.processTopic = :processTopic")})
public class TWmProcessHospital implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "audit_data_rec_corr_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditDataRecCorrDeadline;
    @Column(name = "audit_prel_proc_ans_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditPrelProcAnsDeadline;
    @Column(name = "audit_prel_proc_cl_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditPrelProcClDeadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_closed")
    private long isClosed;
    @Column(name = "mdk_audit_completion_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkAuditCompletionDeadline;
    @Column(name = "mdk_bill_correction_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkBillCorrectionDeadline;
    @Column(name = "mdk_doc_deliver_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkDocDeliverDeadline;
    @Column(name = "process_topic")
    private BigDecimal processTopic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tWmProcessHospitalId")
    private Collection<TWmProcessHospitalFinalis> tWmProcessHospitalFinalisCollection;
    @OneToMany(mappedBy = "tWmProcessHospitalId")
    private Collection<TWmRequest> tWmRequestCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TWmProcess tWmProcess;

    public TWmProcessHospital() {
    }

    public TWmProcessHospital(BigDecimal id) {
        this.id = id;
    }

    public TWmProcessHospital(BigDecimal id, long isClosed) {
        this.id = id;
        this.isClosed = isClosed;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getAuditDataRecCorrDeadline() {
        return auditDataRecCorrDeadline;
    }

    public void setAuditDataRecCorrDeadline(Date auditDataRecCorrDeadline) {
        this.auditDataRecCorrDeadline = auditDataRecCorrDeadline;
    }

    public Date getAuditPrelProcAnsDeadline() {
        return auditPrelProcAnsDeadline;
    }

    public void setAuditPrelProcAnsDeadline(Date auditPrelProcAnsDeadline) {
        this.auditPrelProcAnsDeadline = auditPrelProcAnsDeadline;
    }

    public Date getAuditPrelProcClDeadline() {
        return auditPrelProcClDeadline;
    }

    public void setAuditPrelProcClDeadline(Date auditPrelProcClDeadline) {
        this.auditPrelProcClDeadline = auditPrelProcClDeadline;
    }

    public long getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(long isClosed) {
        this.isClosed = isClosed;
    }

    public Date getMdkAuditCompletionDeadline() {
        return mdkAuditCompletionDeadline;
    }

    public void setMdkAuditCompletionDeadline(Date mdkAuditCompletionDeadline) {
        this.mdkAuditCompletionDeadline = mdkAuditCompletionDeadline;
    }

    public Date getMdkBillCorrectionDeadline() {
        return mdkBillCorrectionDeadline;
    }

    public void setMdkBillCorrectionDeadline(Date mdkBillCorrectionDeadline) {
        this.mdkBillCorrectionDeadline = mdkBillCorrectionDeadline;
    }

    public Date getMdkDocDeliverDeadline() {
        return mdkDocDeliverDeadline;
    }

    public void setMdkDocDeliverDeadline(Date mdkDocDeliverDeadline) {
        this.mdkDocDeliverDeadline = mdkDocDeliverDeadline;
    }

    public BigDecimal getProcessTopic() {
        return processTopic;
    }

    public void setProcessTopic(BigDecimal processTopic) {
        this.processTopic = processTopic;
    }

    @XmlTransient
    public Collection<TWmProcessHospitalFinalis> getTWmProcessHospitalFinalisCollection() {
        return tWmProcessHospitalFinalisCollection;
    }

    public void setTWmProcessHospitalFinalisCollection(Collection<TWmProcessHospitalFinalis> tWmProcessHospitalFinalisCollection) {
        this.tWmProcessHospitalFinalisCollection = tWmProcessHospitalFinalisCollection;
    }

    @XmlTransient
    public Collection<TWmRequest> getTWmRequestCollection() {
        return tWmRequestCollection;
    }

    public void setTWmRequestCollection(Collection<TWmRequest> tWmRequestCollection) {
        this.tWmRequestCollection = tWmRequestCollection;
    }

    public TWmProcess getTWmProcess() {
        return tWmProcess;
    }

    public void setTWmProcess(TWmProcess tWmProcess) {
        this.tWmProcess = tWmProcess;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TWmProcessHospital)) {
            return false;
        }
        TWmProcessHospital other = (TWmProcessHospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmProcessHospital[ id=" + id + " ]";
    }
    
}
