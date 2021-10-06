package com.iprd.intent_proto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BloodDrawResponseMessageUnitTest {

    @Test
    public void build_bloodDrawMessage_correctResponseMessageBuilt() {

        BloodDrawResponseMessage bloodDrawResponseMessage =
                new BloodDrawResponseMessageBuilder()
                        .setHcwUserName("hcw")
                        .setOpenCampLinkId("OCL123")
                        .setResultText("Success")
                        .setResultCode("0")
                        .build();

        assertEquals(bloodDrawResponseMessage.getHcwUserName(), "hcw");
        assertEquals(bloodDrawResponseMessage.getOpenCampLinkId(), "OCL123");
        assertEquals(bloodDrawResponseMessage.getResultCode(), "0");
        assertEquals(bloodDrawResponseMessage.getResultText(), "Success");

    }

    @Test
    public void build_familySurveyMessage_correctResponseMessageBuilt() {

        FamilySurveyResponseMessage familySurveyResponseMessage =
                new FamilySurveyResponseMessageBuilder()
                        .setFamilyId("123")
                        .setPrimaryContactPhone("918105798127")
                        .setHcwUserName("hcwUserName")
                        .setOpenCampLinkId("OCL123")
                        .setResultText("Invalid JSON")
                        .setResultCode("1")
                        .build();

        assertEquals(familySurveyResponseMessage.getHcwUserName(), "hcwUserName");
        assertEquals(familySurveyResponseMessage.getOpenCampLinkId(), "OCL123");
        assertEquals(familySurveyResponseMessage.getResultCode(), "1");
        assertEquals(familySurveyResponseMessage.getResultText(), "Invalid JSON");
        assertEquals(familySurveyResponseMessage.getPrimaryContactPhone(), "918105798127");
        assertEquals(familySurveyResponseMessage.getFamilyId(), "123");


    }
}