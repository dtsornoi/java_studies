package com.sda.DI.injector;

import com.sda.DI.consumer.Consumer;
import com.sda.DI.consumer.MyDIApplication;
import com.sda.DI.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector{
    @Override
    public Consumer getConsumer() {
        MyDIApplication app = new MyDIApplication(new EmailServiceImpl());
        return app;
    }
}
