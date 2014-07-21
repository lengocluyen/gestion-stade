package net.gp.gestade.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class MenuBuild {
	public static List<MenuItem> getMenu(String actionName, HttpSession session){
		SessionManage sessionManage = new SessionManage(session);
		if(sessionManage.getAccount()!=null){
			return MenuBuild.ApresLogin(actionName);
		}
		else
		{
			return MenuBuild.AvantLogin(actionName);
		}
	}
	
	public static List<MenuItemAdmin> getAdminMenu(String actioName, HttpSession session){
		SessionManage sessionManage = new SessionManage(session);
		if(sessionManage.getIsAdmin()){
			return MenuBuild.AdminLogin(actioName);
		}
		return null;
	}
	public static List<MenuItem> AvantLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Gestade/", "Accueil", ""));
		list.add(new MenuItem("/Gestade/emploidutemps", "Emploi du temp", ""));
		list.add(new MenuItem("/Gestade/inscription", "Inscription", ""));
		list.add(new MenuItem("/Gestade/login", "S'identifier", ""));
		list.add(new MenuItem("/Gestade/aboutus", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("selected");
		}
		return list;
	}

	public static List<MenuItem> ApresLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Gestade/", "Accueil", ""));
		list.add(new MenuItem("/Gestade/emploidutemps", "Emploi du Temp", ""));
		list.add(new MenuItem("/Gestade/votrecompte", "Votre Compte", ""));
		list.add(new MenuItem("/Gestade/aboutus", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("selected");
		}
		return list;
	}
	public static List<MenuItemAdmin> AdminLogin(String nameActive){
		ArrayList<MenuItemAdmin> list = new ArrayList<MenuItemAdmin>();
		list.add(new MenuItemAdmin(new MenuItem("/Gestade/gestion/accueil", "Accueil", ""),null));
		list.add(new MenuItemAdmin(new MenuItem("/Gestade/schedule/index", "Emploi du Temps", ""),null));
		list.add(new MenuItemAdmin(new MenuItem("/Gestade/stade/index", "Stade", ""),null));
		list.add(new MenuItemAdmin(new MenuItem("/Gestade/account/index", "Compte", ""),null));
		list.add(new MenuItemAdmin(new MenuItem("/Gestade/equipment/index", "Equipment", ""),null));
		
		
	for (MenuItemAdmin menuItem : list) {
			if (menuItem.getItem().getName().toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.getItem().setIsCurrent("current");
		}
		return list;
	}
}
