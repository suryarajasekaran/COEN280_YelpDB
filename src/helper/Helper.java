package helper;

import db.DBConnector;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            jsonArr[i] = jsonObject;
        }
        return jsonArr;
    }


}
