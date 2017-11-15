package parser.user;

import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderUser {

    JSONObject jsonObject;

    public JsonReaderUser(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getUserName() {
        return this.processString(this.jsonObject.getString("name"));
    }

    public String getUserId() {
        return this.jsonObject.getString("user_id");
    }

    public Integer getRevCount() {
        return this.jsonObject.getInt("review_count");
    }

    public Float getAvgStars() {
        return this.jsonObject.getFloat("average_stars");
    }

    public String processString(String string) {
        return string
                .replace(",","")
                .replace("'","");
    }
/*

    public String getYelping_since() {
        return this.jsonObject.getString("yelping_since");
    }

    public String getVotes() {
        return this.jsonObject.getString("votes");
    }

    public String getUseful() {
        return this.jsonObject.getString("useful");
    }

    public String getFunny() {
        return this.jsonObject.getString("funny");
    }

    public String getCool() {
        return this.jsonObject.getString("cool");
    }





    public String getFriends() {
        return this.jsonObject.getString("Friends");
    }

    public String getFans() {
        return this.jsonObject.getString("Fans");
    }


    public String getCompliments() {
        return this.jsonObject.getString("Compliments");
    }

    public String getElite() {
        return this.jsonObject.getString("Elite");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }
*/

}
