package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest{

    @Test
    void testCrossParameter() throws NoSuchMethodException {
        UserService userService = new UserService();
        Class<? extends UserService> userServiceClass = UserService.class; //userService.getClass() juga bisa
        Method register = userServiceClass.getMethod("register", String.class, String.class, String.class);

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(
                userService, register, new Object[]{
                        "", "password", "password1"
                });

        for(ConstraintViolation<UserService> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============================");
        }
    }
}
