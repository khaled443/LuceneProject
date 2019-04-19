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
@Table(name = "t_wm_request_insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmRequestInsurance.findAll", query = "SELECT t FROM TWmRequestInsurance t")
    , @NamedQuery(name = "TWmRequestInsurance.findById", query = "SELECT t FROM TWmRequestInsurance t WHERE t.id = :id")
    , @NamedQuery(name = "TWmRequestInsurance.findByEditor", query = "SELECT t FROM TWmRequestInsurance t WHERE t.editor = :editor")
    , @NamedQuery(name = "TWmRequestInsurance.findByInsuranceIdentifier", query = "SELECT t FROM TWmRequestInsurance t WHERE t.insuranceIdentifier = :insuranceIdentifier")
    , @NamedQuery(name = "TWmRequestInsurance.findByPublicInsuredFl", query = "SELECT t FROM TWmRequestInsurance t WHERE t.publicInsuredFl = :publicInsuredFl")
    , @NamedQuery(name = "TWmRequestInsurance.findByReportStart", query = "SELECT t FROM TWmRequestInsurance t WHERE t.reportStart = :reportStart")
    , @NamedQuery(name = "TWmRequestInsurance.findByRequestState", query = "SELECT t FROM TWmRequestInsurance t WHERE t.requestState = :requestState")
    , @NamedQuery(name = "TWmRequestInsurance.findByResultComment", query = "SELECT t FROM TWmRequestInsurance t WHERE t.resultComment = :resultComment")
    , @NamedQuery(name = "TWmRequestInsurance.findByStartAudit", query = "SELECT t FROM TWmRequestInsurance t WHERE t.startAudit = :startAudit")
    , @NamedQuery(name = "TWmRequestInsurance.findByTypeOfAuditEn", query = "SELECT t FROM TWmRequestInsurance t WHERE t.typeOfAuditEn = :typeOfAuditEn")})
public class TWmRequestInsurance implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "editor")
    private String editor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "insurance_identifier")
    private String insuranceIdentifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "public_insured_fl")
    private short publicInsuredFl;
    @Column(name = "report_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportStart;
    @Column(name = "request_state")
    private BigDecimal requestState;
    @Size(max = 255)
    @Column(name = "result_comment")
    private String resultComment;
    @Column(name = "start_audit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startAudit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_of_audit_en")
    private long typeOfAuditEn;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TWmRequest tWmRequest;

    public TWmRequestInsurance() {
    }

    public TWmRequestInsurance(BigDecimal id) {
        this.id = id;
    }

    public TWmRequestInsurance(BigDecimal id, String insuranceIdentifier, short publicInsuredFl, long typeOfAuditEn) {
        this.id = id;
        this.insuranceIdentifier = insuranceIdentifier;
        this.publicInsuredFl = publicInsuredFl;
        this.typeOfAuditEn = typeOfAuditEn;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getInsuranceIdentifier() {
        return insuranceIdentifier;
    }

    public void setInsuranceIdentifier(String insuranceIdentifier) {
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public short getPublicInsuredFl() {
        return publicInsuredFl;
    }

    public void setPublicInsuredFl(short publicInsuredFl) {
        this.publicInsuredFl = publicInsuredFl;
    }

    public Date getReportStart() {
        return reportStart;
    }

    public void setReportStart(Date reportStart) {
        this.reportStart = reportStart;
    }

    public BigDecimal getRequestState() {
        return requestState;
    }

    public void setRequestState(BigDecimal requestState) {
        this.requestState = requestState;
    }

    public String getResultComment() {
        return resultComment;
    }

    public void setResultComment(String resultComment) {
        this.resultComment = resultComment;
    }

    public Date getStartAudit() {
        return startAudit;
    }

    public void setStartAudit(Date startAudit) {
        this.startAudit = startAudit;
    }

    public long getTypeOfAuditEn() {
        return typeOfAuditEn;
    }

    public void setTypeOfAuditEn(long typeOfAuditEn) {
        this.typeOfAuditEn = typeOfAuditEn;
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
        if (!(object instanceof TWmRequestInsurance)) {
            return false;
        }
        TWmRequestInsurance other = (TWmRequestInsurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmRequestInsurance[ id=" + id + " ]";
    }
    
}
