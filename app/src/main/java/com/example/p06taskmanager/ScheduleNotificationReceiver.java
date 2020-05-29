package com.example.p06taskmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class ScheduleNotificationReceiver extends BroadcastReceiver {
    int reqCode = 12345;
    String name;

    @Override
    public void onReceive(Context context, Intent intent) {
        name = intent.getStringExtra("name");

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel("default", "Default Channel",
                    NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("This is for default notification");
            notificationManager.createNotificationChannel(channel);
        }

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity
                (context, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context, "default");
        builder.setContentTitle("Task Manager Reminder");
        builder.setContentText(name);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        Notification n = builder.build();

        notificationManager.notify(123, n);
    }
}
