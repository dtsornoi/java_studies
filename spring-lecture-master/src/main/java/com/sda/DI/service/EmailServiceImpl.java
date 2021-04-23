package com.sda.DI.service;


public class EmailServiceImpl implements MessageService {
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Email send to " + rec + " with message: " + msg);
    }
}
