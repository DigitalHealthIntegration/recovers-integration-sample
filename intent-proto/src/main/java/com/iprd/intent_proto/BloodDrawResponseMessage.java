package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BloodDrawResponseMessage extends BaseResponseMessage {

    public String getHcwUserName() {
        return hcwUserName;
    }

    void setHcwUserName(String hcwUserName) {
        this.hcwUserName = hcwUserName;
    }

    @JsonProperty("hcwUserName")
    private String hcwUserName;

    @Override
    public String toJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
