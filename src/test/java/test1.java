
import static com.luceneproject.Search.Interfaces.SearchInterface.persistenceUnitName;
import com.luceneproject.luceneproject.Fall;
import com.luceneproject.luceneproject.QueryManager;
import com.luceneproject.pojo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.lucene.document.DateTools;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kk
 */
public class test1 {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory(persistenceUnitName);

    static List<Fall> falls = new ArrayList<Fall>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<TCase> tcases = getByCsHospitalIdent("10399923");
        List<TCaseDetails> tc = new ArrayList<TCaseDetails>();

        for (TCase tcase : tcases) {
            System.out.println(tcase.getCsCaseNumber());
            tc=((List<TCaseDetails>) (tcase.getTCaseDetailsCollection()));

        }
        for (TCaseDetails tCaseDetails : tc) {
            System.out.println(tCaseDetails.getAgeYears());
            System.out.println(tCaseDetails.getAgeDays());
        }
        
       
        

//        List<TCaseDetails> tde = new ArrayList<TCaseDetails>();
//       createFallsObjects(tcases);
//        
//        for (Fall fall : falls) {
//            System.out.println("case Number: "+fall.getCs_case_number());
//        }
//        for (int i = 0; i < tcases.size(); i++) {
//            Object[] firstResult = (Object[]) tcases.get(i);
//            System.out.println("caseNumberOMGGG: " + firstResult[0]);
//            System.out.println("caseNumberOMGGG: " + firstResult[1]);
//        }
        long endTime = System.currentTimeMillis();
        System.out.println("*****TIME*****");
        float sec = (endTime - startTime) / 1000F;
        System.out.println(sec + " seconds");
        System.out.println("");
    }

    public static List getByCsHospitalIdent(String csCaseNumber) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
// create native Lucene query unsing the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();

//        org.apache.lucene.search.Query luceneQuery = qb
//                .keyword()
//                .wildcard()
//                .onField("tCaseDetailsCollection.ageYears")
//                .matching(4)
//                .createQuery();

 org.apache.lucene.search.Query luceneQuery = getDateQuery("02.02.1991", "01.01.2019", qb);
 

// wrap Lucene query in a javax.persistence.Query
        FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class)
                        //                        .setProjection("csCaseNumber")
                        .setFirstResult(0)
                        .setMaxResults(250);

// execute search
        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();

        return result;

    }

    private static void createFallsObjects(List<TCase> tCases) {

        for (TCase tcase : tCases) {
            //Tcase
            Fall fall = new Fall();
            fall.setCs_case_number(tcase.getCsCaseNumber());
            fall.setInsurance_identifier(tcase.getInsuranceIdentifier());
            fall.setInsurance_number_patient(tcase.getInsuranceNumberPatient());

            //TCaseDetails
            List<TCaseDetails> tcaseDestailses = (List<TCaseDetails>) tcase.getTCaseDetailsCollection();
            LinkedHashSet<String> hdIcdCode = new LinkedHashSet<String>();
            LinkedHashSet<Integer> age_years = new LinkedHashSet<Integer>();
            LinkedHashSet<Date> admisstion_date = new LinkedHashSet<Date>();

            LinkedHashSet<List<TCaseDepartment>> tcaseDepartments = new LinkedHashSet<List<TCaseDepartment>>();
//
//            for (TCaseDetails tcaseDestailse : tcaseDestailses) {
//                hdIcdCode.add(tcaseDestailse.getHdIcdCode());
//                age_years.add(tcaseDestailse.getAgeYears());
//                admisstion_date.add(tcaseDestailse.getAdmissionDate());
//                tcaseDepartments.add((List<TCaseDepartment>) tcaseDestailse.getTCaseDepartmentCollection());
//            }
//            fall.setHd_icd_code(hdIcdCode);
//            fall.setAge_years(age_years);
//            fall.setAdmisstion_date(admisstion_date);
//
//            //TPatient
//            TPatient tpatient = tcase.getTPatientId();
//            fall.setPat_number(tpatient.getPatNumber());
//            fall.setPat_first_name(tpatient.getPatFirstName());
//
//            //TCaseIcd
//            LinkedHashSet<List<TCaseIcd>> tcaseIcd = new LinkedHashSet<List<TCaseIcd>>();
//
//            //TCaseOps 
//            LinkedHashSet<List<TCaseOps>> tcaseOps = new LinkedHashSet<List<TCaseOps>>();
//
//            LinkedHashSet<String> icds = new LinkedHashSet<String>();
//            LinkedHashSet<String> opss = new LinkedHashSet<String>();
//
//            LinkedHashSet<String> icdDescriptions = new LinkedHashSet<String>();
//            LinkedHashSet<String> opsDescriptions = new LinkedHashSet<String>();
//
//            if (tcaseDepartments.size() > 0) {
//                for (List<TCaseDepartment> tcaseDepartmente : tcaseDepartments) {
//                    for (TCaseDepartment tdepartment : tcaseDepartmente) {
//                        tcaseIcd.add((List<TCaseIcd>) tdepartment.getTCaseIcdCollection());
//                        tcaseOps.add((List<TCaseOps>) tdepartment.getTCaseOpsCollection());
//                    }
//
//                }
//                for (List<TCaseIcd> icd : tcaseIcd) {
//                    for (TCaseIcd code : icd) {
//
//                        icds.add(code.getIcdcCode().getIcdCode());
//                        icdDescriptions.add(code.getIcdcCode().getIcdDescription());
//                    }
//
//                }
//                for (List<TCaseOps> ops : tcaseOps) {
//                    for (TCaseOps code : ops) {
//                        opss.add(code.getOpscCode().getOpsCode());
//                        opsDescriptions.add(code.getOpscCode().getOpsDescription());
//                    }
//
//                }
//
//            }
//
//            fall.setIcdcCode(icds);
//            fall.setOpscCode(opss);
//            fall.setICD_DESCRIPTION(icdDescriptions);
//            fall.setOPS_DESCRIPTION(opsDescriptions);

            falls.add(fall);

        }
    }
    
    
    public static org.apache.lucene.search.Query getDateQuery(String start, String end, QueryBuilder qb ) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;

        SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = null;

        try {
            date1 = formatter1.parse(start);
            date2 = formatter2.parse(end);

        } catch (ParseException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, "can't convert to Date", ex);
        }

        org.apache.lucene.search.Query query = qb
                .range()
                .onField("tCaseDetailsCollection.admissionDate")
                .from(date1)
                .to(date2)
                .excludeLimit()
                .createQuery();

        return query;

    }
}
