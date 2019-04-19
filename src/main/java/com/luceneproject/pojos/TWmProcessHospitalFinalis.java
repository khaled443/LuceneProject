/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "t_wm_process_hospital_finalis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmProcessHospitalFinalis.findAll", query = "SELECT t FROM TWmProcessHospitalFinalis t")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findById", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.id = :id")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByClosingDateProcess", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.closingDateProcess = :closingDateProcess")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByClosingResult", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.closingResult = :closingResult")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByCreationDate", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByCreationUser", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByCwDiff", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.cwDiff = :cwDiff")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByCwFinal", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.cwFinal = :cwFinal")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByCwInitial", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.cwInitial = :cwInitial")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByDiffSupplementaryFee", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.diffSupplementaryFee = :diffSupplementaryFee")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByDrgFinal", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.drgFinal = :drgFinal")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByDrgInitial", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.drgInitial = :drgInitial")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByFeecUnbilledDays", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.feecUnbilledDays = :feecUnbilledDays")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByFinalSupplementaryFee", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.finalSupplementaryFee = :finalSupplementaryFee")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByFinalVersion", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.finalVersion = :finalVersion")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByFinalVersionComment", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.finalVersionComment = :finalVersionComment")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByFinalVersionNumber", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.finalVersionNumber = :finalVersionNumber")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByInitialSupplementaryFee", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.initialSupplementaryFee = :initialSupplementaryFee")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByInitialVersion", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.initialVersion = :initialVersion")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByInitialVersionComment", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.initialVersionComment = :initialVersionComment")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByInitialVersionNumber", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.initialVersionNumber = :initialVersionNumber")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByLosDiff", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.losDiff = :losDiff")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByLosFinal", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.losFinal = :losFinal")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByLosInitial", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.losInitial = :losInitial")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByModificationDate", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByModificationUser", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByResultComment", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.resultComment = :resultComment")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByRevenueDiff", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.revenueDiff = :revenueDiff")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByRevenueFinal", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.revenueFinal = :revenueFinal")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByRevenueInitial", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.revenueInitial = :revenueInitial")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findBySavedDays", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.savedDays = :savedDays")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findBySavedMoney", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.savedMoney = :savedMoney")
    , @NamedQuery(name = "TWmProcessHospitalFinalis.findByVersion", query = "SELECT t FROM TWmProcessHospitalFinalis t WHERE t.version = :version")})
