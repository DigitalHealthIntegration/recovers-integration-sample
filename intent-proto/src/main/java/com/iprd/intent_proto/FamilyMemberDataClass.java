package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

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
    @JsonProperty("name")
    private String name;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("head")
    private boolean head = false;

    public boolean isHead() { return head; }
    void setHead(boolean head) { this.head = head; }

    public String getMemberID() { return memberID; }
    void setMemberID(String value) { this.memberID = value; }

    public String getName() { return name; }
    void setName(String value) { this.name = value; }

    public String getDob() { return dob; }
    void setDob(String value) { this.dob = value; }

    public String getGender() { return gender; }
    void setGender(String value) { this.gender = value; }

    public Status getStatus() { return status; }
    void setStatus(Status value) {
        this.status = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMemberDataClass that = (FamilyMemberDataClass) o;
        return head == that.head &&
                memberID.equals(that.memberID) &&
                name.equals(that.name) &&
                dob.equals(that.dob) &&
                gender.equals(that.gender) &&
                status == that.status;
    }
}
