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
@Table(name = "t_wm_document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmDocument.findAll", query = "SELECT t FROM TWmDocument t")
    , @NamedQuery(name = "TWmDocument.findById", query = "SELECT t FROM TWmDocument t WHERE t.id = :id")
    , @NamedQuery(name = "TWmDocument.findByContent", query = "SELECT t FROM TWmDocument t WHERE t.content = :content")
    , @NamedQuery(name = "TWmDocument.findByCreationDate", query = "SELECT t FROM TWmDocument t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmDocument.findByCreationUser", query = "SELECT t FROM TWmDocument t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmDocument.findByDocumentType", query = "SELECT t FROM TWmDocument t WHERE t.documentType = :documentType")
    , @NamedQuery(name = "TWmDocument.findByFilepath", query = "SELECT t FROM TWmDocument t WHERE t.filepath = :filepath")
    , @NamedQuery(name = "TWmDocument.findByModificationDate", query = "SELECT t FROM TWmDocument t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmDocument.findByModificationUser", query = "SELECT t FROM TWmDocument t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmDocument.findByModificationUserId", query = "SELECT t FROM TWmDocument t WHERE t.modificationUserId = :modificationUserId")
    , @NamedQuery(name = "TWmDocument.findByName", query = "SELECT t FROM TWmDocument t WHERE t.name = :name")
    , @NamedQuery(name = "TWmDocument.findByVersion", query = "SELECT t FROM TWmDocument t WHERE t.version = :version")})
public class TWmDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "content")
    private BigInteger content;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Size(max = 255)
    @Column(name = "document_type")
    private String documentType;
    @Size(max = 255)
    @Column(name = "filepath")
    private String filepath;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Column(name = "modification_user_id")
    private BigDecimal modificationUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_wm_process_id", referencedColumnName = "id")
    @ManyToOne
    private TWmProcess tWmProcessId;
    @OneToMany(mappedBy = "tWmDocumentId")
    private Collection<TWmEvent> tWmEventCollection;

    public TWmDocument() {
    }

    public TWmDocument(BigDecimal id) {
        this.id = id;
    }

    public TWmDocument(BigDecimal id, String name, BigDecimal version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContent() {
        return content;
    }

    public void setContent(BigInteger content) {
        this.content = content;
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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof TWmDocument)) {
            return false;
        }
        TWmDocument other = (TWmDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmDocument[ id=" + id + " ]";
    }
    
}
