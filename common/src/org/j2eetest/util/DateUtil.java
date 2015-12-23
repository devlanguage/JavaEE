/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * com.tellabs.tmfnbi.platform.server.util.DateUtil.java is created on 2007-9-12 17:29:34
 */
package org.j2eetest.util;

import static org.j2eetest.util.BasseConstants.DEFAULT_DATE_FORMAT;
import static org.j2eetest.util.BasseConstants.ITU_DATE_FORMAT_NO_TIME_ZONE;
import static org.j2eetest.util.BasseConstants.ITU_DATE_FORMAT_WITH_TIME_ZONE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




/**
 * 
 */
public class DateUtil {

    private final static LoggerUtil logger = LoggerUtil.getLogger(DateUtil.class);
    private final static SimpleDateFormat DATE_FORMATTER = (SimpleDateFormat) SimpleDateFormat.getInstance();

    public final static String formatDate(Date date, String pattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return formatDate(calendar, pattern);

    }

    public final static String formatDate(Calendar calendar) {

        return formatDate(calendar,DEFAULT_DATE_FORMAT);
    }

    public final static String formatDate(Calendar calendar, String pattern) {

        DATE_FORMATTER.applyPattern(pattern);
        return DATE_FORMATTER.format(calendar.getTime());
    }

    public final static Date parseDate(String source) {

        return parseDate(source, DEFAULT_DATE_FORMAT);
    }

    public final static Date parseDate(String soure, String pattern) {

        try {
            DATE_FORMATTER.applyPattern(pattern);
            return DATE_FORMATTER.parse(soure);
        } catch (ParseException e) {
            logger.log(LoggerUtil.ERROR, "parseDate", e.getMessage(), e);
            return null;
        }
    }

    public final static Date parseItuDate(String soure) {
        try {
            if (soure.contains("+")) {
                DATE_FORMATTER.applyPattern(ITU_DATE_FORMAT_WITH_TIME_ZONE);
            } else {
                DATE_FORMATTER.applyPattern(ITU_DATE_FORMAT_NO_TIME_ZONE);
            }
            return DATE_FORMATTER.parse(soure);
        } catch (Exception e) {
            logger.log(LoggerUtil.ERROR, "parseDate", e.getMessage(), e);
            return null;
        }
    }

    public static long getTime(String time, String timePattern) {
        // String timePattern = "yyyyMMddHHmmss.SSS";
        String time_t = time;
        try {
            if (time_t != null && !time_t.equals("")) {
                SimpleDateFormat formtTime = new SimpleDateFormat(timePattern);
                Date date = formtTime.parse(time_t);
                return date.getTime();
            }
        } catch (Exception ex) {
            logger.log(LoggerUtil.DEBUG, "getTimeStamp", "Translate time to Time_T format Error");
        }
        return 0;
    }
}
