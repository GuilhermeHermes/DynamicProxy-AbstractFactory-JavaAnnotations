package com.guilhermehermes.utils;

import com.guilhermehermes.service.*;

public class BancoInterFactory implements PaymentProcessorFactory{

    @Override
    public PaymentService createPaymentService() {
        PaymentService realservice = new BancoInterPaymentService();
        PaymentServiceProxy serviceProxy = new PaymentServiceProxy(realservice);
        return (PaymentService) PaymentDynamicProxy.createProxy(serviceProxy);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoInterEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }
}
