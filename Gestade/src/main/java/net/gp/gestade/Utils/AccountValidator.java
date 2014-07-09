package net.gp.gestade.Utils;

import net.gp.gestade.form.Account;
import net.gp.gestade.form.Equipment;
import net.gp.gestade.service.StadeService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {

	public boolean supports(Class clazz) {
		return Account.class.equals(clazz);
	}

	StadeService cService;
	public void validate(Object target, Errors errors) {
		Account entity = (Account) target;

		if (entity.getPhonenumber() == null||entity.getPhonenumber()=="") {
			errors.rejectValue("phonenumber", "*");
		}
		
		if (entity.getUsername() == null) {
			errors.rejectValue("username", "*");
		}
		if (entity.getFullname()==null) {
			errors.rejectValue("fullname", "*");
		}
	}

}
