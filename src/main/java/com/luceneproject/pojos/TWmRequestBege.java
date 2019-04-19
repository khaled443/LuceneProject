/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_wm_request_bege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWmRequestBege.findAll", query = "SELECT t FROM TWmRequestBege t")
    , @NamedQuery(name = "TWmRequestBege.findById", query = "SELECT t FROM TWmRequestBege t WHERE t.id = :id")
    , @NamedQuery(name = "TWmRequestBege.findByBegeComment", query = "SELECT t FROM TWmRequestBege t WHERE t.begeComment = :begeComment")
    , @NamedQuery(name = "TWmRequestBege.findByBegeEditor", query = "SELECT t FROM TWmRequestBege t WHERE t.begeEditor = :begeEditor")
    , @NamedQuery(name = "TWmRequestBege.findByDirectFax", query = "SELECT t FROM TWmRequestBege t WHERE t.directFax = :directFax")
    , @NamedQuery(name = "TWmRequestBege.findByDirectPhone", query = "SELECT t FROM TWmRequestBege t WHERE t.directPhone = :directPhone")
    , @NamedQuery(name = "TWmRequestBege.findByInsuranceIdentifier", query = "SELECT t FROM TWmRequestBege t WHERE t.insuranceIdentifier = :insuranceIdentifier")})
public class TWmRequestBege implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "bege_comment")
    private String begeComment;
    @Size(max = 255)
    @Column(name = "bege_editor")
    private String begeEditor;
    @Size(max = 255)
    @Column(name = "direct_fax")
    private String directFax;
    @Size(max = 255)
    @Column(name = "direct_phone")
    private String directPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "insurance_identifier")
    private String insuranceIdentifier;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TWmRequest tWmRequest;

    public TWmRequestBege() {
    }

    public TWmRequestBege(BigDecimal id) {
        this.id = id;
    }

    public TWmRequestBege(BigDecimal id, String insuranceIdentifier) {
        this.id = id;
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getBegeComment() {
        return begeComment;
    }

    public void setBegeComment(String begeComment) {
        this.begeComment = begeComment;
    }

    public String getBegeEditor() {
        return begeEditor;
    }

    public void setBegeEditor(String begeEditor) {
        this.begeEditor = begeEditor;
    }

    public String getDirectFax() {
        return directFax;
    }

    public void setDirectFax(String directFax) {
        this.directFax = directFax;
    }

    public String getDirectPhone() {
        return directPhone;
    }

    public void setDirectPhone(String directPhone) {
        this.directPhone = directPhone;
    }

    public String getInsuranceIdentifier() {
        return insuranceIdentifier;
    }

    public void setInsuranceIdentifier(String insuranceIdentifier) {
        this.insuranceIdentifier = insuranceIdentifier;
    }

    public TWmRequest getTWmRequest() {
        return tWmRequest;
    }

    public void setTWmRequest(TWmRequest tWmRequest) {
        this.tWmRequest = tWmRequest;
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
        if (!(object instanceof TWmRequestBege)) {
            return false;
        }
        TWmRequestBege other = (TWmRequestBege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.luceneproject.TWmRequestBege[ id=" + id + " ]";
    }
    
}
