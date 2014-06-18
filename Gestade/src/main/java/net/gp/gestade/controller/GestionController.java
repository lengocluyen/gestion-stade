package net.gp.gestade.controller;

import net.gp.gestade.Utils.MenuBuild;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/gestion")
public class GestionController {

	@RequestMapping("/accueil")
	public ModelAndView accueil(ModelMap map) {
		ModelAndView mv = new ModelAndView("gestion/accueil");
		mv.addObject("admenu", MenuBuild.AdminLogin("Accueil"));
		return mv;
	}

}
