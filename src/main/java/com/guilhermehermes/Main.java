package com.guilhermehermes;

import com.guilhermehermes.entities.PaymentInfo;
import com.guilhermehermes.utils.BancoInterFactory;
import com.guilhermehermes.utils.BancoSantanderFactory;
import com.guilhermehermes.utils.PaymentProcessorFactory;

public class Main {
    public static void main(String[] args) {
        PaymentProcessorFactory[] factories = {
                new BancoInterFactory(),
                new BancoSantanderFactory(),
        };

        PaymentInfo payment = new PaymentInfo("1234567890123456", 100.0);

        for (PaymentProcessorFactory factory : factories) {
            System.out.println("\n=== Processando com " + factory.getClass().getSimpleName() + " ===");
            PaymentSystem paymentSystem = new PaymentSystem(factory);
            paymentSystem.processPaymentWithNotification(payment);
        }

    }
}