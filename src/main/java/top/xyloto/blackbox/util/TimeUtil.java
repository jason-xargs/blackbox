package top.xyloto.blackbox.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaocong05
 * @createTime 2017-09-18
 * @description TimeUtil
 */
public class TimeUtil {

    private static final String FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public static final long OneDay = 24 * 60 * 60 * 1000;

    public static String formatTime(String timestamp) {
        SimpleDateFormat format = new SimpleDateFormat(FORMATTER);
        return format.format(new Date(Long.valueOf(timestamp)));
    }

    public static Date parseTime(String parsedTime) {
        SimpleDateFormat format = new SimpleDateFormat(FORMATTER);
        try {
            return format.parse(parsedTime);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static long getIntervalMin(String str) {
        return (System.currentTimeMillis() - parseTime(str).getTime()) / 1000 / 60;
    }

}
