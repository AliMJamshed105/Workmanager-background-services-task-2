package com.example.workgroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*
        //set constraints

        Constraints constraints= new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build();

        //build a request, either Onetime or Periodic
        //enque it...bas

        final PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(
                MyWorker.class, 20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();

        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setConstraints(constraints)
                .build();



        */

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //alarm
                //
                setAlarm();


               /* WorkManager workManager= WorkManager.getInstance(MainActivity.this);
                //whichever workrequest I enqueue...that will run
                workManager.enqueue(oneTimeWorkRequest);

                */

            }
        });

        final TextView textView = findViewById(R.id.textView);
       // WorkManager workManager= WorkManager.getInstance(MainActivity.this);
        // also get live data as to what is happening
       /* workManager.getWorkInfoByIdLiveData(periodicWorkRequest.getId()) .observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                textView.append(status + '\n');
            }
        });

        */
    }

    private void setAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        //alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 1000*60*1, pendingIntent );
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, GregorianCalendar.getInstance().getTimeInMillis(),60000,pendingIntent);
        Toast.makeText(this, "Alarm is set ", Toast.LENGTH_SHORT).show();
    }

}
