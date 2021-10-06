package com.iprd.testapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.iprd.intent_proto.BloodDrawMessageRequest;
import com.iprd.intent_proto.BloodDrawMessageRequestBuilder;
import com.iprd.intent_proto.CampaignDataClass;
import com.iprd.intent_proto.CampaignDataClassBuilder;
import com.iprd.intent_proto.KeyTypeValue;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import static com.iprd.testapplication.MainActivity.BUNDLE_INPUT_JSON;
import static com.iprd.testapplication.MainActivity.BUNDLE_OUTPUT_JSON;
import static com.iprd.testapplication.MainActivity.NEW_REQUEST_CODE;
import static com.iprd.testapplication.MainActivity.QR_REQUEST_CODE;

public class QrScannerActivity extends AppCompatActivity {
    public static final String QR_DATA_BUNDLE_KEY = "qr_data_string";
    SurfaceView surfaceView;
    TextView txtBarcodeValue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_scanner_activity);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews();
    }

    private void initViews() {
        txtBarcodeValue = findViewById(R.id.txtBarcodeValue);
        surfaceView = findViewById(R.id.surfaceView);
    }

    private void initialiseDetectorsAndSources() {
        Toast.makeText(getApplicationContext(), "Barcode scanner started", Toast.LENGTH_SHORT).show();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(QrScannerActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(QrScannerActivity.this, new
                                String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    }
                } catch (IOException e) {
                    LOG.info(e.toString());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                //Toast.makeText(getApplicationContext(), "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {
                    txtBarcodeValue.post(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                URL qrDataString = new URL(barcodes.valueAt(0).displayValue);
                                String shortIdToRecallWithQR = qrDataString.getQuery().split("=")[1].replace("&v", "");
                                openRecovers(shortIdToRecallWithQR);
                            } catch (MalformedURLException | IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });
    }

    void openRecovers(String shortIdToRecallWithQR){
        cameraSource.stop();
        KeyTypeValue keyTypeValue = new KeyTypeValue("key", "type", "value");
        ArrayList<KeyTypeValue> udf = new ArrayList<>();
        udf.add(keyTypeValue);
        ArrayList<Integer> verticals = new ArrayList<>();
        verticals.add(2);
        CampaignDataClass campaignDataClass =
                new CampaignDataClassBuilder()
                        .setId("6ecb0566-7006-4382-9cdc-202d9010858a")
                        .setName("Oyo State June 2021 Health Campaign")
                        .setUrl("https://health.oyostate.gov.ng/tomotiya/")
                        .setVerticals(verticals)
                        .setLocationPrecision(2)
                        .setTimePrecision(5)
                        .setUdf(udf)
                        .build();

        BloodDrawMessageRequest bloodDrawMessageRequest =
                new BloodDrawMessageRequestBuilder()
                        .setCampaign(campaignDataClass)
                        .setFamilyID("tempID")
                        .setHcwUserName("tempUser")
                        .setHcwUserId("tempUser@test.org")
                        .setOpenCampLinkId(shortIdToRecallWithQR)
                        .setVerificationMethod("BIOMETRIC")
                        .build();

        Intent sendIntent = new Intent();
        sendIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        sendIntent.putExtra(BUNDLE_INPUT_JSON, bloodDrawMessageRequest.toJsonString());
        sendIntent.setAction("HOME_SCREEN_IPRD");
        sendIntent.setComponent(new ComponentName("com.iprd.blooddraw", "com.iprd.blooddraw.home.HomeActivity"));
        Intent chooser = Intent.createChooser(sendIntent, "IPRD OCL");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(chooser, NEW_REQUEST_CODE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         if (requestCode == NEW_REQUEST_CODE) {
            if(data!=null){
                Toast.makeText(this,
                        "Output Json : " +
                                data.getExtras().getString(BUNDLE_OUTPUT_JSON),
                        Toast.LENGTH_LONG).show();
                try {
                    JSONObject jObject = new JSONObject(data.getExtras().getString(BUNDLE_OUTPUT_JSON));
                    if(jObject.getString("resultCode").equals("0")){
                        String shortId = jObject.getString("openCampLinkId");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseDetectorsAndSources();
    }
}

