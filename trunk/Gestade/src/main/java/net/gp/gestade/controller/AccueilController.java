package net.gp.gestade.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.AccountValidator;
import net.gp.gestade.Utils.Config;
import net.gp.gestade.Utils.Utils;
import net.gp.gestade.Utils.LoginValidator;
import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.SessionManage;
import net.gp.gestade.form.Account;
import net.gp.gestade.form.EmploiDuTemps;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.form.Stade;
import net.gp.gestade.service.AccountService;
import net.gp.gestade.service.ScheduleService;
import net.gp.gestade.service.StadeService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private StadeService stadeService;
	@Autowired
	private ScheduleService scheduleService;
	private SessionManage sessionManage;

	private List<EmploiDuTemps> emploidutempslatest(Date date) {
		List<EmploiDuTemps> result = new ArrayList<EmploiDuTemps>();
		EmploiDuTemps obj;
		List<Schedule> data = scheduleService.all();
		int i = 0;
		for (Schedule s : data) {
			if (i < 8) {
				obj = new EmploiDuTemps();
				obj.setId(s.getScheduleID());
				obj.setTitle(accountService.single(s.getAccountID())
						.getFullname());

				obj.setBody(s.getTotalTime() + " minutes");

				obj.setStartHour(s.getFromHour());

				obj.setEndHour(s.getToHour());
				
				String[] arDate = s.getDateOrder().split("-");
				int month = Integer.parseInt(arDate[0]) - 1;
				int day = Integer.parseInt(arDate[1]);
				int year = Integer.parseInt(arDate[2]);
				obj.setDaymonth(arDate[0] + "-" + arDate[1]);
				obj.setDay(Integer.toString(day));
				obj.setMonth(Integer.toString(month));
				obj.setYear(Integer.toString(year));
				obj.setReadOnly(false);
				int order = (i+1)%5;
				if(order==0) order=1;
				obj.setImagesrc("/resources/img/blog/"+order+".jpg");
				result.add(obj);
				i++;
			}
		}
		return result;
	}

	@RequestMapping("/")
	public ModelAndView accueil(ModelMap map, HttpSession session) {
		ModelAndView mv = new ModelAndView("accueil");

		mv.addObject("menu", MenuBuild.getMenu("accueil", session));
		mv.addObject("emploidutemps",this.emploidutempslatest(Calendar.getInstance().getTime()));
		return mv;
	}

	@RequestMapping("/emploidutempsview/{stadeID}")
	public ModelAndView getEmploidutempsView(
			@PathVariable("stadeID") Integer stadeID) {

		ModelAndView mv = new ModelAndView("emploidutempsview");

		Stade stade = stadeService.single(stadeID);
		sessionManage.setStade(stade);
		mv.addObject("message", "Emploi du temps de stade " + stade.getName());
		return mv;
	}

	@RequestMapping("/emploidutemps")
	public ModelAndView getEmploidutemps(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		ModelAndView mv = new ModelAndView("emploidutemps");
		mv.addObject("schedule", new Schedule());
		mv.addObject("stadelist", stadeService.all());
		mv.addObject("barpath", "Page d'Emploi du temps");
		mv.addObject("menu", MenuBuild.getMenu("emloidutemps", session));
		return mv;
	}

	@RequestMapping(value = "/emploidutemps", method = RequestMethod.POST)
	public ModelAndView postEmploidutemps(
			@ModelAttribute("shedule") Schedule schedule, ModelMap map,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("emploidutemps");
		mv.addObject("schedule", schedule);
		mv.addObject("linkview",
				"/Gestade/emploidutempsview/" + schedule.getStadeID());
		mv.addObject("stadelist", stadeService.all());
		mv.addObject("barpath", "Page d'Emploi du temps");
		mv.addObject("menu", MenuBuild.getMenu("emloidutemps", session));
		return mv;
	}

	// for ajax
	@RequestMapping(value = "/getemploidutemps", method = RequestMethod.GET)
	public @ResponseBody
	String getemploidutempjson() {

		// sessionManage = new SessionManage(session);
		List<Schedule> data = scheduleService.getByDate(sessionManage
				.getStade().getStadeID());

		List<EmploiDuTemps> result = new ArrayList<EmploiDuTemps>();
		EmploiDuTemps obj;
		JSONObject jdata = new JSONObject();
		for (Schedule s : data) {
			obj = new EmploiDuTemps();
			obj.setId(s.getScheduleID());
			obj.setTitle(accountService.single(s.getAccountID()).getFullname());

			obj.setBody(s.getTotalTime() + " minutes");
			String[] startTime = s.getFromHour().split(":");
			obj.setStartHour(startTime[0]);
			obj.setStartMinute(startTime[1]);

			String[] endTime = s.getToHour().split(":");
			obj.setEndHour(endTime[0]);
			obj.setEndMinute(endTime[1]);

			String[] arDate = s.getDateOrder().split("-");
			int month = Integer.parseInt(arDate[0]) - 1;
			int day = Integer.parseInt(arDate[1]);
			int year = Integer.parseInt(arDate[2]);

			obj.setDay(Integer.toString(day));
			obj.setMonth(Integer.toString(month));
			obj.setYear(Integer.toString(year));
			obj.setReadOnly(false);
			result.add(obj);
		}
		return jdata.put("events", result).toString();
	}

	@RequestMapping(value = "/createemploidutemps", method = RequestMethod.GET)
	public @ResponseBody
	String createEmploiDuTemps(@RequestParam("start") String dateStart,
			@RequestParam("end") String dateEnd, HttpSession session) {
		Schedule schedule = new Schedule();
		sessionManage = new SessionManage(session);
		Date start = Utils.getDateFromString(dateStart);
		Date end = Utils.getDateFromString(dateEnd);
		schedule.setAccountID(sessionManage.getAccount().getAccountID());
		schedule.setDateOrder(Utils.getSimpleDate(start));
		schedule.setFromHour(Utils.getHourtoString(start));
		schedule.setToHour(Utils.getHourtoString(end));
		schedule.setStadeID(sessionManage.getStade().getStadeID());
		schedule.setPrice((Utils.getTime(start, end) * Config.PRIX) + " VND");
		schedule.setPromotion("non");
		String total = String.valueOf(Utils.getTime(start, end));
		schedule.setTotalTime(total);
		if (scheduleService.checkExiste(schedule))
			return "Existe march!";
		else {
			scheduleService.add(schedule);
			return "OK";
		}
	}

	@RequestMapping(value = "/getaccount", method = RequestMethod.GET)
	public @ResponseBody
	String getAccount(HttpSession session) {
		sessionManage = new SessionManage(session);
		if (sessionManage.getAccount() != null)
			return sessionManage.getAccount().getUsername();
		else
			return "";
	}

	@RequestMapping("/registration")
	public ModelAndView getRegistration(ModelMap map, HttpSession session) {
		sessionManage = new SessionManage(session);
		ModelAndView mv = new ModelAndView("registration");
		Schedule schedule = new Schedule();
		mv.addObject("schedule", schedule);
		mv.addObject("stadelist", stadeService.all());
		mv.addObject("datelist", Utils.DateInTwoWeek());
		mv.addObject("hourlist", Utils.HoursInDate());

		mv.addObject("barpath", "Page d'Inscription de stade");
		mv.addObject("menu", MenuBuild.getMenu("registration", session));
		return mv;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView getRegistration(
			@ModelAttribute("shedule") Schedule schedule, ModelMap map,
			HttpSession session) {
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
}
