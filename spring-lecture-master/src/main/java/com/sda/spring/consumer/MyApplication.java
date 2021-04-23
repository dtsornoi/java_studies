package com.sda.spring.consumer;

import com.sda.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

    private MessageService service;

    @Autowired
    public MyApplication(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String rec){
        return service.sendMessage(msg, rec);
    }
}
