/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Search;

import com.luceneproject.pojo.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kk
 */
public class MainSearch {

    static SearchManager sm;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sm = new SearchManager();

        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("Select Search field: ");
            System.out.println("______tCase______");
            System.out.println("1) CsCaseNumber ");
            System.out.println("2) csHospitalIdent");
            System.out.println("3) InsuranceIdentifier");
            System.out.println("4) InsuranceNumberPatient");
            System.out.println("");
            System.out.println("______TCaseDepartment______");
            System.out.println("5) csdComment");
            System.out.println("______TCaseIcd______");

            System.out.println("6) Icd");
            String s = scanner.next();

            if (s.equals("q")) {
                break;
            } else {

                String searchTerm;
                switch (s) {
                    case "1":
                        System.out.print("Enter search Term: ");
                        searchTerm = scanner.next();
                        tCaseCsCaseNumber(searchTerm);
                        break;
                    case "2":
                        searchTerm = scanner.next();
                        tCaseHospitalIdent(searchTerm);
                        break;
                    case "3":
                        searchTerm = scanner.next();
                        tCaseInsuranceIdentifier(searchTerm);
                        break;
                    case "4":
                        searchTerm = scanner.next();
                        tCaseInsuranceNumberPatient(searchTerm);
                        break;
                    case "5":
                        searchTerm = scanner.next();
                        tCaseDetailsCsdComment(searchTerm);
                        break;
                    case "6":
                        searchTerm = scanner.next();
                        tCaseIcd(searchTerm);
                        break;

                }
            }
        }
        System.out.println("Bye...");
        scanner.close();

    }

    public static void tCaseHospitalIdent(String s) {
        List<TCase> hospitalIdent = sm.getByCsHospitalIdent(s);
        printResults(hospitalIdent);
    }

    public static void tCaseCsCaseNumber(String s) {

        List<TCase> cscase = sm.getByCsCaseNumber(s);
//        printResults(cscase);
    }

    public static void tCaseInsuranceIdentifier(String s) {

        List<TCase> InsuranceIdentifier = sm.getByInsuranceIdentifier(s);
        printResults(InsuranceIdentifier);

    }

    public static void tCaseInsuranceNumberPatient(String s) {

        List<TCase> InsuranceNumberPatient = sm.getByInsuranceNumberPatient(s);
        printResults(InsuranceNumberPatient);

    }

    public static void tCaseDetailsCsdComment(String s) {

        List<TCase> csdComment = sm.getByCsdComment(s);
        printResults(csdComment);
    }

    public static void tCaseIcd(String s) {
        List<TCase> icd = sm.getByIcdcCode(s);
        printResults(icd);
    }

    public static void printResults(List<TCase> results) {
        System.out.println("Resuls: ");
        System.out.println("****************");
        for (TCase result : results) {
            System.out.println("ID: " + result.getId());
            System.out.println("Casenumber: " + result.getCsCaseNumber());
            System.out.println("insurance Identifier: " + result.getInsuranceIdentifier());
            System.out.println("Hospital Ident: " + result.getCsHospitalIdent());
            System.out.println("InsuranceNumberPatient: " + result.getInsuranceNumberPatient());
            System.out.println("");

            List<TCaseDetails> tDetails = (List<TCaseDetails>) result.getTCaseDetailsCollection();

            for (TCaseDetails tCaseDetails : tDetails) {
                System.out.println("        Age in years"+tCaseDetails.getAgeYears());
            }
        }

        System.out.println("************************");
    }

}
