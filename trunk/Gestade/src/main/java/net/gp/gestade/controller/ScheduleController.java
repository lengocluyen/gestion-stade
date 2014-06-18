package net.gp.gestade.controller;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.ScheduleValidator;
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

	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Schedule(), "Add Schedule",
				"/Gestade/schedule/add");
	}
	@RequestMapping("/add")
	public ModelAndView Add() {
		return this.mvIndex(null, new Schedule(), "Add Schedule",
				"/Gestade/schedule/add");
	}
	
	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("schedule/index");
		mv.addObject("schedule", new Schedule());
		mv.addObject("message", null);
		mv.addObject("title", "Add Schedule");
		mv.addObject("action", "/Gestade/schedule/add");
		PagedGenericView<Schedule> ulist = new PagedGenericView<Schedule>();

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
	public ModelAndView Add(@ModelAttribute("schedule") Schedule schedule,
			BindingResult result) {
		ScheduleValidator scheduleValidator = new ScheduleValidator();
		scheduleValidator.validate(schedule, result);
		String message = "";
		Schedule re;
		if (result.hasErrors()) {
			message = "Invalid Data";
			re = new Schedule();
		} else {
			sService.add(schedule);
			message = "Suc";
			re = schedule;
		}
		return this.mvIndex(message, re, "Add Schedule",
				"/Gestade/schedule/add");
	}

	@RequestMapping("/edit/{scheduleID}")
	public ModelAndView edit(
			@PathVariable("scheduleID") Integer scheduleID) {
		return this.mvIndex(null, sService.single(scheduleID),
				"Update Schedule", "/Gestade/schedule/edit/"
						+ scheduleID);
	}

	@RequestMapping(value = "/edit/{scheduleID}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("scheduleID") Integer scheduleID,
			@ModelAttribute("schedule") Schedule schedule,
			BindingResult result) {
		ScheduleValidator scheduleValidator = new ScheduleValidator();
		scheduleValidator.validate(schedule, result);
		String message = "";
		Schedule re;
		if (result.hasErrors()) {
			message = "Invalid data";
			re = new Schedule();
		} else {
			Schedule nu = sService.single(scheduleID);
			nu.setDateOrder(schedule.getDateOrder());
			nu.setFromHour(schedule.getFromHour());
			nu.setToHour(schedule.getToHour());
			nu.setPrice(schedule.getPrice());
			nu.setPromotion(schedule.getPromotion());
			nu.setStadeID(schedule.getStadeID());
			nu.setAccountID(schedule.getAccountID());
			nu.setStatus(schedule.getStatus());
			sService.update(nu);
			message = "Successful update";
			re = schedule;
		}
		return this.mvIndex(message, new Schedule(), "Add Schedule",
				"/Gestade/schedule/add");
	}
	@RequestMapping("/delete/{scheduleID}")
	public ModelAndView delete(
			@PathVariable("scheduleID") Integer scheduleID) {

		sService.delete(scheduleID);
		return this.mvIndex("Successful add", new Schedule(),
				"Add Schedule", "/Gestade/schedule/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
 Schedule schedule, String title,
			String action) {
		ModelAndView mv = new ModelAndView("schedule/index");
		mv.addObject("schedule", schedule);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Schedule> ulist = new PagedGenericView<Schedule>();
		ulist.getNav().setRowCount(sService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(sService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Annonce"));
		return mv;
	}
}

