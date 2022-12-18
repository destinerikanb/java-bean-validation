package com.destinerikanb.javavalidation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorPayload implements Payload {

    public void sendEmail(ConstraintViolation<?> violation){
        System.out.println("Send email message error because : " + violation.getMessage());
    }
}
