package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequestMessage {
    public CampaignDataClass getCampaign() {
        return campaign;
    }

    void setCampaign(CampaignDataClass campaign) {
        this.campaign = campaign;
    }

    @JsonProperty("campaign")
    private CampaignDataClass campaign;
}
