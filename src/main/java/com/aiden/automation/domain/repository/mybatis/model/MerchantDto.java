package com.aiden.automation.domain.repository.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
public abstract class MerchantDto {

    private Long merchantNo;
    private String krName;
    private String cpEmail;

}
