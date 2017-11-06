import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class BusinessReader {

    JSONObject jsonObject;

    public BusinessReader(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getFullAddress() {
        return this.jsonObject.getString("full_address");
    }

    public String getHours() {
        return this.jsonObject.getString("hours");
    }

    public String getOpen() {
        return this.jsonObject.getString("open");
    }

    public String getCategories() {
        return this.jsonObject.getString("categories");
    }

    public String getCity() {
        return this.jsonObject.getString("city");
    }

    public String getBusinessID() {
        return this.jsonObject.getString("business_id");
    }

    public String getReviewCount() {
        return this.jsonObject.getString("review_count");
    }

    public String getName() {
        return this.jsonObject.getString("name");
    }

    public String getNeighborhoods() {
        return this.jsonObject.getString("neighborhoods");
    }

    public String getLongitude() {
        return this.jsonObject.getString("longitude");
    }

    public String getState() {
        return this.jsonObject.getString("state");
    }

    public String getStars() {
        return this.jsonObject.getString("stars");
    }

    public String getLatitude() {
        return this.jsonObject.getString("latitude");
    }

    public String getAttributes() {
        return this.jsonObject.getString("attributes");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }
}
