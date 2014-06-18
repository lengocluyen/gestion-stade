package net.gp.gestade.Utils;

import java.util.ArrayList;
import java.util.List;

public class MenuBuild {
	public static List<MenuItem> AvantLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Covoso/", "Accueil", ""));
		list.add(new MenuItem("/Covoso/recherche", "Recherche", ""));
		list.add(new MenuItem("/Covoso/inscription", "Inscription", ""));
		list.add(new MenuItem("/Covoso/login", "S'identifier", ""));
		list.add(new MenuItem("/Covoso/about", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("current");
		}
		return list;
	}

	public static List<MenuItem> ApresLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Covoso/", "Accueil", ""));
		list.add(new MenuItem("/Covoso/recherche", "Recherche", ""));
		list.add(new MenuItem("/Covoso/vosannonces", "Vos Annonces", ""));
		list.add(new MenuItem("/Covoso/votrecompte", "Votre Compte", ""));
		list.add(new MenuItem("/Covoso/about", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("current");
		}
		return list;
	}
	public static List<MenuItemAdmin> AdminLogin(String nameActive){
		ArrayList<MenuItemAdmin> list = new ArrayList<MenuItemAdmin>();
		list.add(new MenuItemAdmin(new MenuItem("/Covoso/gestion/accueil", "Accueil", ""),null));
		ArrayList<MenuItem> enfantannonce = new ArrayList<MenuItem>();
		enfantannonce.add(new MenuItem("/Covoso/ville/index", "Ville", ""));
		list.add(new MenuItemAdmin(new MenuItem("/Covoso/annonce/index", "Annonce", ""),enfantannonce));
		ArrayList<MenuItem> enfantUtilisateur = new ArrayList<MenuItem>();
		enfantUtilisateur.add(new MenuItem("/Covoso/voiture/index", "Voiture", ""));
		enfantUtilisateur.add(new MenuItem("/Covoso/compte/index", "Compte", ""));
		list.add(new MenuItemAdmin(new MenuItem("/Covoso/utilisateur/index", "Utilisateur", ""),enfantUtilisateur));
		for (MenuItemAdmin menuItem : list) {
			if (menuItem.getItem().getName().toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.getItem().setIsCurrent("current");
		}
		return list;
	}
}
