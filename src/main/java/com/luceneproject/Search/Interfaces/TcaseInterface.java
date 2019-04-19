/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search.Interfaces;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kk
 */
public interface TcaseInterface {

    List getByCsCaseNumber (String number);
    
    List getByCsHospitalIdent(String HospitalIdent);
    
    List getByInsuranceIdentifier(String InsuranceIdentifier);
    
    List getByInsuranceNumberPatient(String InsuranceNumberPatient);
  
}
