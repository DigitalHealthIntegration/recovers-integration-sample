package com.iprd.intent_proto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BaseBaseRequestMessageBuilderUnitTest {
    @Test
    public void build_withJsonString_correctRequestMessageBuilt() {
        String inputJson = "{\n" +
                "  \"campaign\": {\n" +
                "    \"id\": \"6ecb0566-7006-4382-9cdc-202d9010858a\",\n" +
                "    \"name\": \"Oyo State June 2021 Health Campaign\",\n" +
                "    \"verticals\": [\n" +
                "      2,\n" +
                "      5\n" +
                "    ],\n" +
                "    \"url\": \"https://health.oyostate.gov.ng/tomotiya/\",\n" +
                "    \"location_prec\": 3,\n" +
                "    \"time_prec\": 4,\n" +
                "    \"udf\": [\n" +
                "      {\n" +
                "        \"k\": \"PHC ID\",\n" +
                "        \"v\": \"30/25/1/1/1/0020\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"k\": \"PHC Name\",\n" +
                "        \"v\": \"Ifelodun Primary Health Centre\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"k\": \"PHC Location\",\n" +
                "        \"t\": \"url\",\n" +
                "        \"v\": \"https://goo.gl/maps/AyondpDQRZPNJxUi7\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"k\": \"PHC Phone No\",\n" +
                "        \"t\": \"tel\",\n" +
                "        \"v\": \"+234 (0) 803 852 1693\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"familyId\": \"789\",\n" +
                "  \"hcwUserName\": \"nks@apra.in\",\n" +
                "  \"primaryContactPhone\": \"\",\n" +
                "  \"openCampLinkId\": \"\",\n" +
                "  \"familyMembers\": [\n" +
                "    {\n" +
                "      \"memberId\": \"11\",\n" +
                "      \"name\": \"Matt\",\n" +
                "      \"dob\": \"1996-09-25\",\n" +
                "      \"gender\": \"M\",\n" +
                "      \"status\": \"New\",\n" +
                "      \"head\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"memberId\": \"12\",\n" +
                "      \"name\": \"Roma\",\n" +
                "      \"dob\": \"1997-06-12\",\n" +
                "      \"gender\": \"F\",\n" +
                "      \"status\": \"New\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

    }

}