package com.guilhermehermes.service;

public class BancoSantanderEmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {

        System.out.println("Sending email notification to SANTANDER users: " + message);
    }
}
