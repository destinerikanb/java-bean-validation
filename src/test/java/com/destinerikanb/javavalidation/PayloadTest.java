package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.CreditCardPaymentGroup;
import com.destinerikanb.javavalidation.payload.EmailErrorPayload;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("0002");
        payment.setAmount(100_000L);
        payment.setCreditCard("4111");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for(ConstraintViolation<Payment> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            //Untuk mendapatkan payload
            //Payload berupa set karena isinya dapat lebih dari satu
            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for(Class<? extends Payload> p : payload){
                if(p == EmailErrorPayload.class){
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("==============================");
        }
    }
}
