package com.sda.DI.service;

public class SMSServiceImpl implements MessageService{
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Sent sms to " + rec + " with message: " + msg);
    }
}
