package com.aiden.automation.domain.service;

import com.aiden.automation.domain.repository.mybatis.model.MerchantDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final ResourceLoader resourceLoader;
    private final JavaMailSender mailSender;

    public void sendEmailNoticeToMerchants(List<MerchantDto> merchants, String title, String fileName) {
        for (MerchantDto merchant : merchants) {
            try {
                sendEmailToMerchant(merchant.getCpEmail(), title, fileName);
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendEmailToMerchant(String emailAddress, String title, String fileName) throws IOException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(emailAddress);
        helper.setSubject(title);
        String emailBody = loadHtmlTemplate(fileName);
        helper.setText(emailBody, true);
        mailSender.send(message);
    }

    private String loadHtmlTemplate(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:templates/" + fileName);
        InputStream inputStream = resource.getInputStream();
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

}
