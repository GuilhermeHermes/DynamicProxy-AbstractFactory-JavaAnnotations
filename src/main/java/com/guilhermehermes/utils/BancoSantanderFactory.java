package com.guilhermehermes.utils;

import com.guilhermehermes.service.*;

public class BancoSantanderFactory implements PaymentProcessorFactory {

    @Override
    public PaymentService createPaymentService() {
        PaymentService realservice = new BancoSantanderPaymentService();
        return (PaymentService) PaymentDynamicProxy.createProxy(realservice);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoSantanderEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }


}
