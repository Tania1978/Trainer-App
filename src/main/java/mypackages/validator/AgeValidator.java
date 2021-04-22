/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author tania
 */
public class AgeValidator implements ConstraintValidator<Age, LocalDate> {
    
   protected int minAge;

    @Override
    public void initialize(Age ageValue) {
        this.minAge = ageValue.value();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if ( date == null ) {
            return true;
        }
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(date, today)>=minAge;
    }
}
