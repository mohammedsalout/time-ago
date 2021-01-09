package com.mas.gettime;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class GetTime {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;


    public static String getTimeAgo(Context context, String timeString, DateFormat dateFormat, int server_millis_time_zone) {
        //2020-11-24T22:17:20
        String agoTime = "";

        String str_date = timeString.replace(".000000Z", "");

        // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = (Date) dateFormat.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // =============================================
        Calendar currentCalender = Calendar.getInstance();
        TimeZone tz = currentCalender.getTimeZone();
        int zoneTime = (tz.getRawOffset());

        long now = currentCalender.getTimeInMillis();

        Calendar postCalender = Calendar.getInstance();
        postCalender.setTime(date);
        long time;

        if (zoneTime == server_millis_time_zone) {
            time = date.getTime();
        } else {
            time = date.getTime() + zoneTime;
        }

        // TODO: localize
        final long diff = now - time;


        //==============================================

        //return PrettyTimeAgo.getTimeAgo(date.getTime() + zoneTime);

        return getTheTime(diff, context, time);

    }

    public static String getTimeAgo(Context context, Long millis_time, int server_millis_time_zone) {
        //2020-11-24T22:17:20
        // =============================================

        Calendar currentCalender = Calendar.getInstance();
        TimeZone tz = currentCalender.getTimeZone();
        int zoneTime = (tz.getRawOffset());

        long now = currentCalender.getTimeInMillis();
        long time;
        if (zoneTime == server_millis_time_zone) {
            time = millis_time;
        } else {
            time = millis_time + zoneTime;

        }


        // TODO: localize
        final long diff = now - time;

        //==============================================

        //return PrettyTimeAgo.getTimeAgo(date.getTime() + zoneTime);

        return getTheTime(diff, context, time);

    }

    private static String getTheTime(long diff, Context context, Long time) {

        String since = context.getString(R.string.since);

        if (diff < MINUTE_MILLIS) {
            return context.getString(R.string.just_now);
        } else if (diff < 2 * MINUTE_MILLIS) {
            return context.getString(R.string.a_minute_ago);
        } else if (diff < 50 * MINUTE_MILLIS) {
            return since + (diff / MINUTE_MILLIS) + " " + context.getString(R.string.minutes_ago);
        } else if (diff < 90 * MINUTE_MILLIS) {
            return since + context.getString(R.string.an_hour_ago);
        } else if (diff < 24 * HOUR_MILLIS) {
            return since + (diff / HOUR_MILLIS) + " " + context.getString(R.string.an_hour_ago);
        } else if (diff < 48 * HOUR_MILLIS) {
            return since + context.getString(R.string.yesterday);
        } else {
            if (diff / DAY_MILLIS <= 5) {
                return since + (diff / DAY_MILLIS) + " " + context.getString(R.string.days_ago);
            } else {
                return getDateString(time) + "";
            }
        }
    }

    private static String getDateString(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        Date d = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);
        return sdf.format(d);
    }

}
