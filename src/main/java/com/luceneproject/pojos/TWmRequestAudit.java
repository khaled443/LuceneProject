/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_wm_request_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmRequestAudit.findAll", query = "SELECT t FROM TWmRequestAudit t")
    , @NamedQuery(name = "TWmRequestAudit.findById", query = "SELECT t FROM TWmRequestAudit t WHERE t.id = :id")
    , @NamedQuery(name = "TWmRequestAudit.findByAuditComment", query = "SELECT t FROM TWmRequestAudit t WHERE t.auditComment = :auditComment")
    , @NamedQuery(name = "TWmRequestAudit.findByCaseDialogFl", query = "SELECT t FROM TWmRequestAudit t WHERE t.caseDialogFl = :caseDialogFl")
    , @NamedQuery(name = "TWmRequestAudit.findByCreateReminderFl", query = "SELECT t FROM TWmRequestAudit t WHERE t.createReminderFl = :createReminderFl")
    , @NamedQuery(name = "TWmRequestAudit.findByDataRecordCorrDeadline", query = "SELECT t FROM TWmRequestAudit t WHERE t.dataRecordCorrDeadline = :dataRecordCorrDeadline")
    , @NamedQuery(name = "TWmRequestAudit.findByEditor", query = "SELECT t FROM TWmRequestAudit t WHERE t.editor = :editor")
    , @NamedQuery(name = "TWmRequestAudit.findByEnsuranceStartAudit", query = "SELECT t FROM TWmRequestAudit t WHERE t.ensuranceStartAudit = :ensuranceStartAudit")
    , @NamedQuery(name = "TWmRequestAudit.findByInsuranceIdentifier", query = "SELECT t FROM TWmRequestAudit t WHERE t.insuranceIdentifier = :insuranceIdentifier")
    , @NamedQuery(name = "TWmRequestAudit.findByPreTrialEnd", query = "SELECT t FROM TWmRequestAudit t WHERE t.preTrialEnd = :preTrialEnd")
    , @NamedQuery(name = "TWmRequestAudit.findByPreTrialEndFl", query = "SELECT t FROM TWmRequestAudit t WHERE t.preTrialEndFl = :preTrialEndFl")
    , @NamedQuery(name = "TWmRequestAudit.findByPreTrialState", query = "SELECT t FROM TWmRequestAudit t WHERE t.preTrialState = :preTrialState")
    , @NamedQuery(name = "TWmRequestAudit.findByPrelProcAnswerDeadline", query = "SELECT t FROM TWmRequestAudit t WHERE t.prelProcAnswerDeadline = :prelProcAnswerDeadline")
    , @NamedQuery(name = "TWmRequestAudit.findByPrelProcClosedDeadline", query = "SELECT t FROM TWmRequestAudit t WHERE t.prelProcClosedDeadline = :prelProcClosedDeadline")
    , @NamedQuery(name = "TWmRequestAudit.findByRequestDate", query = "SELECT t FROM TWmRequestAudit t WHERE t.requestDate = :requestDate")
    , @NamedQuery(name = "TWmRequestAudit.findBySentOn", query = "SELECT t FROM TWmRequestAudit t WHERE t.sentOn = :sentOn")
    , @NamedQuery(name = "TWmRequestAudit.findBySentOnFl", query = "SELECT t FROM TWmRequestAudit t WHERE t.sentOnFl = :sentOnFl")
    , @NamedQuery(name = "TWmRequestAudit.findByState", query = "SELECT t FROM TWmRequestAudit t WHERE t.state = :state")
    , @NamedQuery(name = "TWmRequestAudit.findByUserComment", query = "SELECT t FROM TWmRequestAudit t WHERE t.userComment = :userComment")})
