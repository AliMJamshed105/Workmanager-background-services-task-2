package com.example.workgroup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.text.DateFormat;
import java.util.Date;

public class MyAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //do something here
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println("hello we are here from the alarm reciever method " + currentDateTimeString);

        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .build();
        WorkManager.getInstance().enqueue(oneTimeWorkRequest);

    }
}
