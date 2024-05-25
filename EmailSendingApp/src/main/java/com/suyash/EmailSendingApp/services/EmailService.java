package com.suyash.EmailSendingApp.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    // send email to single person
    void sendEmail(String to ,String subject,String message);


    // send email to multiple person
    void sendEmail(String [] to ,String subject,String message);


    // send email withHtml
    void sendEmailWithHtml(String to ,String subject,String htmlContent);


    // send email to single person
    void sendEmailWithFile(String to , String subject, String message, File file);

    //
    void sendEmailWithFile(String to , String subject, String message, InputStream is);

}
