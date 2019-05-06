/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.luceneproject.pojos.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author kk
 */
@ManagedBean(name = "fallData")
@RequestScoped
//@SessionScoped
public class FilterView  {

    FallLazyDataModel dataModel = new  FallLazyDataModel();



 
//    private List<Fall> falls;
    

//    //fallManager
//    @ManagedProperty("#{fallManager}")
//    private FallManager manager;

//    @PostConstruct
//    public void init() {
//        falls = manager.getFalls(0, 10);      
//    }
//
//    public List<Fall> getFalls() {
//        return falls;
//    }


//
//    public void setManager(FallManager manager) {
//        this.manager = manager;
//    }

    public LazyDataModel<Fall> getModel(){
        return dataModel;
    }
    
    public int getDataSize(){
        System.out.println("this sssssssssssss " + dataModel.getRowCount());
        return dataModel.getRowCount();
    }
    
    
    
 
    
}