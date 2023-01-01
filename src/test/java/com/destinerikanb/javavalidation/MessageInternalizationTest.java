package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternalizationTest extends AbstractValidatorTest {

    @Test
    void testI18N() {

        //Ganti Locale
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("");
        payment.setAmount(1000L);
        payment.setCreditCard("44421");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {

        Payment payment = new Payment();
        payment.setOrderId("");
        payment.setAmount(1000L);
        payment.setCreditCard("44421");

        //print out message template
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for(ConstraintViolation<Payment> violation : violations){
            //Buat context
            System.out.println(violation.getMessageTemplate());
            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),
                    violation.getInvalidValue(),
                    violation.getRootBeanClass(),
                    violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            //Panggil method interpolate untuk menerjemahkan pesan
            System.out.println(messageInterpolator.interpolate(
                    violation.getMessageTemplate(),
                    context,
                    new Locale("in", "ID")
            ));

            System.out.println("==================================");

        }
    }
}
