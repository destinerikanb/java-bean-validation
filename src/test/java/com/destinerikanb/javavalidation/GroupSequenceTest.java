package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSequence() {

        Payment payment = new Payment();

        //Seharusnya sudah error di CreditCardGroup
        validateWithGroups(payment, PaymentGroup.class);
    }
}
