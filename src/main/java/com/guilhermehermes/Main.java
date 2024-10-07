package com.guilhermehermes;

import com.guilhermehermes.entities.PaymentInfo;
import com.guilhermehermes.utils.BancoInterFactory;
import com.guilhermehermes.utils.BancoSantanderFactory;
import com.guilhermehermes.utils.PaymentProcessorFactory;
import com.guilhermehermes.utils.enums.ProxyStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaymentProcessorFactory[] factories = {
                new BancoInterFactory(),
                new BancoSantanderFactory(),
        };

        List<ProxyStrategy> strategies = List.of(ProxyStrategy.DEFAULT, ProxyStrategy.DYNAMIC, ProxyStrategy.NONE);

        PaymentInfo payment = new PaymentInfo("1234567890123456", 100.0);

        for (PaymentProcessorFactory factory : factories) {
            for (ProxyStrategy strategy : strategies) {
                factory.setProxyStrategy(strategy);
                System.out.println("\n=== Processando com " + factory.getClass().getSimpleName() + " e " + strategy + " ===");
                PaymentSystem paymentSystem = new PaymentSystem(factory);
                paymentSystem.processPaymentWithNotification(payment);
                paymentSystem.refundPaymentWithNotification(payment);
                paymentSystem.getPaymentInfos();
            }
        }

    }
}