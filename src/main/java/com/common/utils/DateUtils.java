package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateFmt(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

}
