package com.guilhermehermes.utils;

import com.guilhermehermes.annotations.Load;
import com.guilhermehermes.annotations.Transaction;
import com.guilhermehermes.entities.PaymentInfo;
import com.guilhermehermes.service.PaymentService;

import java.lang.reflect.Method;
import java.util.List;

public class PaymentServiceProxy implements PaymentService {

    private PaymentService service;
    private List<PaymentInfo> paymentInfoListCache;


    public PaymentServiceProxy(PaymentService paymentService){
        this.service = paymentService;
    }

    @Override
    public List<PaymentInfo> LoadPaymentInfos( ) {
        Method method;
        try {
            method = service.getClass().getMethod("LoadPaymentInfos");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        // Verifica se o método tem a annotation Load
        if (method.isAnnotationPresent(Load.class)) {
            System.out.println("Carregando dados de pagamento...");
            List<PaymentInfo> result = service.LoadPaymentInfos();
            System.out.println("Carregamento de dados finalizado!");
            return result;
        }

        return paymentInfoListCache;
    }


    @Override
    public PaymentInfo findPaymentInfo(String cardNumber) {
        return service.findPaymentInfo(cardNumber);
    }

    @Override
    public boolean processPayment(PaymentInfo paymentInfo) {
        Method method;
        try {
            method = service.getClass().getMethod("LoadPaymentInfos");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        if (method.isAnnotationPresent(Transaction.class)) {
            System.out.println("Iniciando transação para LoadPaymentInfos");
            try {
                boolean result = service.processPayment(paymentInfo);
                System.out.println("Finalizando transação para LoadPaymentInfos");
                return result;
            } catch (Exception e) {
                System.out.println("Erro na transação de LoadPaymentInfos: " + e.getMessage());
                throw e;
            }
        }

        return service.processPayment(paymentInfo);
    }

    @Override
    public void refundPayment(PaymentInfo paymentInfo) {
        Method method;
        try {
            method = service.getClass().getMethod("LoadPaymentInfos");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        if (method.isAnnotationPresent(Transaction.class)) {
            System.out.println("Iniciando transação para LoadPaymentInfos");
            try {
                service.refundPayment(paymentInfo);
                System.out.println("Finalizando transação para LoadPaymentInfos");
            } catch (Exception e) {
                System.out.println("Erro na transação de LoadPaymentInfos: " + e.getMessage());
                throw e;
            }
        }

    }
}
