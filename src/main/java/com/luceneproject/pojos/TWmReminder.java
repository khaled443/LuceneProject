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
@Table(name = "t_wm_reminder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmReminder.findAll", query = "SELECT t FROM TWmReminder t")
    , @NamedQuery(name = "TWmReminder.findById", query = "SELECT t FROM TWmReminder t WHERE t.id = :id")
    , @NamedQuery(name = "TWmReminder.findByAssignedUserId", query = "SELECT t FROM TWmReminder t WHERE t.assignedUserId = :assignedUserId")
    , @NamedQuery(name = "TWmReminder.findByCreationDate", query = "SELECT t FROM TWmReminder t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmReminder.findByCreationUser", query = "SELECT t FROM TWmReminder t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmReminder.findByDueDate", query = "SELECT t FROM TWmReminder t WHERE t.dueDate = :dueDate")
    , @NamedQuery(name = "TWmReminder.findByFinishedFl", query = "SELECT t FROM TWmReminder t WHERE t.finishedFl = :finishedFl")
    , @NamedQuery(name = "TWmReminder.findByHighPrioFl", query = "SELECT t FROM TWmReminder t WHERE t.highPrioFl = :highPrioFl")
    , @NamedQuery(name = "TWmReminder.findByModificationDate", query = "SELECT t FROM TWmReminder t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmReminder.findByModificationUser", query = "SELECT t FROM TWmReminder t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmReminder.findByReminderComment", query = "SELECT t FROM TWmReminder t WHERE t.reminderComment = :reminderComment")
    , @NamedQuery(name = "TWmReminder.findBySubject", query = "SELECT t FROM TWmReminder t WHERE t.subject = :subject")
    , @NamedQuery(name = "TWmReminder.findByVersion", query = "SELECT t FROM TWmReminder t WHERE t.version = :version")})
public class TWmReminder implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assigned_user_id")
    private BigDecimal assignedUserId;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finished_fl")
    private short finishedFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "high_prio_fl")
    private short highPrioFl;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Size(max = 255)
    @Column(name = "reminder_comment")
    private String reminderComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subject")
    private BigDecimal subject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @OneToMany(mappedBy = "tWmReminderId")
    private Collection<TWmRequestMdk> tWmRequestMdkCollection;
    @JoinColumn(name = "t_wm_process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TWmProcess tWmProcessId;
    @OneToMany(mappedBy = "tWmReminderId")
    private Collection<TWmEvent> tWmEventCollection;

    public TWmReminder() {
    }

    public TWmReminder(BigDecimal id) {
        this.id = id;
    }

    public TWmReminder(BigDecimal id, BigDecimal assignedUserId, short finishedFl, short highPrioFl, BigDecimal subject, BigDecimal version) {
        this.id = id;
        this.assignedUserId = assignedUserId;
        this.finishedFl = finishedFl;
        this.highPrioFl = highPrioFl;
        this.subject = subject;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(BigDecimal assignedUserId) {
        this.assignedUserId = assignedUserId;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public short getFinishedFl() {
        return finishedFl;
    }

    public void setFinishedFl(short finishedFl) {
        this.finishedFl = finishedFl;
    }

    public short getHighPrioFl() {
        return highPrioFl;
    }

    public void setHighPrioFl(short highPrioFl) {
        this.highPrioFl = highPrioFl;
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

    public String getReminderComment() {
        return reminderComment;
    }

    public void setReminderComment(String reminderComment) {
        this.reminderComment = reminderComment;
    }

    public BigDecimal getSubject() {
        return subject;
    }

    public void setSubject(BigDecimal subject) {
        this.subject = subject;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<TWmRequestMdk> getTWmRequestMdkCollection() {
        return tWmRequestMdkCollection;
    }

    public void setTWmRequestMdkCollection(Collection<TWmRequestMdk> tWmRequestMdkCollection) {
        this.tWmRequestMdkCollection = tWmRequestMdkCollection;
    }

    public TWmProcess getTWmProcessId() {
        return tWmProcessId;
    }

    public void setTWmProcessId(TWmProcess tWmProcessId) {
        this.tWmProcessId = tWmProcessId;
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
        if (!(object instanceof TWmReminder)) {
            return false;
        }
        TWmReminder other = (TWmReminder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmReminder[ id=" + id + " ]";
    }
    
}
