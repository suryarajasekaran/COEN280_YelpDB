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

    public ArrayList<String> getSubCategories(ArrayList<String> mainCategories){
        Statement statement = null;
        ArrayList<String> outArrayListStr = new ArrayList<String>();
        if (mainCategories != null) {
            try {
                statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(this.generateQuery4SubCategories(mainCategories));
                while (resultSet.next()) {
                    String subCategory = resultSet.getString("SCAT");
                    outArrayListStr.add(subCategory);
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

    public String generateQuery4SubCategories(ArrayList<String> mainCategories){
        String outString = "";
        for(int i=0; i<mainCategories.size(); i++){
            String subSection = "select distinct(SCAT) FROM SUB_CATEGORIES S, MAIN_CATEGORIES M WHERE M.MCAT = '"+mainCategories.get(i)+"' and M.BID = S.BID";
            if (i !=0 ){
                outString = outString + " intersect " + subSection;
            } else {
                outString = subSection;
            }
        }
        return outString;
    }

}
