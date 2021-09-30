package com.iprd.intent_proto;

public class BaseRequestMessageBuilder {
    private BaseRequestMessage requestMessage;

    public BaseRequestMessageBuilder(){
        requestMessage = new BaseRequestMessage();
    }

    public BaseRequestMessageBuilder setCampaign(CampaignDataClass campaign){
        requestMessage.setCampaign(campaign);
        return this;
    }

    public BaseRequestMessage build(){
        return requestMessage;
    }
}
