package com.sda.legacy;

public class MyApplication {
    private EmailService emailService = new EmailService();

    public void processMessage(String msg, String rec){
        emailService.sendEmail(msg, rec);
    }
}
