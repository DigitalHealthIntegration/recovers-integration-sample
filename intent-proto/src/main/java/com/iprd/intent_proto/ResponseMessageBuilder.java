package com.iprd.intent_proto;

import org.json.JSONArray;

public class ResponseMessageBuilder {
    public ResponseMessageBuilder setFamilyId(String familyId) {
        responseMessage.setFamilyId(familyId);
        return this;
    }

    public ResponseMessageBuilder setPrimaryContactPhone(String primaryContactPhone) {
        responseMessage.setPrimaryContactPhone(primaryContactPhone);
        return this;
    }

    public ResponseMessageBuilder setHcwUserName(String hcwUserName) {
        responseMessage.setHcwUserName(hcwUserName);
        return this;
    }

    public ResponseMessageBuilder setResultCode(String resultCode) {
        responseMessage.setResultCode(resultCode);
        return this;
    }

    public ResponseMessageBuilder setResultText(String resultText) {
        responseMessage.setResultText(resultText);
        return this;
    }

    public ResponseMessageBuilder setFamilyMembers(JSONArray familyMembers) {
        responseMessage.setFamilyMembers(familyMembers);
        return this;
    }

    private ResponseMessage responseMessage;

    public ResponseMessageBuilder(){
        responseMessage = new ResponseMessage();
    }

    public ResponseMessage build(){
        return responseMessage;
    }
}
