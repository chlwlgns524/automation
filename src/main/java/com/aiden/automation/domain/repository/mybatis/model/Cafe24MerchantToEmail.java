package com.aiden.automation.domain.repository.mybatis.model;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Getter
@SuperBuilder
public class Cafe24MerchantToEmail extends MerchantDto {

    private String merchantId;

}
