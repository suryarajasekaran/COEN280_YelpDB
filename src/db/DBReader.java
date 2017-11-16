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

    public ArrayList<String> getAttributes(ArrayList<String> mainCategories, ArrayList<String> subCategories, String searchFor){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                String query = this.generateQuery4Attributes(mainCategories, subCategories, searchFor);
                if (query.isEmpty() || query.equals("")){

                } else {
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

    public String generateQuery4SubCategories(ArrayList<String> mainCategories, String searchFor){
        String outString = "";
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

    public String generateQuery4Attributes(ArrayList<String> mainCategories, ArrayList<String> subCategories, String searchFor){
        String query = "";
        if (subCategories.size() == 0 || subCategories.isEmpty()){
            if (searchFor.equals("AND")){
                String section = "";
                for (int i = 0; i<mainCategories.size(); i++){
                    String subSection = "SELECT DISTINCT(A.ATTR) from ATTRIB A where A.Bid in (select DISTINCT(M.BID) FROM MAIN_CATEGORIES M WHERE M.MCAT = " + "'"+mainCategories.get(i)+"'";
                    if (i!=0){
                        section = section + " INTERSECT " + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "select distinct(ATTR) FROM attrib A, MAIN_CATEGORIES M WHERE M.MCAT IN ( "+section+" ) and M.BID = A.BID";
            } else {
                String section = "";
                for (int i = 0; i<mainCategories.size(); i++){
                    String subSection = "'"+mainCategories.get(i)+"'";
                    if (i!=0){
                        section = section + "," + subSection;
                    } else {
                        section = subSection;
                    }
                }
                query = "select distinct(ATTR) FROM attrib A, MAIN_CATEGORIES M WHERE M.MCAT IN ( "+section+" ) and M.BID = A.BID";
            }
        } else {
            String section = "";
            for (int i = 0; i<mainCategories.size(); i++){
                for (int j = 0; j<subCategories.size(); j++){
                    String subSection = "select DISTINCT(M.BID) FROM MAIN_CATEGORIES M, sub_categories S WHERE M.MCAT = '"+mainCategories.get(i)+"' AND S.SCAT = '"+subCategories.get(j)+"' AND  M.BID = S.BID";
                    if (j!=0){
                        section = section + (searchFor.equals("AND")?" INTERSECT ":" UNION ") + subSection;
                    } else {
                        section = subSection;
                    }
                }
            }
            query = "SELECT DISTINCT(A.ATTR) from attrib A where A.Bid in (" + section + ")";
        }
        return query;
    }
}
