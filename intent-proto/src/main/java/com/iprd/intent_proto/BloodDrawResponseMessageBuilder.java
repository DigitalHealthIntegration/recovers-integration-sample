package com.iprd.intent_proto;

public class BloodDrawResponseMessageBuilder extends BaseResponseMessageBuilder {

    public BloodDrawResponseMessageBuilder setHcwUserName(String hcwUserName) {
        bloodDrawResponseMessage.setHcwUserName(hcwUserName);
        return this;
    }

    public BloodDrawResponseMessageBuilder setResultCode(String resultCode) {
        bloodDrawResponseMessage.setResultCode(resultCode);
        return this;
    }

    public BloodDrawResponseMessageBuilder setResultText(String resultText) {
        bloodDrawResponseMessage.setResultText(resultText);
        return this;
    }

    public BloodDrawResponseMessageBuilder setOpenCampLinkId(String openCampLinkId) {
        bloodDrawResponseMessage.setOpenCampLinkId(openCampLinkId);
        return this;
    }

    private BloodDrawResponseMessage bloodDrawResponseMessage;

    public BloodDrawResponseMessageBuilder() {
        bloodDrawResponseMessage = new BloodDrawResponseMessage();
    }

    public BloodDrawResponseMessage build() {
        return bloodDrawResponseMessage;
    }
}
