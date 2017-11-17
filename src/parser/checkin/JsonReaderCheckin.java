package parser.checkin;

import org.json.JSONObject;

import java.util.Iterator;

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

    public JSONObject getCheckinInfo() {
        return this.jsonObject.getJSONObject("checkin_info");
    }

    public Integer getCheckinCount(){
        Integer count = 0;
        Iterator<?> keys = this.getCheckinInfo().keys();
        while( keys.hasNext() ) {
            String key = (String)keys.next();
            count = count + this.getCheckinInfo().getInt(key);
        }
        return count;
    }
}
