package com.iprd.intent_proto;

import org.json.JSONArray;

public class FamilySurveyResponseMessageBuilder extends BaseResponseMessageBuilder {
    public FamilySurveyResponseMessageBuilder setFamilyId(String familyId) {
        familySurveyResponseMessage.setFamilyId(familyId);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setPrimaryContactPhone(String primaryContactPhone) {
        familySurveyResponseMessage.setPrimaryContactPhone(primaryContactPhone);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setHcwUserName(String hcwUserName) {
        familySurveyResponseMessage.setHcwUserName(hcwUserName);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setResultCode(String resultCode) {
        familySurveyResponseMessage.setResultCode(resultCode);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setResultText(String resultText) {
        familySurveyResponseMessage.setResultText(resultText);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setFamilyMembers(JSONArray familyMembers) {
        familySurveyResponseMessage.setFamilyMembers(familyMembers);
        return this;
    }

    public FamilySurveyResponseMessageBuilder setOpenCampLinkId(String openCampLinkId) {
        familySurveyResponseMessage.setOpenCampLinkId(openCampLinkId);
        return this;
    }

    private FamilySurveyResponseMessage familySurveyResponseMessage;

    public FamilySurveyResponseMessageBuilder(){
        familySurveyResponseMessage = new FamilySurveyResponseMessage();
    }

    public FamilySurveyResponseMessage build(){
        return familySurveyResponseMessage;
    }
}
