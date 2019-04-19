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
import javax.persistence.ManyToOne;
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
@Table(name = "t_wm_request_mdk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmRequestMdk.findAll", query = "SELECT t FROM TWmRequestMdk t")
    , @NamedQuery(name = "TWmRequestMdk.findById", query = "SELECT t FROM TWmRequestMdk t WHERE t.id = :id")
    , @NamedQuery(name = "TWmRequestMdk.findByBillCorrectionDeadline", query = "SELECT t FROM TWmRequestMdk t WHERE t.billCorrectionDeadline = :billCorrectionDeadline")
    , @NamedQuery(name = "TWmRequestMdk.findByContinuationFeePaidDate", query = "SELECT t FROM TWmRequestMdk t WHERE t.continuationFeePaidDate = :continuationFeePaidDate")
    , @NamedQuery(name = "TWmRequestMdk.findByContinuationFeePaidFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.continuationFeePaidFl = :continuationFeePaidFl")
    , @NamedQuery(name = "TWmRequestMdk.findByHealthEnsuranceStartAudit", query = "SELECT t FROM TWmRequestMdk t WHERE t.healthEnsuranceStartAudit = :healthEnsuranceStartAudit")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkAuditCompletionDeadline", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkAuditCompletionDeadline = :mdkAuditCompletionDeadline")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkComment", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkComment = :mdkComment")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkDocumentDeliverDeadline", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkDocumentDeliverDeadline = :mdkDocumentDeliverDeadline")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkDocumentDelivered", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkDocumentDelivered = :mdkDocumentDelivered")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkDocumentDeliveredFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkDocumentDeliveredFl = :mdkDocumentDeliveredFl")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkDocumentRequest", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkDocumentRequest = :mdkDocumentRequest")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkDocumentRequestFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkDocumentRequestFl = :mdkDocumentRequestFl")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkEditor", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkEditor = :mdkEditor")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkInternalId", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkInternalId = :mdkInternalId")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkReportCreationDate", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkReportCreationDate = :mdkReportCreationDate")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkReportFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkReportFl = :mdkReportFl")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkReportReceiveDate", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkReportReceiveDate = :mdkReportReceiveDate")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkStartAudit", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkStartAudit = :mdkStartAudit")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkStartAuditExtended", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkStartAuditExtended = :mdkStartAuditExtended")
    , @NamedQuery(name = "TWmRequestMdk.findByMdkState", query = "SELECT t FROM TWmRequestMdk t WHERE t.mdkState = :mdkState")
    , @NamedQuery(name = "TWmRequestMdk.findByReminderDeliverDeadlineFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.reminderDeliverDeadlineFl = :reminderDeliverDeadlineFl")
    , @NamedQuery(name = "TWmRequestMdk.findBySubsequentProceedingDate", query = "SELECT t FROM TWmRequestMdk t WHERE t.subsequentProceedingDate = :subsequentProceedingDate")
    , @NamedQuery(name = "TWmRequestMdk.findBySubsequentProceedingFl", query = "SELECT t FROM TWmRequestMdk t WHERE t.subsequentProceedingFl = :subsequentProceedingFl")
    , @NamedQuery(name = "TWmRequestMdk.findByUserComment", query = "SELECT t FROM TWmRequestMdk t WHERE t.userComment = :userComment")})
