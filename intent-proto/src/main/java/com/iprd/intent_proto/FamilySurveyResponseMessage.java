package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FamilySurveyResponseMessage extends BaseResponseMessage {

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
    @JsonProperty("family Members")
    private JSONArray familyMembers;

    @Override
    public String toJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
