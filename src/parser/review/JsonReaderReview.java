package parser.review;

import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderReview {

    JSONObject jsonObject;

    public JsonReaderReview(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public JSONObject getVotes() {
        return this.jsonObject.getJSONObject("votes");
    }

    public Integer getVotesUseful() {
        return this.getVotes().getInt("useful");
    }

    public Integer getVotesFunny() {
        return this.getVotes().getInt("useful");
    }

    public Integer getVotesCool() {
        return this.getVotes().getInt("useful");
    }

    public String getUserId() {
        return this.jsonObject.getString("user_id");
    }

    public String getRId() {
        return this.jsonObject.getString("review_id");
    }

    public Integer getStars() {
        return this.jsonObject.getInt("stars");
    }

    public String getReviewDate() {
        return this.jsonObject.getString("date");
    }

    public String getText() {
        return this.jsonObject.getString("text");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }

    public String getBId() {
        return this.jsonObject.getString("business_id");
    }

}
