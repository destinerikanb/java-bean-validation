package com.destinerikanb.javavalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFailed() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        //Untuk cek bahwa yang gagal memang benar berjumlah 2 yaitu firstname dan lastname
        Assertions.assertEquals(2, constraintViolations.size());

        for(ConstraintViolation<Person> violation : constraintViolations){
            System.out.println("Message :" + violation.getMessage());
            System.out.println("Bean :" + violation.getLeafBean());
            System.out.println("Constraint/Annottaion :" + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value :" + violation.getInvalidValue());
            System.out.println("Path :" + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationFailedSize() {
        Person person = new Person("Destin Erika Nawang Budiarti", "Destin Erika Nawang Budiarti");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        //Untuk cek bahwa yang gagal memang benar berjumlah 2 yaitu firstname dan lastname
        Assertions.assertEquals(2, constraintViolations.size());

        for(ConstraintViolation<Person> violation : constraintViolations){
            System.out.println("Message :" + violation.getMessage());
            System.out.println("Bean :" + violation.getLeafBean());
            System.out.println("Constraint/Annottaion :" + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value :" + violation.getInvalidValue());
            System.out.println("Path :" + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationSuccess() {
        Person person = new Person("Destin", "Budiarti");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        //Untuk cek bahwa semua validasi berhasil, artinya set kosong
        Assertions.assertEquals(0, constraintViolations.size());

    }
}