public class TWmRequestMdk implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "bill_correction_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billCorrectionDeadline;
    @Column(name = "continuation_fee_paid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date continuationFeePaidDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "continuation_fee_paid_fl")
    private short continuationFeePaidFl;
    @Column(name = "health_ensurance_start_audit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date healthEnsuranceStartAudit;
    @Column(name = "mdk_audit_completion_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkAuditCompletionDeadline;
    @Size(max = 255)
    @Column(name = "mdk_comment")
    private String mdkComment;
    @Column(name = "mdk_document_deliver_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkDocumentDeliverDeadline;
    @Column(name = "mdk_document_delivered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkDocumentDelivered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdk_document_delivered_fl")
    private short mdkDocumentDeliveredFl;
    @Column(name = "mdk_document_request")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkDocumentRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdk_document_request_fl")
    private short mdkDocumentRequestFl;
    @Size(max = 255)
    @Column(name = "mdk_editor")
    private String mdkEditor;
    @Column(name = "mdk_internal_id")
    private BigDecimal mdkInternalId;
    @Column(name = "mdk_report_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkReportCreationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdk_report_fl")
    private short mdkReportFl;
    @Column(name = "mdk_report_receive_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkReportReceiveDate;
    @Column(name = "mdk_start_audit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkStartAudit;
    @Column(name = "mdk_start_audit_extended")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdkStartAuditExtended;
    @Column(name = "mdk_state")
    private BigDecimal mdkState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reminder_deliver_deadline_fl")
    private short reminderDeliverDeadlineFl;
    @Column(name = "subsequent_proceeding_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subsequentProceedingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subsequent_proceeding_fl")
    private short subsequentProceedingFl;
    @Size(max = 255)
    @Column(name = "user_comment")
    private String userComment;
    @JoinColumn(name = "t_wm_reminder_id", referencedColumnName = "id")
    @ManyToOne
    private TWmReminder tWmReminderId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TWmRequest tWmRequest;

    public TWmRequestMdk() {
    }

    public TWmRequestMdk(BigDecimal id) {
        this.id = id;
    }

    public TWmRequestMdk(BigDecimal id, short continuationFeePaidFl, short mdkDocumentDeliveredFl, short mdkDocumentRequestFl, short mdkReportFl, short reminderDeliverDeadlineFl, short subsequentProceedingFl) {
        this.id = id;
        this.continuationFeePaidFl = continuationFeePaidFl;
        this.mdkDocumentDeliveredFl = mdkDocumentDeliveredFl;
        this.mdkDocumentRequestFl = mdkDocumentRequestFl;
        this.mdkReportFl = mdkReportFl;
        this.reminderDeliverDeadlineFl = reminderDeliverDeadlineFl;
        this.subsequentProceedingFl = subsequentProceedingFl;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getBillCorrectionDeadline() {
        return billCorrectionDeadline;
    }

    public void setBillCorrectionDeadline(Date billCorrectionDeadline) {
        this.billCorrectionDeadline = billCorrectionDeadline;
    }

    public Date getContinuationFeePaidDate() {
        return continuationFeePaidDate;
    }

    public void setContinuationFeePaidDate(Date continuationFeePaidDate) {
        this.continuationFeePaidDate = continuationFeePaidDate;
    }

    public short getContinuationFeePaidFl() {
        return continuationFeePaidFl;
    }

    public void setContinuationFeePaidFl(short continuationFeePaidFl) {
        this.continuationFeePaidFl = continuationFeePaidFl;
    }

    public Date getHealthEnsuranceStartAudit() {
        return healthEnsuranceStartAudit;
    }

    public void setHealthEnsuranceStartAudit(Date healthEnsuranceStartAudit) {
        this.healthEnsuranceStartAudit = healthEnsuranceStartAudit;
    }

    public Date getMdkAuditCompletionDeadline() {
        return mdkAuditCompletionDeadline;
    }

    public void setMdkAuditCompletionDeadline(Date mdkAuditCompletionDeadline) {
        this.mdkAuditCompletionDeadline = mdkAuditCompletionDeadline;
    }

    public String getMdkComment() {
        return mdkComment;
    }

    public void setMdkComment(String mdkComment) {
        this.mdkComment = mdkComment;
    }

    public Date getMdkDocumentDeliverDeadline() {
        return mdkDocumentDeliverDeadline;
    }

    public void setMdkDocumentDeliverDeadline(Date mdkDocumentDeliverDeadline) {
        this.mdkDocumentDeliverDeadline = mdkDocumentDeliverDeadline;
    }

    public Date getMdkDocumentDelivered() {
        return mdkDocumentDelivered;
    }

    public void setMdkDocumentDelivered(Date mdkDocumentDelivered) {
        this.mdkDocumentDelivered = mdkDocumentDelivered;
    }

    public short getMdkDocumentDeliveredFl() {
        return mdkDocumentDeliveredFl;
    }

    public void setMdkDocumentDeliveredFl(short mdkDocumentDeliveredFl) {
        this.mdkDocumentDeliveredFl = mdkDocumentDeliveredFl;
    }

    public Date getMdkDocumentRequest() {
        return mdkDocumentRequest;
    }

    public void setMdkDocumentRequest(Date mdkDocumentRequest) {
        this.mdkDocumentRequest = mdkDocumentRequest;
    }

    public short getMdkDocumentRequestFl() {
        return mdkDocumentRequestFl;
    }

    public void setMdkDocumentRequestFl(short mdkDocumentRequestFl) {
        this.mdkDocumentRequestFl = mdkDocumentRequestFl;
    }

    public String getMdkEditor() {
        return mdkEditor;
    }

    public void setMdkEditor(String mdkEditor) {
        this.mdkEditor = mdkEditor;
    }

    public BigDecimal getMdkInternalId() {
        return mdkInternalId;
    }

    public void setMdkInternalId(BigDecimal mdkInternalId) {
        this.mdkInternalId = mdkInternalId;
    }

    public Date getMdkReportCreationDate() {
        return mdkReportCreationDate;
    }

    public void setMdkReportCreationDate(Date mdkReportCreationDate) {
        this.mdkReportCreationDate = mdkReportCreationDate;
    }

    public short getMdkReportFl() {
        return mdkReportFl;
    }

    public void setMdkReportFl(short mdkReportFl) {
        this.mdkReportFl = mdkReportFl;
    }

    public Date getMdkReportReceiveDate() {
        return mdkReportReceiveDate;
    }

    public void setMdkReportReceiveDate(Date mdkReportReceiveDate) {
        this.mdkReportReceiveDate = mdkReportReceiveDate;
    }

    public Date getMdkStartAudit() {
        return mdkStartAudit;
    }

    public void setMdkStartAudit(Date mdkStartAudit) {
        this.mdkStartAudit = mdkStartAudit;
    }

    public Date getMdkStartAuditExtended() {
        return mdkStartAuditExtended;
    }

    public void setMdkStartAuditExtended(Date mdkStartAuditExtended) {
        this.mdkStartAuditExtended = mdkStartAuditExtended;
    }

    public BigDecimal getMdkState() {
        return mdkState;
    }

    public void setMdkState(BigDecimal mdkState) {
        this.mdkState = mdkState;
    }

    public short getReminderDeliverDeadlineFl() {
        return reminderDeliverDeadlineFl;
    }

    public void setReminderDeliverDeadlineFl(short reminderDeliverDeadlineFl) {
        this.reminderDeliverDeadlineFl = reminderDeliverDeadlineFl;
    }

    public Date getSubsequentProceedingDate() {
        return subsequentProceedingDate;
    }

    public void setSubsequentProceedingDate(Date subsequentProceedingDate) {
        this.subsequentProceedingDate = subsequentProceedingDate;
    }

    public short getSubsequentProceedingFl() {
        return subsequentProceedingFl;
    }

    public void setSubsequentProceedingFl(short subsequentProceedingFl) {
        this.subsequentProceedingFl = subsequentProceedingFl;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public TWmReminder getTWmReminderId() {
        return tWmReminderId;
    }

    public void setTWmReminderId(TWmReminder tWmReminderId) {
        this.tWmReminderId = tWmReminderId;
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
        if (!(object instanceof TWmRequestMdk)) {
            return false;
        }
        TWmRequestMdk other = (TWmRequestMdk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmRequestMdk[ id=" + id + " ]";
    }
    
}
