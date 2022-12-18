package com.destinerikanb.javavalidation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void testValidator() {
        //Membuat ValidationFactory
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        //Membuat validator
        Validator validator = validatorFactory.getValidator();

        //Testing : Cek validator tidak null
        Assertions.assertNotNull(validator);

        //Tutup validatorFactory jika sudah tidak digunakan
        validatorFactory.close();
    }
}
