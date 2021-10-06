package com.iprd.intent_proto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseMessage {

    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("resultText")
    private String resultText;
    @JsonProperty("openCampLinkId")
    private String openCampLinkId;

    public String getResultCode() {
        return resultCode;
    }

    void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getOpenCampLinkId() {
        return openCampLinkId;
    }

    void setOpenCampLinkId(String openCampLinkId) {
        this.openCampLinkId = openCampLinkId;
    }

    public String toJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
