package parser.checkin;

import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/13/17.
 */
public class Checkin {

    private JSONObject checkinInfo;
    private String type;
    private String businessId;

    public JSONObject getCheckinInfo() {
        return checkinInfo;
    }

    public void setCheckinInfo(JSONObject checkinInfo) {
        this.checkinInfo = checkinInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

}
