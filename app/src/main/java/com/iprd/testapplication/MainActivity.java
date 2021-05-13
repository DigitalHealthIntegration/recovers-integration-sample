package com.iprd.testapplication;

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

import com.iprd.federatedid.records.ReportActivityNigeriaNet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnStart);
        button.setOnClickListener(v -> {
            openApp(this);
        });
    }

    void openApp(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent intent =new Intent(this, ReportActivityNigeriaNet.class); //new Intent();
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            manager.resolveActivity(intent, 0);
//            intent.setComponent(new ComponentName("com.iprd.federatedid", "com.iprd.federatedid.records.ReportActivityNigeriaNet"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}