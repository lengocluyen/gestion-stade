package net.gp.gestade.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	public static Date getDateFromString(String d) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"E MMM dd yyyy HH:mm:ss");

		try {

			return formatter.parse(d);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static Date convertFormatDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		try {

			return formatter.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static List<String> DateInTwoWeek() {
		List<String> result = new ArrayList<String>();
		Date current = Calendar.getInstance().getTime();
		for (int i = 0; i < 14; i++) {
			@SuppressWarnings("deprecation")
			int a = current.getDate() + 1;
			current.setDate(a);
			result.add(Utils.getSimpleDate(current));
		}
		return result;
	}

	public static List<String> HoursInDate() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			String hour = (i < 10 ? "0" + i : i).toString();
			for (int j = 0; j < 46; j += 30) {
				String minute = (j < 10 ? "0" + j : j).toString();
				result.add(hour + ":" + minute);
			}
		}
		return result;
	}

	public static String getSimpleDateFormat(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"MM-dd-yyyy HH:mm");
		return simpleDateFormat.format(date);
	}

	public static String getSimpleDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		return simpleDateFormat.format(date);
	}

	public static Date getDate(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

		try {

			return simpleDateFormat.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static String getHourtoString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		return simpleDateFormat.format(date);
	}

	public static int getTime(Date start, Date end) {
		int minuteStart = start.getHours() * 60 + start.getMinutes();
		int minuteEnd = end.getHours() * 60 + end.getMinutes();
		return minuteEnd - minuteStart;
	}
}
