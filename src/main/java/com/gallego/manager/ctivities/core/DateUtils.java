package com.gallego.manager.ctivities.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public int checkDifferenceDays(String starDate) {
        int delay_days = 0;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        Date dateNow;
        Date dateActivity;
        try {
            dateActivity = format.parse(starDate);
            dateNow = format.parse(format.format(cal.getTime()));
            delay_days = ((int) getDifferenceDays(dateActivity, dateNow));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (delay_days < 0)
            delay_days = 0;

        return delay_days;
    }

    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
