package com.iprd.intent_proto;

public class FamilySurveyMessageRequestBuilder extends BaseRequestMessageBuilder {
    public FamilySurveyMessageRequestBuilder setHomeImageUri(String homeImageUri) {
        familySurvey.setHomeImageUri(homeImageUri);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setVerificationMethod(String verificationMethod) {
        familySurvey.setVerificationMethod(verificationMethod);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setOpenCampLinkId(String openCampLinkId) {
        familySurvey.setOpenCampLinkId(openCampLinkId);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setFamilyID(String value) {
        familySurvey.setFamilyID(value);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setHcwUserName(String value) {
        familySurvey.setHcwUserName(value);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setPrimaryContactPhone(String value) {
        familySurvey.setPrimaryContactPhone(value);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setFamilyMembers(FamilyMemberDataClass[] value) {
        familySurvey.setFamilyMembers(value);
        return this;
    }

    public FamilySurveyMessageRequestBuilder setFamilySurveyResponse(String value) {
        familySurvey.setFamilySurveyResponse(value);
        return this;
    }


    public FamilySurveyMessageRequestBuilder setCampaign(CampaignDataClass campaign) {
        familySurvey.setCampaign(campaign);
        return this;
    }

    private FamilySurveyMessageRequest familySurvey;

    public FamilySurveyMessageRequestBuilder(){
        familySurvey = new FamilySurveyMessageRequest();
    }


    public FamilySurveyMessageRequest build(){
        return familySurvey;
    }
}
