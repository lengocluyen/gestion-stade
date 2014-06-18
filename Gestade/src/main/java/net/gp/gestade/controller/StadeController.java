package net.gp.gestade.controller;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.StadeValidator;
import net.gp.gestade.form.Stade;
import net.gp.gestade.service.StadeService;

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

	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Stade(), "Add Stade",
				"/Gestade/stade/add");
	}
	@RequestMapping("/add")
	public ModelAndView Add() {
		return this.mvIndex(null, new Stade(), "Add Stade",
				"/Gestade/stade/add");
	}
	
	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("stade/index");
		mv.addObject("stade", new Stade());
		mv.addObject("message", null);
		mv.addObject("title", "Add Stade");
		mv.addObject("action", "/Gestade/stade/add");
		PagedGenericView<Stade> ulist = new PagedGenericView<Stade>();

		ulist.getNav().setRowCount(sService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(sService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("stade") Stade stade,
			BindingResult result) {
		StadeValidator stadeValidator = new StadeValidator();
		stadeValidator.validate(stade, result);
		String message = "";
		Stade re;
		if (result.hasErrors()) {
			message = "Invalid Data";
			re = new Stade();
		} else {
			sService.add(stade);
			message = "Suc";
			re = stade;
		}
		return this.mvIndex(message, re, "Add Stade",
				"/Gestade/stade/add");
	}

	@RequestMapping("/edit/{stadeID}")
	public ModelAndView edit(
			@PathVariable("stadeID") Integer stadeID) {
		return this.mvIndex(null, sService.single(stadeID),
				"Update Stade", "/Gestade/stade/edit/"
						+ stadeID);
	}

	@RequestMapping(value = "/edit/{stadeID}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("stadeID") Integer stadeID,
			@ModelAttribute("stade") Stade stade,
			BindingResult result) {
		StadeValidator stadeValidator = new StadeValidator();
		stadeValidator.validate(stade, result);
		String message = "";
		Stade re;
		if (result.hasErrors()) {
			message = "Invalid data";
			re = new Stade();
		} else {
			Stade nu = sService.single(stadeID);
			nu.setName(stade.getName());
			nu.setPosition(stade.getPosition());
			nu.setState(stade.getState());
			nu.setType(stade.getType());
			nu.setDescription(stade.getDescription());
			sService.update(nu);
			message = "Successful update";
			re = stade;
		}
		return this.mvIndex(message, new Stade(), "Add Stade",
				"/Gestade/stade/add");
	}
	@RequestMapping("/delete/{stadeID}")
	public ModelAndView delete(
			@PathVariable("stadeID") Integer stadeID) {

		sService.delete(stadeID);
		return this.mvIndex("Successful add", new Stade(),
				"Add Stade", "/Gestade/stade/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
 Stade stade, String title,
			String action) {
		ModelAndView mv = new ModelAndView("stade/index");
		mv.addObject("stade", stade);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Stade> ulist = new PagedGenericView<Stade>();
		ulist.getNav().setRowCount(sService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(sService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Annonce"));
		return mv;
	}
}

