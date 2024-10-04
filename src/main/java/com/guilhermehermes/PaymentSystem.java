package com.guilhermehermes;

import com.guilhermehermes.entities.PaymentInfo;
import com.guilhermehermes.service.NotificationService;
import com.guilhermehermes.service.PaymentService;
import com.guilhermehermes.utils.PaymentProcessorFactory;

public class PaymentSystem {
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public PaymentSystem(PaymentProcessorFactory factory) {
        this.paymentService = factory.createPaymentService();
        this.notificationService = factory.createNotificationService();
    }

    public void processPaymentWithNotification(PaymentInfo paymentInfo) {
        try {
            boolean success = paymentService.processPayment(paymentInfo);
            if (success) {
                notificationService.sendNotification("Pagamento de R$" +
                        paymentInfo.getAmount() + " processado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro durante o processamento: " + e.getMessage());
            try {
                notificationService.sendNotification("Falha no processamento do pagamento: " +
                        e.getMessage());
            } catch (Exception notifError) {
                System.out.println("Não foi possível enviar notificação de erro: " +
                        notifError.getMessage());
            }
        }
    }
}
