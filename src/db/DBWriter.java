package db;

import helper.Helper;
import org.json.JSONObject;
import parser.business.JsonReaderBusiness;
import parser.user.JsonReaderUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SuryaRajasekaran on 11/13/17.
 */
public class DBWriter {

    Connection connection;

    public DBWriter(Connection connection){
        this.connection = connection;
    }

    public void cleanUpTables() {

        String[] queries = new String[7];

        queries[0]  = "DELETE FROM BUSINESS_MAIN_CATEGORIES";
        queries[1]  = "DELETE FROM BUSINESS";
        queries[2]  = "DELETE FROM USERS";
        queries[3]  = "DELETE FROM MAIN_CATEGORIES";
        queries[4]  = "DELETE FROM SUB_CATEGORIES";
        queries[5]  = "DELETE FROM REVIEWS";
        queries[6]  = "DELETE FROM ATTRIB";

        for (int i=0;i<queries.length-4;i++) {
            try {
                Statement statement = null;
                statement = this.connection.createStatement();
                statement.executeUpdate(queries[i]);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void writeMainCategoriesTable() {

        String[] queries = new String[28];

        queries[0]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Active Life')";
        queries[1]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Automotive')";
        queries[2]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Car Rental')";
        queries[3]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Cafes')";
        queries[4]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Food')";
        queries[5]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Convenience Stores')";
        queries[6]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Dentists')";
        queries[7]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Doctors')";
        queries[8]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Drugstores')";
        queries[9]  = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Department Stores')";
        queries[10] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Education')";
        queries[11] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Home Services')";
        queries[12] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Hospitals')";
        queries[13] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Hardware Stores')";
        queries[14] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Grocery')";
        queries[15] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Medical Centers')";
        queries[16] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Nightlife')";
        queries[17] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Restaurants')";
        queries[18] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Shopping')";
        queries[19] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Transportation')";
        queries[20] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Arts & Entertainment')";
        queries[21] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Beauty & Spas')";
        queries[22] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Event Planning & Services')";
        queries[23] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Home & Garden')";
        queries[24] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Flowers & Gifts')";
        queries[25] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Health & Medical')";
        queries[26] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Hotels & Travel')";
        queries[27] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORY) VALUES ('Nurseries & Gardening')";

        for (int i=0;i<queries.length;i++) {
            Statement statement = null;
            try {
                statement = this.connection.createStatement();
                statement.executeUpdate(queries[i]);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void writeBusinessTable(String filePath) {
        JSONObject[] jsonObjectArr = Helper.strArr2jsonArr(Helper.str2Arr(Helper.readFile(filePath)));
        for (int i=0; i < jsonObjectArr.length; i++){
            JsonReaderBusiness jsonReaderBusiness = new JsonReaderBusiness(jsonObjectArr[i]);
            // ﻿INSERT INTO BUSINESS
            /*String query = "Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , REV_COUNT , BNAME, STARS) VALUES ("
                            + "'" + jsonReaderBusiness.getBId() + "',"
                            + "'" + jsonReaderBusiness.getAddress() + "',"
                            + "'" + jsonReaderBusiness.getOpCl() + "',"
                            + "'" + jsonReaderBusiness.getCity() + "',"
                            + "'" + jsonReaderBusiness.getState() + "',"
                            + "" + jsonReaderBusiness.getRevCount() + ","
                            + "'" + jsonReaderBusiness.getBName() + "',"
                            + "" + jsonReaderBusiness.getStars()+ ""
                            + ")";
            try {
                Statement statement = null;
                statement = this.connection.createStatement();
                statement.executeUpdate(query);
                statement.close();
            } catch (SQLException e) {
                System.out.println(query);
                e.printStackTrace();
            }
            // ﻿INSERT INTO MAIN_CATEGORIES
            ArrayList<String> mainCategories = jsonReaderBusiness.getMainCategories();
            for (int j = 0; j < mainCategories.size(); j++) {
                String query = "Insert into MAIN_CATEGORIES (BID , MCAT) VALUES ("
                        + "'" + jsonReaderBusiness.getBId() + "',"
                        + "'" + mainCategories.get(j) + "'"
                        + ")";
                try {
                    Statement statement = null;
                    statement = this.connection.createStatement();
                    statement.executeUpdate(query);
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(query);
                    e.printStackTrace();
                }
            }*/
            // ﻿INSERT INTO SUB_CATEGORIES
            ArrayList<String> subCategories = jsonReaderBusiness.getSubCategories();
            for (int j = 0; j < subCategories.size(); j++) {
                String query = "Insert into SUB_CATEGORIES (BID , SCAT) VALUES ("
                        + "'" + jsonReaderBusiness.getBId() + "',"
                        + "'" + subCategories.get(j) + "'"
                        + ")";
                try {
                    Statement statement = null;
                    statement = this.connection.createStatement();
                    statement.executeUpdate(query);
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(query);
                    e.printStackTrace();
                }
            }

        }

    }

    public void writeCheckinTable(String filePath) {
        //System.out.println(Helper.readFile(filePath));
    }

    public void writeReviewTable(String filePath) {
        //System.out.println(Helper.readFile(filePath));
    }

    public void writeUserTable(String filePath) {
        JSONObject[] jsonObjectArr = Helper.strArr2jsonArr(Helper.str2Arr(Helper.readFile(filePath)));
        for (int i=0; i < jsonObjectArr.length; i++){
            JsonReaderUser jsonReaderUser = new JsonReaderUser(jsonObjectArr[i]);
            String query = "Insert into USERS (REV_COUNT , USER_NAME, USERID, AVG_STARS) VALUES ("
                    + "" + jsonReaderUser.getRevCount() + ","
                    + "'" + jsonReaderUser.getUserName() + "',"
                    + "'" + jsonReaderUser.getUserId() + "',"
                    + "" + jsonReaderUser.getAvgStars() + ""
                    + ")";
            try {
                Statement statement = null;
                statement = this.connection.createStatement();
                statement.executeUpdate(query);
                statement.close();
            } catch (SQLException e) {
                System.out.println(query);
                e.printStackTrace();
            }
        }
    }



}