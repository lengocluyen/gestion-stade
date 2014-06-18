package net.gp.gestade.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.AccountValidator;
import net.gp.gestade.Utils.CovosoUtils;
import net.gp.gestade.Utils.LoginValidator;
import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.SessionManage;
import net.gp.gestade.Utils.StadeValidator;
import net.gp.gestade.form.Account;
import net.gp.gestade.form.Equipment;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.form.Stade;
import net.gp.gestade.service.StadeService;
import net.gp.gestade.service.AccountService;
import net.gp.gestade.service.ScheduleService;
import net.gp.gestade.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import freemarker.core.Expression;

@Controller
//@SessionAttributes({ "utilisateur", "compte", "admin" })
public class AccueilController {
	@Autowired
	private AccountService accountService;
	@RequestMapping("/")
	public ModelAndView accueil(ModelMap map) {
		ModelAndView mv = new ModelAndView("accueil");
		
		return mv;
	}
	// 1. Login
	@RequestMapping("/login")
	public ModelAndView login(ModelMap map,HttpSession session) {
		SessionManage sessionManage = new SessionManage(session);
		if (sessionManage.getAccount()== null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("account", new Account());
			mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("accueil");
//			mv.addObject("recherchebox", new Annonce());
//			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.ApresLogin("accueil"));
			return mv;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("account") Account account,
			BindingResult result, ModelMap map,HttpSession session) {
		SessionManage sessionManage = new SessionManage(session);
		LoginValidator valid = new LoginValidator();
		valid.validate(account, result);
		String message = "";
		Account newacc= new Account();
		ModelAndView mv = new ModelAndView("login");
		if (result.hasErrors()) {
			message = "Les donnees incorrectes";
			
			mv.addObject("account", new Account());
			mv.addObject("message", message);
			mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
			return mv;
		} else {
			newacc = accountService.login(account.getPhonenumber(),
					account.getPassword());
			if (newacc != null) {
				sessionManage.setAccount(newacc);
				sessionManage.setIsLogin(true);
				//account admin?
				if (newacc.getStatus().compareTo("admin") == 0) {
					sessionManage.setIsAdmin(true);
				}
				return new ModelAndView("redirect:/");
			} else {
				message = "Compte n'existe pas";
				mv.addObject("account", new Account());
				mv.addObject("message", message);
				mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
				return mv;
			}
		}
	}

	//
	// 2.Logout
	@RequestMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		SessionManage sessionManage = new SessionManage(session);
		sessionManage.setAccount(null);
		sessionManage.setIsAdmin(null);
		sessionManage.setIsLogin(null);
		return "redirect:/";
	}

