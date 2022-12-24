package com.destinerikanb.javavalidation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest{

    @Test
    void testValidateConstructorParameter() throws NoSuchMethodException {

        Person person = new Person();

        //Class reflection
        Class<Person> personClass = Person.class;
        //Get constructor reflection
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        //Perform constructor parameter validation using executableValidator
        //Save result in set of constraint violation
        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{"", "", null});

        for(ConstraintViolation<Person> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("================================");
        }
    }

    @Test
    void testValidateConstructorReturnValue() throws NoSuchMethodException {

        Person person = new Person("", "", new Address());

        //Class reflection
        Class<Person> personClass = Person.class;
        //Get constructor reflection
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        //Perform constructor parameter validation using executableValidator
        //Save result in set of constraint violation
        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructor, person);

        for(ConstraintViolation<Person> violation : violations){
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("================================");
        }
    }
}
