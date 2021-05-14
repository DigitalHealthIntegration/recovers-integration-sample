package com.iprd.testapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.iprd.federatedid.records.ReportActivityNigeriaNet;

public class MainActivity extends AppCompatActivity {

    private String shortId = "";
    private String name = "Rohit Kumar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btnNew);
        Button btnEdit = findViewById(R.id.btnEdit);
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_USERNAME, name);
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_DEMOGRAPHIC, "sample-demo");
            startActivityForResult(intent, ReportActivityNigeriaNet.NEW_REQUEST_CODE);

        });

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_SHORT_ID, shortId);
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_USERNAME,name);
            startActivityForResult(intent, ReportActivityNigeriaNet.EDIT_REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            Toast.makeText(this,
                    "Number of faces : "+
                    data.getExtras().getInt(ReportActivityNigeriaNet.BUNDLE_KEY_NUMBER_OF_FACES) +
                    "Number of houses : "+
                    data.getExtras().getInt(ReportActivityNigeriaNet.BUNDLE_KEY_NUMBER_OF_HOUSES),
                    Toast.LENGTH_LONG).show();
            shortId = data.getExtras().getString(ReportActivityNigeriaNet.BUNDLE_KEY_SHORT_ID);
        }

    }

}