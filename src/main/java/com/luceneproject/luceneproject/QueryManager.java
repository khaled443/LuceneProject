/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.util.Map;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author kk
 */
public class QueryManager {
    
    public  static org.apache.lucene.search.Query getStringsStartsWithQuery(QueryBuilder qb,Map.Entry<String, Object> entry, String field){
        
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField(field)
                .matching(entry.getValue().toString() + "*")
                .createQuery();
        
        return luceneQuery;
    }
    
}
