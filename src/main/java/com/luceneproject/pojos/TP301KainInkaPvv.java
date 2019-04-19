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
@Table(name = "t_p301_kain_inka_pvv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TP301KainInkaPvv.findAll", query = "SELECT t FROM TP301KainInkaPvv t")
    , @NamedQuery(name = "TP301KainInkaPvv.findById", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.id = :id")
    , @NamedQuery(name = "TP301KainInkaPvv.findByBillDate", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.billDate = :billDate")
    , @NamedQuery(name = "TP301KainInkaPvv.findByBillNr", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.billNr = :billNr")
    , @NamedQuery(name = "TP301KainInkaPvv.findByCreationDate", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TP301KainInkaPvv.findByCreationUser", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TP301KainInkaPvv.findByInformationKey30", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.informationKey30 = :informationKey30")
    , @NamedQuery(name = "TP301KainInkaPvv.findByModificationDate", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TP301KainInkaPvv.findByModificationUser", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TP301KainInkaPvv.findByVersion", query = "SELECT t FROM TP301KainInkaPvv t WHERE t.version = :version")})
public class TP301KainInkaPvv implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bill_nr")
    private String billNr;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "information_key_30")
    private String informationKey30;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tP301KainInkaPvvId")
    private Collection<TP301KainInkaPvt> tP301KainInkaPvtCollection;
    @JoinColumn(name = "t_p301_kain_inka_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TP301KainInka tP301KainInkaId;

    public TP301KainInkaPvv() {
    }

    public TP301KainInkaPvv(BigDecimal id) {
        this.id = id;
    }

    public TP301KainInkaPvv(BigDecimal id, Date billDate, String billNr, String informationKey30, BigDecimal version) {
        this.id = id;
        this.billDate = billDate;
        this.billNr = billNr;
        this.informationKey30 = informationKey30;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillNr() {
        return billNr;
    }

    public void setBillNr(String billNr) {
        this.billNr = billNr;
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

    public String getInformationKey30() {
        return informationKey30;
    }

    public void setInformationKey30(String informationKey30) {
        this.informationKey30 = informationKey30;
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

    @XmlTransient
    public Collection<TP301KainInkaPvt> getTP301KainInkaPvtCollection() {
        return tP301KainInkaPvtCollection;
    }

    public void setTP301KainInkaPvtCollection(Collection<TP301KainInkaPvt> tP301KainInkaPvtCollection) {
        this.tP301KainInkaPvtCollection = tP301KainInkaPvtCollection;
    }

    public TP301KainInka getTP301KainInkaId() {
        return tP301KainInkaId;
    }

    public void setTP301KainInkaId(TP301KainInka tP301KainInkaId) {
        this.tP301KainInkaId = tP301KainInkaId;
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
        if (!(object instanceof TP301KainInkaPvv)) {
            return false;
        }
        TP301KainInkaPvv other = (TP301KainInkaPvv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TP301KainInkaPvv[ id=" + id + " ]";
    }
    
}
