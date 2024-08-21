package dev.arhimedes.makersharks.supplier.utils.validators;

import dev.arhimedes.makersharks.supplier.utils.validators.annotations.EnumPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumPatternValidator implements ConstraintValidator<EnumPattern, String> {
    private EnumPattern annotation;
    @Override
    public void initialize(EnumPattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null) {
            return true;
        }

        Object[] enumValues = this.annotation.enumClass().getEnumConstants();

        for(Object enumValue: enumValues) {
            if(value.equals(enumValue.toString())) {
                return true;
            }
        }

        return false;
    }
}
