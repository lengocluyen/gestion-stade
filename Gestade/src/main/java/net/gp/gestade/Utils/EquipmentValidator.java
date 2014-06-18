package net.gp.gestade.Utils;

import net.gp.gestade.form.Equipment;
import net.gp.gestade.form.Schedule;
import net.gp.gestade.service.ScheduleService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EquipmentValidator implements Validator {

	public boolean supports(Class clazz) {
		return Schedule.class.equals(clazz);
	}
	ScheduleService uservice;
	public void validate(Object target, Errors errors) {
		Equipment obj = (Equipment) target;

		if (obj.getName()== null) {
			errors.rejectValue("Name", "*");
		}
		if (obj.getQuantity() == null) {
			errors.rejectValue("Quantity", "*");
		}
	}

}
