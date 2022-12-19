package com.destinerikanb.javavalidation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest{

    @Test
    void testFullName() throws NoSuchMethodException {

        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        Method method = person.getClass().getMethod("fullName");

        String returnValue = person.fullName();

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.validateReturnValue(person, method, returnValue);

        for(ConstraintViolation<Person> violation : constraintViolations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void testSayHello() throws NoSuchMethodException {

        Person person = new Person();
        String name = "";

        Method method = person.getClass().getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.validateParameters(person, method, new Object[]{name});

        for(ConstraintViolation<Person> violation : constraintViolations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
        
        
    }
}
