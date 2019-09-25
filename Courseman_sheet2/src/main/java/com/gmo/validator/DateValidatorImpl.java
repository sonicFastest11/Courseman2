package com.gmo.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidatorImpl implements ConstraintValidator<DateValidator, String> {

	public boolean isValid(String s, ConstraintValidatorContext cvc) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			 df.parse(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}