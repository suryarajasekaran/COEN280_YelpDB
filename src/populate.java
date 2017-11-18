import db.DBWriter;
import helper.Helper;

import java.io.FileNotFoundException;

/**
 * Created by SuryaRajasekaran on 11/4/17.
 */
public class populate {

    public static void main(String[] args) throws FileNotFoundException {

        // create db writer object
        DBWriter dbWriter = new DBWriter(Helper.getDBConnection());

        // cleanup
        dbWriter.cleanUpTables();

        String business = args[0]; //"/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_business.json";
        String checkin = args[1]; //"/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_checkin.json";
        String review = args[2]; //"/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_review.json";
        String user = args[3]; //"/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_user.json";

        // insert data into main categories table
        dbWriter.writeMainCategoriesTable();

        // insert data into business table
        dbWriter.writeBusinessTable(business);

        // insert data into checkin table
        dbWriter.writeCheckinTable(business, checkin);

        // insert data into review table
        dbWriter.writeReviewTable(review);

        // insert data into user table
        dbWriter.writeUserTable(user);

    }
}