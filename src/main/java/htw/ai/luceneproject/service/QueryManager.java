/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htw.ai.luceneproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author Khaled Halabieh QueryManager
 */
public class QueryManager {

    /**
     * get Lucene Query for general search
     * @param qb QueryBuilder
     * @param entry search term 
     * @return Lucene Query
     */
    public static org.apache.lucene.search.Query getGlobalSearchQuery(QueryBuilder qb, Map.Entry<String, Object> entry) {

        org.apache.lucene.search.Query luceneQuery = qb
                .simpleQueryString()
                .onField("csCaseNumber").boostedTo(3)
                .andField("insuranceIdentifier")
                .andField("insuranceNumberPatient")
                .andField("tCaseDetailsCollection.hdIcdCode")
                .andField("tPatientId.patNumber")
                .andField("tPatientId.patFirstName")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdCode")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdDescription")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsCode")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsDescription")
                .withAndAsDefaultOperator()
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

    /**
     * get Lucene Query for autocomplete 
     * @param qb QueryBuilder
     * @param entry search term 
     * @param field field name
     * @return Lucene Query
     */
    public static org.apache.lucene.search.Query getAutocompleteQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField(field)
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();
        return luceneQuery;
    }

    /**
     * get Lucene Query to search in icdcCode and opscCode
     * @param qb  QueryBuilder
     * @param entry search term 
     * @param field field name
     * @return Lucene Query
     */
    public static org.apache.lucene.search.Query getSimpleQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {

        org.apache.lucene.search.Query luceneQuery = qb
                .simpleQueryString()
                .onField(field).boostedTo(3)
                .withAndAsDefaultOperator()
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

    /**
     * get Lucene Query to search in Date field 
     * @param qb  QueryBuilder
     * @param entry  search term 
     * @param field field name
     * @return  Lucene Query
     */
    public static org.apache.lucene.search.Query getDateQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query query = qb
                .range()
                .onField(field)
                .above((Date) entry.getValue())
                .excludeLimit()
                .createQuery();

        return query;

    }

    /**
     * get Lucene Query to search in Patient age field
     * @param qb  QueryBuilder
     * @param entry   search term 
     * @param field field name
     * @return  Lucene Query
     */
    public static org.apache.lucene.search.Query getIntegerQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField(field)
                .matching(Integer.parseInt(entry.getValue().toString()))
                .createQuery();
        return luceneQuery;
    }

    /**
     * get Lucene Query to start fuzzy search in diseases description
     * @param qb QueryBuilder
     * @param entry search term
     * @param field field name
     * @return Lucene Query
     */
    public static org.apache.lucene.search.Query getFuzzySearchQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(2)
                .withThreshold(.8f)
                .onField(field).boostedTo(3)
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

}
