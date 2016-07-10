package com.bfd.oms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * 日期与字符串间的互转
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
public class DateUtil {
	private static Logger	log				= Logger.getLogger(DateUtil.class);
	public static String	dateFormat		= "yyyy-MM-dd HH:mm:ss";
	public static String	dateFormatPart	= "yyyy-MM-dd";

	/**
	 * 日期转字符
	 * @param date 待格式化的日期
	 * @param str  格式字符
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static String getFormatDate(Date date, String str) {
		if (str == null || str.length() == 0) {
			str = dateFormat;
		}
		SimpleDateFormat format = new SimpleDateFormat(str);
		return format.format(date);
	}

	/**
	 * 日期转字符
	 * @param str  格式字符
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static String getFormatDate(String str) {
		return getFormatDate(new Date(), str);
	}

	/**
	 * 日期转字符
	 * @param date 待格式化的日期
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static String getFormatDate(Date date) {
		return getFormatDate(date, dateFormat);
	}

	/**
	 * 日期转字符
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static String getFormatDate() {
		return getFormatDate(new Date(), dateFormat);
	}

	/**
	 * 字符转日期
	 * @param format  格式字符
	 * @param date 待格式化的日期
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static Date getStringToDate(String format, String date) {
		if (format == null || format.length() == 0) {
			format = dateFormat;
		}
		SimpleDateFormat sft = new SimpleDateFormat(format);
		try {
			return sft.parse(date);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error(e);
			return new Date();
		}
	}

	/**
	 * 字符转日期
	 * @param date 待格式化的日期
	 * @return 日期
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static Date getStringToDate(String date) {
		return getStringToDate(dateFormat, date);
	}
}
