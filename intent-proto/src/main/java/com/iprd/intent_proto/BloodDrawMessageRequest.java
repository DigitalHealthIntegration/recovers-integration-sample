package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BloodDrawMessageRequest extends BaseRequestMessage {
    public BloodDrawMessageRequest(){}

    @JsonProperty("familyId")
    private String familyID;
    @JsonProperty("hcwUserName")
    private String hcwUserName;
    @JsonProperty("hcwUserId")
    private String hcwUserId;
    @JsonProperty("primaryContactPhone")
    private String primaryContactPhone;
    @JsonProperty("familyMemberDataClasses")
    private FamilyMemberDataClass[] familyMemberDataClasses;
    @JsonProperty("openCampLinkId")
    private String openCampLinkId;
    @JsonProperty("familySurveyResponse")
    private String familySurveyResponse;
    @JsonProperty("verificationMethod")
    private FamilySurveyMessageRequest.VerificationMethod verificationMethod;
    @JsonProperty("homeImageUri")
    private String homeImageUri;
    @JsonProperty("clinicGuid")
    private String clinicGuid;
    @JsonProperty("clinicName")
    private String clinicName;

    public String getHomeImageUri() {
        return homeImageUri;
    }

    void setHomeImageUri(String homeImageUri) {
        this.homeImageUri = homeImageUri;
    }

    public FamilySurveyMessageRequest.VerificationMethod getVerificationMethod() {
        return verificationMethod;
    }

    void setVerificationMethod(String verificationMethod) {
        switch (verificationMethod.toUpperCase()) {
            case "NONE":
                this.verificationMethod = FamilySurveyMessageRequest.VerificationMethod.NONE;
                break;
            case "BIOMETRIC":
                this.verificationMethod = FamilySurveyMessageRequest.VerificationMethod.BIOMETRIC;
                break;
            case "PHONE":
                this.verificationMethod = FamilySurveyMessageRequest.VerificationMethod.PHONE;
                break;
            case "ALL":
                this.verificationMethod = FamilySurveyMessageRequest.VerificationMethod.ALL;
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


    public String getClinicGuid() {
        return clinicGuid;
    }

    void setClinicGuid(String clinicGuid) {
        this.clinicGuid = clinicGuid;
    }

    public String getClinicName() {
        return clinicName;
    }

    void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getHcwUserId() {
        return hcwUserId;
    }

    void setHcwUserId(String hcwUserId) {
        this.hcwUserId = hcwUserId;
    }

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