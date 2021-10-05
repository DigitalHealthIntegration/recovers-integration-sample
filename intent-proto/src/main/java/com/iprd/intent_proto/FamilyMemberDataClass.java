package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FamilyMemberDataClass {
    public FamilyMemberDataClass(){

    }

    public enum Status{
        New, Update, Delete; // Using Caps for first letter because of backward compatibility
    }
    @JsonProperty("memberId")
    private String memberID;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("inputOpenCampLinkId")
    private String inputOpenCampLinkId;
    @JsonProperty("head")
    private boolean head = false;

    public boolean isHead() { return head; }
    void setHead(boolean head) { this.head = head; }

    public String getMemberID() { return memberID; }
    void setMemberID(String value) { this.memberID = value; }

    public String getLastName() { return lastName; }
    void setLastName(String value) { this.lastName = value; }

    public String getDob() { return dob; }
    void setDob(String value) { this.dob = value; }

    public String getGender() { return gender; }
    void setGender(String value) { this.gender = value; }

    public Status getStatus() { return status; }
    void setStatus(Status value) {
        this.status = value;
    }


    public String getInputOpenCampLinkId() {
        return inputOpenCampLinkId;
    }

    void setInputOpenCampLinkId(String inputOpenCampLinkId) {
        this.inputOpenCampLinkId = inputOpenCampLinkId;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMemberDataClass that = (FamilyMemberDataClass) o;
        return head == that.head &&
                memberID.equals(that.memberID) &&
                lastName.equals(that.lastName) &&
                firstName.equals(that.firstName) &&
                dob.equals(that.dob) &&
                gender.equals(that.gender) &&
                status == that.status;
    }
}
