package com.iprd.testapplication;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static int NEW_REQUEST_CODE = 401;
    public static int EDIT_REQUEST_CODE = 402;
    public static final String BUNDLE_KEY_USERNAME = "username";
    public static final String BUNDLE_KEY_SHORT_ID = "shortId";
    public static final String BUNDLE_KEY_DEMOGRAPHIC = "demographics";
    public static final String BUNDLE_KEY_NUMBER_OF_FACES = "noFaces";
    public static final String BUNDLE_KEY_NUMBER_OF_HOUSES = "noHouses";
    public static final String BUNDLE_KEY_LOCATION_CAPTURED = "locationCaptured";

    private String shortId = "8LDFRK4QVQ7E";
    private String name = "apra2793@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btnNew);
        Button btnEdit = findViewById(R.id.btnEdit);
        btnNew.setOnClickListener(v -> {
            openSmartHealthApp(true);
        });

        btnEdit.setOnClickListener(v -> {
            openSmartHealthApp(false);
        });

    }

    void openSmartHealthApp(boolean isNew) {
        Intent intent = new Intent("HOME_SCREEN_IPRD");
        if (isNew) {
            intent.putExtra(BUNDLE_KEY_USERNAME, name);
            intent.putExtra(BUNDLE_KEY_DEMOGRAPHIC, "sample-demo");
        } else {
            intent.putExtra(BUNDLE_KEY_SHORT_ID, shortId);
        }
        intent.setComponent(new ComponentName("com.iprd.federatedid", "com.iprd.federatedid.records.ReportActivityNigeriaNet"));
        startActivityForResult(intent, NEW_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Toast.makeText(this,
                    "Number of faces : " +
                            data.getExtras().getInt(BUNDLE_KEY_NUMBER_OF_FACES),
                    Toast.LENGTH_LONG).show();
            shortId = data.getExtras().getString(BUNDLE_KEY_SHORT_ID);
        }

    }
}