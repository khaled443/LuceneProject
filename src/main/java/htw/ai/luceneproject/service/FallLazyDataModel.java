/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package htw.ai.luceneproject.service;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *  Lazy loading
 * @author Khaled Halabieh
 *
 */
public class FallLazyDataModel extends LazyDataModel<Fall> {
    
    public FallLazyDataModel() {
        this.setRowCount(DataService.INSTANCE.getFallsTotalCount());
    }
    
    @Override
    public List<Fall> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, Object> filters) {
        List<Fall> list = DataService.INSTANCE.getFallsList(first, pageSize, filters);
        if (filters.size() > 0) {
            //set filterSize
            this.setRowCount(DataService.INSTANCE.getFilteredFallSize());
        }
        return list;
    }
}
