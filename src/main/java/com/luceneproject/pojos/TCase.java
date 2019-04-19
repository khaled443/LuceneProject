/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


/**
 *
 * @author kk
 */
@Entity
@Indexed
@Table(name = "t_case")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCase.findAll", query = "SELECT t FROM TCase t")
    , @NamedQuery(name = "TCase.findById", query = "SELECT t FROM TCase t WHERE t.id = :id")
    , @NamedQuery(name = "TCase.findByCancelFl", query = "SELECT t FROM TCase t WHERE t.cancelFl = :cancelFl")
    , @NamedQuery(name = "TCase.findByCreationDate", query = "SELECT t FROM TCase t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCase.findByCreationUser", query = "SELECT t FROM TCase t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCase.findByCsBillingDate", query = "SELECT t FROM TCase t WHERE t.csBillingDate = :csBillingDate")
    , @NamedQuery(name = "TCase.findByCsCaseNumber", query = "SELECT t FROM TCase t WHERE t.csCaseNumber = :csCaseNumber")
    , @NamedQuery(name = "TCase.findByCsCaseTypeEn", query = "SELECT t FROM TCase t WHERE t.csCaseTypeEn = :csCaseTypeEn")
    , @NamedQuery(name = "TCase.findByCsDoctorIdent", query = "SELECT t FROM TCase t WHERE t.csDoctorIdent = :csDoctorIdent")
    , @NamedQuery(name = "TCase.findByCsFeeGroupEn", query = "SELECT t FROM TCase t WHERE t.csFeeGroupEn = :csFeeGroupEn")
    , @NamedQuery(name = "TCase.findByCsHospitalIdent", query = "SELECT t FROM TCase t WHERE t.csHospitalIdent = :csHospitalIdent")
    , @NamedQuery(name = "TCase.findByCsKisStatusFl", query = "SELECT t FROM TCase t WHERE t.csKisStatusFl = :csKisStatusFl")
    , @NamedQuery(name = "TCase.findByCsStatusEn", query = "SELECT t FROM TCase t WHERE t.csStatusEn = :csStatusEn")
    , @NamedQuery(name = "TCase.findByInsuranceIdentifier", query = "SELECT t FROM TCase t WHERE t.insuranceIdentifier = :insuranceIdentifier")
    , @NamedQuery(name = "TCase.findByInsuranceNumberPatient", query = "SELECT t FROM TCase t WHERE t.insuranceNumberPatient = :insuranceNumberPatient")
    , @NamedQuery(name = "TCase.findByModificationDate", query = "SELECT t FROM TCase t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCase.findByModificationUser", query = "SELECT t FROM TCase t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCase.findByVersion", query = "SELECT t FROM TCase t WHERE t.version = :version")})
public class TCase implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancel_fl")
    private short cancelFl;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Column(name = "cs_billing_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date csBillingDate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cs_case_number")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String csCaseNumber;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cs_case_type_en")
    private String csCaseTypeEn;
    @Size(max = 255)
    @Column(name = "cs_doctor_ident")
    private String csDoctorIdent;
    @Column(name = "cs_fee_group_en")
    private BigInteger csFeeGroupEn;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cs_hospital_ident")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String csHospitalIdent;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cs_kis_status_fl")
    private long csKisStatusFl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cs_status_en")
    private String csStatusEn;
    
    
    @Size(max = 255)
    @Column(name = "insurance_identifier")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String insuranceIdentifier;
    
    
    @Size(max = 255)
    @Column(name = "insurance_number_patient")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String insuranceNumberPatient;
    
    
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_patient_id", referencedColumnName = "id")
    @ManyToOne
    private TPatient tPatientId;
    @OneToMany(mappedBy = "tCaseId")
    private Collection<TCaseDetails> tCaseDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tCaseId")
    private Collection<TP301KainInka> tP301KainInkaCollection;
    @OneToMany(mappedBy = "tCaseId")
    private Collection<TWmEvent> tWmEventCollection;

    public TCase() {
    }

    public TCase(BigDecimal id) {
        this.id = id;
    }

    public TCase(BigDecimal id, short cancelFl, String csCaseNumber, String csCaseTypeEn, String csHospitalIdent, long csKisStatusFl, String csStatusEn, BigDecimal version) {
        this.id = id;
        this.cancelFl = cancelFl;
        this.csCaseNumber = csCaseNumber;
        this.csCaseTypeEn = csCaseTypeEn;
        this.csHospitalIdent = csHospitalIdent;
        this.csKisStatusFl = csKisStatusFl;
        this.csStatusEn = csStatusEn;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public short getCancelFl() {
        return cancelFl;
    }

    public void setCancelFl(short cancelFl) {
        this.cancelFl = cancelFl;
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

    public Date getCsBillingDate() {
        return csBillingDate;
    }

    public void setCsBillingDate(Date csBillingDate) {
        this.csBillingDate = csBillingDate;
    }

    public String getCsCaseNumber() {
        return csCaseNumber;
    }

    public void setCsCaseNumber(String csCaseNumber) {
        this.csCaseNumber = csCaseNumber;
    }

    public String getCsCaseTypeEn() {
        return csCaseTypeEn;
    }

    public void setCsCaseTypeEn(String csCaseTypeEn) {
        this.csCaseTypeEn = csCaseTypeEn;
    }

    public String getCsDoctorIdent() {
        return csDoctorIdent;
    }

    public void setCsDoctorIdent(String csDoctorIdent) {
        this.csDoctorIdent = csDoctorIdent;
    }

    public BigInteger getCsFeeGroupEn() {
        return csFeeGroupEn;
    }

    public void setCsFeeGroupEn(BigInteger csFeeGroupEn) {
        this.csFeeGroupEn = csFeeGroupEn;
    }

    public String getCsHospitalIdent() {
        return csHospitalIdent;
    }

    public void setCsHospitalIdent(String csHospitalIdent) {
        this.csHospitalIdent = csHospitalIdent;
    }

    public long getCsKisStatusFl() {
        return csKisStatusFl;
    }

    public void setCsKisStatusFl(long csKisStatusFl) {
        this.csKisStatusFl = csKisStatusFl;
    }

    public String getCsStatusEn() {
        return csStatusEn;
    }

    public void setCsStatusEn(String csStatusEn) {
        this.csStatusEn = csStatusEn;
    }

    public String getInsuranceIdentifier() {
        return insuranceIdentifier;
    }

    public void setInsuranceIdentifier(String insuranceIdentifier) {
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public String getInsuranceNumberPatient() {
        return insuranceNumberPatient;
    }

    public void setInsuranceNumberPatient(String insuranceNumberPatient) {
        this.insuranceNumberPatient = insuranceNumberPatient;
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

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public TPatient getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(TPatient tPatientId) {
        this.tPatientId = tPatientId;
    }

    @XmlTransient
    public Collection<TCaseDetails> getTCaseDetailsCollection() {
        return tCaseDetailsCollection;
    }

    public void setTCaseDetailsCollection(Collection<TCaseDetails> tCaseDetailsCollection) {
        this.tCaseDetailsCollection = tCaseDetailsCollection;
    }

    @XmlTransient
    public Collection<TP301KainInka> getTP301KainInkaCollection() {
        return tP301KainInkaCollection;
    }

    public void setTP301KainInkaCollection(Collection<TP301KainInka> tP301KainInkaCollection) {
        this.tP301KainInkaCollection = tP301KainInkaCollection;
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
        if (!(object instanceof TCase)) {
            return false;
        }
        TCase other = (TCase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TCase[ id=" + id + " ]";
    }

}
