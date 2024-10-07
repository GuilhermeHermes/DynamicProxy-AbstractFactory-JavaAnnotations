package com.guilhermehermes.utils;

import com.guilhermehermes.service.*;
import com.guilhermehermes.utils.enums.ProxyStrategy;

public class BancoSantanderFactory implements PaymentProcessorFactory {

    ProxyStrategy proxyStrategy;

    @Override
    public void setProxyStrategy(ProxyStrategy proxyStrategy) {
        this.proxyStrategy = proxyStrategy;
    }

    @Override
    public PaymentService createPaymentService() {
        if (proxyStrategy == ProxyStrategy.NONE) {
            return new BancoSantanderPaymentService();
        } else if (proxyStrategy == ProxyStrategy.DYNAMIC) {
            PaymentService realservice = new BancoSantanderPaymentService();
            return (PaymentService) PaymentDynamicProxy.createProxy(realservice);
        }
        PaymentService realservice = new BancoSantanderPaymentService();
        return new PaymentServiceProxy(realservice);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoSantanderEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }


}
