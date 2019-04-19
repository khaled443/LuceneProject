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
@Table(name = "t_patient_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPatientDetails.findAll", query = "SELECT t FROM TPatientDetails t")
    , @NamedQuery(name = "TPatientDetails.findById", query = "SELECT t FROM TPatientDetails t WHERE t.id = :id")
    , @NamedQuery(name = "TPatientDetails.findByCreationDate", query = "SELECT t FROM TPatientDetails t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TPatientDetails.findByCreationUser", query = "SELECT t FROM TPatientDetails t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TPatientDetails.findByModificationDate", query = "SELECT t FROM TPatientDetails t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TPatientDetails.findByModificationUser", query = "SELECT t FROM TPatientDetails t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TPatientDetails.findByPatdAddress", query = "SELECT t FROM TPatientDetails t WHERE t.patdAddress = :patdAddress")
    , @NamedQuery(name = "TPatientDetails.findByPatdCellNumber", query = "SELECT t FROM TPatientDetails t WHERE t.patdCellNumber = :patdCellNumber")
    , @NamedQuery(name = "TPatientDetails.findByPatdCity", query = "SELECT t FROM TPatientDetails t WHERE t.patdCity = :patdCity")
    , @NamedQuery(name = "TPatientDetails.findByPatdCountry", query = "SELECT t FROM TPatientDetails t WHERE t.patdCountry = :patdCountry")
    , @NamedQuery(name = "TPatientDetails.findByPatdIsActualFl", query = "SELECT t FROM TPatientDetails t WHERE t.patdIsActualFl = :patdIsActualFl")
    , @NamedQuery(name = "TPatientDetails.findByPatdPhoneNumber", query = "SELECT t FROM TPatientDetails t WHERE t.patdPhoneNumber = :patdPhoneNumber")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostAddress", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostAddress = :patdPostAddress")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostCity", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostCity = :patdPostCity")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostCountry", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostCountry = :patdPostCountry")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostDiffFl", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostDiffFl = :patdPostDiffFl")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostState", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostState = :patdPostState")
    , @NamedQuery(name = "TPatientDetails.findByPatdPostZipcode", query = "SELECT t FROM TPatientDetails t WHERE t.patdPostZipcode = :patdPostZipcode")
    , @NamedQuery(name = "TPatientDetails.findByPatdState", query = "SELECT t FROM TPatientDetails t WHERE t.patdState = :patdState")
    , @NamedQuery(name = "TPatientDetails.findByPatdZipcode", query = "SELECT t FROM TPatientDetails t WHERE t.patdZipcode = :patdZipcode")
    , @NamedQuery(name = "TPatientDetails.findByVersion", query = "SELECT t FROM TPatientDetails t WHERE t.version = :version")})
public class TPatientDetails implements Serializable {

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
    @Size(max = 255)
    @Column(name = "patd_address")
    private String patdAddress;
    @Size(max = 255)
    @Column(name = "patd_cell_number")
    private String patdCellNumber;
    @Size(max = 255)
    @Column(name = "patd_city")
    private String patdCity;
    @Size(max = 255)
    @Column(name = "patd_country")
    private String patdCountry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patd_is_actual_fl")
    private long patdIsActualFl;
    @Size(max = 255)
    @Column(name = "patd_phone_number")
    private String patdPhoneNumber;
    @Size(max = 255)
    @Column(name = "patd_post_address")
    private String patdPostAddress;
    @Size(max = 255)
    @Column(name = "patd_post_city")
    private String patdPostCity;
    @Size(max = 255)
    @Column(name = "patd_post_country")
    private String patdPostCountry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patd_post_diff_fl")
    private long patdPostDiffFl;
    @Size(max = 255)
    @Column(name = "patd_post_state")
    private String patdPostState;
    @Size(max = 255)
    @Column(name = "patd_post_zipcode")
    private String patdPostZipcode;
    @Size(max = 255)
    @Column(name = "patd_state")
    private String patdState;
    @Size(max = 255)
    @Column(name = "patd_zipcode")
    private String patdZipcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TPatient tPatientId;

    public TPatientDetails() {
    }

    public TPatientDetails(BigDecimal id) {
        this.id = id;
    }

    public TPatientDetails(BigDecimal id, long patdIsActualFl, long patdPostDiffFl, BigDecimal version) {
        this.id = id;
        this.patdIsActualFl = patdIsActualFl;
        this.patdPostDiffFl = patdPostDiffFl;
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

    public String getPatdAddress() {
        return patdAddress;
    }

    public void setPatdAddress(String patdAddress) {
        this.patdAddress = patdAddress;
    }

    public String getPatdCellNumber() {
        return patdCellNumber;
    }

    public void setPatdCellNumber(String patdCellNumber) {
        this.patdCellNumber = patdCellNumber;
    }

    public String getPatdCity() {
        return patdCity;
    }

    public void setPatdCity(String patdCity) {
        this.patdCity = patdCity;
    }

    public String getPatdCountry() {
        return patdCountry;
    }

    public void setPatdCountry(String patdCountry) {
        this.patdCountry = patdCountry;
    }

    public long getPatdIsActualFl() {
        return patdIsActualFl;
    }

    public void setPatdIsActualFl(long patdIsActualFl) {
        this.patdIsActualFl = patdIsActualFl;
    }

    public String getPatdPhoneNumber() {
        return patdPhoneNumber;
    }

    public void setPatdPhoneNumber(String patdPhoneNumber) {
        this.patdPhoneNumber = patdPhoneNumber;
    }

    public String getPatdPostAddress() {
        return patdPostAddress;
    }

    public void setPatdPostAddress(String patdPostAddress) {
        this.patdPostAddress = patdPostAddress;
    }

    public String getPatdPostCity() {
        return patdPostCity;
    }

    public void setPatdPostCity(String patdPostCity) {
        this.patdPostCity = patdPostCity;
    }

    public String getPatdPostCountry() {
        return patdPostCountry;
    }

    public void setPatdPostCountry(String patdPostCountry) {
        this.patdPostCountry = patdPostCountry;
    }

    public long getPatdPostDiffFl() {
        return patdPostDiffFl;
    }

    public void setPatdPostDiffFl(long patdPostDiffFl) {
        this.patdPostDiffFl = patdPostDiffFl;
    }

    public String getPatdPostState() {
        return patdPostState;
    }

    public void setPatdPostState(String patdPostState) {
        this.patdPostState = patdPostState;
    }

    public String getPatdPostZipcode() {
        return patdPostZipcode;
    }

    public void setPatdPostZipcode(String patdPostZipcode) {
        this.patdPostZipcode = patdPostZipcode;
    }

    public String getPatdState() {
        return patdState;
    }

    public void setPatdState(String patdState) {
        this.patdState = patdState;
    }

    public String getPatdZipcode() {
        return patdZipcode;
    }

    public void setPatdZipcode(String patdZipcode) {
        this.patdZipcode = patdZipcode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPatientDetails)) {
            return false;
        }
        TPatientDetails other = (TPatientDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TPatientDetails[ id=" + id + " ]";
    }
    
}
