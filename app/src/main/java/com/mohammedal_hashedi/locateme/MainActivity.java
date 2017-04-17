package com.mohammedal_hashedi.locateme;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.senab.photoview.PhotoViewAttacher;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    Button locateMe;


    WifiManager mainWifi;

    public void locateMEFunction(View view){
        startActivity(new Intent(MainActivity.this, CDBBuildingActivity.class));
    }



    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    private void checkPermissions() {
        // the only way we insert the dummy contact if if we are below M.
        // Else we continue on and prompt the user for permissions
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            //insertDummyContact();

            Toast.makeText(MainActivity.this, "This version is not suitable for this app", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
            permissionsNeeded.add("Coarse Location");
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_WIFI_STATE))
            permissionsNeeded.add("Wifi State");
        if (!addPermission(permissionsList, Manifest.permission.CHANGE_WIFI_STATE))
            permissionsNeeded.add("Wifi Change");
        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                showMessageOKCancel(message,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                            }
                        });
                return;
            }
            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }
    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_WIFI_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.CHANGE_WIFI_STATE, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION
                if (perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.CHANGE_WIFI_STATE) == PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted



                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "Some Permission is Denied", Toast.LENGTH_SHORT)
                            .show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    ImageView ground_floor;
    ImageView first_floor;
    ImageView second_floor;
    ImageView third_floor;
    ImageView fourth_floor;
    ImageView fifth_floor;
    ImageView fetg;
    ImageView fet1;
    ImageView fet2;
    ImageView fet3;
    ImageView fet4;

    PhotoViewAttacher photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ground_floor = (ImageView) findViewById(R.id.imageShowFloor);
        first_floor = (ImageView) findViewById(R.id.imageShowFloor);
        second_floor = (ImageView) findViewById(R.id.imageShowFloor);

        third_floor = (ImageView) findViewById(R.id.imageShowFloor);
        fourth_floor = (ImageView) findViewById(R.id.imageShowFloor);
        fifth_floor = (ImageView) findViewById(R.id.imageShowFloor);

        fetg = (ImageView) findViewById(R.id.imageShowFloor);
        fet1 = (ImageView) findViewById(R.id.imageShowFloor);
        fet2 = (ImageView) findViewById(R.id.imageShowFloor);

        fet3 = (ImageView) findViewById(R.id.imageShowFloor);
        fet4 = (ImageView) findViewById(R.id.imageShowFloor);

        photoView = new PhotoViewAttacher(ground_floor);
        photoView = new PhotoViewAttacher(first_floor);
        photoView = new PhotoViewAttacher(second_floor);
        photoView = new PhotoViewAttacher(third_floor);
        photoView = new PhotoViewAttacher(fourth_floor);
        photoView = new PhotoViewAttacher(fifth_floor);

        photoView = new PhotoViewAttacher(fetg);
        photoView = new PhotoViewAttacher(fet1);
        photoView = new PhotoViewAttacher(fet2);
        photoView = new PhotoViewAttacher(fet3);
        photoView = new PhotoViewAttacher(fet4);
        photoView.update();


        Spinner s =(Spinner) findViewById(R.id.spin);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(MainActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                    if (i == 0){
                          ground_floor.setImageResource(R.drawable.ground_floor);
                    }else if (i == 1){
                            first_floor.setImageResource(R.drawable.first_floor);

                    }else if (i == 2){
                        second_floor.setImageResource(R.drawable.second_floor);

                    }else if (i == 3){
                        third_floor.setImageResource(R.drawable.third_floor);

                    }else if (i == 4){
                        fourth_floor.setImageResource(R.drawable.fourth_floor);

                    }else if (i == 5){
                        fifth_floor.setImageResource(R.drawable.fifth_floor);


                     }else if (i == 6){
                         fetg.setImageResource(R.drawable.fetg);

                    }else if (i == 7){
                        fet1.setImageResource(R.drawable.fet1);

                    }else if (i == 8){
                        fet2.setImageResource(R.drawable.fet2);

                     }else if (i == 9){
                         fet3.setImageResource(R.drawable.fet3);

                    }else if (i == 10){
                        fet4.setImageResource(R.drawable.fet4);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        locateMe = (Button) findViewById(R.id.LocateME);
        mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        // Check for wifi is disabled
        if (mainWifi.isWifiEnabled() == false) {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
                    Toast.LENGTH_LONG).show();

            mainWifi.setWifiEnabled(true);
        }
        checkPermissions();

    }


}

