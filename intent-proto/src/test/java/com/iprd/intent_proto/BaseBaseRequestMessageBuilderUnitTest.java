package com.iprd.intent_proto;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BaseBaseRequestMessageBuilderUnitTest {
    @Test
    public void build_withJsonString_correctRequestMessageBuilt() {
        KeyTypeValue keyTypeValue = new KeyTypeValue("key", "type", "value");
        ArrayList<KeyTypeValue> udf = new ArrayList<>();
        udf.add(keyTypeValue);
        ArrayList<Integer> verticals = new ArrayList<>();
        verticals.add(2);
        CampaignDataClass campaignDataClass =
                new CampaignDataClassBuilder()
                        .setId("campId")
                        .setName("campName")
                        .setUrl("url")
                        .setVerticals(verticals)
                        .setLocationPrecision(2)
                        .setTimePrecision(3)
                        .setUdf(udf)
                        .build();

        FamilyMemberDataClass[] familyMemberDataClasses = new FamilyMemberDataClass[]{
                new FamilyMemberDataBuilder()
                        .setDob("12-09-2021")
                        .setGender("M")
                        .setHead(true)
                        .setMemberID("1234")
                        .setName("kash")
                        .setStatus("NEW")
                        .build()
        };

        FamilySurveyMessageRequest familySurveyMessageRequest =
                new FamilySurveyMessageRequestBuilder()
                        .setCampaign(campaignDataClass)
                        .setFamilyID("tempID")
                        .setHcwUserName("tempUser")
                        .setHomeImageUri("ImageTempUri")
                        .setPrimaryContactPhone("123456")
                        .setVerificationMethod("BIOMETRIC")
                        .setOpenCampLinkId("ABCD")
                        .setFamilyMembers(familyMemberDataClasses)
                        .build();

        assertEquals(familySurveyMessageRequest.getCampaign().getId(),"campId");
        assertEquals(familySurveyMessageRequest.getCampaign().getName(),"campName");
        assertEquals(familySurveyMessageRequest.getCampaign().getVerticals(),verticals);
        assertEquals(familySurveyMessageRequest.getCampaign().getUrl(),"url");
        assertEquals((long)familySurveyMessageRequest.getCampaign().getLocationPrecision(),(long)Integer.parseInt("2"));
        assertEquals((long)familySurveyMessageRequest.getCampaign().getTimePrecision(),(long)Integer.parseInt("3"));
        assertEquals(familySurveyMessageRequest.getCampaign().getUdf(), udf);
        assertEquals(familySurveyMessageRequest.getFamilyID(),"tempID");
        assertEquals(familySurveyMessageRequest.getHcwUserName(),"tempUser");
        assertEquals(familySurveyMessageRequest.getPrimaryContactPhone(),"123456");
        assertEquals(familySurveyMessageRequest.getOpenCampLinkId(),"ABCD");
        assertEquals(familySurveyMessageRequest.getVerificationMethod(), FamilySurveyMessageRequest.VerificationMethod.BIOMETRIC);
        assertEquals(familySurveyMessageRequest.getHomeImageUri(),"ImageTempUri");
        assertArrayEquals(familySurveyMessageRequest.getFamilyMembers(),familyMemberDataClasses);

    }

}