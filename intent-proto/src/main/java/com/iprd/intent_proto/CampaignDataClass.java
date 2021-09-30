package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDataClass {
    public String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getVerticals() {
        return verticals;
    }

    void setVerticals(ArrayList<Integer> verticals) {
        this.verticals = verticals;
    }

    public String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public Integer getLocationPrecision() {
        return locationPrecision;
    }

    void setLocationPrecision(Integer locationPrecision) {
        this.locationPrecision = locationPrecision;
    }

    public Integer getTimePrecision() {
        return timePrecision;
    }

    void setTimePrecision(Integer timePrecision) {
        this.timePrecision = timePrecision;
    }

    public List<KeyTypeValue> getUdf() {
        return udf;
    }

    void setUdf(List<KeyTypeValue> udf) {
        this.udf = udf;
    }

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("verticals")
    private ArrayList<Integer> verticals;
    @JsonProperty("url")
    private String url;
    @JsonProperty("location_prec")
    private Integer locationPrecision;
    @JsonProperty("time_prec")
    private Integer timePrecision;
    @JsonProperty("udf")
    private List<KeyTypeValue> udf;


}
