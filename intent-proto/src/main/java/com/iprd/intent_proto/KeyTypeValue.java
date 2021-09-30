package com.iprd.intent_proto;

import android.annotation.SuppressLint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyTypeValue {

    @JsonProperty("k")
    private String key;
    @JsonProperty("v")
    private String value;
    @JsonProperty("t")
    private String type;

    public KeyTypeValue(){

    }

    public KeyTypeValue(String key,String type,String value){
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyTypeValue that = (KeyTypeValue) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value) &&
                Objects.equals(type, that.type);
    }

}
