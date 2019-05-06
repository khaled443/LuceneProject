/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kk
 */
public class Fall implements Serializable {

    //Tcase
    String cs_case_number;
    String cs_hospital_ident;
    String insurance_identifier;
    String insurance_number_patient;

    //TCase_details
    List<String> hd_icd_code;
    List<String> csd_comment;
    List<BigInteger> age_years;
    List<Date> admisstion_date;

    public Fall() {

    }

    public Fall(String cs_case_number) {
        this.cs_case_number = cs_case_number;
    }

    public Fall(String cs_case_number, String cs_hospital_ident, String insurance_identifier, 
            String insurance_number_patient, List<String> hd_icd_code, List<String> csd_comment,
            List<BigInteger> age_years, List<Date> admisstion_date) {
        this.cs_case_number = cs_case_number;
        this.cs_hospital_ident = cs_hospital_ident;
        this.insurance_identifier = insurance_identifier;
        this.insurance_number_patient = insurance_number_patient;
        this.hd_icd_code = hd_icd_code;
        this.csd_comment = csd_comment;
        this.age_years = age_years;
        this.admisstion_date = admisstion_date;
    }

    public String getCs_case_number() {
        return cs_case_number;
    }

    public void setCs_case_number(String cs_case_number) {
        this.cs_case_number = cs_case_number;
    }

    public String getCs_hospital_ident() {
        return cs_hospital_ident;
    }

    public void setCs_hospital_ident(String cs_hospital_ident) {
        this.cs_hospital_ident = cs_hospital_ident;
    }

    public String getInsurance_identifier() {
        return insurance_identifier;
    }

    public void setInsurance_identifier(String insurance_identifier) {
        this.insurance_identifier = insurance_identifier;
    }

    public String getInsurance_number_patient() {
        return insurance_number_patient;
    }

    public void setInsurance_number_patient(String insurance_number_patient) {
        this.insurance_number_patient = insurance_number_patient;
    }

    public List<String> getHd_icd_code() {
        return hd_icd_code;
    }

    public void setHd_icd_code(List<String> hd_icd_code) {
        this.hd_icd_code = hd_icd_code;
    }



    public List<String> getCsd_comment() {
        return csd_comment;
    }

    public void setCsd_comment(List<String> csd_comment) {
        this.csd_comment = csd_comment;
    }

    public List<BigInteger> getAge_years() {
        return age_years;
    }

    public void setAge_years(List<BigInteger> age_years) {
        this.age_years = age_years;
    }

    public List<Date> getAdmisstion_date() {
        return admisstion_date;
    }

    public void setAdmisstion_date(List<Date> admisstion_date) {
        this.admisstion_date = admisstion_date;
    }

}
