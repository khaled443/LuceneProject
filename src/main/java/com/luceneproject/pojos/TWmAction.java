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
@Table(name = "t_wm_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmAction.findAll", query = "SELECT t FROM TWmAction t")
    , @NamedQuery(name = "TWmAction.findById", query = "SELECT t FROM TWmAction t WHERE t.id = :id")
    , @NamedQuery(name = "TWmAction.findByActionComment", query = "SELECT t FROM TWmAction t WHERE t.actionComment = :actionComment")
    , @NamedQuery(name = "TWmAction.findByActionSubjectId", query = "SELECT t FROM TWmAction t WHERE t.actionSubjectId = :actionSubjectId")
    , @NamedQuery(name = "TWmAction.findByCreationDate", query = "SELECT t FROM TWmAction t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmAction.findByCreationUser", query = "SELECT t FROM TWmAction t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmAction.findByModificationDate", query = "SELECT t FROM TWmAction t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmAction.findByModificationUser", query = "SELECT t FROM TWmAction t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmAction.findByVersion", query = "SELECT t FROM TWmAction t WHERE t.version = :version")})
public class TWmAction implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Size(max = 2147483647)
    @Column(name = "action_comment")
    private String actionComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "action_subject_id")
    private BigDecimal actionSubjectId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_wm_process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TWmProcess tWmProcessId;
    @OneToMany(mappedBy = "tWmActionId")
    private Collection<TWmEvent> tWmEventCollection;

    public TWmAction() {
    }

    public TWmAction(BigDecimal id) {
        this.id = id;
    }

    public TWmAction(BigDecimal id, BigDecimal actionSubjectId, BigDecimal version) {
        this.id = id;
        this.actionSubjectId = actionSubjectId;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getActionComment() {
        return actionComment;
    }

    public void setActionComment(String actionComment) {
        this.actionComment = actionComment;
    }

    public BigDecimal getActionSubjectId() {
        return actionSubjectId;
    }

    public void setActionSubjectId(BigDecimal actionSubjectId) {
        this.actionSubjectId = actionSubjectId;
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

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
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
        if (!(object instanceof TWmAction)) {
            return false;
        }
        TWmAction other = (TWmAction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmAction[ id=" + id + " ]";
    }
    
}
