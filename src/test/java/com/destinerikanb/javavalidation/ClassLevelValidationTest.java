package com.destinerikanb.javavalidation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest{

    @Test
    void TestClassLevel() {

        Register register = new Register();
        register.setUsername("destin");
        register.setPassword("rahasia");
        register.setRetypePassword("rahasia");

        validate(register);
    }
}
