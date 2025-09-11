//package com.todo.todoapplication.services;
//
//import jakarta.mail.internet.MimeMessage;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//class EmailServiceImplTest {
//
//    @Mock
//    JavaMailSender mailSender;
//
//    @InjectMocks
//    EmailServiceImpl emailServiceImpl ;
//
//    @Test
//    void testSendEmail() {
//        //MockitoAnnotations.openMocks(this);
//        emailServiceImpl.sendEmail("helen@yahoo.com","Subject","body");
//        verify(mailSender, times(1)).send(any(MimeMessage.class));
//
//    }
//
//
//}