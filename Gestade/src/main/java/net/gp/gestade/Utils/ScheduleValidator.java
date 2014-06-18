package net.gp.gestade.Utils;

import net.gp.gestade.form.Schedule;
import net.gp.gestade.service.AccountService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ScheduleValidator implements Validator {

	public boolean supports(Class clazz) {
		return Schedule.class.equals(clazz);
	}

	AccountService cService;
	public void validate(Object target, Errors errors) {
		Schedule entity = (Schedule) target;

		if (entity.getDateOrder() == null) {
			errors.rejectValue("Date Order", "*");
			
		}
		if (entity.getFromHour() == null) {
			errors.rejectValue("From Hour", "*");
		}
		if (entity.getToHour() == null) {
			errors.rejectValue("To Hour", "*");
		}
	}

}
