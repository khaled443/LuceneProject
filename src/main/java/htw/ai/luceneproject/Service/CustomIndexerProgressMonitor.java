/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htw.ai.luceneproject.Service;

import org.hibernate.search.batchindexing.MassIndexerProgressMonitor;
import org.hibernate.search.batchindexing.impl.SimpleIndexingProgressMonitor;

/**
 *CustomIndexerProgressMonitor to get information about the Indexing process
 * this data will be used in process bar
 * @author Khaled halabieh
 */
public class CustomIndexerProgressMonitor extends SimpleIndexingProgressMonitor {

    int counter = 0;
    long totalCount = 0;

    /**
     * Summing the numbers passed to this method gives the total number of entities that Hibernate Search plans to index.
     * This number can be incremented during indexing as Hibernate Search moves from one entity type to the next.
     * @param count 
     */
    @Override
    public void addToTotalCount(long count) {
        totalCount = count;
        super.addToTotalCount(count); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Summing the numbers passed to this method gives the total number of documents that have been built so far.
     * @param number 
     */
    @Override
    public void documentsBuilt(int number) {
        counter = counter + number;
        super.documentsBuilt(number); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * get process
     * @return process in percent
     */
    public int getProcess(){
        int progress =0;
        if (totalCount!=0l ) {
            progress = (int) (100 * counter /totalCount);
        }        
        return progress;
    }

}
