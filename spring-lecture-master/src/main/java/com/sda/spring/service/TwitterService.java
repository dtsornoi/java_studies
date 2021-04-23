package com.sda.spring.service;

public class TwitterService implements MessageService{
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter msg sent to: " + rec + " with message: " + msg);
        return true;
    }
}
