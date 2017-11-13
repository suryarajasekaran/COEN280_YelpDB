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

    public ArrayList<String> getSubCategories(){
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

}