	// Page d'introduction de notre groupe
	@RequestMapping("/about")
	public ModelAndView about(ModelMap map) {

		if (map.get("utilisateur") == null) {
			ModelAndView mv = new ModelAndView("about");
			//mv.addObject("menu", MenuBuild.AvantLogin("a propos nous"));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("about");
			//mv.addObject("menu", MenuBuild.ApresLogin("a propos nous"));
			return mv;
		}
	}
	
	
	/*
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private VoitureService voitureService;

	@Autowired
	private AnnonceService annonceService;

	@RequestMapping("/")
	public ModelAndView accueil(ModelMap map) {
		ModelAndView mv = new ModelAndView("accueil");
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
		alist.getNav().setRowCount(annonceService.countAnnonce());

		alist.getNav().setCurrentPage(1);
		alist.setEntities(annonceService.allAnnonce(alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("accueil") : MenuBuild
						.ApresLogin("accueil"));
		return mv;
	}

	@RequestMapping("/accueil/{index}")
	public ModelAndView accueil(@PathVariable("index") Integer index,
			ModelMap map) {
		ModelAndView mv = new ModelAndView("accueil");
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();

		alist.getNav().setRowCount(annonceService.countAnnonce());

		if (index == null || index < 1)
			alist.getNav().setCurrentPage(1);
		else
			alist.getNav().setCurrentPage(index);

		alist.setEntities(annonceService.allAnnonce(alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("accueil") : MenuBuild
						.ApresLogin("accueil"));
		return mv;
	}

	// 4. Recherche des covoiturages
	@RequestMapping("/recherche")
	public ModelAndView recherche(ModelMap map) {
		ModelAndView mv = new ModelAndView("recherche");
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("recherche") : MenuBuild
						.ApresLogin("recherche"));
		return mv;
	}

	@RequestMapping(value = "/recherche", method = RequestMethod.POST)
	public ModelAndView recherche(@ModelAttribute("recherche") Annonce rc,
			BindingResult result, ModelMap map) {
		ModelAndView mv = new ModelAndView("recherche");
		mv.addObject("result", annonceService.listAnnonceFindAll(rc));

		mv.addObject("display", "true");
		mv.addObject("recherchebox", rc);
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("recherche") : MenuBuild
						.ApresLogin("recherche"));
		return mv;
	}

	// 3. Inscription le nouveau utilisateur
	@RequestMapping("/inscription")
	public ModelAndView inscriptionPage() {
		ModelAndView mv = new ModelAndView("inscription");
		mv.addObject("menu", MenuBuild.AvantLogin("inscription"));
		UtilisateuretCompte uc = new UtilisateuretCompte();
		uc.setUtilisateur(new Utilisateur());
		uc.setCompte(new Compte());
		mv.addObject("uc", uc);
		return mv;
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ModelAndView inscription(
			@ModelAttribute("uc") UtilisateuretCompte uc, BindingResult result,
			ModelMap map) {
		ModelAndView mv = new ModelAndView("inscription");
		try {
			UtilisateuretCompteValidator ucValid = new UtilisateuretCompteValidator();
			ucValid.validate(uc, result);
			if (result.hasErrors()) {
				mv.addObject("message",
						"Certains champs manquent des informations");
			} else {
				utilisateurService.addUtilisateuretCompte(uc);
				mv.addObject("message", "Inscription reussi");
			}
		} catch (Exception e) {
			mv.addObject("message", "Certains champs manquent des informations");
		}
		mv.addObject("menu", MenuBuild.AvantLogin("inscription"));
		return mv;
	}
	// 4. Update utilisateur et compte
		@RequestMapping("/utilisateurcompteupdate/{utilisateurId}")
		public ModelAndView utilisateurcompteupdate(@PathVariable("utilisateurId") Integer utilisateurId,
				ModelMap map) {
			ModelAndView mv = new ModelAndView("utilisateurcompteupdate");
			mv.addObject("menu", MenuBuild.AvantLogin("inscription"));
			UtilisateuretCompte uc = new UtilisateuretCompte();
			uc.setUtilisateur((Utilisateur) map.get("utilisateur"));
			uc.setCompte(compteService.findByUtilisateurID(utilisateurId));
			mv.addObject("uc", uc);
			mv.addObject("action","/Covoso/utilisateurcompteupdate/"+utilisateurId);
			mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
			return mv;
		}

		@RequestMapping(value = "/utilisateurcompteupdate/{utilisateurId}", method = RequestMethod.POST)
		public ModelAndView utilisateurcompteupdate(@PathVariable("utilisateurId") Integer utilisateurId,
				@ModelAttribute("uc") UtilisateuretCompte uc, BindingResult result,
				ModelMap map) {
			ModelAndView mv = new ModelAndView("utilisateurcompteupdate");
			try {
				//UtilisateuretCompteValidator ucValid = new UtilisateuretCompteValidator();
				//ucValid.validate(uc, result);
				if (uc.getUtilisateur().getEmail()==""||uc.getUtilisateur().getNom()==""||uc.getCompte().getLogin()==""||uc.getCompte().getPassword().length()<6) {
					mv.addObject("message",
							"Certains champs manquent des informations ou password > 6");
				} else {
					utilisateurService.updateUtilisateuretCompte(uc,(Utilisateur) map.get("utilisateur"));
					mv.addObject("message", "Inscription reussi");
				}
			} catch (Exception e) {
				mv.addObject("message", "Certains champs manquent des informations - error");
			}
			mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
			mv.addObject("action","/Covoso/utilisateurcompteupdate/"+utilisateurId);
			mv.addObject("uc", new UtilisateuretCompte());
			return mv;
		}
	// 5. Ajoute des nouveaux annonces
	@RequestMapping("/ajouteannonce")
	public ModelAndView ajouteannoncePage(ModelMap map) {
		if (map.get("utilisateur") != null) {
			ModelAndView mv = new ModelAndView("ajouteannonce");
			mv.addObject("recherchebox", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.AvantLogin("accueil"));
			mv.addObject("an", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("listVoiture", voitureService.all());
			return mv;
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(value = "/ajouteannonce", method = RequestMethod.POST)
	public ModelAndView ajouteannonce(@ModelAttribute("an") Annonce an,
			BindingResult result, ModelMap map) {
		ModelAndView mv = new ModelAndView("ajouteannonce");
		AnnonceValidator ucValid = new AnnonceValidator();
		ucValid.validate(an, result);
		if (result.hasErrors()) {
			mv.addObject("message", "Certains champs manquent des informations");
		} else {
			an.setDateCreate(new Date());
			Utilisateur uti = (Utilisateur) map.get("utilisateur");
			an.setUtilisateurID(uti.getUtilisateurID());
			annonceService.createAnnonce(an);
			mv.addObject("message", "Inscription reussi");
		}
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject("menu", MenuBuild.AvantLogin("accueil"));
		mv.addObject("an", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject("listVoiture", voitureService.all());
		mv.addObject("listHeure", CovosoUtils.HeureDepartDefault());

		return mv;
	}

	// 6. Liste des annonces nouveaux
	@RequestMapping("/vosannonces")
	public ModelAndView annoncelist(ModelMap map) {
		ModelAndView mv = new ModelAndView("vosannonces");
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
		alist.getNav().setRowCount(
				annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map
						.get("utilisateur")));

		alist.getNav().setCurrentPage(1);
		alist.setEntities(annonceService.listAnnonceFindbyUtilisateur(
				(Utilisateur) map.get("utilisateur"), alist.getNav()
						.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject("menu", MenuBuild.ApresLogin("vos annonces"));
		return mv;
	}

	@RequestMapping("/vosannonces/{index}")
	public ModelAndView annoncelist(@PathVariable("index") Integer index,
			ModelMap map) {
		ModelAndView mv = new ModelAndView("vosannonces");
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();

		alist.getNav().setRowCount(
				annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map
						.get("utilisateur")));

		if (index == null || index < 1)
			alist.getNav().setCurrentPage(1);
		else
			alist.getNav().setCurrentPage(index);

		alist.setEntities(annonceService.listAnnonceFindbyUtilisateur(
				(Utilisateur) map.get("utilisateur"), alist.getNav()
						.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject("menu", MenuBuild.ApresLogin("vos annonces"));
		return mv;
	}

	// 7. Modifier compte
	@RequestMapping("/votrecompte")
	public ModelAndView votrecompte(ModelMap map) {
		if (map.get("utilisateur") != null) {
			ModelAndView mv = new ModelAndView("votrecompte");
			UtilisateuretCompte uc = new UtilisateuretCompte();
			uc.setCompte((Compte) map.get("compte"));
			uc.setUtilisateur((Utilisateur) map.get("utilisateur"));
			mv.addObject("uc", uc);
			mv.addObject("listVoiture", voitureService.find(((Utilisateur) map
					.get("utilisateur")).getUtilisateurID()));
			mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
			return mv;
		} else
			return new ModelAndView("redirect:/");
	}

	// 8 Utilisateur inscrit un covoiturage
	@RequestMapping("/uinscription/{annonceID}")
	public ModelAndView utilisateurInscriptionePage(
			@PathVariable("annonceID") Long annonceID, ModelMap map) {
		if (map.get("utilisateur") != null) {
			ModelAndView mv = new ModelAndView("uinscription");
			Inscription ins = new Inscription();
			ins.setAnnonceID(annonceID);
			ins.setUtilisateurID((Integer) map.get("utilisateurID"));
			mv.addObject("inscription", ins);
			Annonce annonce = annonceService.singleAnnonce(annonceID);
			Utilisateur auteurs = utilisateurService.single(annonce
					.getUtilisateurID());
			Ville depart = annonceService.singleVille(annonce.getVilleDepart());
			Ville arrivee = annonceService.singleVille(annonce
					.getVilleArrivee());
			Voiture voiture = voitureService.single(annonce.getVoitureID());
			mv.addObject("utilisateurAuteur", auteurs);
			mv.addObject("annonce", annonce);
			mv.addObject("villeArrivee", arrivee);
			mv.addObject("villeDepart", depart);
			voiture.setNom(voiture.getType()+ " " +voiture.getNombrePlace());
			mv.addObject("voiture", voiture);

			mv.addObject("action", "/Covoso/uinscription/" + annonceID);
			mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
			Utilisateur user = (Utilisateur) map.get("utilisateur");
			if (user.getUtilisateurID() == annonce.getUtilisateurID()) {
				mv.addObject("viewinscription", null);
				mv.addObject("annoncelis", annonceService.findbyAnnonce(annonceID));
			} else
				mv.addObject("viewinscription", "true");
			return mv;
		} else
			return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/uinscription/{annonceID}", method = RequestMethod.POST)
	public ModelAndView utilisateurInscriptione(
			@ModelAttribute("inscription") Inscription an,
			@PathVariable("annonceID") Long annonceID, ModelMap map) {
		if (map.get("utilisateur") != null) {
			ModelAndView mv = new ModelAndView("uinscription");
			Annonce annonce = annonceService.singleAnnonce(annonceID);
			Inscription ins = new Inscription();
			ins.setAnnonceID(annonceID);
			Utilisateur user = (Utilisateur)map.get("utilisateur");
			try{
			ins.setUtilisateurID(user.getUtilisateurID());
			ins.setDateInscription(new Date());
			ins.setConfirmer(0);

			ins.setNombrePlace(an.getNombrePlace());
			List<Inscription> listI= annonceService.findbyAnnonce(annonceID);
			int totalnombre=0;
			for (Inscription inscription : listI) {
				totalnombre += inscription.getNombrePlace();
			}
			int restplace = annonce.getNombrePlace()-totalnombre;
			if (ins.getNombrePlace() < 0
					|| ins.getNombrePlace() > restplace) {
				mv.addObject("message", "Impossible le nombre place est dépassé. Nombre disponible: "+restplace);
			} else if (annonceService.hasInscription(annonceID,
					ins.getUtilisateurID())) {
				mv.addObject("message",
						"Vous etes deja inscrit pour cette covoiturage");
			} else {
				
				annonceService.createInscription(ins);
				mv.addObject("message", "Inscription de covoiturage reussi");
			}
		}catch(Exception e){
			mv.addObject("message", "Impossible le nombre place");
		}
			mv.addObject("inscription", ins);
			Utilisateur auteurs = utilisateurService.single(annonce
					.getUtilisateurID());
			Ville depart = annonceService.singleVille(annonce.getVilleDepart());
			Ville arrivee = annonceService.singleVille(annonce
					.getVilleArrivee());
			Voiture voiture = voitureService.single(annonce.getVoitureID());
			mv.addObject("utilisateurAuteur", auteurs);
			mv.addObject("annonce", annonce);
			mv.addObject("villeArrivee", arrivee);
			mv.addObject("villeDepart", depart);
			mv.addObject("voiture", voiture);
			mv.addObject("action", "/Covoso/uinscription/" + annonceID);
			mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
			//Utilisateur user = (Utilisateur) map.get("utilisateur");
			if (user.getUtilisateurID() == annonce.getUtilisateurID()) {
				mv.addObject("viewinscription", null);
				mv.addObject("annoncelis", annonceService.findbyAnnonce(annonceID));
			} else
				mv.addObject("viewinscription", "true");
			return mv;
		} else
			return new ModelAndView("redirect:/login");
	}

	//
	@RequestMapping("/voitureinsert")
	public ModelAndView voitureInsert() {
		return this.mvVoitreInsert(null, new Voiture(), "Mis à jour d'Voiture",
				"/Covoso/voitureinsert");
	}

	@RequestMapping(value = "/voitureinsert", method = RequestMethod.POST)
	public ModelAndView voitureInsert(@ModelAttribute("voiture") Voiture voi,
			BindingResult result, ModelMap map) {
		String message = "";
		Voiture re;

		try {
			VoitureValidator voiValidator = new VoitureValidator();
			voiValidator.validate(voi, result);

			if (result.hasErrors()) {
				message = "Les données incorrectes";
				re = new Voiture();
			} else {
				Utilisateur user = (Utilisateur) map.get("utilisateur");
				voi.setUtilisateurID(user.getUtilisateurID());
				voitureService.create(voi);

				message = "L'insertion réussi";
				re = voi;
			}
		} catch (Exception e) {
			message = "Les données incorrectes";
			re = new Voiture();

		}
		return this.mvVoitreInsert(message, re, "Ajoute de Voiture",
				"/Covoso/voitureinsert");
	}

	@RequestMapping("/voitureupdate/{voitureId}")
	public ModelAndView voitureUpdate(
			@PathVariable("voitureId") Long voitureId) {
		Voiture voi = voitureService.single(voitureId);
		
		return this.mvVoitreUpdate(null, voi==null?new Voiture():voi,
				"Mis à jour d'Voiture", "/Covoso/voitureupdate/" + voitureId);
	}

	@RequestMapping(value = "/voitureupdate/{voitureId}", method = RequestMethod.POST)
	public ModelAndView voitureUpdatePage(
			@PathVariable("voitureId") Long voitureId,
			@ModelAttribute("voiture") Voiture voi, BindingResult result,ModelMap map) {
		VoitureValidator voiValidator = new VoitureValidator();
		voiValidator.validate(voi, result);
		String message = "";
		Voiture re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Voiture();
		} else {
			Voiture nu = voitureService.single(voitureId);
			nu.setType(voi.getType());
			nu.setNombrePlace(voi.getNombrePlace());
			Utilisateur user = (Utilisateur) map.get("utilisateur");
			voi.setUtilisateurID(user.getUtilisateurID());
			voitureService.update(nu);
			message = "Le mis a jour réussi";
			re = voi;
		}
		return this.mvVoitreInsert(message, new Voiture(), "Ajoute de Voiture",
				"/Covoso/voitureinsert");
	}

	// la procedure commun
	public ModelAndView mvVoitreUpdate(String message, Voiture voi,
			String title, String action) {
		ModelAndView mv = new ModelAndView("voitureupdate");
		mv.addObject("voiture", voi);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		mv.addObject("menu", MenuBuild.ApresLogin("a propos nous"));
		return mv;
	}

	public ModelAndView mvVoitreInsert(String message, Voiture voi,
			String title, String action) {
		ModelAndView mv = new ModelAndView("voitureinsert");
		mv.addObject("voiture", voi);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		mv.addObject("menu", MenuBuild.ApresLogin("a propos nous"));
		return mv;
	}


*/
}
