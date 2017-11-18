package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class Test {
//﻿SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, CHECKIN C where B.BID = C.BID and B.Bid IN (select distinct (H.BID) from HOURS H WHERE h.workday = 'Wednesday' AND H.OPENHRS >='800'AND H.CLOSEHRS <= '1700'and H.BID IN SELECT DISTINCT(L.BID) FROM LOCATON L , business b WHERE b.city = 'Sun Lakes, AZ' and b.bid = l.bid and L.BID IN (select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Family Practice' AND A.ATTR = 'By_Appointment_Only_TRUE' AND  M.BID = S.BID AND M.BID = A.BID INTERSECT select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Family Practice' AND A.ATTR = 'By_Appointment_Only_TRUE' AND  M.BID = S.BID AND M.BID = A.BID ))

    Connection connection;

    public Test(Connection connection){
        this.connection = connection;
    }


    public ArrayList<String> getMainCategories(){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAIN_CATEGORY FROM BUSINESS_MAIN_CATEGORIES order by main_Category");
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

    public ArrayList<String> getAttributes(ArrayList<String> mainCategories, ArrayList<String> subCategories, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4Attributes(mainCategories, subCategories, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.println(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("ATTR");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<String> getLocation(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4Location(mainCategories, subCategories, attributes, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.print(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("LOC");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<String> getDay(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4Day(mainCategories, subCategories, attributes, location, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.print(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("WORKDAY");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<String> getFrom(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4From(mainCategories, subCategories, attributes, location, day, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.print(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("OPENHRS");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<String> getTo(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String from, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4To(mainCategories, subCategories, attributes, location, day, from, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.print(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String subCategory = resultSet.getString("CLOSEHRS");
                        outArrayListStr.add(subCategory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }

    public ArrayList<ArrayList<String>> getSearch(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String from, String to, String searchFor){
        Statement statement = null;
        ArrayList<ArrayList<String>> outArrayListStr = new ArrayList<ArrayList<String>>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4Search(mainCategories, subCategories, attributes, location, day, from, to, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
                    System.out.print(query);
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        ArrayList<String> subArrayListStr = new ArrayList<String>();
                        String bid = resultSet.getString("BID");
                        String bname = resultSet.getString("BNAME");
                        String address = resultSet.getString("ADDRESS");
                        String city = resultSet.getString("CITY");
                        String state = resultSet.getString("STATE");
                        String stars = Integer.toString(resultSet.getInt("STARS"));
                        String revCount = Integer.toString(resultSet.getInt("REV_COUNT"));
                        String chkincount = Integer.toString(resultSet.getInt("CHKINCOUNT"));
                        subArrayListStr.add(bid);
                        subArrayListStr.add(bname);
                        subArrayListStr.add(address);
                        subArrayListStr.add(city);
                        subArrayListStr.add(state);
                        subArrayListStr.add(stars);
                        subArrayListStr.add(revCount);
                        subArrayListStr.add(chkincount);
                        outArrayListStr.add(subArrayListStr);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outArrayListStr;
    }


    public String generateQuery4SubCategories(ArrayList<String> mainCategories, String searchFor){
        String outString = "";
        if (searchFor.equals("AND")) {
            String section = "";
            for(int i=0; i<mainCategories.size(); i++){
                String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '" + mainCategories.get(i) + "'";
                if (!section.equals("")) {
                    section = section + " intersect " + subSection;
                } else {
                    section = subSection;
                }
            }
            if (section.isEmpty() || section.equals("")){
            } else {
                outString = "SELECT DISTINCT(S.SCAT) from SUB_CATEGORIES S where S.Bid in ("+section+") order by S.scat";
            }
        } else {
            String section = "";
            for(int i=0; i<mainCategories.size(); i++){
                if (!section.equals("")) {
                    section = section + "," + "'"  + mainCategories.get(i) + "'";
                } else {
                    section = "'" + mainCategories.get(i) + "'";
                }
            }
            if (section.isEmpty() || section.equals("")){
            } else {
                outString = "select distinct(SCAT) FROM SUB_CATEGORIES S, MAIN_CATEGORIES M WHERE M.MCAT IN ( " + section + ") and M.BID = S.BID order by S.scat";
            }
        }
        System.out.print(outString);
        return outString;
    }

    public String generateQuery4Attributes(ArrayList<String> mainCategories, ArrayList<String> subCategories, String searchFor){
        String query = "";
        if (subCategories.size() == 0 || subCategories.isEmpty()){
            if (searchFor.equals("AND")){
                String section = "";
                for (int i = 0; i<mainCategories.size(); i++){
                    String subSection = "SELECT DISTINCT(A.ATTR) from ATTRIB A where A.Bid in (select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = " + "'"+mainCategories.get(i)+"'";
                    if (!section.equals("")){
                        section = section + " INTERSECT " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "select distinct(ATTR) FROM attrib A, MAIN_CATEGORIES M WHERE M.MCAT IN ( "+section+" ) and M.BID = A.BID order by A.ATTR";
            } else {
                String section = "";
                for (int i = 0; i<mainCategories.size(); i++){
                    String subSection = "'"+mainCategories.get(i)+"'";
                    if (!section.equals("")){
                        section = section + "," + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "select distinct(ATTR) FROM attrib A, MAIN_CATEGORIES M WHERE M.MCAT IN ( "+section+" ) and M.BID = A.BID order by A.ATTR";
            }
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if (!section.equals("")){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(A.ATTR) from attrib A where A.Bid in (" + section + ") order by A.ATTR";
        }
        return query;
    }

    public String generateQuery4Location(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String searchFor) {
        String query = "";

        if (mainCategories.size() == 0 || mainCategories.isEmpty()) {
            query = "select distinct(LOC) from locaton";
        } else if (subCategories.size() == 0 || subCategories.isEmpty()) {
            if (searchFor.equals("AND")) {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"'";
                    if ( !section.equals("") ) {
                        section = section + " Intersect " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "SELECT DISTINCT(l.loc) from locaton L where l.Bid in ( " + section + ") order by L.LOC";
            } else {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    if ( !section.equals("") ) {
                        section = section + "," + "'" + mainCategories.get(i) + "'";
                    } else {
                        section = "'" + mainCategories.get(i) + "'";
                    }
                }
                query = "select distinct(l.loc) from locaton L, main_Categories M where m.mcat in ( " + section + " ) and l.bid = m.bid order by L.LOC";
            }
        } else if (attributes.size() == 0 || attributes.isEmpty()) {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if ( !section.equals("") ){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(L.loc) from locaton l where l.bid in ( " + section + " ) order by L.LOC";
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    for (int k = 0; k<attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if ( !section.equals("") ) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "select distinct (l.loc) from BUSINESS B, LOCATON L WHERE B.BID = L.BID AND B.BID IN ( SELECT DISTINCT(B.BID) from BUSINESS B where B.Bid in (" + section + " )) order by L.LOC";
        }
        return query;
    }

    public String generateQuery4Day(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String searchFor) {
        String query = "";

        if (mainCategories.size() == 0 || mainCategories.isEmpty()) {
            query = "SELECT DISTINCT(H.WORKDAY) FROM HOURS H";
        } else if (subCategories.size() == 0 || subCategories.isEmpty()) {
            if (searchFor.equals("AND")) {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"'";
                    if ( !section.equals("") ) {
                        section = section + " Intersect " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "SELECT DISTINCT(H.WORKDAY) from HOURS H where H.Bid in ( " + section + ") order by H.WORKDAY";
            } else {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    if ( !section.equals("") ) {
                        section = section + "," + "'" + mainCategories.get(i) + "'";
                    } else {
                        section = "'" + mainCategories.get(i) + "'";
                    }
                }
                query = "SELECT DISTINCT(H.WORKDAY) FROM HOURS H, main_Categories M where m.mcat in ( " + section + " ) and H.bid = m.bid order by H.WORKDAY";
            }
        } else if (attributes.size() == 0 || attributes.isEmpty()) {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if ( !section.equals("") ){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(H.WORKDAY) from HOURS H where H.Bid in ( " + section + " ) order by H.WORKDAY";
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    for (int k = 0; k<attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if ( !section.equals("") ) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "select distinct (H.WORKDAY) from HOURS H WHERE H.BID IN ( SELECT DISTINCT(B.BID) from BUSINESS B where B.Bid in (" + section + " )) order by H.WORKDAY";
        }
        return query;
    }

    public String generateQuery4From(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String searchFor) {
        String query = "";

        if (mainCategories.size() == 0 || mainCategories.isEmpty()) {
            query = "SELECT DISTINCT(H.OPENHRS) FROM HOURS H";
        } else if (subCategories.size() == 0 || subCategories.isEmpty()) {
            if (searchFor.equals("AND")) {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"'";
                    if ( !section.equals("") ) {
                        section = section + " Intersect " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "SELECT DISTINCT(H.OPENHRS) from HOURS H where H.Bid in ( " + section + ") order by H.OPENHRS";
            } else {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    if ( !section.equals("") ) {
                        section = section + "," + "'" + mainCategories.get(i) + "'";
                    } else {
                        section = "'" + mainCategories.get(i) + "'";
                    }
                }
                query = "SELECT DISTINCT(H.OPENHRS) FROM HOURS H, main_Categories M where m.mcat in ( " + section + " ) and H.bid = m.bid order by H.OPENHRS";
            }
        } else if (attributes.size() == 0 || attributes.isEmpty()) {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if ( !section.equals("") ){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(H.OPENHRS) from HOURS H where H.Bid in ( " + section + " ) order by H.OPENHRS";
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    for (int k = 0; k<attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if ( !section.equals("") ) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "select distinct (H.OPENHRS) from HOURS H WHERE H.BID IN ( SELECT DISTINCT(B.BID) from BUSINESS B where B.Bid in (" + section + " )) order by H.OPENHRS";
        }
        return query;
    }

    public String generateQuery4To(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String from, String searchFor) {
        String query = "";

        if (mainCategories.size() == 0 || mainCategories.isEmpty()) {
            query = "SELECT DISTINCT(H.CLOSEHRS) FROM HOURS H";
        } else if (subCategories.size() == 0 || subCategories.isEmpty()) {
            if (searchFor.equals("AND")) {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"'";
                    if ( !section.equals("") ) {
                        section = section + " Intersect " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "SELECT DISTINCT(H.CLOSEHRS) from HOURS H where H.Bid in ( " + section + ") orderby H.CLOSEHRS";
            } else {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    if ( !section.equals("") ) {
                        section = section + "," + "'" + mainCategories.get(i) + "'";
                    } else {
                        section = "'" + mainCategories.get(i) + "'";
                    }
                }
                query = "SELECT DISTINCT(H.CLOSEHRS) FROM HOURS H, main_Categories M where m.mcat in ( " + section + " ) and H.bid = m.bid orderby H.CLOSEHRS";
            }
        } else if (attributes.size() == 0 || attributes.isEmpty()) {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if ( !section.equals("") ){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(H.CLOSEHRS) from HOURS H where H.Bid in ( " + section + " ) orderby H.CLOSEHRS";
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    for (int k = 0; k<attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if ( !section.equals("") ) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "select distinct (H.CLOSEHRS) from HOURS H WHERE H.BID IN ( SELECT DISTINCT(B.BID) from BUSINESS B where B.Bid in (" + section + " )) orderby H.CLOSEHRS";
        }
        return query;
    }

    public String generateQuery4Search(ArrayList<String> mainCategories, ArrayList<String> subCategories, ArrayList<String> attributes, String location, String day, String from, String to, String searchFor) {
        String query = "";

        if (mainCategories.size() == 0 || mainCategories.isEmpty()) {
            // query = ""
        } else if (subCategories.size() == 0 || subCategories.isEmpty()) {
            if (searchFor.equals("AND")) {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"'";
                    if ( !section.equals("") ) {
                        section = section + " Intersect " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B , CHECKIN C where B.BID = C.BID and B.Bid in ( " + section + ")";
            } else {
                String section = "";
                for (int i = 0; i < mainCategories.size(); i++) {
                    if ( !section.equals("") ) {
                        section = section + "," + "'" + mainCategories.get(i) + "'";
                    } else {
                        section = "'" + mainCategories.get(i) + "'";
                    }
                }
                query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, MAIN_cATEGORIES M, CHECKIN C  where B.BID = C.BID and m.mcat in ( " + section + " ) AND B.BID = M.BID";
            }
        } else if (attributes.size() == 0 || attributes.isEmpty()) {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if ( !section.equals("") ){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "sELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B , CHECKIN C where B.BID = C.BID and B.Bid in (" + section + " )";
        } else if (location == "" || location.equals("") ||location.isEmpty()) {
            String section = "";
            for (int i = 0; i < mainCategories.size(); i++) {
                for (int j = 0; j < subCategories.size(); j++) {
                    for (int k = 0; k < attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if (!section.equals("")) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, CHECKIN C where B.BID = C.BID and B.Bid IN (SELECT DISTINCT(L.BID) FROM LOCATON L , business b WHERE b.city = '" +location+ "' and b.bid = l.bid and L.BID IN (" + section + " ))";
        } else if (day == "" || day.equals("") || day.isEmpty()) {
            String section = "";
            for (int i = 0; i < mainCategories.size(); i++) {
                for (int j = 0; j < subCategories.size(); j++) {
                    for (int k = 0; k < attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if (!section.equals("")) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, CHECKIN C where B.BID = C.BID and B.Bid IN (select distinct (H.BID) from HOURS H WHERE h.workday = '"+day+"' and H.BID IN SELECT DISTINCT(L.BID) FROM LOCATON L , business b WHERE b.city = '"+location+"' and b.bid = l.bid and L.BID IN (" + section + " ))";
        } else if (from == "" || from.equals("") ||from.isEmpty()){
            String section = "";
            for (int i = 0; i < mainCategories.size(); i++) {
                for (int j = 0; j < subCategories.size(); j++) {
                    for (int k = 0; k < attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if (!section.equals("")) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, CHECKIN C where B.BID = C.BID and B.Bid IN (select distinct (H.BID) from HOURS H WHERE h.workday = '"+day+"' AND H.OPENHRS >='"+from+"'and H.BID IN SELECT DISTINCT(L.BID) FROM LOCATON L , business b WHERE b.city = '"+location+"' and b.bid = l.bid and L.BID IN (" + section + " ))";
        } else {
            //if (to == "" || to.equals("") ||to.isEmpty())
            String section = "";
            for (int i = 0; i < mainCategories.size(); i++) {
                for (int j = 0; j < subCategories.size(); j++) {
                    for (int k = 0; k < attributes.size(); k++) {
                        String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S, attrib A WHERE M.MCAT = '" + mainCategories.get(i) + "' AND S.SCAT = '" + subCategories.get(j) + "' AND A.ATTR = '" + attributes.get(k) + "' AND  M.BID = S.BID AND M.BID = A.BID";
                        if (!section.equals("")) {
                            section = section + (searchFor.equals("AND") ? " INTERSECT " : " UNION ") + subSection;
                        } else {
                            section = subSection;
                        }
                    }
                }
            }
            query = "SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT, C.chkincount FROM BUSINESS B, CHECKIN C where B.BID = C.BID and B.Bid IN (select distinct (H.BID) from HOURS H WHERE h.workday = '" + day + "' AND H.OPENHRS >='" + from + "'AND H.CLOSEHRS <= '"+to+"'and H.BID IN SELECT DISTINCT(L.BID) FROM LOCATON L , business b WHERE b.city = '" + location + "' and b.bid = l.bid and L.BID IN (" + section + " ))";
        }
        return query;
    }
}


