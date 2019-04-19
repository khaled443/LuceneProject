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
@Table(name = "t_p301_kain_inka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TP301KainInka.findAll", query = "SELECT t FROM TP301KainInka t")
    , @NamedQuery(name = "TP301KainInka.findById", query = "SELECT t FROM TP301KainInka t WHERE t.id = :id")
    , @NamedQuery(name = "TP301KainInka.findByContractReference", query = "SELECT t FROM TP301KainInka t WHERE t.contractReference = :contractReference")
    , @NamedQuery(name = "TP301KainInka.findByCostUnitSap", query = "SELECT t FROM TP301KainInka t WHERE t.costUnitSap = :costUnitSap")
    , @NamedQuery(name = "TP301KainInka.findByCreationDate", query = "SELECT t FROM TP301KainInka t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TP301KainInka.findByCreationUser", query = "SELECT t FROM TP301KainInka t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TP301KainInka.findByCurrentTransactionNr", query = "SELECT t FROM TP301KainInka t WHERE t.currentTransactionNr = :currentTransactionNr")
    , @NamedQuery(name = "TP301KainInka.findByHospitalIdentifier", query = "SELECT t FROM TP301KainInka t WHERE t.hospitalIdentifier = :hospitalIdentifier")
    , @NamedQuery(name = "TP301KainInka.findByHospitalNumberPatient", query = "SELECT t FROM TP301KainInka t WHERE t.hospitalNumberPatient = :hospitalNumberPatient")
    , @NamedQuery(name = "TP301KainInka.findByInsuranceCaseNumber", query = "SELECT t FROM TP301KainInka t WHERE t.insuranceCaseNumber = :insuranceCaseNumber")
    , @NamedQuery(name = "TP301KainInka.findByInsuranceIdentifier", query = "SELECT t FROM TP301KainInka t WHERE t.insuranceIdentifier = :insuranceIdentifier")
    , @NamedQuery(name = "TP301KainInka.findByInsuranceRefNumber", query = "SELECT t FROM TP301KainInka t WHERE t.insuranceRefNumber = :insuranceRefNumber")
    , @NamedQuery(name = "TP301KainInka.findByMessageType", query = "SELECT t FROM TP301KainInka t WHERE t.messageType = :messageType")
    , @NamedQuery(name = "TP301KainInka.findByModificationDate", query = "SELECT t FROM TP301KainInka t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TP301KainInka.findByModificationUser", query = "SELECT t FROM TP301KainInka t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TP301KainInka.findByProcessingRef", query = "SELECT t FROM TP301KainInka t WHERE t.processingRef = :processingRef")
    , @NamedQuery(name = "TP301KainInka.findByVersion", query = "SELECT t FROM TP301KainInka t WHERE t.version = :version")})
public class TP301KainInka implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "contract_reference")
    private String contractReference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cost_unit_sap")
    private String costUnitSap;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "current_transaction_nr")
    private String currentTransactionNr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hospital_identifier")
    private String hospitalIdentifier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hospital_number_patient")
    private String hospitalNumberPatient;
    @Size(max = 255)
    @Column(name = "insurance_case_number")
    private String insuranceCaseNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "insurance_identifier")
    private String insuranceIdentifier;
    @Size(max = 255)
    @Column(name = "insurance_ref_number")
    private String insuranceRefNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message_type")
    private String messageType;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "processing_ref")
    private String processingRef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_case_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TCase tCaseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tP301KainInkaId")
    private Collection<TP301KainInkaPvv> tP301KainInkaPvvCollection;
    @OneToMany(mappedBy = "tP301KainInkaId")
    private Collection<TWmEvent> tWmEventCollection;

    public TP301KainInka() {
    }

    public TP301KainInka(BigDecimal id) {
        this.id = id;
    }

    public TP301KainInka(BigDecimal id, String costUnitSap, String currentTransactionNr, String hospitalIdentifier, String hospitalNumberPatient, String insuranceIdentifier, String messageType, String processingRef, BigDecimal version) {
        this.id = id;
        this.costUnitSap = costUnitSap;
        this.currentTransactionNr = currentTransactionNr;
        this.hospitalIdentifier = hospitalIdentifier;
        this.hospitalNumberPatient = hospitalNumberPatient;
        this.insuranceIdentifier = insuranceIdentifier;
        this.messageType = messageType;
        this.processingRef = processingRef;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getContractReference() {
        return contractReference;
    }

    public void setContractReference(String contractReference) {
        this.contractReference = contractReference;
    }

    public String getCostUnitSap() {
        return costUnitSap;
    }

    public void setCostUnitSap(String costUnitSap) {
        this.costUnitSap = costUnitSap;
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

    public String getCurrentTransactionNr() {
        return currentTransactionNr;
    }

    public void setCurrentTransactionNr(String currentTransactionNr) {
        this.currentTransactionNr = currentTransactionNr;
    }

    public String getHospitalIdentifier() {
        return hospitalIdentifier;
    }

    public void setHospitalIdentifier(String hospitalIdentifier) {
        this.hospitalIdentifier = hospitalIdentifier;
    }

    public String getHospitalNumberPatient() {
        return hospitalNumberPatient;
    }

    public void setHospitalNumberPatient(String hospitalNumberPatient) {
        this.hospitalNumberPatient = hospitalNumberPatient;
    }

    public String getInsuranceCaseNumber() {
        return insuranceCaseNumber;
    }

    public void setInsuranceCaseNumber(String insuranceCaseNumber) {
        this.insuranceCaseNumber = insuranceCaseNumber;
    }

    public String getInsuranceIdentifier() {
        return insuranceIdentifier;
    }

    public void setInsuranceIdentifier(String insuranceIdentifier) {
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public String getInsuranceRefNumber() {
        return insuranceRefNumber;
    }

    public void setInsuranceRefNumber(String insuranceRefNumber) {
        this.insuranceRefNumber = insuranceRefNumber;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
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

    public String getProcessingRef() {
        return processingRef;
    }

    public void setProcessingRef(String processingRef) {
        this.processingRef = processingRef;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public TCase getTCaseId() {
        return tCaseId;
    }

    public void setTCaseId(TCase tCaseId) {
        this.tCaseId = tCaseId;
    }

    @XmlTransient
    public Collection<TP301KainInkaPvv> getTP301KainInkaPvvCollection() {
        return tP301KainInkaPvvCollection;
    }

    public void setTP301KainInkaPvvCollection(Collection<TP301KainInkaPvv> tP301KainInkaPvvCollection) {
        this.tP301KainInkaPvvCollection = tP301KainInkaPvvCollection;
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
        if (!(object instanceof TP301KainInka)) {
            return false;
        }
        TP301KainInka other = (TP301KainInka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TP301KainInka[ id=" + id + " ]";
    }
    
}
