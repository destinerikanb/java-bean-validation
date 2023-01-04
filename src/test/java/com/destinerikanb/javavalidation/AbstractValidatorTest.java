package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.extractor.DataIntegerValueExtractor;
import com.destinerikanb.javavalidation.extractor.DataValueExtractor;
import com.destinerikanb.javavalidation.extractor.EntriValueExtractorKey;
import com.destinerikanb.javavalidation.extractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;
    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();

        //Validator factory dengan registrasi value extractor
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntriValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    void validate(Object o){
        Set<ConstraintViolation<Object>> violations = validator.validate(o);

        for(ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===================================");
        }
    }

    void validateWithGroups(Object o, Class<?>... groups){
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);

        for(ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===================================");
        }
    }

    void validateWithException(Object o){
        Set<ConstraintViolation<Object>> violations = validator.validate(o);

        //exception
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }
}
