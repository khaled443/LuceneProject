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
@Table(name = "t_wm_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmEvent.findAll", query = "SELECT t FROM TWmEvent t")
    , @NamedQuery(name = "TWmEvent.findById", query = "SELECT t FROM TWmEvent t WHERE t.id = :id")
    , @NamedQuery(name = "TWmEvent.findByCreationDate", query = "SELECT t FROM TWmEvent t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmEvent.findByCreationUser", query = "SELECT t FROM TWmEvent t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmEvent.findByCreationUserId", query = "SELECT t FROM TWmEvent t WHERE t.creationUserId = :creationUserId")
    , @NamedQuery(name = "TWmEvent.findByDescription", query = "SELECT t FROM TWmEvent t WHERE t.description = :description")
    , @NamedQuery(name = "TWmEvent.findByEventType", query = "SELECT t FROM TWmEvent t WHERE t.eventType = :eventType")
    , @NamedQuery(name = "TWmEvent.findByModificationDate", query = "SELECT t FROM TWmEvent t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmEvent.findByModificationUser", query = "SELECT t FROM TWmEvent t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmEvent.findBySubject", query = "SELECT t FROM TWmEvent t WHERE t.subject = :subject")
    , @NamedQuery(name = "TWmEvent.findByVersion", query = "SELECT t FROM TWmEvent t WHERE t.version = :version")})
public class TWmEvent implements Serializable {

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
    @Column(name = "creation_user_id")
    private BigDecimal creationUserId;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_type")
    private long eventType;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Size(max = 255)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_case_id", referencedColumnName = "id")
    @ManyToOne
    private TCase tCaseId;
    @JoinColumn(name = "t_p301_kain_inka_id", referencedColumnName = "id")
    @ManyToOne
    private TP301KainInka tP301KainInkaId;
    @JoinColumn(name = "t_wm_action_id", referencedColumnName = "id")
    @ManyToOne
    private TWmAction tWmActionId;
    @JoinColumn(name = "t_wm_document_id", referencedColumnName = "id")
    @ManyToOne
    private TWmDocument tWmDocumentId;
    @JoinColumn(name = "t_wm_process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TWmProcess tWmProcessId;
    @JoinColumn(name = "t_wm_reminder_id", referencedColumnName = "id")
    @ManyToOne
    private TWmReminder tWmReminderId;
    @JoinColumn(name = "t_wm_request_id", referencedColumnName = "id")
    @ManyToOne
    private TWmRequest tWmRequestId;

    public TWmEvent() {
    }

    public TWmEvent(BigDecimal id) {
        this.id = id;
    }

    public TWmEvent(BigDecimal id, long eventType, BigDecimal version) {
        this.id = id;
        this.eventType = eventType;
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

    public BigDecimal getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(BigDecimal creationUserId) {
        this.creationUserId = creationUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEventType() {
        return eventType;
    }

    public void setEventType(long eventType) {
        this.eventType = eventType;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public TP301KainInka getTP301KainInkaId() {
        return tP301KainInkaId;
    }

    public void setTP301KainInkaId(TP301KainInka tP301KainInkaId) {
        this.tP301KainInkaId = tP301KainInkaId;
    }

    public TWmAction getTWmActionId() {
        return tWmActionId;
    }

    public void setTWmActionId(TWmAction tWmActionId) {
        this.tWmActionId = tWmActionId;
    }

    public TWmDocument getTWmDocumentId() {
        return tWmDocumentId;
    }

    public void setTWmDocumentId(TWmDocument tWmDocumentId) {
        this.tWmDocumentId = tWmDocumentId;
    }

    public TWmProcess getTWmProcessId() {
        return tWmProcessId;
    }

    public void setTWmProcessId(TWmProcess tWmProcessId) {
        this.tWmProcessId = tWmProcessId;
    }

    public TWmReminder getTWmReminderId() {
        return tWmReminderId;
    }

    public void setTWmReminderId(TWmReminder tWmReminderId) {
        this.tWmReminderId = tWmReminderId;
    }

    public TWmRequest getTWmRequestId() {
        return tWmRequestId;
    }

    public void setTWmRequestId(TWmRequest tWmRequestId) {
        this.tWmRequestId = tWmRequestId;
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
        if (!(object instanceof TWmEvent)) {
            return false;
        }
        TWmEvent other = (TWmEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmEvent[ id=" + id + " ]";
    }
    
}
