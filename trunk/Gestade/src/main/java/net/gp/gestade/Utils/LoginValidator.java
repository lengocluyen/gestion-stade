package net.gp.gestade.Utils;
import net.gp.gestade.form.Account;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	public boolean supports(Class clazz) {
		return Account.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Account entity = (Account) target;

		if (entity.getUsername() == null) {
			errors.rejectValue("username", "*");
		}
		if (entity.getPassword() == null) {
			errors.rejectValue("password", "*");
		}
	}

}
