package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FamilyMemberDataBuilder  {
    public FamilyMemberDataBuilder setHead(boolean head) {
        familyMemberDataClass.setHead(head);
        return this;
    }

    public FamilyMemberDataBuilder setMemberID(String value) {
        familyMemberDataClass.setMemberID(value);
        return this;
    }

    public FamilyMemberDataBuilder setName(String value) {
        familyMemberDataClass.setName(value);
        return this;
    }

    public FamilyMemberDataBuilder setDob(String value) {
        familyMemberDataClass.setDob(value);
        return this;
    }

    public FamilyMemberDataBuilder setGender(String value) {
        familyMemberDataClass.setGender(value);
        return this;
    }

    public FamilyMemberDataBuilder setStatus(FamilyMemberDataClass.Status value) {
        familyMemberDataClass.setStatus(value);
        return this;
    }

    private FamilyMemberDataClass familyMemberDataClass;

    public FamilyMemberDataBuilder(){
        familyMemberDataClass = new FamilyMemberDataClass();
    }

    public FamilyMemberDataClass build(){
        return familyMemberDataClass;
    }
}
