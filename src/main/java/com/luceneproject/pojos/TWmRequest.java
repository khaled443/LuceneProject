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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_wm_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmRequest.findAll", query = "SELECT t FROM TWmRequest t")
    , @NamedQuery(name = "TWmRequest.findById", query = "SELECT t FROM TWmRequest t WHERE t.id = :id")
    , @NamedQuery(name = "TWmRequest.findByCreationDate", query = "SELECT t FROM TWmRequest t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmRequest.findByCreationUser", query = "SELECT t FROM TWmRequest t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmRequest.findByModificationDate", query = "SELECT t FROM TWmRequest t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmRequest.findByModificationUser", query = "SELECT t FROM TWmRequest t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmRequest.findByModificationUserId", query = "SELECT t FROM TWmRequest t WHERE t.modificationUserId = :modificationUserId")
    , @NamedQuery(name = "TWmRequest.findByRequestComment", query = "SELECT t FROM TWmRequest t WHERE t.requestComment = :requestComment")
    , @NamedQuery(name = "TWmRequest.findByRequestType", query = "SELECT t FROM TWmRequest t WHERE t.requestType = :requestType")
    , @NamedQuery(name = "TWmRequest.findByVersion", query = "SELECT t FROM TWmRequest t WHERE t.version = :version")})
public class TWmRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Column(name = "modification_user_id")
    private BigDecimal modificationUserId;
    @Size(max = 255)
    @Column(name = "request_comment")
    private String requestComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "request_type")
    private long requestType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tWmRequest")
    private TWmRequestBege tWmRequestBege;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tWmRequest")
    private TWmRequestMdk tWmRequestMdk;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tWmRequest")
    private TWmRequestInsurance tWmRequestInsurance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tWmRequest")
    private TWmRequestAudit tWmRequestAudit;
    @JoinColumn(name = "t_wm_process_hospital_id", referencedColumnName = "id")
    @ManyToOne
    private TWmProcessHospital tWmProcessHospitalId;
    @OneToMany(mappedBy = "tWmRequestId")
    private Collection<TWmEvent> tWmEventCollection;

    public TWmRequest() {
    }

    public TWmRequest(BigDecimal id) {
        this.id = id;
    }

    public TWmRequest(BigDecimal id, long requestType, BigDecimal version) {
        this.id = id;
        this.requestType = requestType;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(BigDecimal creationUser) {
        this.creationUser = creationUser;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public BigDecimal getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(BigDecimal modificationUser) {
        this.modificationUser = modificationUser;
    }

    public BigDecimal getModificationUserId() {
        return modificationUserId;
    }

    public void setModificationUserId(BigDecimal modificationUserId) {
        this.modificationUserId = modificationUserId;
    }

    public String getRequestComment() {
        return requestComment;
    }

    public void setRequestComment(String requestComment) {
        this.requestComment = requestComment;
    }

    public long getRequestType() {
        return requestType;
    }

    public void setRequestType(long requestType) {
        this.requestType = requestType;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public TWmRequestBege getTWmRequestBege() {
        return tWmRequestBege;
    }

    public void setTWmRequestBege(TWmRequestBege tWmRequestBege) {
        this.tWmRequestBege = tWmRequestBege;
    }

    public TWmRequestMdk getTWmRequestMdk() {
        return tWmRequestMdk;
    }

    public void setTWmRequestMdk(TWmRequestMdk tWmRequestMdk) {
        this.tWmRequestMdk = tWmRequestMdk;
    }

    public TWmRequestInsurance getTWmRequestInsurance() {
        return tWmRequestInsurance;
    }

    public void setTWmRequestInsurance(TWmRequestInsurance tWmRequestInsurance) {
        this.tWmRequestInsurance = tWmRequestInsurance;
    }

    public TWmRequestAudit getTWmRequestAudit() {
        return tWmRequestAudit;
    }

    public void setTWmRequestAudit(TWmRequestAudit tWmRequestAudit) {
        this.tWmRequestAudit = tWmRequestAudit;
    }

    public TWmProcessHospital getTWmProcessHospitalId() {
        return tWmProcessHospitalId;
    }

    public void setTWmProcessHospitalId(TWmProcessHospital tWmProcessHospitalId) {
        this.tWmProcessHospitalId = tWmProcessHospitalId;
    }

    @XmlTransient
    public Collection<TWmEvent> getTWmEventCollection() {
        return tWmEventCollection;
    }

    public void setTWmEventCollection(Collection<TWmEvent> tWmEventCollection) {
        this.tWmEventCollection = tWmEventCollection;
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
        if (!(object instanceof TWmRequest)) {
            return false;
        }
        TWmRequest other = (TWmRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmRequest[ id=" + id + " ]";
    }
    
}
