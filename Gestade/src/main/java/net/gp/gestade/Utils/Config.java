package net.gp.gestade.Utils;

import java.util.*;

public class Config
{
	public static final long PRIX;
	public static final double PROMOTION;
	static{
		ResourceBundle rb=ResourceBundle.getBundle("config");
		
		PRIX=Long.parseLong(rb.getString("PRIX"));
		PROMOTION=Double.parseDouble(rb.getString("PROMOTION"));
	}
}
