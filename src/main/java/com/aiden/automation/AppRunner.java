package com.aiden.automation;

import com.aiden.automation.domain.service.Cafe24MerchantEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final Cafe24MerchantEmailService cafe24MerchantEmailService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cafe24MerchantEmailService.sendEmailToCafe24MerchantToNoticeMasterCardEnabled(LocalDateTime.of(2024, 10, 19, 00, 00, 00));
        System.out.println("이메일 발송 완료");
    }

}
