package com.aiden.automation.domain.repository.mybatis.mapper;

import com.aiden.automation.domain.repository.mybatis.model.Cafe24MerchantToEmail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MerchantMapper {

    List<Cafe24MerchantToEmail> findCafe24MerchantToEmailByRegDt(@Param("regDt") LocalDateTime regDt);

}
