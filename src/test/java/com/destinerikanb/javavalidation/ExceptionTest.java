package com.destinerikanb.javavalidation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.Constants;

public class ExceptionTest extends AbstractValidatorTest{

    @Test
    void testException() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });

    }
}
