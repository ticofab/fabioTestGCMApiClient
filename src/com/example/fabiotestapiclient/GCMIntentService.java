package com.example.fabiotestapiclient;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {
    private static final String TAG = GCMIntentService.class.getSimpleName();

    @Override
    protected void onError(Context arg0, String arg1) {
        Log.d(TAG, "onError");

    }

    @Override
    protected void onMessage(Context arg0, Intent arg1) {
        Log.d(TAG, "onMessage");
        // Get the data from intent and send to notificaion bar
        Log.d(TAG, "message: " + arg1.getStringExtra("message"));
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setContentTitle(
                "My notification").setSmallIcon(R.drawable.ic_launcher).setContentText(
                arg1.getStringExtra("message"));
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(54, mBuilder.build());
    }

    @Override
    protected void onRegistered(Context arg0, String arg1) {
        Log.d(TAG, "onRegistered");

    }

    @Override
    protected void onUnregistered(Context arg0, String arg1) {
        Log.d(TAG, "onUnregistered");

    }

}
