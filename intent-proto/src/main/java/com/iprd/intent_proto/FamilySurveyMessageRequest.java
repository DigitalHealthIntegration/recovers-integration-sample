package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FamilySurveyMessageRequest extends BaseRequestMessage {
    public FamilySurveyMessageRequest(){}

    public enum VerificationMethod {
        NONE, BIOMETRIC, PHONE, ALL
    }

    @JsonProperty("familyId")
    private String familyID;
    @JsonProperty("hcwUserName")
    private String hcwUserName;
    @JsonProperty("primaryContactPhone")
    private String primaryContactPhone;
    @JsonProperty("familyMemberDataClasses")
    private FamilyMemberDataClass[] familyMemberDataClasses;
    @JsonProperty("openCampLinkId")
    private String openCampLinkId;
    @JsonProperty("familySurveyResponse")
    private String familySurveyResponse;
    @JsonProperty("verificationMethod")
    private VerificationMethod verificationMethod;
    @JsonProperty("homeImageUri")
    private String homeImageUri;

    public String getHomeImageUri() {
        return homeImageUri;
    }

    void setHomeImageUri(String homeImageUri) {
        this.homeImageUri = homeImageUri;
    }

    public VerificationMethod getVerificationMethod() {
        return verificationMethod;
    }

    void setVerificationMethod(String verificationMethod) {
        switch (verificationMethod.toUpperCase()) {
            case "NONE":
                this.verificationMethod = VerificationMethod.NONE;
                break;
            case "BIOMETRIC":
                this.verificationMethod = VerificationMethod.BIOMETRIC;
                break;
            case "PHONE":
                this.verificationMethod = VerificationMethod.PHONE;
                break;
            case "ALL":
                this.verificationMethod = VerificationMethod.ALL;
                break;
        }
    }

    public String getOpenCampLinkId() {
        return openCampLinkId;
    }

    void setOpenCampLinkId(String openCampLinkId) {
        this.openCampLinkId = openCampLinkId;
    }

    public String getFamilyID() {
        return familyID;
    }

    void setFamilyID(String value) {
        this.familyID = value;
    }

    public String getHcwUserName() {
        return hcwUserName;
    }

    void setHcwUserName(String value) {
        this.hcwUserName = value;
    }

    public String getPrimaryContactPhone() {
        return primaryContactPhone;
    }

    void setPrimaryContactPhone(String value) {
        this.primaryContactPhone = value;
    }

    public FamilyMemberDataClass[] getFamilyMembers() {
        return familyMemberDataClasses;
    }

    void setFamilyMembers(FamilyMemberDataClass[] value) {
        this.familyMemberDataClasses = value;
    }

    public String getFamilySurveyResponse() {
        return familySurveyResponse;
    }

    void setFamilySurveyResponse(String value) {
        this.familySurveyResponse = value;
    }
}