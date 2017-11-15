package parser.checkin;

import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/5/17.
 */
public class JsonReaderCheckin {

    JSONObject jsonObject;

    public JsonReaderCheckin(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getBusinessId() {
        return this.jsonObject.getString("business_id");
    }

    public String getType() {
        return this.jsonObject.getString("type");
    }


}
