package com.iprd.intent_proto;

import java.util.ArrayList;
import java.util.List;

public class CampaignDataClassBuilder {

    public CampaignDataClassBuilder setId(String id) {
        campaignDataClass.setId(id);
        return this;
    }

    public CampaignDataClassBuilder setName(String name) {
        campaignDataClass.setName(name);
        return this;
    }

    public CampaignDataClassBuilder setVerticals(ArrayList<Integer> verticals) {
        campaignDataClass.setVerticals(verticals);
        return this;
    }

    public CampaignDataClassBuilder setUrl(String url) {
        campaignDataClass.setUrl(url);
        return this;
    }

    public CampaignDataClassBuilder setLocationPrecision(Integer locationPrecision) {
        campaignDataClass.setLocationPrecision(locationPrecision);
        return this;
    }

    public CampaignDataClassBuilder setTimePrecision(Integer timePrecision) {
        campaignDataClass.setTimePrecision(timePrecision);
        return this;
    }

    public CampaignDataClassBuilder setUdf(List<KeyTypeValue> udf) {
        campaignDataClass.setUdf(udf);
        return this;
    }

    private CampaignDataClass campaignDataClass;

    public CampaignDataClassBuilder(){
        campaignDataClass = new CampaignDataClass();
    }

    public CampaignDataClass build(){
        return campaignDataClass;
    }
}
