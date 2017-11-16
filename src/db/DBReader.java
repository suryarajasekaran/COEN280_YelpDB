package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class DBReader {

    Connection connection;

    public DBReader(Connection connection){
        this.connection = connection;
    }

    public ArrayList<String> getMainCategories(){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAIN_CATEGORY FROM BUSINESS_MAIN_CATEGORIES");
            while (resultSet.next()) {
                String mainCategory = resultSet.getString("MAIN_CATEGORY");
                outArrayListStr.add(mainCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outArrayListStr;
    }

    public ArrayList<String> getSubCategories(ArrayList<String> mainCategories, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4SubCategories(mainCategories, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("SCAT");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<String> getAttributes(){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAIN_CATEGORY FROM BUSINESS_MAIN_CATEGORIES");
            while (resultSet.next()) {
                String mainCategory = resultSet.getString("MAIN_CATEGORY");
                outArrayListStr.add(mainCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outArrayListStr;
    }

    public String generateQuery4SubCategories(ArrayList<String> mainCategories, String searchFor){
        String outString = "";

        // ﻿select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = 'Doctors' Intersect select DISTINCT( M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = 'Dentists');
        if (searchFor.equals("AND")) {
            String section = "";
            for(int i=0; i<mainCategories.size(); i++){
                String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '" + mainCategories.get(i) + "'";
                if (i != 0) {
                    section = section + " intersect " + subSection;
                } else {
                    section = subSection;
                }
            }
            if (section.isEmpty() || section.equals("")){
            } else {
                outString = "SELECT DISTINCT(S.SCAT) from SUB_CATEGORIES S where S.Bid in ("+section+")";
            }

        } else {
            String section = "";
            for(int i=0; i<mainCategories.size(); i++){
                if (i != 0) {
                    section = section + "," + "'"  + mainCategories.get(i) + "'";
                } else {
                    section = "'" + mainCategories.get(i) + "'";
                }
            }
            if (section.isEmpty() || section.equals("")){
            } else {
                outString = "select distinct(SCAT) FROM SUB_CATEGORIES S, MAIN_CATEGORIES M WHERE M.MCAT IN ( " + section + ") and M.BID = S.BID";
            }
        }
        System.out.print(outString);
        return outString;
    }

}
