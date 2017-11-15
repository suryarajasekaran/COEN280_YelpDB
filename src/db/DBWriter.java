package db;

import helper.Helper;
import org.json.JSONObject;
import parser.business.JsonReaderBusiness;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SuryaRajasekaran on 11/13/17.
 */
public class DBWriter {

    Connection connection;

    public DBWriter(Connection connection){
        this.connection = connection;
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void writeBusinessTable(String filePath) {
        JSONObject[] jsonObjectArr = Helper.strArr2jsonArr(Helper.str2Arr(Helper.readFile(filePath)));
        for (int i=0; i < jsonObjectArr.length; i++){
            JsonReaderBusiness jsonReaderBusiness = new JsonReaderBusiness(jsonObjectArr[i]);
            //﻿Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , latitude , longitude, REV_COUNT , BNAME, STARS, BTYPE) VALUES
            //('vcNAWiLM4dR7D2nwwJ7nCA', '4840 E Indian School Rd\nSte 101\nPhoenix, AZ 85018','true', 'Phoenix', 'AZ', 33.499313000000001, -111.98375799999999, 7,'Eric Goldberg, MD', 3.5, 'business');
            String query = "Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , REV_COUNT , BNAME, STARS) VALUES ("
                            + "'" + jsonReaderBusiness.getBId() + "',"
                            + "'" + jsonReaderBusiness.getAddress() + "',"
                            + "'" + jsonReaderBusiness.getOpCl() + "',"
                            + "'" + jsonReaderBusiness.getCity() + "',"
                            + "'" + jsonReaderBusiness.getState() + "',"
                            + "'" + jsonReaderBusiness.getRevCount() + "',"
                            + "'" + jsonReaderBusiness.getBName() + "',"
                            + "'" + jsonReaderBusiness.getStars() + "',"
                            + ");";

            Statement statement = null;
            try {
                statement = this.connection.createStatement();
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
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
        //System.out.println(Helper.readFile(filePath));
    }

}
