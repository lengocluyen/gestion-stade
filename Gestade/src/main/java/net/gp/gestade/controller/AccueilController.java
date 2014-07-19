package net.gp.gestade.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.AccountValidator;
import net.gp.gestade.Utils.Utils;
import net.gp.gestade.Utils.LoginValidator;
import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.SessionManage;
import net.gp.gestade.form.Account;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.service.AccountService;
import net.gp.gestade.service.StadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private StadeService stadeService;
	private SessionManage sessionManage;

	@RequestMapping("/")
	public ModelAndView accueil(ModelMap map, HttpSession session) {
		ModelAndView mv = new ModelAndView("accueil");

		mv.addObject("menu", MenuBuild.getMenu("accueil", session));
		return mv;
	}

	
	@RequestMapping("/emploidutempsview")
	public ModelAndView getEmploidutempsView() {
		ModelAndView mv = new ModelAndView("emploidutempsview");
		return mv;
	}
	@RequestMapping("/emploidutemps")
	public ModelAndView getEmploidutemps(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		ModelAndView mv = new ModelAndView("emploidutemps");

		mv.addObject("barpath", "Page d'Emploi du temps");
		mv.addObject("menu", MenuBuild.getMenu("emloidutemps", session));
		return mv;
	}
	
	
	@RequestMapping("/registration")
	public ModelAndView getRegistration(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		ModelAndView mv = new ModelAndView("registration");
		Schedule schedule = new Schedule();
		mv.addObject("schedule", schedule);
		mv.addObject("stadelist", stadeService.all());
		mv.addObject("datelist",Utils.DateInTwoWeek());
		mv.addObject("hourlist", Utils.HoursInDate());
		
		mv.addObject("barpath", "Page d'Inscription de stade");
		mv.addObject("menu", MenuBuild.getMenu("registration", session));
		return mv;
	}
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public ModelAndView getRegistration(@ModelAttribute("shedule") Schedule schedule, ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		ModelAndView mv = new ModelAndView("registration");
	
		
		
		
		
		mv.addObject("schedule", schedule);
		mv.addObject("stade", stadeService.all());
		mv.addObject("barpath", "Page d'Inscription de stade");
		mv.addObject("menu", MenuBuild.getMenu("registration", session));
		return mv;
	}

	// 7. Modifier compte
	@RequestMapping("/votrecompte")
	public ModelAndView votrecompte(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		if (sessionManage.getAccount() != null) {
			ModelAndView mv = new ModelAndView("votrecompte");
			Account account = sessionManage.getAccount();
			mv.addObject("account", account);
			mv.addObject("barpath",
					"Page d'informations personnelles du Compte");
			mv.addObject("menu", MenuBuild.getMenu("votr compte", session));
			return mv;
		} else
			return new ModelAndView("redirect:/");
	}

	// 3. Inscription le nouveau utilisateur
	@RequestMapping("/inscription")
	public ModelAndView getInscription(HttpSession session) {
		ModelAndView mv = new ModelAndView("inscription");
		sessionManage = new SessionManage(session);
		if (sessionManage.getAccount() == null) {
			Account account = new Account();
			mv.addObject("account", account);
			mv.addObject("barpath", "Inscription");
		} else {
			Account account = sessionManage.getAccount();
			mv.addObject("account", account);
			mv.addObject("barpath", "Modification du compte");

		}
		mv.addObject("menu", MenuBuild.getMenu("inscription", session));
		return mv;
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ModelAndView postInscription(
			@ModelAttribute("account") Account account, BindingResult result,
			ModelMap map, HttpSession session) {
		ModelAndView mv = new ModelAndView("inscription");

		try {
			AccountValidator accountValid = new AccountValidator();
			accountValid.validate(account, result);
			if (result.hasErrors()) {
				mv.addObject("message",
						"Certains champs manquent des informations");
			} else {
				sessionManage = new SessionManage(session);
				if (sessionManage.getAccount() == null) {
					account.setDateCreate(Utils.getSimpleDateFormat(Calendar
							.getInstance().getTime()));
					account.setStatus("Active");
					account.setLastLogin(Utils.getSimpleDateFormat(Calendar
							.getInstance().getTime()));
					accountService.add(account);

					mv.addObject("barpath", "Inscription d'un nouveu Compte");
					mv.addObject("message", "Inscription succes");
				} else {
					account.setStatus("Active");
					account.setLastLogin(Utils.getSimpleDateFormat(Calendar
							.getInstance().getTime()));
					accountService.update(account);
					mv.addObject("message", "Modification succes");
					mv.addObject("barpath", "Modification du compte");
				}
			}
		} catch (Exception e) {
			mv.addObject("message", "Certains champs manquent des informations");
		}
		mv.addObject("account", account);
		mv.addObject("menu", MenuBuild.getMenu("inscription", session));
		return mv;
	}

	// 1. Login
	@RequestMapping("/login")
	public ModelAndView login(ModelMap map, HttpSession session) {
		SessionManage sessionManage = new SessionManage(session);
		if (sessionManage.getAccount() == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("account", new Account());
			mv.addObject("barpath", "Login");
			mv.addObject("menu", MenuBuild.getMenu("s'identifier", session));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("accueil");
			mv.addObject("barpath", "Login");
			mv.addObject("menu", MenuBuild.getMenu("s'identifier", session));
			return mv;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("account") Account account,
			BindingResult result, ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		LoginValidator valid = new LoginValidator();
		valid.validate(account, result);
		String message = "";
		Account newacc = new Account();
		ModelAndView mv = new ModelAndView("login");
		if (result.hasErrors()) {
			message = "Les donnees incorrectes";

			mv.addObject("account", account);
			mv.addObject("message", message);
			mv.addObject("menu", MenuBuild.getMenu("s'identifier", session));

			return mv;
		} else {
			newacc = accountService.login(account.getUsername(),
					account.getPassword());
			if (newacc != null) {
				sessionManage.setAccount(newacc);
				sessionManage.setIsLogin(true);
				// account admin?
				if (newacc.getStatus().compareTo("admin") == 0) {
					sessionManage.setIsAdmin(true);
				}
				return new ModelAndView("redirect:/");
			} else {
				message = "Compte n'existe pas";
				mv.addObject("account", account);
				mv.addObject("message", message);
				mv.addObject("menu", MenuBuild.getMenu("s'identifier", session));
				return mv;
			}
		}
	}

	//
	// 2.Logout
	@RequestMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		sessionManage.setAccount(null);
		sessionManage.setIsAdmin(false);
		sessionManage.setIsLogin(false);
		return "redirect:/";
	}

	// Page d'introduction de notre groupe
	@RequestMapping("/aboutus")
	public ModelAndView about(ModelMap map, HttpSession session) {

		ModelAndView mv = new ModelAndView("aboutus");
		mv.addObject("barpath", "À Propos Nous");
		mv.addObject("menu", MenuBuild.getMenu("A propos nous", session));
		return mv;
	}

	/*
	 * 
	 * @Autowired private UtilisateurService utilisateurService;
	 * 
	 * @Autowired private VoitureService voitureService;
	 * 
	 * @Autowired private AnnonceService annonceService;
	 * 
	 * @RequestMapping("/") public ModelAndView accueil(ModelMap map) {
	 * ModelAndView mv = new ModelAndView("accueil");
	 * mv.addObject("recherchebox", new Annonce()); mv.addObject("listVille",
	 * annonceService.allVille()); PagedGenericView<Annonce> alist = new
	 * PagedGenericView<Annonce>();
	 * alist.getNav().setRowCount(annonceService.countAnnonce());
	 * 
	 * alist.getNav().setCurrentPage(1);
	 * alist.setEntities(annonceService.allAnnonce(alist.getNav()
	 * .getCurrentPage(), alist.getNav().getPageSize()));
	 * 
	 * mv.addObject("aList", alist); mv.addObject( "menu",
	 * map.get("utilisateur") == null ? MenuBuild .AvantLogin("accueil") :
	 * MenuBuild .ApresLogin("accueil")); return mv; }
	 * 
	 * @RequestMapping("/accueil/{index}") public ModelAndView
	 * accueil(@PathVariable("index") Integer index, ModelMap map) {
	 * ModelAndView mv = new ModelAndView("accueil");
	 * mv.addObject("recherchebox", new Annonce()); mv.addObject("listVille",
	 * annonceService.allVille()); PagedGenericView<Annonce> alist = new
	 * PagedGenericView<Annonce>();
	 * 
	 * alist.getNav().setRowCount(annonceService.countAnnonce());
	 * 
	 * if (index == null || index < 1) alist.getNav().setCurrentPage(1); else
	 * alist.getNav().setCurrentPage(index);
	 * 
	 * alist.setEntities(annonceService.allAnnonce(alist.getNav()
	 * .getCurrentPage(), alist.getNav().getPageSize()));
	 * 
	 * mv.addObject("aList", alist); mv.addObject( "menu",
	 * map.get("utilisateur") == null ? MenuBuild .AvantLogin("accueil") :
	 * MenuBuild .ApresLogin("accueil")); return mv; }
	 * 
	 * // 4. Recherche des covoiturages
	 * 
	 * @RequestMapping("/recherche") public ModelAndView recherche(ModelMap map)
	 * { ModelAndView mv = new ModelAndView("recherche");
	 * mv.addObject("recherchebox", new Annonce()); mv.addObject("listVille",
	 * annonceService.allVille()); mv.addObject( "menu", map.get("utilisateur")
	 * == null ? MenuBuild .AvantLogin("recherche") : MenuBuild
	 * .ApresLogin("recherche")); return mv; }
	 * 
	 * @RequestMapping(value = "/recherche", method = RequestMethod.POST) public
	 * ModelAndView recherche(@ModelAttribute("recherche") Annonce rc,
	 * BindingResult result, ModelMap map) { ModelAndView mv = new
	 * ModelAndView("recherche"); mv.addObject("result",
	 * annonceService.listAnnonceFindAll(rc));
	 * 
	 * mv.addObject("display", "true"); mv.addObject("recherchebox", rc);
	 * mv.addObject("listVille", annonceService.allVille()); mv.addObject(
	 * "menu", map.get("utilisateur") == null ? MenuBuild
	 * .AvantLogin("recherche") : MenuBuild .ApresLogin("recherche")); return
	 * mv; }
	 * 
	 * // 4. Update utilisateur et compte
	 * 
	 * @RequestMapping("/utilisateurcompteupdate/{utilisateurId}") public
	 * ModelAndView utilisateurcompteupdate(@PathVariable("utilisateurId")
	 * Integer utilisateurId, ModelMap map) { ModelAndView mv = new
	 * ModelAndView("utilisateurcompteupdate"); mv.addObject("menu",
	 * MenuBuild.AvantLogin("inscription")); UtilisateuretCompte uc = new
	 * UtilisateuretCompte(); uc.setUtilisateur((Utilisateur)
	 * map.get("utilisateur"));
	 * uc.setCompte(compteService.findByUtilisateurID(utilisateurId));
	 * mv.addObject("uc", uc);
	 * mv.addObject("action","/Covoso/utilisateurcompteupdate/"+utilisateurId);
	 * mv.addObject("menu", MenuBuild.ApresLogin("votre compte")); return mv; }
	 * 
	 * @RequestMapping(value = "/utilisateurcompteupdate/{utilisateurId}",
	 * method = RequestMethod.POST) public ModelAndView
	 * utilisateurcompteupdate(@PathVariable("utilisateurId") Integer
	 * utilisateurId,
	 * 
	 * @ModelAttribute("uc") UtilisateuretCompte uc, BindingResult result,
	 * ModelMap map) { ModelAndView mv = new
	 * ModelAndView("utilisateurcompteupdate"); try {
	 * //UtilisateuretCompteValidator ucValid = new
	 * UtilisateuretCompteValidator(); //ucValid.validate(uc, result); if
	 * (uc.getUtilisateur
	 * ().getEmail()==""||uc.getUtilisateur().getNom()==""||uc.
	 * getCompte().getLogin()==""||uc.getCompte().getPassword().length()<6) {
	 * mv.addObject("message",
	 * "Certains champs manquent des informations ou password > 6"); } else {
	 * utilisateurService.updateUtilisateuretCompte(uc,(Utilisateur)
	 * map.get("utilisateur")); mv.addObject("message", "Inscription reussi"); }
	 * } catch (Exception e) { mv.addObject("message",
	 * "Certains champs manquent des informations - error"); }
	 * mv.addObject("menu", MenuBuild.ApresLogin("votre compte"));
	 * mv.addObject("action","/Covoso/utilisateurcompteupdate/"+utilisateurId);
	 * mv.addObject("uc", new UtilisateuretCompte()); return mv; } // 5. Ajoute
	 * des nouveaux annonces
	 * 
	 * @RequestMapping("/ajouteannonce") public ModelAndView
	 * ajouteannoncePage(ModelMap map) { if (map.get("utilisateur") != null) {
	 * ModelAndView mv = new ModelAndView("ajouteannonce");
	 * mv.addObject("recherchebox", new Annonce()); mv.addObject("listVille",
	 * annonceService.allVille()); mv.addObject("menu",
	 * MenuBuild.AvantLogin("accueil")); mv.addObject("an", new Annonce());
	 * mv.addObject("listVille", annonceService.allVille());
	 * mv.addObject("listVoiture", voitureService.all()); return mv; } else {
	 * return new ModelAndView("redirect:/login"); } }
	 * 
	 * @RequestMapping(value = "/ajouteannonce", method = RequestMethod.POST)
	 * public ModelAndView ajouteannonce(@ModelAttribute("an") Annonce an,
	 * BindingResult result, ModelMap map) { ModelAndView mv = new
	 * ModelAndView("ajouteannonce"); AnnonceValidator ucValid = new
	 * AnnonceValidator(); ucValid.validate(an, result); if (result.hasErrors())
	 * { mv.addObject("message", "Certains champs manquent des informations"); }
	 * else { an.setDateCreate(new Date()); Utilisateur uti = (Utilisateur)
	 * map.get("utilisateur"); an.setUtilisateurID(uti.getUtilisateurID());
	 * annonceService.createAnnonce(an); mv.addObject("message",
	 * "Inscription reussi"); } mv.addObject("recherchebox", new Annonce());
	 * mv.addObject("listVille", annonceService.allVille());
	 * mv.addObject("menu", MenuBuild.AvantLogin("accueil")); mv.addObject("an",
	 * new Annonce()); mv.addObject("listVille", annonceService.allVille());
	 * mv.addObject("listVoiture", voitureService.all());
	 * mv.addObject("listHeure", CovosoUtils.HeureDepartDefault());
	 * 
	 * return mv; }
	 * 
	 * // 6. Liste des annonces nouveaux
	 * 
	 * @RequestMapping("/vosannonces") public ModelAndView annoncelist(ModelMap
	 * map) { ModelAndView mv = new ModelAndView("vosannonces");
	 * PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
	 * alist.getNav().setRowCount(
	 * annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map
	 * .get("utilisateur")));
	 * 
	 * alist.getNav().setCurrentPage(1);
	 * alist.setEntities(annonceService.listAnnonceFindbyUtilisateur(
	 * (Utilisateur) map.get("utilisateur"), alist.getNav() .getCurrentPage(),
	 * alist.getNav().getPageSize()));
	 * 
	 * mv.addObject("aList", alist); mv.addObject("menu",
	 * MenuBuild.ApresLogin("vos annonces")); return mv; }
	 * 
	 * @RequestMapping("/vosannonces/{index}") public ModelAndView
	 * annoncelist(@PathVariable("index") Integer index, ModelMap map) {
	 * ModelAndView mv = new ModelAndView("vosannonces");
	 * PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
	 * 
	 * alist.getNav().setRowCount(
	 * annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map
	 * .get("utilisateur")));
	 * 
	 * if (index == null || index < 1) alist.getNav().setCurrentPage(1); else
	 * alist.getNav().setCurrentPage(index);
	 * 
	 * alist.setEntities(annonceService.listAnnonceFindbyUtilisateur(
	 * (Utilisateur) map.get("utilisateur"), alist.getNav() .getCurrentPage(),
	 * alist.getNav().getPageSize()));
	 * 
	 * mv.addObject("aList", alist); mv.addObject("menu",
	 * MenuBuild.ApresLogin("vos annonces")); return mv; }
	 * 
	 * /
	 * 
	 * // 8 Utilisateur inscrit un covoiturage
	 * 
	 * @RequestMapping("/uinscription/{annonceID}") public ModelAndView
	 * utilisateurInscriptionePage(
	 * 
	 * @PathVariable("annonceID") Long annonceID, ModelMap map) { if
	 * (map.get("utilisateur") != null) { ModelAndView mv = new
	 * ModelAndView("uinscription"); Inscription ins = new Inscription();
	 * ins.setAnnonceID(annonceID); ins.setUtilisateurID((Integer)
	 * map.get("utilisateurID")); mv.addObject("inscription", ins); Annonce
	 * annonce = annonceService.singleAnnonce(annonceID); Utilisateur auteurs =
	 * utilisateurService.single(annonce .getUtilisateurID()); Ville depart =
	 * annonceService.singleVille(annonce.getVilleDepart()); Ville arrivee =
	 * annonceService.singleVille(annonce .getVilleArrivee()); Voiture voiture =
	 * voitureService.single(annonce.getVoitureID());
	 * mv.addObject("utilisateurAuteur", auteurs); mv.addObject("annonce",
	 * annonce); mv.addObject("villeArrivee", arrivee);
	 * mv.addObject("villeDepart", depart); voiture.setNom(voiture.getType()+
	 * " " +voiture.getNombrePlace()); mv.addObject("voiture", voiture);
	 * 
	 * mv.addObject("action", "/Covoso/uinscription/" + annonceID);
	 * mv.addObject("menu", MenuBuild.ApresLogin("votre compte")); Utilisateur
	 * user = (Utilisateur) map.get("utilisateur"); if (user.getUtilisateurID()
	 * == annonce.getUtilisateurID()) { mv.addObject("viewinscription", null);
	 * mv.addObject("annoncelis", annonceService.findbyAnnonce(annonceID)); }
	 * else mv.addObject("viewinscription", "true"); return mv; } else return
	 * new ModelAndView("redirect:/login"); }
	 * 
	 * @RequestMapping(value = "/uinscription/{annonceID}", method =
	 * RequestMethod.POST) public ModelAndView utilisateurInscriptione(
	 * 
	 * @ModelAttribute("inscription") Inscription an,
	 * 
	 * @PathVariable("annonceID") Long annonceID, ModelMap map) { if
	 * (map.get("utilisateur") != null) { ModelAndView mv = new
	 * ModelAndView("uinscription"); Annonce annonce =
	 * annonceService.singleAnnonce(annonceID); Inscription ins = new
	 * Inscription(); ins.setAnnonceID(annonceID); Utilisateur user =
	 * (Utilisateur)map.get("utilisateur"); try{
	 * ins.setUtilisateurID(user.getUtilisateurID()); ins.setDateInscription(new
	 * Date()); ins.setConfirmer(0);
	 * 
	 * ins.setNombrePlace(an.getNombrePlace()); List<Inscription> listI=
	 * annonceService.findbyAnnonce(annonceID); int totalnombre=0; for
	 * (Inscription inscription : listI) { totalnombre +=
	 * inscription.getNombrePlace(); } int restplace =
	 * annonce.getNombrePlace()-totalnombre; if (ins.getNombrePlace() < 0 ||
	 * ins.getNombrePlace() > restplace) { mv.addObject("message",
	 * "Impossible le nombre place est dépassé. Nombre disponible: "+restplace);
	 * } else if (annonceService.hasInscription(annonceID,
	 * ins.getUtilisateurID())) { mv.addObject("message",
	 * "Vous etes deja inscrit pour cette covoiturage"); } else {
	 * 
	 * annonceService.createInscription(ins); mv.addObject("message",
	 * "Inscription de covoiturage reussi"); } }catch(Exception e){
	 * mv.addObject("message", "Impossible le nombre place"); }
	 * mv.addObject("inscription", ins); Utilisateur auteurs =
	 * utilisateurService.single(annonce .getUtilisateurID()); Ville depart =
	 * annonceService.singleVille(annonce.getVilleDepart()); Ville arrivee =
	 * annonceService.singleVille(annonce .getVilleArrivee()); Voiture voiture =
	 * voitureService.single(annonce.getVoitureID());
	 * mv.addObject("utilisateurAuteur", auteurs); mv.addObject("annonce",
	 * annonce); mv.addObject("villeArrivee", arrivee);
	 * mv.addObject("villeDepart", depart); mv.addObject("voiture", voiture);
	 * mv.addObject("action", "/Covoso/uinscription/" + annonceID);
	 * mv.addObject("menu", MenuBuild.ApresLogin("votre compte")); //Utilisateur
	 * user = (Utilisateur) map.get("utilisateur"); if (user.getUtilisateurID()
	 * == annonce.getUtilisateurID()) { mv.addObject("viewinscription", null);
	 * mv.addObject("annoncelis", annonceService.findbyAnnonce(annonceID)); }
	 * else mv.addObject("viewinscription", "true"); return mv; } else return
	 * new ModelAndView("redirect:/login"); }
	 * 
	 * //
	 * 
	 * @RequestMapping("/voitureinsert") public ModelAndView voitureInsert() {
	 * return this.mvVoitreInsert(null, new Voiture(), "Mis à jour d'Voiture",
	 * "/Covoso/voitureinsert"); }
	 * 
	 * @RequestMapping(value = "/voitureinsert", method = RequestMethod.POST)
	 * public ModelAndView voitureInsert(@ModelAttribute("voiture") Voiture voi,
	 * BindingResult result, ModelMap map) { String message = ""; Voiture re;
	 * 
	 * try { VoitureValidator voiValidator = new VoitureValidator();
	 * voiValidator.validate(voi, result);
	 * 
	 * if (result.hasErrors()) { message = "Les données incorrectes"; re = new
	 * Voiture(); } else { Utilisateur user = (Utilisateur)
	 * map.get("utilisateur"); voi.setUtilisateurID(user.getUtilisateurID());
	 * voitureService.create(voi);
	 * 
	 * message = "L'insertion réussi"; re = voi; } } catch (Exception e) {
	 * message = "Les données incorrectes"; re = new Voiture();
	 * 
	 * } return this.mvVoitreInsert(message, re, "Ajoute de Voiture",
	 * "/Covoso/voitureinsert"); }
	 * 
	 * @RequestMapping("/voitureupdate/{voitureId}") public ModelAndView
	 * voitureUpdate(
	 * 
	 * @PathVariable("voitureId") Long voitureId) { Voiture voi =
	 * voitureService.single(voitureId);
	 * 
	 * return this.mvVoitreUpdate(null, voi==null?new Voiture():voi,
	 * "Mis à jour d'Voiture", "/Covoso/voitureupdate/" + voitureId); }
	 * 
	 * @RequestMapping(value = "/voitureupdate/{voitureId}", method =
	 * RequestMethod.POST) public ModelAndView voitureUpdatePage(
	 * 
	 * @PathVariable("voitureId") Long voitureId,
	 * 
	 * @ModelAttribute("voiture") Voiture voi, BindingResult result,ModelMap
	 * map) { VoitureValidator voiValidator = new VoitureValidator();
	 * voiValidator.validate(voi, result); String message = ""; Voiture re; if
	 * (result.hasErrors()) { message = "Les données incorrectes"; re = new
	 * Voiture(); } else { Voiture nu = voitureService.single(voitureId);
	 * nu.setType(voi.getType()); nu.setNombrePlace(voi.getNombrePlace());
	 * Utilisateur user = (Utilisateur) map.get("utilisateur");
	 * voi.setUtilisateurID(user.getUtilisateurID()); voitureService.update(nu);
	 * message = "Le mis a jour réussi"; re = voi; } return
	 * this.mvVoitreInsert(message, new Voiture(), "Ajoute de Voiture",
	 * "/Covoso/voitureinsert"); }
	 * 
	 * // la procedure commun public ModelAndView mvVoitreUpdate(String message,
	 * Voiture voi, String title, String action) { ModelAndView mv = new
	 * ModelAndView("voitureupdate"); mv.addObject("voiture", voi);
	 * mv.addObject("message", message); mv.addObject("title", title);
	 * mv.addObject("action", action); mv.addObject("menu",
	 * MenuBuild.ApresLogin("a propos nous")); return mv; }
	 * 
	 * public ModelAndView mvVoitreInsert(String message, Voiture voi, String
	 * title, String action) { ModelAndView mv = new
	 * ModelAndView("voitureinsert"); mv.addObject("voiture", voi);
	 * mv.addObject("message", message); mv.addObject("title", title);
	 * mv.addObject("action", action); mv.addObject("menu",
	 * MenuBuild.ApresLogin("a propos nous")); return mv; }
	 */
}
