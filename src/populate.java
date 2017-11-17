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
        //dbWriter.cleanUpTables();

        // insert data into main categories table
        //dbWriter.writeMainCategoriesTable();

        // insert data into business table
        //dbWriter.writeBusinessTable("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_business.json");

        // insert data into checkin table
        //dbWriter.writeCheckinTable("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_checkin.json");

        // insert data into review table
        dbWriter.writeReviewTable("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_review.json");

        // insert data into user table
        //dbWriter.writeUserTable("/Users/SuryaRajasekaran/scratch/code/Personal-Work/COEN280_YelpDB/YelpDataset/yelp_user.json");

    }
}