package com.myprojectlist.springboot.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
