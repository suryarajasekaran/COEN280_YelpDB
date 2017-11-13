import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderUser {

    JSONObject jsonObject;

    public JsonReaderUser(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

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

    public String getReview_count() {
        return this.jsonObject.getString("review_count");
    }

    public String getName() {
        return this.jsonObject.getString("Name");
    }

    public String getUserId() {
        return this.jsonObject.getString("UserId");
    }

    public String getFriends() {
        return this.jsonObject.getString("Friends");
    }

    public String getFans() {
        return this.jsonObject.getString("Fans");
    }

    public String getAverageStars() {
        return this.jsonObject.getString("AverageStars");
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

}
