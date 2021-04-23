package com.sda.DI.injector;

import com.sda.DI.consumer.Consumer;
import com.sda.DI.consumer.MyDIApplication;
import com.sda.DI.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector{
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }
}
