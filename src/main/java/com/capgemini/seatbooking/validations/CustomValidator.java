package com.capgemini.seatbooking.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidation, String> {
    @Override
    public void initialize(CustomValidation constraintAnnotation) {
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    if(value.isEmpty())
		    return false;
	    else
	    	return true;
	}
}