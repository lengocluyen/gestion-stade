package net.gp.gestade.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	public static List<String> DateInTwoWeek(){
		List<String> result = new ArrayList<String>();
		Date current= Calendar.getInstance().getTime();
		for(int i=0;i<14;i++){
			@SuppressWarnings("deprecation")
			int a = current.getDate()+1;
			current.setDate(a);
			result.add(Utils.getSimpleDate(current));
		}
		return result;
	}
	public static List<String> HoursInDate(){
		List<String> result= new ArrayList<String>();
		for(int i=0;i<24;i++){
			String hour= (i<10?"0"+i:i).toString();
			for(int j=0;j<46;j+=30){
				String minute =(j<10?"0"+j:j).toString();
				result.add(hour+":"+minute);
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"MM-dd-yyyy");
		return simpleDateFormat.format(date);
	}
}
