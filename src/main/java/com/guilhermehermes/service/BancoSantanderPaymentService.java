package com.guilhermehermes.service;

import com.guilhermehermes.annotations.Load;
import com.guilhermehermes.annotations.Transaction;
import com.guilhermehermes.entities.PaymentInfo;

import java.util.List;

public class BancoSantanderPaymentService implements PaymentService{


    @Override
    public List<PaymentInfo> LoadPaymentInfos() {
        List<PaymentInfo> paymentInfos = List.of(
                new PaymentInfo("1234 5678 9012 3456", 100.0),
                new PaymentInfo("1234 5678 9012 3456", 200.0),
                new PaymentInfo("1234 5678 9012 3456", 300.0),
                new PaymentInfo("1234 5678 9012 3456", 400.0),
                new PaymentInfo("1234 5678 9012 3456", 500.0)
        );
        return paymentInfos;
    }

    public PaymentInfo findPaymentInfo(String cardNumber) {
        List<PaymentInfo> paymentInfos = LoadPaymentInfos();
        for (PaymentInfo paymentInfo : paymentInfos) {

            if (paymentInfo.getCardNumber().equals(cardNumber)) {
                return paymentInfo;
            }

        }
        return null;
    }

    @Override
    public boolean processPayment(PaymentInfo paymentInfo) {
        System.out.println("SANTANDER: Processing credit card payment");
        System.out.printf("SANTANDER: Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());
        if (Math.random() < 0.3) {
            throw new RuntimeException("Erro no PayPal: Limite excedido");
        }
        return true;
    }


    @Override
    public void refundPayment(PaymentInfo paymentInfo) {
        System.out.println("SANTANDER: Processing credit card payment");
        System.out.printf("SANTANDER: Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());
    }
}
