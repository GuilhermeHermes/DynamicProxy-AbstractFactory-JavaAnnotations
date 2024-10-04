package com.guilhermehermes.utils;

import com.guilhermehermes.service.NotificationService;
import com.guilhermehermes.service.PaymentService;

public interface PaymentProcessorFactory {
    PaymentService createPaymentService();
    NotificationService createNotificationService();
}
