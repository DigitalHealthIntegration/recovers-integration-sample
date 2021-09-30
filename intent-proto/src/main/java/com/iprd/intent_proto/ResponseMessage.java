package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONArray;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessage {

    public String getFamilyId() {
        return familyId;
    }

    void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getPrimaryContactPhone() {
        return primaryContactPhone;
    }

    void setPrimaryContactPhone(String primaryContactPhone) {
        this.primaryContactPhone = primaryContactPhone;
    }

    public String getHcwUserName() {
        return hcwUserName;
    }

    void setHcwUserName(String hcwUserName) {
        this.hcwUserName = hcwUserName;
    }

    public String getResultCode() {
        return resultCode;
    }

    void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public JSONArray getFamilyMembers() {
        return familyMembers;
    }

    void setFamilyMembers(JSONArray familyMembers) {
        this.familyMembers = familyMembers;
    }

    @JsonProperty("familyId")
    private String familyId;
    @JsonProperty("primaryContactPhone")
    private String primaryContactPhone;
    @JsonProperty("hcwUserName")
    private String hcwUserName;
    @JsonProperty("result-code")
    private String resultCode;
    @JsonProperty("result-text")
    private String resultText;
    @JsonProperty("family Members")
    private JSONArray familyMembers;
}
