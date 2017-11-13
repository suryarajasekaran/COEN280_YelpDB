import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderReview {

    JSONObject jsonObject;

    public JsonReaderReview(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getVotes() {
        return this.jsonObject.getString("Votes");
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

    public String getUserId() {
        return this.jsonObject.getString("user_id");
    }

    public String getReviewId() {
        return this.jsonObject.getString("review_id");
    }

    public String getStars() {
        return this.jsonObject.getString("stars");
    }

    public String getDate() {
        return this.jsonObject.getString("date");
    }

    public String getText() {
        return this.jsonObject.getString("text");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }

}
