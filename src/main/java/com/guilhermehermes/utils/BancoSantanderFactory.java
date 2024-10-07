package com.guilhermehermes.utils;

import com.guilhermehermes.service.*;

public class BancoSantanderFactory implements PaymentProcessorFactory {

    @Override
    public PaymentService createPaymentService() {
        PaymentService realservice = new BancoSantanderPaymentService();
        PaymentServiceProxy serviceProxy = new PaymentServiceProxy(realservice);
        return (PaymentService) PaymentDynamicProxy.createProxy(serviceProxy);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoSantanderEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }


}
