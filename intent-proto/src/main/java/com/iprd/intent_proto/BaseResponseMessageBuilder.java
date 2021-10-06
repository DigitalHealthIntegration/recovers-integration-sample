package com.iprd.intent_proto;

public class BaseResponseMessageBuilder {
    private BaseResponseMessage baseResponseMessage;

    public BaseResponseMessageBuilder(){
        baseResponseMessage = new BaseResponseMessage();
    }

    public BaseResponseMessageBuilder setResultCode(String resultCode){
        baseResponseMessage.setResultCode(resultCode);
        return this;
    }

    public BaseResponseMessageBuilder setResultText(String resultText){
        baseResponseMessage.setResultText(resultText);
        return this;
    }

    public BaseResponseMessageBuilder setOpenCampLinkId(String openCampLinkId){
        baseResponseMessage.setOpenCampLinkId(openCampLinkId);
        return this;
    }

    public BaseResponseMessage build(){
        return baseResponseMessage;
    }
}
