package com.iprd.intent_proto;

public class BloodDrawMessageRequestBuilder extends BaseRequestMessageBuilder {
    public BloodDrawMessageRequestBuilder setHomeImageUri(String homeImageUri) {
        bloodDrawRequest.setHomeImageUri(homeImageUri);
        return this;
    }

    public BloodDrawMessageRequestBuilder setVerificationMethod(String verificationMethod) {
        bloodDrawRequest.setVerificationMethod(verificationMethod);
        return this;
    }

    public BloodDrawMessageRequestBuilder setOpenCampLinkId(String openCampLinkId) {
        bloodDrawRequest.setOpenCampLinkId(openCampLinkId);
        return this;
    }

    public BloodDrawMessageRequestBuilder setFamilyID(String value) {
        bloodDrawRequest.setFamilyID(value);
        return this;
    }

    public BloodDrawMessageRequestBuilder setPhoneNumber(String phoneNumber) {
        bloodDrawRequest.setPhoneNumber(phoneNumber);
        return this;
    }

    public BloodDrawMessageRequestBuilder setCountryCode(String countryCode) {
        bloodDrawRequest.setCountryCode(countryCode);
        return this;
    }

    public BloodDrawMessageRequestBuilder setHcwUserName(String value) {
        bloodDrawRequest.setHcwUserName(value);
        return this;
    }

    public BloodDrawMessageRequestBuilder setFamilyMembers(FamilyMemberDataClass[] value) {
        bloodDrawRequest.setFamilyMembers(value);
        return this;
    }

    public BloodDrawMessageRequestBuilder setFamilySurveyResponse(String value) {
        bloodDrawRequest.setFamilySurveyResponse(value);
        return this;
    }


    public BloodDrawMessageRequestBuilder setCampaign(CampaignDataClass campaign) {
        bloodDrawRequest.setCampaign(campaign);
        return this;
    }

    public BloodDrawMessageRequestBuilder setClinicGuid(String clinicGuid) {
        bloodDrawRequest.setClinicGuid(clinicGuid);
        return this;
    }

    public BloodDrawMessageRequestBuilder setClinicName(String clinicName) {
        bloodDrawRequest.setClinicName(clinicName);
        return this;
    }

    public BloodDrawMessageRequestBuilder setHcwUserId(String hcwUserId) {
        bloodDrawRequest.setHcwUserId(hcwUserId);
        return this;
    }

    private BloodDrawMessageRequest bloodDrawRequest;

    public BloodDrawMessageRequestBuilder(){
        bloodDrawRequest = new BloodDrawMessageRequest();
    }


    public BloodDrawMessageRequest build(){
        return bloodDrawRequest;
    }
}
