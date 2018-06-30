package com.deanzhelev.chat.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { PayloadValidator.class })
public @interface IsValidPayload {

    String message() default "Incorrect payload";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
