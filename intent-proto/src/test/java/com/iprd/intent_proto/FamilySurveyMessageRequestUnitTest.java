package com.iprd.intent_proto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FamilySurveyMessageRequestUnitTest {
    @Test
    public void jsonString_new_correctFamilySurveyDataClassParsed() throws JSONException, JsonProcessingException {
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
                "  \"primaryContactPhone\": \"000000\",\n" +
                "  \"openCampLinkId\": \"ABCD1234\",\n" +
                "  \"familyMembers\": [\n" +
                "    {\n" +
                "      \"memberId\": \"11\",\n" +
                "      \"firstName\": \"Matt\",\n" +
                "      \"lastName\": \"Nime\",\n" +
                "      \"dob\": \"1996-09-25\",\n" +
                "      \"gender\": \"M\",\n" +
                "      \"status\": \"New\",\n" +
                "      \"head\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"memberId\": \"12\",\n" +
                "      \"firstName\": \"Jeff\",\n" +
                "      \"lastName\": \"Nime\",\n" +
                "      \"dob\": \"1997-06-12\",\n" +
                "      \"gender\": \"F\",\n" +
                "      \"status\": \"New\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Integer> verticals =new ArrayList<>();
        verticals.add(2);verticals.add(5);
        FamilySurveyMessageRequest familySurveyMessageRequest = objectMapper.readValue(inputJson,FamilySurveyMessageRequest.class);
        assertEquals(familySurveyMessageRequest.getCampaign().getId(),"6ecb0566-7006-4382-9cdc-202d9010858a");
        assertEquals(familySurveyMessageRequest.getCampaign().getName(),"Oyo State June 2021 Health Campaign");
        assertEquals(familySurveyMessageRequest.getCampaign().getVerticals(),verticals);
        assertEquals(familySurveyMessageRequest.getCampaign().getUrl(),"https://health.oyostate.gov.ng/tomotiya/");
        assertEquals((long)familySurveyMessageRequest.getCampaign().getLocationPrecision(),(long)Integer.parseInt("3"));
        assertEquals((long)familySurveyMessageRequest.getCampaign().getTimePrecision(),(long)Integer.parseInt("4"));
        ArrayList<KeyTypeValue> udfExpected = new ArrayList();
        KeyTypeValue valueOne = new KeyTypeValue("PHC ID",null,"30/25/1/1/1/0020");
        KeyTypeValue valueTwo = new KeyTypeValue("PHC Name",null,"Ifelodun Primary Health Centre");
        KeyTypeValue valueThird = new KeyTypeValue("PHC Location","url","https://goo.gl/maps/AyondpDQRZPNJxUi7");
        KeyTypeValue valueFourth = new KeyTypeValue("PHC Phone No","tel","+234 (0) 803 852 1693");
        udfExpected.add(valueOne);udfExpected.add(valueTwo);udfExpected.add(valueThird);udfExpected.add(valueFourth);
        assertEquals(familySurveyMessageRequest.getCampaign().getUdf(), udfExpected);
        assertEquals(familySurveyMessageRequest.getFamilyID(),"789");
        assertEquals(familySurveyMessageRequest.getHcwUserName(),"nks@apra.in");
        assertEquals(familySurveyMessageRequest.getPrimaryContactPhone(),"000000");
        assertEquals(familySurveyMessageRequest.getOpenCampLinkId(),"ABCD1234");
        FamilyMemberDataClass[] familyMemberDataClasses = {objectMapper.readValue( "    {\n" +
                "      \"memberId\": \"11\",\n" +
                "      \"firstName\": \"Matt\",\n" +
                "      \"lastName\": \"Nime\",\n" +
                "      \"name\": \"Matt Nime\",\n" +
                "      \"dob\": \"1996-09-25\",\n" +
                "      \"gender\": \"M\",\n" +
                "      \"status\": \"New\",\n" +
                "      \"head\": true\n" +
                "    }",FamilyMemberDataClass.class),
                objectMapper.readValue("    {\n" +
                        "      \"memberId\": \"12\",\n" +
                        "      \"firstName\": \"Jeff\",\n" +
                        "      \"lastName\": \"Nime\",\n" +
                        "      \"dob\": \"1997-06-12\",\n" +
                        "      \"gender\": \"F\",\n" +
                        "      \"status\": \"New\"\n" +
                        "    }\n",FamilyMemberDataClass.class)
        };
        assertArrayEquals(familySurveyMessageRequest.getFamilyMembers(),familyMemberDataClasses);
    }

    @Test
    public void jsonString_edit_correctFamilySurveyDataClassParsed() throws JSONException, JsonProcessingException {
        String shortId = "ABBCD";
        String inputJson = "{\"familyId\": \"789\",\"hcwUserName\": \"nks@apra.in\",\"primaryContactPhone\": \"+918923645896\",\"openCampLinkId\":\""+shortId+"\",\"familySurveyResponse\":\"\",\"familyMembers\": [{\"memberId\": \"13\",\"firstName\": \"Jeff\",\"lastName\": \"Nime\",\"dob\": \"1998-05-03\",\"gender\": \"M\",\"status\": \"New\"},{\"memberId\": \"12\",\"firstName\": \"Roma\",\"lastName\": \"Nime\", \"dob\": \"1997-06-12\",\"gender\": \"F\",\"status\": \"Delete\"},{\"memberId\": \"11\",\"firstName\": \"Time\",\"lastName\": \"Nime\",\"dob\": \"1993-09-25\",\"gender\": \"M\",\"status\": \"Update\"}]};\n";
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Integer> verticals =new ArrayList<>();
        verticals.add(2);verticals.add(5);
        FamilySurveyMessageRequest familySurveyMessageRequest = objectMapper.readValue(inputJson,FamilySurveyMessageRequest.class);
        assertNull(familySurveyMessageRequest.getCampaign());
        assertEquals(familySurveyMessageRequest.getFamilyID(),"789");
        assertEquals(familySurveyMessageRequest.getHcwUserName(),"nks@apra.in");
        assertEquals(familySurveyMessageRequest.getPrimaryContactPhone(),"+918923645896");
        assertEquals(familySurveyMessageRequest.getOpenCampLinkId(),shortId);
        FamilyMemberDataClass[] familyMemberDataClasses = {objectMapper.readValue( "    {\n" +
                "      \"memberId\": \"13\",\n" +
                "      \"firstName\": \"Jeff\",\n" +
                "      \"lastName\": \"Nime\",\n" +
                "      \"dob\": \"1998-05-03\",\n" +
                "      \"gender\": \"M\",\n" +
                "      \"status\": \"New\"\n" +
                "    }",FamilyMemberDataClass.class),
                objectMapper.readValue("    {\n" +
                        "      \"memberId\": \"12\",\n" +
                        "      \"firstName\": \"Roma\",\n" +
                        "      \"lastName\": \"Nime\",\n" +
                        "      \"dob\": \"1997-06-12\",\n" +
                        "      \"gender\": \"F\",\n" +
                        "      \"status\": \"Delete\"\n" +
                        "    }\n",FamilyMemberDataClass.class),
                objectMapper.readValue("    {\n" +
                        "      \"memberId\": \"11\",\n" +
                        "      \"firstName\": \"Time\",\n" +
                        "      \"lastName\": \"Nime\",\n" +
                        "      \"dob\": \"1993-09-25\",\n" +
                        "      \"gender\": \"M\",\n" +
                        "      \"status\": \"Update\"\n" +
                        "    }\n",FamilyMemberDataClass.class)
        };
        assertArrayEquals(familySurveyMessageRequest.getFamilyMembers(),familyMemberDataClasses);
    }
}