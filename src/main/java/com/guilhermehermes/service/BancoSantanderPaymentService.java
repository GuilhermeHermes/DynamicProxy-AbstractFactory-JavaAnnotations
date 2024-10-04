package com.guilhermehermes.service;

import com.guilhermehermes.annotations.Transaction;
import com.guilhermehermes.entities.PaymentInfo;

public class BancoSantanderPaymentService implements PaymentService{


    @Transaction
    @Override
    public boolean processPayment(PaymentInfo paymentInfo) {
        System.out.println("SANTANDER: Processing credit card payment");
        System.out.printf("SANTANDER: Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());
        if (Math.random() < 0.3) {
            throw new RuntimeException("Erro no PayPal: Limite excedido");
        }
        return true;
    }

    @Transaction
    @Override
    public void refundPayment(PaymentInfo paymentInfo) {
        System.out.println("SANTANDER: Processing credit card payment");
        System.out.printf("SANTANDER: Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());
    }
}
