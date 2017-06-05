package com.iws.appportal.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	public static void main(String[] args) {
		
		Calendar c=new GregorianCalendar();
		c.add(Calendar.DATE, 180);
		Date d=c.getTime();
		
		System.out.println(d);
	}
}
