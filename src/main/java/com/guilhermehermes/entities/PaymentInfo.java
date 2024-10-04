package com.guilhermehermes.entities;

public class PaymentInfo {

    private String cardNumber;
    private double amount;

    public PaymentInfo(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getAmount() {
        return amount;
    }
}