import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class PopulateMainCategories {

    Connection connection;

    public PopulateMainCategories (Connection connection){
        this.connection = connection;
    }

    public void load() {

        String[] queries = new String[28];

        queries[0] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Active Life')";
        queries[1] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Automotive')";
        queries[2] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Car Rental')";
        queries[3] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Cafes')";
        queries[4] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Food')";
        queries[5] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Convenience Stores')";
        queries[6] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Dentists')";
        queries[7] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Doctors')";
        queries[8] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Drugstores')";
        queries[9] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Department Stores')";
        queries[10] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Education')";
        queries[11] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Home Services')";
        queries[12] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Hospitals')";
        queries[13] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Hardware Stores')";
        queries[14] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Grocery')";
        queries[15] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Medical Centers')";
        queries[16] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Nightlife')";
        queries[17] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Restaurants')";
        queries[18] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Shopping')";
        queries[19] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Transportation')";
        queries[20] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Arts & Entertainment')";
        queries[21] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Beauty & Spas')";
        queries[22] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Event Planning & Services')";
        queries[23] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Home & Garden')";
        queries[24] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Flowers & Gifts')";
        queries[25] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Health & Medical')";
        queries[26] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Hotels & Travel')";
        queries[27] = "Insert into BUSINESS_MAIN_CATEGORIES (MAIN_CATEGORTY) VALUES ('Nurseries & Gardening')";


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

}
