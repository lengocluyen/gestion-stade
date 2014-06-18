package net.gp.gestade.controller;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.StadeValidator;
import net.gp.gestade.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired
	private EquipmentService eService;

	/*@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Voiture(), "Ajoute de Voiture",
				"/Covoso/voiture/add");
	}

	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("voiture/index");
		mv.addObject("voiture", new Voiture());
		mv.addObject("message", null);
		mv.addObject("title", "Ajoute de Voiture");
		mv.addObject("action", "/Covoso/voiture/add");
		PagedGenericView<Voiture> ulist = new PagedGenericView<Voiture>();

		ulist.getNav().setRowCount(voitureService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(voitureService.all(ulist.getNav().getCurrentPage(),
				ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("voiture") Voiture voi,
			BindingResult result) {
		StadeValidator voiValidator = new StadeValidator();
		voiValidator.validate(voi, result);
		String message = "";
		Voiture re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Voiture();
		} else {
			voitureService.create(voi);
			message = "L'insertion réussi";
			re = voi;
		}
		return this.mvIndex(message, re, "Ajoute de Voiture",
				"/Covoso/voiture/add");
	}

	@RequestMapping("/edit/{voitureId}")
	public ModelAndView edit(
@PathVariable("voitureId") Long voitureId) {
		return this.mvIndex(null, voitureService.single(voitureId),
				"Mis à jour d'Voiture", "/Covoso/voiture/edit/" + voitureId);
	}

	@RequestMapping(value = "/edit/{voitureId}", method = RequestMethod.POST)
	public ModelAndView editPage(
@PathVariable("voitureId") Long voitureId,
			@ModelAttribute("voiture") Voiture voi,
			BindingResult result) {
		StadeValidator voiValidator = new StadeValidator();
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
			nu.setUtilisateurID(voi.getUtilisateurID());
			voitureService.update(nu);
			message = "Le mis a jour réussi";
			re = voi;
		}
		return this.mvIndex(message, new Voiture(), "Ajoute de Voiture",
				"/Covoso/voiture/add");
	}
	@RequestMapping("/delete/{voitureId}")
	public ModelAndView delete(
@PathVariable("voitureId") Long voitureId) {

		voitureService.remove(voitureId);
		return this.mvIndex("La supression reussi", new Voiture(),
				"Ajoute d'voiture", "/Covoso/voiture/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message, Voiture voi, String title,
			String action) {
		ModelAndView mv = new ModelAndView("voiture/index");
		mv.addObject("voiture", voi);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Voiture> ulist = new PagedGenericView<Voiture>();
		ulist.getNav().setRowCount(voitureService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(voitureService.all(ulist.getNav().getCurrentPage(),
				ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Utilisateur"));
		return mv;
	}
	*/
}
