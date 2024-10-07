package com.guilhermehermes.service;

import com.guilhermehermes.annotations.Load;
import com.guilhermehermes.annotations.Transaction;
import com.guilhermehermes.entities.PaymentInfo;

import java.util.ArrayList;
import java.util.List;

public class BancoInterPaymentService implements PaymentService{

    @Load
    public List<PaymentInfo> LoadPaymentInfos() {
        List<PaymentInfo> paymentInfos = new ArrayList<>();
        paymentInfos.add(new PaymentInfo("1234567890123456", 100.00));
        paymentInfos.add(new PaymentInfo("2345678901234567", 200.00));
        paymentInfos.add(new PaymentInfo("3456789012345678", 300.00));
        paymentInfos.add(new PaymentInfo("4567890123456789", 400.00));
        paymentInfos.add(new PaymentInfo("5678901234567890", 500.00));
        paymentInfos.add(new PaymentInfo("6789012345678901", 600.00));
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

    @Transaction
    @Override
    public boolean processPayment(PaymentInfo paymentInfo) {
        System.out.println("INTER:Processing credit card payment");
        System.out.printf("INTER:Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());
        if (Math.random() < 0.3) {
            throw new RuntimeException("Erro no PayPal: Limite excedido");
        }
        return true;
    }

    @Transaction
    @Override
    public void refundPayment(PaymentInfo paymentInfo) {
        System.out.println("INTER:Processing credit card payment");
        System.out.printf("INTER:Payment of %.2f made with card %s%n", paymentInfo.getAmount(), paymentInfo.getCardNumber());

    }
}
