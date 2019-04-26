package com.ucontrol.dapweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ��ת��������
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
		Date date = StringToDate(time, formatType); // String����ת��date����
		if (date == null) {
			return (long) 0;
		} else {
			long currentTime = DateToLong(date); // date����ת��long����
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
		Date dateOld = new Date(time); // ����long���͵ĺ���������һ��date���͵�ʱ��
		String sDateTime = DateToString(dateOld, "yyyyMMdd"); // ��date���͵�ʱ��ת��Ϊstring
		Date date = StringToDate(sDateTime, "yyyyMMdd"); // ��String����ת��ΪDate����
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
	 * �����ꡢ�¡��� �õ�long��ʱ��
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
	 * ��ȡ�ꡢ�¡���
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
