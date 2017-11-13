import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * Created by SuryaRajasekaran on 11/4/17.
 */
public class populate {

    // read the provided json and output string
    public static String readFile(String filename) {
        String content = null;
        File file = new File(filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    // split string on \n and output array of strings
    public static String[] str2Arr(String content) {
        return content.split("\\r?\\n");
    }

    // convert array of strings to array of jsons
    public static JSONObject[] strArr2jsonArr(String[] content) {
        JSONObject jsonArr[] = new JSONObject[content.length];
        for (int i = 0; i < content.length; i++) {
            JSONObject jsonObject = new JSONObject(content[i]);
            System.out.println(new UserReader(jsonObject).getYelping_since());
            jsonArr[i] = jsonObject;
        }
        return jsonArr;
    }

    // connect to Oracle DB
    public static Connection connect2DB(String databaseURL, String username, String password)
    {
        Connection conn = null;
        try
        {
            // Step 1: "Load" the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Step 2: Establish the connection to the database
            conn = DriverManager.getConnection(databaseURL, username, password);
        }
        catch (Exception e)
        {
            System.err.println("D'oh! Got an exception!");
            System.err.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // connect to DB
        Connection conn = connect2DB("jdbc:oracle:thin:hr/hr@localhost:1521:orcl", "hr","hr");

        // insert 28 main categories to table ﻿BUSINESS_MAIN_CATEGORIES
        PopulateMainCategories populateMainCategories = new PopulateMainCategories(conn);
        populateMainCategories.load();
    }
}





   /* // create.sql a Statement from the connection
    Statement statement = null;
        try {
                //statement = conn.createStatement();
                //statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");

                statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT COUNTRY_ID FROM COUNTRIES WHERE REGION_ID=1");
                while (rs.next()) {
                String lastName = rs.getString("COUNTRY_ID");
                System.out.println(lastName + "\n");
                }
                } catch (SQLException e) {
                e.printStackTrace();
                }

// insert the data

//JSONObject[] output_yelp_business_arr_json = strArr2jsonArr(str2Arr(readFile("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_business.json")));
//JSONObject[] output_yelp_checkin_arr_json = strArr2jsonArr(str2Arr(readFile("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_checkin.json")));
//JSONObject[] output_yelp_review_arr_json = strArr2jsonArr(str2Arr(readFile("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_review.json")));
//JSONObject[] output_yelp_user_arr_json = strArr2jsonArr(str2Arr(readFile("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_user.json")));



*/