package com.guilhermehermes.utils;

import com.guilhermehermes.service.BancoInterEmailNotificationService;
import com.guilhermehermes.service.BancoInterPaymentService;
import com.guilhermehermes.service.NotificationService;
import com.guilhermehermes.service.PaymentService;

public class BancoInterFactory implements PaymentProcessorFactory{

    @Override
    public PaymentService createPaymentService() {
        PaymentService realservice = new BancoInterPaymentService();
        return (PaymentService) PaymentDynamicProxy.createProxy(realservice);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoInterEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }
}
