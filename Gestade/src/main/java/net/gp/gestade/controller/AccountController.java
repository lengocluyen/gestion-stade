package net.gp.gestade.controller;

import net.gp.gestade.Utils.ScheduleValidator;
import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.form.Account;
import net.gp.gestade.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService aService;
/*
	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Account(), "Ajoute de Compte",
				"/Covoso/compte/add");
	}

	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("compte/index");
		mv.addObject("compte", new Account());
		mv.addObject("message", null);
		mv.addObject("title", "Ajoute de Compte");
		mv.addObject("action", "/Covoso/compte/add");
		PagedGenericView<Account> ulist = new PagedGenericView<Account>();

		ulist.getNav().setRowCount(compteService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(compteService.all(ulist.getNav().getCurrentPage(),
				ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("compte") Account entity,
			BindingResult result) {
		ScheduleValidator entityValidator = new ScheduleValidator();
		entityValidator.validate(entity, result);
		String message = "";
		Account re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Account();
		} else {
			compteService.create(entity);
			message = "L'insertion réussi";
			re = entity;
		}
		return this.mvIndex(message, re, "Ajoute d'Compte",
				"/Covoso/compte/add");
	}

	@RequestMapping("/edit/{login}")
	public ModelAndView edit(@PathVariable("login") String login) {
		return this.mvIndex(null, compteService.single(login),
				"Mis à jour d'Compte", "/Covoso/compte/edit/" + login);
	}

	@RequestMapping(value = "/edit/{login}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("login") String login,
			@ModelAttribute("compte") Account entity,
			BindingResult result) {
		ScheduleValidator entityValidator = new ScheduleValidator();
		entityValidator.validate(entity, result);
		String message = "";
		Account re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Account();
		} else {
			Account nu = compteService.single(login);
			nu.setLogin(entity.getLogin());
			nu.setPassword(entity.getPassword());
			nu.setType(entity.getType());
			nu.setAvatar(entity.getAvatar());
			compteService.update(nu);
			message = "Le mis a jour réussi";
			re = entity;
		}
		return this.mvIndex(message, new Account(), "Ajoute de Compte",
				"/Covoso/compte/add");
	}

	@RequestMapping("/delete/{login}")
	public ModelAndView delete(@PathVariable("login") String login) {

		compteService.remove(login);
		return this.mvIndex("La supression reussi", new Account(),
				"Ajoute de Compte", "/Covoso/compte/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message, Account entity, String title,
			String action) {
		ModelAndView mv = new ModelAndView("compte/index");
		mv.addObject("compte", entity);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Account> ulist = new PagedGenericView<Account>();
		ulist.getNav().setRowCount(compteService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(compteService.all(ulist.getNav().getCurrentPage(),
				ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Utilisateur"));
		return mv;
	}
	*/
}
