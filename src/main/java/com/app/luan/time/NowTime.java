package com.app.luan.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: xwluan
 * @Date: 2019-03-29
 * @Description:
 */
public class NowTime {

    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmw");
        String formatTime = format.format(new Date());
        Long nowTime = Long.valueOf(formatTime);
        System.out.println("nowTime： "+nowTime);


        DateFormat df = new SimpleDateFormat("YYYYMMDDHHMM");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        System.out.println("dateName： "+dateName);



    }
}
