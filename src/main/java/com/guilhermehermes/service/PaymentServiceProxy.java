package com.guilhermehermes.service;

import com.guilhermehermes.annotations.Load;
import com.guilhermehermes.annotations.Transaction;
import com.guilhermehermes.entities.PaymentInfo;
import com.sun.jdi.Method;

import java.util.List;

public class PaymentServiceProxy implements PaymentService{

    private PaymentService service;
    private List<PaymentInfo> paymentInfoListCache;
    boolean needReset = false;


    public PaymentServiceProxy(PaymentService paymentService){
        this.service = paymentService;
    }

    @Load
    @Override
    public List<PaymentInfo> LoadPaymentInfos( ) {
        System.out.println("Loading payment info from cache");
        if(paymentInfoListCache == null || needReset){
            paymentInfoListCache = service.LoadPaymentInfos();
        }
        return paymentInfoListCache;
    }


    @Override
    public PaymentInfo findPaymentInfo(String cardNumber) {
        return service.findPaymentInfo(cardNumber);
    }

    @Transaction
    @Override
    public boolean processPayment(PaymentInfo paymentInfo) {
        return service.processPayment(paymentInfo);
    }

    @Transaction
    @Override
    public void refundPayment(PaymentInfo paymentInfo) {
        service.refundPayment(paymentInfo);
    }
}
