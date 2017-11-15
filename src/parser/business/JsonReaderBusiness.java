package parser.business;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderBusiness {

    JSONObject jsonObject;
    String[] MAIN_CATEGORIES = new String[28];

    public JsonReaderBusiness(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        this.MAIN_CATEGORIES[0]  = "Active Life";
        this.MAIN_CATEGORIES[1]  = "Automotive";
        this.MAIN_CATEGORIES[2]  = "Car Rental";
        this.MAIN_CATEGORIES[3]  = "Cafes";
        this.MAIN_CATEGORIES[4]  = "Food";
        this.MAIN_CATEGORIES[5]  = "Convenience Stores";
        this.MAIN_CATEGORIES[6]  = "Dentists";
        this.MAIN_CATEGORIES[7]  = "Doctors";
        this.MAIN_CATEGORIES[8]  = "Drugstores";
        this.MAIN_CATEGORIES[9]  = "Department Stores";
        this.MAIN_CATEGORIES[10] = "Education";
        this.MAIN_CATEGORIES[11] = "Home Services";
        this.MAIN_CATEGORIES[12] = "Hospitals";
        this.MAIN_CATEGORIES[13] = "Hardware Stores";
        this.MAIN_CATEGORIES[14] = "Grocery";
        this.MAIN_CATEGORIES[15] = "Medical Centers";
        this.MAIN_CATEGORIES[16] = "Nightlife";
        this.MAIN_CATEGORIES[17] = "Restaurants";
        this.MAIN_CATEGORIES[18] = "Shopping";
        this.MAIN_CATEGORIES[19] = "Transportation";
        this.MAIN_CATEGORIES[20] = "Arts & Entertainment";
        this.MAIN_CATEGORIES[21] = "Beauty & Spas";
        this.MAIN_CATEGORIES[22] = "Event Planning & Services";
        this.MAIN_CATEGORIES[23] = "Home & Garden";
        this.MAIN_CATEGORIES[24] = "Flowers & Gifts";
        this.MAIN_CATEGORIES[25] = "Health & Medical";
        this.MAIN_CATEGORIES[26] = "Hotels & Travel";
        this.MAIN_CATEGORIES[27] = "Nurseries & Gardening";
    }

    public String getAddress() {
        return this.processString(this.jsonObject.getString("full_address"));
    }

    public String getBId() {
        return this.jsonObject.getString("business_id");
    }

    public String getOpCl() {
        return this.processString(this.jsonObject.getBoolean("open")?"open":"close");
    }

    public String getCity() {
        return this.processString(this.jsonObject.getString("city"));
    }

    public Integer getRevCount() {
        return this.jsonObject.getInt("review_count");
    }

    public String getBName() {
        return this.processString(this.jsonObject.getString("name"));
    }

    public String getState() {
        return this.processString(this.jsonObject.getString("state"));
    }

    public Float getStars() {
        return this.jsonObject.getFloat("stars");
    }

    public JSONArray getCategories() {
        return this.jsonObject.getJSONArray("categories");
    }

    public ArrayList<String> getMainCategories() {
        JSONArray jsonArray = this.getCategories();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i<jsonArray.length(); i++){
            if (Arrays.asList(this.MAIN_CATEGORIES).contains(jsonArray.get(i))){
                arrayList.add(this.processString(jsonArray.get(i).toString()));
            }
        }
        return arrayList;
    }

    public ArrayList<String> getSubCategories() {
        JSONArray jsonArray = this.getCategories();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i<jsonArray.length(); i++){
            if (!Arrays.asList(this.MAIN_CATEGORIES).contains(jsonArray.get(i))){
                arrayList.add(this.processString(jsonArray.get(i).toString()));
            }
        }
        return arrayList;
    }

    public String processString(String string) {
        return string
                .replace(",","")
                .replace("'","");
    }

    /*
    public String getHours() {
        return this.jsonObject.getString("hours");
    }




    public String getNeighborhoods() {
        return this.jsonObject.getString("neighborhoods");
    }

    public String getLongitude() {
        return this.jsonObject.getString("longitude");
    }


    public String getLatitude() {
        return this.jsonObject.getString("latitude");
    }

    public String getAttributes() {
        return this.jsonObject.getString("attributes");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }*/
}
