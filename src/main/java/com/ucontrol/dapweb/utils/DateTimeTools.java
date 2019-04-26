package com.ucontrol.dapweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换工具类
 * @author nanhao
 *
 */
public class DateTimeTools {

	public DateTimeTools() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * long-String
	 * 
	 * @param time
	 * @param formatType
	 * @return
	 */
	public static String LongToString(long time, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		String ss = sdf.format(new Date(time));
		return ss;
	}

	/**
	 * String-long
	 * 
	 * @param time
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Long StringToLong(String time, String formatType)
			throws ParseException {
		Date date = StringToDate(time, formatType); // String类型转成date类型
		if (date == null) {
			return (long) 0;
		} else {
			long currentTime = DateToLong(date); // date类型转成long类型
			return currentTime;
		}
	}

	/**
	 * Date-long
	 * 
	 * @param date
	 * @return
	 */
	public static long DateToLong(Date date) {
		return date.getTime();
	}

	/**
	 * LongToDate
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date LongToDate(long time) throws ParseException {
		Date dateOld = new Date(time); // 根据long类型的毫秒数生命一个date类型的时间
		String sDateTime = DateToString(dateOld, "yyyyMMdd"); // 把date类型的时间转换为string
		Date date = StringToDate(sDateTime, "yyyyMMdd"); // 把String类型转换为Date类型
		return date;
	}

	/**
	 * String-Date
	 * 
	 * @param time
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Date StringToDate(String time, String formatType)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(time);
		return date;
	}

	/**
	 * Date-String
	 * 
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String DateToString(Date date, String formatType) {
		return new SimpleDateFormat(formatType).format(date);
	}

	/**
	 * 根据年、月、日 得到long型时间
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static long IntToLong(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		long time = cal.getTimeInMillis();
		return time;
	}
	
	/**
	 * 提取年、月、日
	 * @param time
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static String[] StringToArray(String time, String formatType) throws ParseException{
		long longtime = StringToLong(time, formatType);
		String strdate = LongToString(longtime, "yyyy-MM-dd");
		String[] date = strdate.split("-");
		return date;
	}

}