public class TWmRequestAudit implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "audit_comment")
    private String auditComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "case_dialog_fl")
    private short caseDialogFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_reminder_fl")
    private short createReminderFl;
    @Column(name = "data_record_corr_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecordCorrDeadline;
    @Size(max = 255)
    @Column(name = "editor")
    private String editor;
    @Column(name = "ensurance_start_audit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ensuranceStartAudit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "insurance_identifier")
    private String insuranceIdentifier;
    @Column(name = "pre_trial_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preTrialEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_trial_end_fl")
    private short preTrialEndFl;
    @Column(name = "pre_trial_state")
    private BigDecimal preTrialState;
    @Column(name = "prel_proc_answer_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prelProcAnswerDeadline;
    @Column(name = "prel_proc_closed_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prelProcClosedDeadline;
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "sent_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sent_on_fl")
    private short sentOnFl;
    @Column(name = "state")
    private BigDecimal state;
    @Size(max = 255)
    @Column(name = "user_comment")
    private String userComment;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TWmRequest tWmRequest;

    public TWmRequestAudit() {
    }

    public TWmRequestAudit(BigDecimal id) {
        this.id = id;
    }

    public TWmRequestAudit(BigDecimal id, short caseDialogFl, short createReminderFl, String insuranceIdentifier, short preTrialEndFl, short sentOnFl) {
        this.id = id;
        this.caseDialogFl = caseDialogFl;
        this.createReminderFl = createReminderFl;
        this.insuranceIdentifier = insuranceIdentifier;
        this.preTrialEndFl = preTrialEndFl;
        this.sentOnFl = sentOnFl;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    public short getCaseDialogFl() {
        return caseDialogFl;
    }

    public void setCaseDialogFl(short caseDialogFl) {
        this.caseDialogFl = caseDialogFl;
    }

    public short getCreateReminderFl() {
        return createReminderFl;
    }

    public void setCreateReminderFl(short createReminderFl) {
        this.createReminderFl = createReminderFl;
    }

    public Date getDataRecordCorrDeadline() {
        return dataRecordCorrDeadline;
    }

    public void setDataRecordCorrDeadline(Date dataRecordCorrDeadline) {
        this.dataRecordCorrDeadline = dataRecordCorrDeadline;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEnsuranceStartAudit() {
        return ensuranceStartAudit;
    }

    public void setEnsuranceStartAudit(Date ensuranceStartAudit) {
        this.ensuranceStartAudit = ensuranceStartAudit;
    }

    public String getInsuranceIdentifier() {
        return insuranceIdentifier;
    }

    public void setInsuranceIdentifier(String insuranceIdentifier) {
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public Date getPreTrialEnd() {
        return preTrialEnd;
    }

    public void setPreTrialEnd(Date preTrialEnd) {
        this.preTrialEnd = preTrialEnd;
    }

    public short getPreTrialEndFl() {
        return preTrialEndFl;
    }

    public void setPreTrialEndFl(short preTrialEndFl) {
        this.preTrialEndFl = preTrialEndFl;
    }

    public BigDecimal getPreTrialState() {
        return preTrialState;
    }

    public void setPreTrialState(BigDecimal preTrialState) {
        this.preTrialState = preTrialState;
    }

    public Date getPrelProcAnswerDeadline() {
        return prelProcAnswerDeadline;
    }

    public void setPrelProcAnswerDeadline(Date prelProcAnswerDeadline) {
        this.prelProcAnswerDeadline = prelProcAnswerDeadline;
    }

    public Date getPrelProcClosedDeadline() {
        return prelProcClosedDeadline;
    }

    public void setPrelProcClosedDeadline(Date prelProcClosedDeadline) {
        this.prelProcClosedDeadline = prelProcClosedDeadline;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getSentOn() {
        return sentOn;
    }

    public void setSentOn(Date sentOn) {
        this.sentOn = sentOn;
    }

    public short getSentOnFl() {
        return sentOnFl;
    }

    public void setSentOnFl(short sentOnFl) {
        this.sentOnFl = sentOnFl;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public TWmRequest getTWmRequest() {
        return tWmRequest;
    }

    public void setTWmRequest(TWmRequest tWmRequest) {
        this.tWmRequest = tWmRequest;
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
        if (!(object instanceof TWmRequestAudit)) {
            return false;
        }
        TWmRequestAudit other = (TWmRequestAudit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmRequestAudit[ id=" + id + " ]";
    }
    
}
