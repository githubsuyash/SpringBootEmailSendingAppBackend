package com.suyash.EmailSendingApp;

import com.suyash.EmailSendingApp.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;
    @Test
    void  emailSendTest(){
        System.out.println("sending email");
        emailService.sendEmail("ThoseYouWantTOSend@gmail.com","Email From Spring Boot","WoW! This email is send using spring boot while creating email service");
    }
    @Test
    void sendHtmlInEmail(){
        String html =""+
                "<h1 style='color:red;border:1px solid red;'> Welcome to Java With Suyash</h1>" +"";
        emailService.sendEmailWithHtml("ThoseYouWantTOSend@gmail.com","Email From Spring Boot",html);
    }
    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("ThoseYouWantTOSend@gmail.com","Email from SpringBootProject with file","This email contains file",new File("C:\\Users\\hp\\Desktop\\EmailSendingApp1\\EmailSendingApp\\src\\main\\resources\\static\\HeroImage.jpg.jpg"));
    }
    @Test
    void sendEmailWithFileWithStream(){
        File file = new File("C:\\Users\\hp\\Desktop\\EmailSendingApp1\\EmailSendingApp\\src\\main\\resources\\static\\HeroImage.jpg.jpg");
        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("ThoseYouWantTOSend@gmail.com","Email from SpringBootProject with file","This email contains file",is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
