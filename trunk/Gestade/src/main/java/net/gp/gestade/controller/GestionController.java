package net.gp.gestade.controller;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.MenuBuild;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/gestion")
public class GestionController {

	@RequestMapping("/accueil")
	public ModelAndView accueil(ModelMap map,HttpSession session) {
		ModelAndView mv = new ModelAndView("gestion/accueil");
		mv.addObject("barpath","Page d'Administrateur");
		mv.addObject("admenu", MenuBuild.getAdminMenu("accueil",session));
		return mv;
	}

}
