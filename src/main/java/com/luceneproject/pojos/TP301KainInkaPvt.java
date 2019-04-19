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
@Table(name = "t_p301_kain_inka_pvt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TP301KainInkaPvt.findAll", query = "SELECT t FROM TP301KainInkaPvt t")
    , @NamedQuery(name = "TP301KainInkaPvt.findById", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.id = :id")
    , @NamedQuery(name = "TP301KainInkaPvt.findByCreationDate", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TP301KainInkaPvt.findByCreationUser", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TP301KainInkaPvt.findByMainDiagIcd", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.mainDiagIcd = :mainDiagIcd")
    , @NamedQuery(name = "TP301KainInkaPvt.findByMainDiagLocEn", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.mainDiagLocEn = :mainDiagLocEn")
    , @NamedQuery(name = "TP301KainInkaPvt.findByMainDiagSecondaryIcd", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.mainDiagSecondaryIcd = :mainDiagSecondaryIcd")
    , @NamedQuery(name = "TP301KainInkaPvt.findByMainDiagSecondaryLocEn", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.mainDiagSecondaryLocEn = :mainDiagSecondaryLocEn")
    , @NamedQuery(name = "TP301KainInkaPvt.findByModificationDate", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TP301KainInkaPvt.findByModificationUser", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TP301KainInkaPvt.findByOpsCode", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.opsCode = :opsCode")
    , @NamedQuery(name = "TP301KainInkaPvt.findByOpsLocalisationEn", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.opsLocalisationEn = :opsLocalisationEn")
    , @NamedQuery(name = "TP301KainInkaPvt.findBySecondaryDiagIcd", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.secondaryDiagIcd = :secondaryDiagIcd")
    , @NamedQuery(name = "TP301KainInkaPvt.findBySecondaryDiagLocEn", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.secondaryDiagLocEn = :secondaryDiagLocEn")
    , @NamedQuery(name = "TP301KainInkaPvt.findBySecondarySecondDiagIcd", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.secondarySecondDiagIcd = :secondarySecondDiagIcd")
    , @NamedQuery(name = "TP301KainInkaPvt.findBySecondarySecondDiagLocEn", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.secondarySecondDiagLocEn = :secondarySecondDiagLocEn")
    , @NamedQuery(name = "TP301KainInkaPvt.findByText", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.text = :text")
    , @NamedQuery(name = "TP301KainInkaPvt.findByVersion", query = "SELECT t FROM TP301KainInkaPvt t WHERE t.version = :version")})
public class TP301KainInkaPvt implements Serializable {

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
    @Size(max = 255)
    @Column(name = "main_diag_icd")
    private String mainDiagIcd;
    @Size(max = 255)
    @Column(name = "main_diag_loc_en")
    private String mainDiagLocEn;
    @Size(max = 255)
    @Column(name = "main_diag_secondary_icd")
    private String mainDiagSecondaryIcd;
    @Size(max = 255)
    @Column(name = "main_diag_secondary_loc_en")
    private String mainDiagSecondaryLocEn;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Size(max = 255)
    @Column(name = "ops_code")
    private String opsCode;
    @Size(max = 255)
    @Column(name = "ops_localisation_en")
    private String opsLocalisationEn;
    @Size(max = 255)
    @Column(name = "secondary_diag_icd")
    private String secondaryDiagIcd;
    @Size(max = 255)
    @Column(name = "secondary_diag_loc_en")
    private String secondaryDiagLocEn;
    @Size(max = 255)
    @Column(name = "secondary_second_diag_icd")
    private String secondarySecondDiagIcd;
    @Size(max = 255)
    @Column(name = "secondary_second_diag_loc_en")
    private String secondarySecondDiagLocEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_p301_kain_inka_pvv_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TP301KainInkaPvv tP301KainInkaPvvId;

    public TP301KainInkaPvt() {
    }

    public TP301KainInkaPvt(BigDecimal id) {
        this.id = id;
    }

    public TP301KainInkaPvt(BigDecimal id, String text, BigDecimal version) {
        this.id = id;
        this.text = text;
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

    public String getMainDiagIcd() {
        return mainDiagIcd;
    }

    public void setMainDiagIcd(String mainDiagIcd) {
        this.mainDiagIcd = mainDiagIcd;
    }

    public String getMainDiagLocEn() {
        return mainDiagLocEn;
    }

    public void setMainDiagLocEn(String mainDiagLocEn) {
        this.mainDiagLocEn = mainDiagLocEn;
    }

    public String getMainDiagSecondaryIcd() {
        return mainDiagSecondaryIcd;
    }

    public void setMainDiagSecondaryIcd(String mainDiagSecondaryIcd) {
        this.mainDiagSecondaryIcd = mainDiagSecondaryIcd;
    }

    public String getMainDiagSecondaryLocEn() {
        return mainDiagSecondaryLocEn;
    }

    public void setMainDiagSecondaryLocEn(String mainDiagSecondaryLocEn) {
        this.mainDiagSecondaryLocEn = mainDiagSecondaryLocEn;
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

    public String getOpsCode() {
        return opsCode;
    }

    public void setOpsCode(String opsCode) {
        this.opsCode = opsCode;
    }

    public String getOpsLocalisationEn() {
        return opsLocalisationEn;
    }

    public void setOpsLocalisationEn(String opsLocalisationEn) {
        this.opsLocalisationEn = opsLocalisationEn;
    }

    public String getSecondaryDiagIcd() {
        return secondaryDiagIcd;
    }

    public void setSecondaryDiagIcd(String secondaryDiagIcd) {
        this.secondaryDiagIcd = secondaryDiagIcd;
    }

    public String getSecondaryDiagLocEn() {
        return secondaryDiagLocEn;
    }

    public void setSecondaryDiagLocEn(String secondaryDiagLocEn) {
        this.secondaryDiagLocEn = secondaryDiagLocEn;
    }

    public String getSecondarySecondDiagIcd() {
        return secondarySecondDiagIcd;
    }

    public void setSecondarySecondDiagIcd(String secondarySecondDiagIcd) {
        this.secondarySecondDiagIcd = secondarySecondDiagIcd;
    }

    public String getSecondarySecondDiagLocEn() {
        return secondarySecondDiagLocEn;
    }

    public void setSecondarySecondDiagLocEn(String secondarySecondDiagLocEn) {
        this.secondarySecondDiagLocEn = secondarySecondDiagLocEn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public TP301KainInkaPvv getTP301KainInkaPvvId() {
        return tP301KainInkaPvvId;
    }

    public void setTP301KainInkaPvvId(TP301KainInkaPvv tP301KainInkaPvvId) {
        this.tP301KainInkaPvvId = tP301KainInkaPvvId;
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
        if (!(object instanceof TP301KainInkaPvt)) {
            return false;
        }
        TP301KainInkaPvt other = (TP301KainInkaPvt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TP301KainInkaPvt[ id=" + id + " ]";
    }
    
}
