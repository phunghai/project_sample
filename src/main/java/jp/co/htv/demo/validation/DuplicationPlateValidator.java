package jp.co.htv.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.htv.demo.utils.Constants;
import jp.co.htv.demo.utils.ValidationUtils;

/**
 * Custom check plate duplicate.
 * @author hainp
 *
 */
public class DuplicationPlateValidator implements ConstraintValidator<DuplicationPlateCheck, String> {
 
    @Override
    public void initialize(DuplicationPlateCheck plateNumber) {
    }
 
    @Override
    public boolean isValid(String plateField, ConstraintValidatorContext cxt) {
        String[] platesArray = plateField.split(Constants.NEW_LINE);
        boolean isInvalid = ValidationUtils.checkForDuplicates(platesArray);
        
        return !isInvalid;
    }
 
}
