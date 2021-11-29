package com.iprd.intent_proto;

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

    public FamilyMemberDataBuilder setLastName(String value) {
        familyMemberDataClass.setLastName(value);
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

    public FamilyMemberDataBuilder setInputOpenCampLinkId(String inputOpenCampLinkId) {
        familyMemberDataClass.setInputOpenCampLinkId(inputOpenCampLinkId);
        return this;
    }

    public FamilyMemberDataBuilder setFirstName(String firstName) {
        familyMemberDataClass.setFirstName(firstName);
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
