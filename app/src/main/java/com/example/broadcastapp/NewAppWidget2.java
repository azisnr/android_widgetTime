package com.example.broadcastapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget2 extends AppWidgetProvider {
    private static  final String SHARED_PREF_FILE="com.example.broadcastapp";


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        SharedPreferences prefs= context.getSharedPreferences(SHARED_PREF_FILE, 0);

        String dateString1= DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());

        String dateString2= DateFormat.getDateInstance(DateFormat.LONG).format(new Date());

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget2);
        views.setTextViewText(R.id.appwidget_time, dateString1);
        views.setTextViewText(R.id.appwidget_date,dateString2);

        SharedPreferences.Editor prefEditor=prefs.edit();

        prefEditor.apply();

        //otomatis
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+1);
        calendar.set(Calendar.SECOND,0);
        AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        //alarmManager.setAlarmClock(AlarmManager.RTC,calendar.getTimeInMillis(),60*1000);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

