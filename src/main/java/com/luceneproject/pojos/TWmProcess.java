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
@Table(name = "t_wm_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmProcess.findAll", query = "SELECT t FROM TWmProcess t")
    , @NamedQuery(name = "TWmProcess.findById", query = "SELECT t FROM TWmProcess t WHERE t.id = :id")
    , @NamedQuery(name = "TWmProcess.findByAssignedUser", query = "SELECT t FROM TWmProcess t WHERE t.assignedUser = :assignedUser")
    , @NamedQuery(name = "TWmProcess.findByCreationDate", query = "SELECT t FROM TWmProcess t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmProcess.findByCreationUser", query = "SELECT t FROM TWmProcess t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmProcess.findByLastProcessModification", query = "SELECT t FROM TWmProcess t WHERE t.lastProcessModification = :lastProcessModification")
    , @NamedQuery(name = "TWmProcess.findByModificationDate", query = "SELECT t FROM TWmProcess t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmProcess.findByModificationUser", query = "SELECT t FROM TWmProcess t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmProcess.findByProcessComment", query = "SELECT t FROM TWmProcess t WHERE t.processComment = :processComment")
    , @NamedQuery(name = "TWmProcess.findByProcessModificationUser", query = "SELECT t FROM TWmProcess t WHERE t.processModificationUser = :processModificationUser")
    , @NamedQuery(name = "TWmProcess.findByProcessType", query = "SELECT t FROM TWmProcess t WHERE t.processType = :processType")
    , @NamedQuery(name = "TWmProcess.findByVersion", query = "SELECT t FROM TWmProcess t WHERE t.version = :version")
    , @NamedQuery(name = "TWmProcess.findByWmState", query = "SELECT t FROM TWmProcess t WHERE t.wmState = :wmState")
    , @NamedQuery(name = "TWmProcess.findByWmType", query = "SELECT t FROM TWmProcess t WHERE t.wmType = :wmType")
    , @NamedQuery(name = "TWmProcess.findByWorkflowNumber", query = "SELECT t FROM TWmProcess t WHERE t.workflowNumber = :workflowNumber")})
public class TWmProcess implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "assigned_user")
    private BigDecimal assignedUser;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Column(name = "last_process_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessModification;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Size(max = 255)
    @Column(name = "process_comment")
    private String processComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "process_modification_user")
    private BigDecimal processModificationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "process_type")
    private String processType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "wm_state")
    private String wmState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "wm_type")
    private String wmType;
    @Column(name = "workflow_number")
    private BigDecimal workflowNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tWmProcessId")
    private Collection<TWmAction> tWmActionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tWmProcessId")
    private Collection<TWmReminder> tWmReminderCollection;
    @JoinColumn(name = "t_patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TPatient tPatientId;
    @OneToMany(mappedBy = "tWmProcessId")
    private Collection<TWmDocument> tWmDocumentCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tWmProcess")
    private TWmProcessHospital tWmProcessHospital;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tWmProcessId")
    private Collection<TWmEvent> tWmEventCollection;

    public TWmProcess() {
    }

    public TWmProcess(BigDecimal id) {
        this.id = id;
    }

    public TWmProcess(BigDecimal id, BigDecimal processModificationUser, String processType, BigDecimal version, String wmState, String wmType) {
        this.id = id;
        this.processModificationUser = processModificationUser;
        this.processType = processType;
        this.version = version;
        this.wmState = wmState;
        this.wmType = wmType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(BigDecimal assignedUser) {
        this.assignedUser = assignedUser;
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

    public Date getLastProcessModification() {
        return lastProcessModification;
    }

    public void setLastProcessModification(Date lastProcessModification) {
        this.lastProcessModification = lastProcessModification;
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

    public String getProcessComment() {
        return processComment;
    }

    public void setProcessComment(String processComment) {
        this.processComment = processComment;
    }

    public BigDecimal getProcessModificationUser() {
        return processModificationUser;
    }

    public void setProcessModificationUser(BigDecimal processModificationUser) {
        this.processModificationUser = processModificationUser;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getWmState() {
        return wmState;
    }

    public void setWmState(String wmState) {
        this.wmState = wmState;
    }

    public String getWmType() {
        return wmType;
    }

    public void setWmType(String wmType) {
        this.wmType = wmType;
    }

    public BigDecimal getWorkflowNumber() {
        return workflowNumber;
    }

    public void setWorkflowNumber(BigDecimal workflowNumber) {
        this.workflowNumber = workflowNumber;
    }

    @XmlTransient
    public Collection<TWmAction> getTWmActionCollection() {
        return tWmActionCollection;
    }

    public void setTWmActionCollection(Collection<TWmAction> tWmActionCollection) {
        this.tWmActionCollection = tWmActionCollection;
    }

    @XmlTransient
    public Collection<TWmReminder> getTWmReminderCollection() {
        return tWmReminderCollection;
    }

    public void setTWmReminderCollection(Collection<TWmReminder> tWmReminderCollection) {
        this.tWmReminderCollection = tWmReminderCollection;
    }

    public TPatient getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(TPatient tPatientId) {
        this.tPatientId = tPatientId;
    }

    @XmlTransient
    public Collection<TWmDocument> getTWmDocumentCollection() {
        return tWmDocumentCollection;
    }

    public void setTWmDocumentCollection(Collection<TWmDocument> tWmDocumentCollection) {
        this.tWmDocumentCollection = tWmDocumentCollection;
    }

    public TWmProcessHospital getTWmProcessHospital() {
        return tWmProcessHospital;
    }

    public void setTWmProcessHospital(TWmProcessHospital tWmProcessHospital) {
        this.tWmProcessHospital = tWmProcessHospital;
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
        if (!(object instanceof TWmProcess)) {
            return false;
        }
        TWmProcess other = (TWmProcess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmProcess[ id=" + id + " ]";
    }
    
}
