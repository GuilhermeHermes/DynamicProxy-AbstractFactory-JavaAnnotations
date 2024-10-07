package com.guilhermehermes.utils;

import com.guilhermehermes.service.NotificationService;
import com.guilhermehermes.service.PaymentService;
import com.guilhermehermes.utils.enums.ProxyStrategy;

public interface PaymentProcessorFactory {
    void setProxyStrategy(ProxyStrategy proxyStrategy);
    PaymentService createPaymentService();
    NotificationService createNotificationService();
}
