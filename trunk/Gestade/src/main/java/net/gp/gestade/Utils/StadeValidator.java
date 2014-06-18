package net.gp.gestade.Utils;

import net.gp.gestade.form.Stade;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StadeValidator implements Validator {

	public boolean supports(Class clazz) {
		return Stade.class.equals(clazz);
	}


	public void validate(Object target, Errors errors) {
		Stade entity = (Stade) target;

		if (entity.getName() == "") {
			errors.rejectValue("Name", "*");
		}
	}
}
