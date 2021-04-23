package com.sda.DI.consumer;

import com.sda.DI.service.MessageService;

public class MyDIApplication implements Consumer{
    private MessageService service;

    public MyDIApplication(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessage(String msg, String rec) {
        this.service.sendMessage(msg, rec);
    }
}
