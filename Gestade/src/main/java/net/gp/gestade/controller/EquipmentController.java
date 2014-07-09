package net.gp.gestade.controller;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.EquipmentValidator;
import net.gp.gestade.form.Equipment;
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

	@RequestMapping("/index")
	public ModelAndView Index(HttpSession session) {
		return this.mvIndex(null, new Equipment(), "Adds equipment",
				"/Gestade/equipment/add",session);
	}
	@RequestMapping("/add")
	public ModelAndView Add(HttpSession session) {
		return this.mvIndex(null, new Equipment(), "Adds equipment",
				"/Gestade/equipment/add",session);
	}
	
	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index,HttpSession session) {
		ModelAndView mv = new ModelAndView("equipment/index");
		mv.addObject("equipment", new Equipment());
		mv.addObject("message", null);
		mv.addObject("title", "Adds equipment");
		mv.addObject("action", "/Gestade/equipment/add");
		PagedGenericView<Equipment> ulist = new PagedGenericView<Equipment>();

		ulist.getNav().setRowCount(eService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(eService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("barpath","Page de Gestion d'equipment");
		mv.addObject("admenu", MenuBuild.getAdminMenu("equipment",session));
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("equipment") Equipment equipment,
			BindingResult result,HttpSession session) {
		EquipmentValidator equipmentValidator = new EquipmentValidator();
		equipmentValidator.validate(equipment, result);
		String message = "";
		Equipment re;
		if (result.hasErrors()) {
			message = "Invalid data";
			re = new Equipment();
		} else {
			eService.add(equipment);
			message = "Successful add";
			re = equipment;
		}
		return this.mvIndex(message, re, null,
				"/Gestade/equipment/add",session);
	}

	@RequestMapping("/edit/{equipmentID}")
	public ModelAndView edit(
			@PathVariable("equipmentID") Integer equipmentID,HttpSession session) {
		return this.mvIndex(null, eService.single(equipmentID),
				"Update equipment", "/Gestade/equipment/edit/"
						+ equipmentID,session);
	}

	@RequestMapping(value = "/edit/{equipmentID}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("equipmentID") Integer equipmentID,
			@ModelAttribute("equipment") Equipment equipment,
			BindingResult result,HttpSession session) {
		EquipmentValidator equipmentValidator = new EquipmentValidator();
		equipmentValidator.validate(equipment, result);
		String message = "";
		Equipment re;
		if (result.hasErrors()) {
			message = "Invalid data";
			re = new Equipment();
		} else {
			Equipment nu = eService.single(equipmentID);
			nu.setName(equipment.getName());
			nu.setQuantity(equipment.getQuantity());
			nu.setUserImport(equipment.getUserImport());
			nu.setDateImport(equipment.getDateImport());
			eService.update(nu);
			message = "Successful update";
			re = equipment;
		}
		return this.mvIndex(message, new Equipment(), null,
				"/Gestade/equipment/add",session);
	}
	@RequestMapping("/delete/{equipmentID}")
	public ModelAndView delete(
			@PathVariable("equipmentID") Integer equipmentID,HttpSession session) {

		eService.remove(equipmentID);
		return this.mvIndex("Succesful delete", new Equipment(),
				null, "/Gestade/equipment/add",session);
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
			Equipment equipment, String title,
			String action,HttpSession session) {
		ModelAndView mv = new ModelAndView("equipment/index");
		mv.addObject("equipment", equipment);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Equipment> ulist = new PagedGenericView<Equipment>();
		ulist.getNav().setRowCount(eService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(eService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("barpath","Page de Gestion d'equipment");
		mv.addObject("admenu", MenuBuild.getAdminMenu("equipment",session));
		return mv;
	}
}

