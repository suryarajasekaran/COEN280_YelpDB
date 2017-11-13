package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class DBConnector {

    String databaseURL, username, password;

    public DBConnector(String databaseURL, String username, String password){
        this.databaseURL = databaseURL;
        this.username = username;
        this.password = password;
    }
    // connect to Oracle DB
    public Connection getConnection()
    {
        Connection conn = null;
        try
        {
            // Step 1: "Load" the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Step 2: Establish the connection to the database
            conn = DriverManager.getConnection(this.databaseURL, this.username, this.password);
        }
        catch (Exception e)
        {
            System.err.println("D'oh! Got an exception!");
            System.err.println(e.getMessage());
        }
        return conn;
    }

}