public class TWmProcessHospitalFinalis implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closing_date_process")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closingDateProcess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closing_result")
    private BigDecimal closingResult;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Column(name = "cw_diff")
    private Double cwDiff;
    @Column(name = "cw_final")
    private Double cwFinal;
    @Column(name = "cw_initial")
    private Double cwInitial;
    @Column(name = "diff_supplementary_fee")
    private Double diffSupplementaryFee;
    @Size(max = 255)
    @Column(name = "drg_final")
    private String drgFinal;
    @Size(max = 255)
    @Column(name = "drg_initial")
    private String drgInitial;
    @Column(name = "feec_unbilled_days")
    private BigInteger feecUnbilledDays;
    @Column(name = "final_supplementary_fee")
    private Double finalSupplementaryFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "final_version")
    private BigDecimal finalVersion;
    @Size(max = 255)
    @Column(name = "final_version_comment")
    private String finalVersionComment;
    @Column(name = "final_version_number")
    private BigDecimal finalVersionNumber;
    @Column(name = "initial_supplementary_fee")
    private Double initialSupplementaryFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "initial_version")
    private BigDecimal initialVersion;
    @Size(max = 255)
    @Column(name = "initial_version_comment")
    private String initialVersionComment;
    @Column(name = "initial_version_number")
    private BigDecimal initialVersionNumber;
    @Column(name = "los_diff")
    private BigInteger losDiff;
    @Column(name = "los_final")
    private BigInteger losFinal;
    @Column(name = "los_initial")
    private BigInteger losInitial;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Size(max = 255)
    @Column(name = "result_comment")
    private String resultComment;
    @Column(name = "revenue_diff")
    private Double revenueDiff;
    @Column(name = "revenue_final")
    private Double revenueFinal;
    @Column(name = "revenue_initial")
    private Double revenueInitial;
    @Column(name = "saved_days")
    private BigInteger savedDays;
    @Column(name = "saved_money")
    private BigInteger savedMoney;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @JoinColumn(name = "t_wm_process_hospital_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TWmProcessHospital tWmProcessHospitalId;

    public TWmProcessHospitalFinalis() {
    }

    public TWmProcessHospitalFinalis(BigDecimal id) {
        this.id = id;
    }

    public TWmProcessHospitalFinalis(BigDecimal id, Date closingDateProcess, BigDecimal closingResult, BigDecimal finalVersion, BigDecimal initialVersion, BigDecimal version) {
        this.id = id;
        this.closingDateProcess = closingDateProcess;
        this.closingResult = closingResult;
        this.finalVersion = finalVersion;
        this.initialVersion = initialVersion;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getClosingDateProcess() {
        return closingDateProcess;
    }

    public void setClosingDateProcess(Date closingDateProcess) {
        this.closingDateProcess = closingDateProcess;
    }

    public BigDecimal getClosingResult() {
        return closingResult;
    }

    public void setClosingResult(BigDecimal closingResult) {
        this.closingResult = closingResult;
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

    public Double getCwDiff() {
        return cwDiff;
    }

    public void setCwDiff(Double cwDiff) {
        this.cwDiff = cwDiff;
    }

    public Double getCwFinal() {
        return cwFinal;
    }

    public void setCwFinal(Double cwFinal) {
        this.cwFinal = cwFinal;
    }

    public Double getCwInitial() {
        return cwInitial;
    }

    public void setCwInitial(Double cwInitial) {
        this.cwInitial = cwInitial;
    }

    public Double getDiffSupplementaryFee() {
        return diffSupplementaryFee;
    }

    public void setDiffSupplementaryFee(Double diffSupplementaryFee) {
        this.diffSupplementaryFee = diffSupplementaryFee;
    }

    public String getDrgFinal() {
        return drgFinal;
    }

    public void setDrgFinal(String drgFinal) {
        this.drgFinal = drgFinal;
    }

    public String getDrgInitial() {
        return drgInitial;
    }

    public void setDrgInitial(String drgInitial) {
        this.drgInitial = drgInitial;
    }

    public BigInteger getFeecUnbilledDays() {
        return feecUnbilledDays;
    }

    public void setFeecUnbilledDays(BigInteger feecUnbilledDays) {
        this.feecUnbilledDays = feecUnbilledDays;
    }

    public Double getFinalSupplementaryFee() {
        return finalSupplementaryFee;
    }

    public void setFinalSupplementaryFee(Double finalSupplementaryFee) {
        this.finalSupplementaryFee = finalSupplementaryFee;
    }

    public BigDecimal getFinalVersion() {
        return finalVersion;
    }

    public void setFinalVersion(BigDecimal finalVersion) {
        this.finalVersion = finalVersion;
    }

    public String getFinalVersionComment() {
        return finalVersionComment;
    }

    public void setFinalVersionComment(String finalVersionComment) {
        this.finalVersionComment = finalVersionComment;
    }

    public BigDecimal getFinalVersionNumber() {
        return finalVersionNumber;
    }

    public void setFinalVersionNumber(BigDecimal finalVersionNumber) {
        this.finalVersionNumber = finalVersionNumber;
    }

    public Double getInitialSupplementaryFee() {
        return initialSupplementaryFee;
    }

    public void setInitialSupplementaryFee(Double initialSupplementaryFee) {
        this.initialSupplementaryFee = initialSupplementaryFee;
    }

    public BigDecimal getInitialVersion() {
        return initialVersion;
    }

    public void setInitialVersion(BigDecimal initialVersion) {
        this.initialVersion = initialVersion;
    }

    public String getInitialVersionComment() {
        return initialVersionComment;
    }

    public void setInitialVersionComment(String initialVersionComment) {
        this.initialVersionComment = initialVersionComment;
    }

    public BigDecimal getInitialVersionNumber() {
        return initialVersionNumber;
    }

    public void setInitialVersionNumber(BigDecimal initialVersionNumber) {
        this.initialVersionNumber = initialVersionNumber;
    }

    public BigInteger getLosDiff() {
        return losDiff;
    }

    public void setLosDiff(BigInteger losDiff) {
        this.losDiff = losDiff;
    }

    public BigInteger getLosFinal() {
        return losFinal;
    }

    public void setLosFinal(BigInteger losFinal) {
        this.losFinal = losFinal;
    }

    public BigInteger getLosInitial() {
        return losInitial;
    }

    public void setLosInitial(BigInteger losInitial) {
        this.losInitial = losInitial;
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

    public String getResultComment() {
        return resultComment;
    }

    public void setResultComment(String resultComment) {
        this.resultComment = resultComment;
    }

    public Double getRevenueDiff() {
        return revenueDiff;
    }

    public void setRevenueDiff(Double revenueDiff) {
        this.revenueDiff = revenueDiff;
    }

    public Double getRevenueFinal() {
        return revenueFinal;
    }

    public void setRevenueFinal(Double revenueFinal) {
        this.revenueFinal = revenueFinal;
    }

    public Double getRevenueInitial() {
        return revenueInitial;
    }

    public void setRevenueInitial(Double revenueInitial) {
        this.revenueInitial = revenueInitial;
    }

    public BigInteger getSavedDays() {
        return savedDays;
    }

    public void setSavedDays(BigInteger savedDays) {
        this.savedDays = savedDays;
    }

    public BigInteger getSavedMoney() {
        return savedMoney;
    }

    public void setSavedMoney(BigInteger savedMoney) {
        this.savedMoney = savedMoney;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public TWmProcessHospital getTWmProcessHospitalId() {
        return tWmProcessHospitalId;
    }

    public void setTWmProcessHospitalId(TWmProcessHospital tWmProcessHospitalId) {
        this.tWmProcessHospitalId = tWmProcessHospitalId;
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
        if (!(object instanceof TWmProcessHospitalFinalis)) {
            return false;
        }
        TWmProcessHospitalFinalis other = (TWmProcessHospitalFinalis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmProcessHospitalFinalis[ id=" + id + " ]";
    }
    
}
