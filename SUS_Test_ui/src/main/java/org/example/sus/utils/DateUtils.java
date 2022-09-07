package org.example.sus.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class DateUtils {
    static Logger logger = Logger.getLogger(DateUtils.class.getName());

    private DateUtils(){}
    public static final String DATE_FORMAT_01 = "MM/dd/yy";

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_01);
        return sdf.format(date);
    }

    public static String getFutureDate(int numOfDays) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_01);
        return sdf.format(date);
    }

    public static String getFutureDate(int numOfDays, String strFormat) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        return sdf.format(date);
    }

    public static String getDayOfWeekOfGivenDate(String date) {
        String dayOfWeek = "";
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
            Date dt1 = format1.parse(date);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            dayOfWeek = format2.format(dt1);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return dayOfWeek;
    }

    public static String getTransmissionDate(String date1, int numOfDays) throws Exception{
        SimpleDateFormat format1;
        if (date1.length()==8){
            format1 = new SimpleDateFormat(DATE_FORMAT_01);
        }
        else {
            format1 = new SimpleDateFormat("M/dd/yy");
        }
        Date dt1 = format1.parse(date1);

        Date date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt1);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yy");
        return sdf.format(date);
    }
}
