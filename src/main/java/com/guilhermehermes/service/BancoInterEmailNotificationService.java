package com.guilhermehermes.service;

public class BancoInterEmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification to INTER users: " + message);
    }
}
