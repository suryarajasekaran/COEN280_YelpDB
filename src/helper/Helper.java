package helper;

import db.DBConnector;

import java.sql.Connection;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class Helper {

    public static Connection getDBConnection(){
        DBConnector dbConnector = new DBConnector("jdbc:oracle:thin:hr/hr@localhost:1521:orcl", "hr","hr");
        Connection connection = dbConnector.getConnection();
        return connection;
    }
}
