/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author kk
 */
@ManagedBean(name="dtFilterView")
@ViewScoped
public class FilterView implements Serializable {
     
    private List<Car> cars;
     
    private List<Car> filteredCars;
    
    private String csCaseNumber;

    @ManagedProperty("#{carService}")
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars = service.createCars(10);
    }
     
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
     
    public List<String> getBandos() {
        return service.getBrands();
    }
     
    public List<String> getColors() {
        return service.getColors();
    }
     
    public List<Car> getCars() {
        return cars;
    }
 
    public List<Car> getFilteredCars() {
        return filteredCars;
    }
 
    public void setFilteredCars(List<Car> filteredCars) {
        this.filteredCars = filteredCars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }

    public String getCsCaseNumber() {
        return csCaseNumber;
    }

    public void setCsCaseNumber(String csCaseNumber) {
        this.csCaseNumber = csCaseNumber;
    }
    
    public void createMoreCars(){
           Car c;
        if (csCaseNumber==null || csCaseNumber.isEmpty() ) {
           c = new Car("khaled ", "kh", 10, "kh");
        }else{   
      c= new Car(csCaseNumber, "kh", 10, "kh");
        }
        cars.add(c);
    }
}
