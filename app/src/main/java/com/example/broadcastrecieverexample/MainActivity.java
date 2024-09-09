package com.example.broadcastrecieverexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView chargingStatusTextView;
    private TextView batteryPercentageTextView;
    private BatteryStatusReceiver batteryStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View rootView = findViewById(android.R.id.content);

        chargingStatusTextView = findViewById(R.id.chargingStatusTextView);
        batteryPercentageTextView = findViewById(R.id.batteryPercentageTextView);

        // Initialize the BatteryStatusReceiver
        batteryStatusReceiver = new BatteryStatusReceiver(chargingStatusTextView, batteryPercentageTextView);

        // Register the receiver with the ACTION_BATTERY_CHANGED filter
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryStatusReceiver, ifilter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Register the BroadcastReceiver to listen for airplane mode changes
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryStatusReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the BroadcastReceiver when the activity is not in the foreground
        unregisterReceiver(batteryStatusReceiver);
    }
}