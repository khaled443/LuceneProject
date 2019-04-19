/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


/**
 *
 * @author kk
 */
public class loggg {
    
    
   /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(loggg.class.getName());
   
    
    public static void main(String[] args) throws IOException,SQLException {
        
             log.debug("Hello this is a debug message");
      log.info("Hello this is an info message");
      
        log.info("This is Logger Info");
        log.log(Level.ERROR, "test error");
    }
    
 
}

