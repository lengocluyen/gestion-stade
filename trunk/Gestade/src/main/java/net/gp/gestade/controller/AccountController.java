package net.gp.gestade.controller;

import javax.servlet.http.HttpSession;

import net.gp.gestade.Utils.MenuBuild;
import net.gp.gestade.Utils.PagedGenericView;
import net.gp.gestade.Utils.AccountValidator;
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

	@RequestMapping("/index")
	public ModelAndView Index(HttpSession session) {
		return this.mvIndex(null, new Account(), null,
				"/Gestade/account/add",session);
	}
	@RequestMapping("/add")
	public ModelAndView Add(HttpSession session) {
		return this.mvIndex(null, new Account(), null,
				"/Gestade/account/add",session);
	}
	
	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index,HttpSession session) {
		ModelAndView mv = new ModelAndView("account/index");
		mv.addObject("account", new Account());
		mv.addObject("message", null);
		mv.addObject("title", "Add Account");
		mv.addObject("action", "/Gestade/account/add");
		PagedGenericView<Account> ulist = new PagedGenericView<Account>();

		ulist.getNav().setRowCount(aService.count());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(aService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("barpath","Page de Gestion de Compte");
		mv.addObject("admenu", MenuBuild.getAdminMenu("Compte",session));
		
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("account") Account account,
			BindingResult result,HttpSession session) {
		AccountValidator accountValidator = new AccountValidator();
		accountValidator.validate(account, result);
		String message = "";
		Account re;
		if (result.hasErrors()) {
			message = "Invalid Data";
			re = new Account();
		} else {
			aService.add(account);
			message = "Suc";
			re = account;
		}
		return this.mvIndex(message, re, "Add Account",
				"/Gestade/account/add",session);
	}

	@RequestMapping("/edit/{accountID}")
	public ModelAndView edit(
			@PathVariable("accountID") Integer accountID,HttpSession session) {
		return this.mvIndex(null, aService.single(accountID),
				"Update Account", "/Gestade/account/edit/"
						+ accountID,session);
	}

	@RequestMapping(value = "/edit/{accountID}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("accountID") Integer accountID,
			@ModelAttribute("account") Account account,
			BindingResult result,HttpSession session) {
		AccountValidator accountValidator = new AccountValidator();
		accountValidator.validate(account, result);
		String message = "";
		Account re;
		if (result.hasErrors()) {
			message = "Invalid data";
			re = new Account();
		} else {
			Account nu = aService.single(accountID);
			nu.setFullname(account.getFullname());
			if(account.getPassword()!="")
			nu.setPassword(account.getPassword());
			nu.setPhonenumber(account.getPhonenumber());
			nu.setUsername(account.getUsername());
			aService.update(nu);
			message = "Successful update";
			re = account;
		}
		return this.mvIndex(message, new Account(), "Add Account",
				"/Gestade/account/add",session);
	}
	@RequestMapping("/delete/{accountID}")
	public ModelAndView delete(
			@PathVariable("accountID") Integer accountID,HttpSession session) {

		aService.remove(accountID);
		return this.mvIndex("Successful add", new Account(),
				"Add Account", "/Gestade/account/add",session);
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
			Account account, String title,
			String action,HttpSession session) {
		ModelAndView mv = new ModelAndView("account/index");
		mv.addObject("account", account);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		PagedGenericView<Account> ulist = new PagedGenericView<Account>();
		ulist.getNav().setRowCount(aService.count());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(aService.all(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("barpath","Page de Gestion de Compte");
		mv.addObject("admenu", MenuBuild.getAdminMenu("Compte",session));
		return mv;
	}
}

