package com.mohammedal_hashedi.locateme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.util.Log;

public class CDBBuildingActivity extends AppCompatActivity {

    TextView mainText;
    TextView locationText;
    TextView dateAndTime;
    WifiManager mainWifi;
    WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    StringBuilder sb = new StringBuilder();
    DBHelper mDatabase = new DBHelper(this);


    PhotoViewAttacher photoView;

    ImageView ground_floor;
    ImageView first_floor;
    ImageView second_floor;
    ImageView third_floor;
    ImageView fourth_floor;
    ImageView fifth_floor;
    ImageView fetgl;
    ImageView fetgr;
    ImageView fet1l;
    ImageView fet1r;
    ImageView fet2l;
    ImageView fet2r;
    ImageView fet3l;
    ImageView fet3r;
    ImageView fet4l;
    ImageView fet4r;
    ImageView first_floor_right;
    ImageView first_floor_left;
    ImageView second_floor_right;
    ImageView second_floor_left;
    ImageView third_floor_right;
    ImageView third_floor_left;
    ImageView fourth_floor_right;
    ImageView fourth_floor_left;
    ImageView fifth_floor_left;
    ImageView fifth_floor_right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdbbuilding);

        ground_floor = (ImageView) findViewById(R.id.imageView);
        first_floor = (ImageView) findViewById(R.id.imageView);
        second_floor = (ImageView) findViewById(R.id.imageView);
        third_floor = (ImageView) findViewById(R.id.imageView);
        fourth_floor = (ImageView) findViewById(R.id.imageView);
        fifth_floor = (ImageView) findViewById(R.id.imageView);
        first_floor_right = (ImageView) findViewById(R.id.imageView);
        first_floor_left = (ImageView) findViewById(R.id.imageView);
        second_floor_right = (ImageView) findViewById(R.id.imageView);
        second_floor_left = (ImageView) findViewById(R.id.imageView);
        third_floor_right = (ImageView) findViewById(R.id.imageView);
        third_floor_left = (ImageView) findViewById(R.id.imageView);
        fourth_floor_right = (ImageView) findViewById(R.id.imageView);
        fourth_floor_left = (ImageView) findViewById(R.id.imageView);
        fifth_floor_right = (ImageView) findViewById(R.id.imageView);
        fifth_floor_left = (ImageView) findViewById(R.id.imageView);
        fetgl = (ImageView) findViewById(R.id.imageView);
        fetgr = (ImageView) findViewById(R.id.imageView);
        fet1l = (ImageView) findViewById(R.id.imageView);
        fet1r = (ImageView) findViewById(R.id.imageView);
        fet2l = (ImageView) findViewById(R.id.imageView);
        fet2r = (ImageView) findViewById(R.id.imageView);
        fet3l = (ImageView) findViewById(R.id.imageView);
        fet3r = (ImageView) findViewById(R.id.imageView);
        fet4l = (ImageView) findViewById(R.id.imageView);
        fet4r = (ImageView) findViewById(R.id.imageView);

        mainText = (TextView) findViewById(R.id.mainText);
        locationText = (TextView) findViewById(R.id.locationText);
        mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        dateAndTime = (TextView) findViewById(R.id.dateAndTime);

        photoView = new PhotoViewAttacher(ground_floor);
        photoView = new PhotoViewAttacher(first_floor);
        photoView = new PhotoViewAttacher(second_floor);
        photoView = new PhotoViewAttacher(third_floor);
        photoView = new PhotoViewAttacher(fourth_floor);
        photoView = new PhotoViewAttacher(fifth_floor);

        photoView = new PhotoViewAttacher(first_floor_right);
        photoView = new PhotoViewAttacher(second_floor_right);
        photoView = new PhotoViewAttacher(third_floor_right);
        photoView = new PhotoViewAttacher(fourth_floor_right);
        photoView = new PhotoViewAttacher(fifth_floor_right);

        photoView = new PhotoViewAttacher(first_floor_left);
        photoView = new PhotoViewAttacher(second_floor_left);
        photoView = new PhotoViewAttacher(third_floor_left);
        photoView = new PhotoViewAttacher(fourth_floor_left);
        photoView = new PhotoViewAttacher(fifth_floor_left);

        photoView = new PhotoViewAttacher(fetgl);
        photoView = new PhotoViewAttacher(fetgr);
        photoView = new PhotoViewAttacher(fet1l);
        photoView = new PhotoViewAttacher(fet1r);
        photoView = new PhotoViewAttacher(fet2l);

        photoView = new PhotoViewAttacher(fet2r);
        photoView = new PhotoViewAttacher(fet3l);
        photoView = new PhotoViewAttacher(fet3r);
        photoView = new PhotoViewAttacher(fet4l);
        photoView = new PhotoViewAttacher(fet4r);
        photoView.update();


        if (mainWifi.isWifiEnabled() == false) {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
                    Toast.LENGTH_LONG).show();

            mainWifi.setWifiEnabled(true);
        }


        receiverWifi = new WifiReceiver();


        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mainWifi.startScan();
        mainText.setText("Starting Scan...");
    }



        class WifiReceiver extends BroadcastReceiver {


            public void onReceive(Context c, Intent intent) {

                sb = new StringBuilder();


                Comparator<ScanResult> comparator = new Comparator<ScanResult>() {
                    @Override
                    public int compare(ScanResult lhs, ScanResult rhs) {
                        return (lhs.level > rhs.level ? -1 : (lhs.level == rhs.level ? 0 : 1));
                    }
                };


                wifiList = mainWifi.getScanResults();
                Collections.sort(wifiList, comparator);
                Log.i("SSID", wifiList.get(0).SSID);

                int numberOfConnections = wifiList.size();

                sb.append("\n        Number Of Wifi connections :" + wifiList.size() + "\n\n");
                int count =1  ;
                for (int i = 0; i < numberOfConnections; i++) {

                  // if (new String(wifiList.get(i).SSID).equals("WiFi@MMU Student")) {

                      /* sb.append(new Integer(i + 1).toString() + ". ");
                        sb.append("SSID:- ").append((wifiList.get(i).SSID).toString());
                        sb.append("\nBSSID:- ").append((wifiList.get(i).BSSID).toString());
                        sb.append("\nLevel: ").append((wifiList.get(i).level));
                        sb.append("\n\n");*/
                    if (new String(wifiList.get(i).SSID).equals("WiFi@MMU Student")) {
                        if (count == 1) {
                            Cursor rs;
                            rs = mDatabase.selectRecords(wifiList.get(i).BSSID);
                            rs.moveToFirst();

                            if (rs.getCount() != 0) {
                                int MacIndex = rs.getColumnIndex("Mac_Address");
                                int floorIndex = rs.getColumnIndex("Floor_Number");
                                int buildingIndex = rs.getColumnIndex("building");
                                int Left_or_Right = rs.getColumnIndex("left_or_right");
                                Log.i("try",rs.getString(buildingIndex));
                                Log.i("try",rs.getString(floorIndex));
                                Log.i("try",rs.getString(Left_or_Right));


                                if (rs.getString(buildingIndex).equals("CDP")) {
                                    if (rs.getString(floorIndex).equals("Ground"))
                                        ground_floor.setImageResource(R.drawable.ground_floor);

                                    else if (rs.getString(floorIndex).equals("1") && rs.getString(Left_or_Right).equals("Left"))
                                        first_floor_left.setImageResource(R.drawable.first_floor_left);
                                    else if (rs.getString(floorIndex).equals("1") && rs.getString(Left_or_Right).equals("Right"))
                                        first_floor_right.setImageResource(R.drawable.first_floor_right);

                                    else if (rs.getString(floorIndex).equals("2") && rs.getString(Left_or_Right).equals("Left"))
                                        second_floor_left.setImageResource(R.drawable.second_floor_left);
                                    else if (rs.getString(floorIndex).equals("2") && rs.getString(Left_or_Right).equals("Right"))
                                        second_floor_right.setImageResource(R.drawable.second_floor_right);

                                    else if (rs.getString(floorIndex).equals("3") && rs.getString(Left_or_Right).equals("Left"))
                                        third_floor_left.setImageResource(R.drawable.third_floor_left);
                                    else if (rs.getString(floorIndex).equals("3") && rs.getString(Left_or_Right).equals("Right"))
                                        third_floor_right.setImageResource(R.drawable.third_floor_right);

                                    else if (rs.getString(floorIndex).equals("4") && rs.getString(Left_or_Right).equals("Left"))
                                        fourth_floor_left.setImageResource(R.drawable.fourth_floor_left);
                                    else if (rs.getString(floorIndex).equals("4") && rs.getString(Left_or_Right).equals("Right"))
                                        fourth_floor_right.setImageResource(R.drawable.fourth_floor_right);

                                    else if (rs.getString(floorIndex).equals("5") && rs.getString(Left_or_Right).equals("Left"))
                                        fifth_floor_left.setImageResource(R.drawable.fifth_floor_left);
                                    else if (rs.getString(floorIndex).equals("5") && rs.getString(Left_or_Right).equals("Right"))
                                        fifth_floor_right.setImageResource(R.drawable.fifth_floor_right);
                                }

                                else if (rs.getString(buildingIndex).equals("FET")) {
                                    if (rs.getString(floorIndex).equals("Ground") && rs.getString(Left_or_Right).equals("Left") )
                                        fetgl.setImageResource(R.drawable.fetgl);
                                    else if (rs.getString(floorIndex).equals("Ground") && rs.getString(Left_or_Right).equals("Right") )
                                        fetgr.setImageResource(R.drawable.fetgr);

                                    else if (rs.getString(floorIndex).equals("1") && rs.getString(Left_or_Right).equals("Left"))
                                        fet1l.setImageResource(R.drawable.fet1l);
                                    else if (rs.getString(floorIndex).equals("1") && rs.getString(Left_or_Right).equals("Right"))
                                        fet1r.setImageResource(R.drawable.fet1r);

                                    else if (rs.getString(floorIndex).equals("2") && rs.getString(Left_or_Right).equals("Left"))
                                        fet2l.setImageResource(R.drawable.fet2l);
                                    else if (rs.getString(floorIndex).equals("2") && rs.getString(Left_or_Right).equals("Right"))
                                        fet2r.setImageResource(R.drawable.fet2r);

                                    else if (rs.getString(floorIndex).equals("3") && rs.getString(Left_or_Right).equals("Left"))
                                        fet3l.setImageResource(R.drawable.fet3l);
                                    else if (rs.getString(floorIndex).equals("3") && rs.getString(Left_or_Right).equals("Right"))
                                        fet3r.setImageResource(R.drawable.fet3r);

                                    else if (rs.getString(floorIndex).equals("4") && rs.getString(Left_or_Right).equals("Left"))
                                        fet4l.setImageResource(R.drawable.fet4l);
                                    else if (rs.getString(floorIndex).equals("4") && rs.getString(Left_or_Right).equals("Right"))
                                        fet4r.setImageResource(R.drawable.fet4r);

                                } else {
                                    Toast.makeText(CDBBuildingActivity.this, "please you need to go to either FET or CDB", Toast.LENGTH_SHORT).show();
                                }

                                if (rs.getString(floorIndex).equals("Ground"))
                                {
                                    Toast.makeText(CDBBuildingActivity.this, "Welcome to " + rs.getString(buildingIndex) + " :). You are in the ground floor", Toast.LENGTH_LONG).show();
                                }
                                else {

                                    Toast.makeText(CDBBuildingActivity.this, rs.getString(MacIndex) + ": you are in the " + rs.getString(Left_or_Right) + "side of the " + rs.getString(floorIndex) + " floor of the " + rs.getString(buildingIndex),
                                            Toast.LENGTH_LONG).show();
                                }
                                count++;

                                locationText.setText(rs.getString(buildingIndex) +" "+  rs.getString(floorIndex) + " floor" );
                            }
                            rs.close();

                        }

                    }

                    mainText.setText(sb);
                    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                    dateAndTime.setText(currentDateTimeString);

                }
            }
        }


}

