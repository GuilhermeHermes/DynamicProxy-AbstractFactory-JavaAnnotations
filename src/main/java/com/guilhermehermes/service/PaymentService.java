package com.guilhermehermes.service;

import com.guilhermehermes.entities.PaymentInfo;

public interface PaymentService {

    boolean processPayment(PaymentInfo paymentInfo);

    void refundPayment(PaymentInfo paymentInfo);


}
