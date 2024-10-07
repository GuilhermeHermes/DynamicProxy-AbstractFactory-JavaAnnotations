package com.guilhermehermes.service;

import com.guilhermehermes.entities.PaymentInfo;

import java.util.List;

public interface PaymentService {

    List<PaymentInfo> LoadPaymentInfos();

    PaymentInfo findPaymentInfo(String cardNumber);

    boolean processPayment(PaymentInfo paymentInfo);

    void refundPayment(PaymentInfo paymentInfo);


}
