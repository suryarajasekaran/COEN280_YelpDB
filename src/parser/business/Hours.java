package parser.business;

import org.json.JSONObject;

/**
 * Created by SuryaRajasekaran on 11/16/17.
 */
public class Hours {

    JSONObject jsonObject;
    String key;

    public Hours(JSONObject jsonObject, String key){
        this.jsonObject = jsonObject;
        this.key = key;
    }

    public String getWorkDay(){
        return this.key;
    }

    public Integer getOpenHours(){
        return Integer.parseInt(this.jsonObject.getString("open").replace(":",""));
    };

    public Integer getCloseHours(){
        return Integer.parseInt(this.jsonObject.getString("close").replace(":",""));
    };
}
