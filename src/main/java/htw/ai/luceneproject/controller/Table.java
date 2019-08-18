/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htw.ai.luceneproject.controller;

import htw.ai.luceneproject.service.Fall;
import htw.ai.luceneproject.service.FallLazyDataModel;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;

/**
 * Table 
 * @author Khaled Halabieh
 */
@ManagedBean(name = "fallData")
@SessionScoped


public class Table implements Serializable{
  
    FallLazyDataModel dataModel = new  FallLazyDataModel();

    /**
     * get lazy Data Model
     * @return FallLazyDataModel
     */
    public LazyDataModel<Fall> getModel(){
        return dataModel;
    }
    
    public int getDataSize(){
        System.out.println("Data RowCount:  " + dataModel.getRowCount());
        return dataModel.getRowCount();
    }
    
}