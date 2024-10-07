package com.guilhermehermes.utils;

import com.guilhermehermes.service.*;
import com.guilhermehermes.utils.enums.ProxyStrategy;

public class BancoInterFactory implements PaymentProcessorFactory{

    ProxyStrategy proxyStrategy = ProxyStrategy.DEFAULT;

    @Override
    public void setProxyStrategy(ProxyStrategy proxyStrategy) {
        this.proxyStrategy = proxyStrategy;
    }

    @Override
    public PaymentService createPaymentService() {
        if(proxyStrategy == ProxyStrategy.NONE){
            return new BancoInterPaymentService();
        }else if(proxyStrategy == ProxyStrategy.DYNAMIC){
            PaymentService realservice = new BancoInterPaymentService();
            return (PaymentService) PaymentDynamicProxy.createProxy(realservice);
        }
        PaymentService realservice = new BancoInterPaymentService();
        return new PaymentServiceProxy(realservice);
    }

    @Override
    public NotificationService createNotificationService() {
        NotificationService realservice = new BancoInterEmailNotificationService();
        return (NotificationService) PaymentDynamicProxy.createProxy(realservice);
    }
}
