package net.gp.gestade.controller;

import java.util.Date;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.EquipmentValidator;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.service.StadeService;
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
@RequestMapping("/stade")
public class StadeController {
	@Autowired
	private StadeService sService;
/*
	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Ville(), "Ajoute de Ville",
				"/Covoso/ville/add");
	}

	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("ville/index");
		mv.addObject("ville", new Ville());
		mv.addObject("message", null);
		mv.addObject("title", "Ajoute de Ville");
		mv.addObject("action", "/Covoso/ville/add");
		PagedGenericView<Ville> ulist = new PagedGenericView<Ville>();

		ulist.getNav().setRowCount(villeService.countVille());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(villeService.allVille(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("ville") Ville ville,
			BindingResult result) {
		VilleValidator userValidator = new VilleValidator();
		userValidator.validate(ville, result);
		String message = "";
		Ville re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Ville();
		} else {
			villeService.createVille(ville);
			message = "L'insertion réussi";
			re = ville;
		}
		return this.mvIndex(message, re, "Ajoute de Ville",
				"/Covoso/ville/add");
	}

	@RequestMapping("/edit/{villeId}")
	public ModelAndView edit(
			@PathVariable("villeId") Long villeId) {
		return this.mvIndex(null, villeService.singleVille(villeId),
				"Mis à jour de ville", "/Covoso/ville/edit/"
						+ villeId);
	}

	@RequestMapping(value = "/edit/{villeId}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("villeId") Long villeId,
			@ModelAttribute("ville") Ville ville,
			BindingResult result) {
		VilleValidator villeValidator = new VilleValidator();
		villeValidator.validate(ville, result);
		String message = "";
		Ville re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Ville();
		} else {
			Ville nu = villeService.singleVille(villeId);
			nu.setNom(ville.getNom());
			villeService.updateVille(nu);
			message = "Le mis a jour réussi";
			re = ville;
		}
		return this.mvIndex(message, new Ville(), "Ajoute de Ville",
				"/Covoso/ville/add");
	}
	@RequestMapping("/delete/{villeId}")
	public ModelAndView delete(
			@PathVariable("villeId") Long villeId) {

		villeService.removeVille(villeId);
		return this.mvIndex("La supression reussi", new Ville(),
				"Ajoute de Ville", "/Covoso/ville/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
 Ville ville, String title,
			String action) {
		ModelAndView mv = new ModelAndView("ville/index");
		mv.addObject("ville", ville);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Ville> ulist = new PagedGenericView<Ville>();
		ulist.getNav().setRowCount(villeService.countVille());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(villeService.allVille(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Annonce"));
		return mv;
	}
	*/
}

