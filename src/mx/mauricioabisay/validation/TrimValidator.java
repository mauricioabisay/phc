package mx.mauricioabisay.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrimValidator implements ConstraintValidator<Trim, CharSequence> {
    @Override
    public void initialize(Trim annotation) {

    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
    	if(value.equals("") || value == null)
    		return true;
    	if(value instanceof String)
            return ((String) value).trim().length() > 0;
        return value.toString().trim().length() > 0;
    }
}
