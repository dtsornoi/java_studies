package com.sda.DI;

import com.sda.DI.consumer.Consumer;
import com.sda.DI.injector.EmailServiceInjector;
import com.sda.DI.injector.MessageServiceInjector;
import com.sda.DI.injector.SMSServiceInjector;

public class MyMessageDITest {
    public static void main(String[] args) {
        String msg = "Hi Dima";
        String email = "dima@abc.com";
        String phone = "123456789";

        MessageServiceInjector injector;
        Consumer app;

        //Send Email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessage(msg, email);

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessage(msg, phone);
    }
}
