package com.example.broadcastrecieverexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class BootCompleteReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "boot_channel";
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "BootCompletedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.d(TAG, "Boot completed broadcast received");

//            // Create the notification channel
//            createNotificationChannel(context);
//
//            // Create an explicit intent for an Activity in your app
//            Intent notificationIntent = new Intent(context, MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//
//            // Build the notification
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
//                    .setSmallIcon(R.drawable.ic_launcher_foreground) // Use your app's icon
//                    .setContentTitle("Boot Completed")
//                    .setContentText("The device has successfully booted.")
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                    .setContentIntent(pendingIntent)
//                    .setAutoCancel(true);
//
//            // Show the notification
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
//            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
    private void createNotificationChannel(Context context) {
        // Create the NotificationChannel, required for Android 8.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Boot Channel";
            String description = "Channel for boot completed notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
