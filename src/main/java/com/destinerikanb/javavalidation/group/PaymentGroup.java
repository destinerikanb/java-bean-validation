package com.destinerikanb.javavalidation.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence(value = {
        Default.class,
        CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class
})
public interface PaymentGroup {
}