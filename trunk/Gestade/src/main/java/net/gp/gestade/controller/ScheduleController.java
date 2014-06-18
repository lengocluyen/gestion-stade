package net.gp.gestade.controller;

import java.util.Date;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.EquipmentValidator;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleService sService;
/*
	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Schedule(), "Ajoute d'Utilisateur",
				"/Covoso/utilisateur/add");
	}

	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("utilisateur/index");
		mv.addObject("utilisateur", new Schedule());
		mv.addObject("message", null);
		mv.addObject("title", "Ajoute d'Utilisateur");
		mv.addObject("action", "/Covoso/utilisateur/add");
		PagedGenericView<Schedule> ulist = new PagedGenericView<Schedule>();

		ulist.getNav().setRowCount(utilisateurService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(utilisateurService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("utilisateur") Schedule user,
			BindingResult result) {
		EquipmentValidator userValidator = new EquipmentValidator();
		userValidator.validate(user, result);
		String message = "";
		Schedule re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Schedule();
		} else {
			user.setDateCreate(new Date());
			user.setDateUpdate(new Date());
			utilisateurService.create(user);
			message = "L'insertion réussi";
			re = user;
		}
		return this.mvIndex(message, re, "Ajoute d'Utilisateur",
				"/Covoso/utilisateur/add");
	}

	@RequestMapping("/edit/{utilisateurId}")
	public ModelAndView edit(
			@PathVariable("utilisateurId") Integer utilisateurId) {
		return this.mvIndex(null, utilisateurService.single(utilisateurId),
				"Mis à jour d'Utilisateur", "/Covoso/utilisateur/edit/"
						+ utilisateurId);
	}

	@RequestMapping(value = "/edit/{utilisateurId}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("utilisateurId") Integer utilisateurId,
			@ModelAttribute("utilisateur") Schedule user,
			BindingResult result) {
		EquipmentValidator userValidator = new EquipmentValidator();
		userValidator.validate(user, result);
		String message = "";
		Schedule re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Schedule();
		} else {
			Schedule nu = utilisateurService.single(utilisateurId);
			nu.setNom(user.getNom());
			nu.setPrenom(user.getPrenom());
			nu.setTelephone(user.getTelephone());
			nu.setEmail(user.getEmail());
			;
			nu.setDateNaissance(user.getDateNaissance());
			nu.setDateUpdate(new Date());
			utilisateurService.update(nu);
			message = "Le mis a jour réussi";
			re = user;
		}
		return this.mvIndex(message, new Schedule(), "Ajoute d'Utilisateur",
				"/Covoso/utilisateur/add");
	}
	@RequestMapping("/delete/{utilisateurId}")
	public ModelAndView delete(
			@PathVariable("utilisateurId") Integer utilisateurId) {

		utilisateurService.remove(utilisateurId);
		return this.mvIndex("La supression reussi", new Schedule(),
				"Ajoute d'Utilisateur", "/Covoso/utilisateur/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
 Schedule user, String title,
			String action) {
		ModelAndView mv = new ModelAndView("utilisateur/index");
		mv.addObject("utilisateur", user);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Schedule> ulist = new PagedGenericView<Schedule>();
		ulist.getNav().setRowCount(utilisateurService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(utilisateurService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Utilisateur"));
		return mv;
	}
	*/
}
