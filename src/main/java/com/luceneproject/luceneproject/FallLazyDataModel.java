/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author kk
 */
public class FallLazyDataModel extends LazyDataModel<Fall> {

    public FallLazyDataModel(){
System.out.println("--------- "+this+" -----------------");
          this.setRowCount(DataService.INSTANCE.getFallsTotalCount());


    }

    @Override
   public List<Fall> load(int first, int pageSize, String sortField,
                               SortOrder sortOrder, Map<String, Object> filters) {
       List<Fall> list = DataService.INSTANCE.getFallsList(first, pageSize);
      return list;
    }
    
}
