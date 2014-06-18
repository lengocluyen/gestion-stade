package net.gp.gestade.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CovosoUtils {
	public static Map<String,String> HeureDepartDefault(){
		Map<String,String> result = new LinkedHashMap<String,String>();
		for(int i=0;i<24;i++){
			if(i<10){
			result.put("0"+i +"H00","0"+i +"H00");
			result.put("0"+i +"H15","0"+i +"H15");
			result.put("0"+i +"H30","0"+i +"H30");
			result.put("0"+i +"H45","0"+i +"H45");
			}
			else
			{
				result.put(i +"H00",i +"H00");
				result.put(i +"H15",i +"H15");
				result.put(i +"H30",i +"H30");
				result.put(i +"H45",i +"H45");
				}
				
		}
		return result;
	}
}
