package com.aiden.automation.domain.service;

import com.aiden.automation.domain.repository.mybatis.mapper.MerchantMapper;
import com.aiden.automation.domain.repository.mybatis.model.Cafe24MerchantToEmail;
import com.aiden.automation.domain.repository.mybatis.model.MerchantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class Cafe24MerchantEmailService {


    private final MerchantMapper merchantMapper;
    private final EmailService emailService;

    public void sendEmailToCafe24MerchantToNoticeMasterCardEnabled(LocalDateTime from) {
        String emailTitle = " [Eximbay] MasterCard 결제수단 추가 세팅 안내";
        String templateName = "mailing_cafe24_mastercard.html";
        /*
        List<MerchantDto> cafe24MerchantToEmailByRegDt = merchantMapper.findCafe24MerchantToEmailByRegDt(from)
                .stream()
                .map(cafe24MerchantToEmail -> (MerchantDto) cafe24MerchantToEmail)
                .toList();

         */
        List<MerchantDto> cafe24MerchantToEmailByRegDt = createTestCafe24MerchantData();
        emailService.sendEmailNoticeToMerchants(cafe24MerchantToEmailByRegDt, emailTitle, templateName);
    }

    public List<MerchantDto> createTestCafe24MerchantData() {
        return Stream.of(
                        Cafe24MerchantToEmail.builder()
                                .cpEmail("aiden@eximbay.com")
                                .build()
                        ,
                        Cafe24MerchantToEmail.builder()
                                .cpEmail("chlwlgns524@naver.com")
                                .build()
                )
                .map(cafe24MerchantToEmail -> (MerchantDto) cafe24MerchantToEmail)
                .collect(Collectors.toList());
    }

}
