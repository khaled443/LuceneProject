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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kk
 */
@ManagedBean(name = "fallData")
@ViewScoped
//@SessionScoped
public class FilterView2 implements Serializable {


    public FilterView2(){
        
    }
    private List<Fall> falls;
    

    //fallManager
    @ManagedProperty("#{fallManager}")
    private FallManager manager;

    @PostConstruct
    public void init() {
        falls = manager.getFalls(0, 10);      
    }

    public List<Fall> getFalls() {
        return falls;
    }



    public void setManager(FallManager manager) {
        this.manager = manager;
    }


    
    
    
    
    
    

}
