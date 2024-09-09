package com.example.broadcastrecieverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;

public class BatteryStatusReceiver extends BroadcastReceiver {
    private TextView chargingStatusTextView;
    private TextView batteryPercentageTextView;

    // Constructor to initialize TextViews
    public BatteryStatusReceiver(TextView chargingStatusTextView, TextView batteryPercentageTextView) {
        this.chargingStatusTextView = chargingStatusTextView;
        this.batteryPercentageTextView = batteryPercentageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the battery charging status
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        int batteryPercentage = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

//        // Get the current battery percentage
//        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//        int batteryPercentage = (int) ((level / (float) scale) * 100);

        // Update the TextViews with the charging status and battery percentage
        chargingStatusTextView.setText(isCharging ? "Charging" : "Not Charging");
        batteryPercentageTextView.setText("Battery Level: " + batteryPercentage + "%");
    }
}