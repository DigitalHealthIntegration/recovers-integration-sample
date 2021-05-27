package com.iprd.testapplication;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static int NEW_REQUEST_CODE = 401;
    public static int EDIT_REQUEST_CODE = 402;
    public static final String BUNDLE_INPUT_JSON = "input_json";
    public static final String BUNDLE_OUTPUT_JSON = "output_json";
    public static final String BUNDLE_KEY_USERNAME = "username";
    public static final String BUNDLE_KEY_SHORT_ID = "shortId";
    public static final String BUNDLE_KEY_DEMOGRAPHIC = "demographics";
    public static final String BUNDLE_KEY_NUMBER_OF_FACES = "noFaces";
    public static final String BUNDLE_KEY_NUMBER_OF_HOUSES = "noHouses";
    public static final String BUNDLE_KEY_LOCATION_CAPTURED = "locationCaptured";

    private String shortId = "51GY4AWC5L76";
    private String name = "apra2793@gmail.com";
    String inputJson = "{\"familyId\": \"1234\",\"hcwUserName\": \"nitink@apra.in\",\"primaryContactPhone\": \"+918923645896\",\"openCampLinkId\":\"\",\"familySurveyResponse\":\"\",\"familyMembers\": [{\"memberId\": \"11\",\"name\": \"Jeevan\",\"age\": \"23\",\"gender\": \"M\",\"status\": \"New\"},{\"memberId\": \"12\",\"name\": \"Tricha\",\"age\": \"22\",\"gender\": \"F\",\"status\": \"New\"}]};\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btnNew);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnRecall = findViewById(R.id.btnRecall);
        btnNew.setOnClickListener(v -> {
            openSmartHealthApp();
        });

        btnEdit.setOnClickListener(v -> {
            openSmartHealthAppInEditMode();
        });

        btnRecall.setOnClickListener(v -> {
            openSmartHealthAppInRecallMode();
        });

    }

    void openSmartHealthApp() {
        Intent intent = new Intent("HOME_SCREEN_IPRD");
        intent.putExtra(BUNDLE_INPUT_JSON, inputJson);
        intent.setComponent(new ComponentName("com.iprd.opencamplink", "com.iprd.opencamplink.records.OpenCampLinkHomeActivity"));
        startActivityForResult(intent, NEW_REQUEST_CODE);
    }

    void openSmartHealthAppInEditMode() {
        String inputForEdit = "{\"familyId\": \"123\",\"hcwUserName\": \"adataintegrity@apra.in\",\"primaryContactPhone\": \"+918923645896\",\"openCampLinkId\":\""+shortId+"\",\"familySurveyResponse\":\"\",\"familyMembers\": [{\"memberId\": \"3\",\"name\": \"Rohit\",\"age\": \"22\",\"gender\": \"M\",\"status\": \"New\"},{\"memberId\": \"1\",\"name\": \"Adarsh\",\"age\": \"23\",\"gender\": \"M\",\"status\": \"Delete\"},{\"memberId\": \"2\",\"name\": \"Trintera\",\"age\": \"22\",\"gender\": \"F\",\"status\": \"Update\"}]};\n";
        Intent intent = new Intent("HOME_SCREEN_IPRD");
        intent.putExtra(BUNDLE_INPUT_JSON, inputForEdit);
        intent.setComponent(new ComponentName("com.iprd.opencamplink", "com.iprd.opencamplink.records.OpenCampLinkHomeActivity"));
        startActivityForResult(intent, NEW_REQUEST_CODE);
    }

    void openSmartHealthAppInRecallMode() {
        String inputForRecall = "{\n" +
                "  \"openCampLinkId\": \"\",\n" +
                "  \"hcwUserName\": \"nitink@apra.in\",\n" +
                "  \"primaryContactPhone\": \"+919812345678\",\n" +
                "  \"verificationMethod\": \"NONE\",\n" +
                "  \"familyMembers\": [" +
                "  ]\n" +
                "}";
        Intent intent = new Intent("RECALL_SCREEN_IPRD");
        intent.putExtra(BUNDLE_INPUT_JSON, inputForRecall);
        intent.setComponent(new ComponentName("com.iprd.opencamplink", "com.iprd.opencamplink.records.OpenCampLinkRecallActivity"));
        startActivityForResult(intent, NEW_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Toast.makeText(this,
                    "Output Json : " +
                            data.getExtras().getString(BUNDLE_OUTPUT_JSON),
                    Toast.LENGTH_LONG).show();
            try {
                JSONObject jObject = new JSONObject(data.getExtras().getString(BUNDLE_OUTPUT_JSON));
                if(jObject.getString("resultCode").equals("0")){
                    shortId = jObject.getString("openCampLinkId");
                }
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }

    }
}