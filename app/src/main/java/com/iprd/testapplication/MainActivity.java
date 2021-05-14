package com.iprd.testapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.iprd.federatedid.records.ReportActivityNigeriaNet;

public class MainActivity extends AppCompatActivity {

    public static int NEW_REQUEST_CODE = 401;
    public static int EDIT_REQUEST_CODE = 402;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btnNew);
        Button btnEdit = findViewById(R.id.btnEdit);
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_USERNAME, "Rohit Kumar");
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_DEMOGRAPHIC, "sample-demo");
            startActivityForResult(intent, NEW_REQUEST_CODE);
        });

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_SHORT_ID, "123456789");
            startActivityForResult(intent, EDIT_REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(this,data.getExtras().getString(ReportActivityNigeriaNet.BUNDLE_KEY_SHORT_ID),Toast.LENGTH_LONG).show();
    }

    void openApp(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent intent = new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_USERNAME, "Rohit Kumar");
            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_DEMOGRAPHIC, "sample-demo");
//            intent.putExtra(ReportActivityNigeriaNet.BUNDLE_KEY_SHORT_ID,"Rohit Kumar");
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            manager.resolveActivity(intent, 0);
//            intent.setComponent(new ComponentName("com.iprd.federatedid", "com.iprd.federatedid.records.ReportActivityNigeriaNet"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}