package com.myprojectlist.springboot.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    /**
     * 返回字符串时间格式 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getSystemTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) ;
    }
    /**
     * 转换成date类型时间格式
     * @return
     */
    public static Date StrToTime( ) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(getSystemTime());
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 转换成date类型时间格式
     * @return
     */
    public static Date StrToTime( String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 返回成日期字符串 yyyy-MM-dd
     * @return
     */
    public static String getSystemDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date()) ;
    }
    /**
     * date转换string yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date) ;
    }

    /**
     * 返回成日期日期格式
     * @return
     */
    public static Date StrToDate( ) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(getSystemDate());
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     *字符串转换日期
     * @return
     */
    public static Date StrToDate( String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Timestamp 转字时间字符串
     */
    public static  String  TimestampToString (long str){
        Timestamp ts = new Timestamp(str);
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(ts);
	         /* System.out.println(tsStr);
	          //方法二
	          tsStr = ts.toString();   */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsStr;
    }
    /**
     * 返回成日期字符串 yyyyMMdd
     * @return
     */
    public static String getSystemDateToyyyyMMdd(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date()) ;
    }
    /**
     * 返回成日期字符串 yyyyMMddHHmmss
     * @return
     */
    public static String getSystemDateToyyyyMMddHHmmss(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date()) ;
    }
    /**
     * Date或者String转化为时间戳
     * @throws ParseException
     */
    public  static long getSystemDateToTimestamp(String time) throws ParseException{
        SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

//	       String time="1970-01-06 11:45:55";

        Date date = format.parse(time);

        return date.getTime();
    }

    public static String dateToStrShort(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public static String getTimeShort(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 日期转字符串;
     * @Title: dateToString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static String dateToString(Date date,String pattern){
        String dateResult = null;
        if(date != null){
            SimpleDateFormat f = new SimpleDateFormat(StringUtils.isNotEmpty(pattern)?pattern:"yyyy-MM-dd");
            dateResult = f.format(date);
        }
        return dateResult;
    }

    /**
     * 日期转字符串;
     * @Title: dateToString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateResult = null;
        if(date != null){
            dateResult = format.format(date);
        }
        return dateResult;
    }

    /**
     * 字符串转成日期;
     * @Title: stringToDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static Date stringToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateResult = null;
        try {
            if(date != null && ""!=date){
                dateResult = format.parse(date);
            }
            return dateResult;
        } catch (ParseException e) {
            e.printStackTrace();
            dateResult = getNowDate();
        }
        return dateResult;
    }

    /**
     * 根据传递过来的时间获取指定日期的格式;
     * @Title: getNowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static Date dateToDate(Date date){
        String currDate = null;
        if(date != null){
            currDate = dateToString(date);
        }
        return stringToDate(currDate);
    }

    /**
     * 获取当前日期,并且转换成指定格式;
     * @Title: getNowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static Date getNowDate(){
        String currDate = dateToString(new Date());
        return stringToDate(currDate);
    }

    /**
     * 获取当前日期,并且转换成指定格式;
     * @Title: getNowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @throws
     */
    public static String getNowDateAsString(){
        String currDate = dateToString(new Date());
        return currDate;
    }

    /***
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Integer getDifMonth(Date startDate, Date endDate){
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }


    /***
     * 获取某月总天数
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 获取相差天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDifDay(Date startDate, Date endDate){
        long betweenDate = (endDate.getTime() - startDate.getTime())/(60*60*24*1000);
        return betweenDate;
    }


    /**
     * 获得当天零时零分零秒
     * @return
     */
    public static Date initDateZeroDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得当天23时59分59秒
     * @return
     */
    public static Date initDateNineDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


    /***
     * 某月第一天
     * @param currentDate
     * @return
     */
    public static Date monthFirstDay(Date currentDate){
        // 获取本月的第一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(currentDate);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /***
     * 某月最后一天
     * @param currentDate
     * @return
     */
    public static Date monthLastDay(Date currentDate){
        // 获取本月的第一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(currentDate);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }


    /***
     *
     * @param currentDate
     * @return
     */
    public static Date initDateZeroDay(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得当天23时59分59秒
     * @return
     */
    public static Date initDateNineDay(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


    /***
     * 当周第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal.getTime();
    }


    /***
     * 当周最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 2);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return cal.getTime();
    }
    /**
     * findDates方法概述:
     * 时间段中的每一天
     */
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("==============="+sdf.format(getFirstDayOfWeek(currentDate)));
        System.out.println("==============="+sdf.format(getLastDayOfWeek(currentDate)));
    }
}
