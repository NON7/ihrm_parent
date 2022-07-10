package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * 1.配置springboot的包扫描
 * 2.配置
 */

@SpringBootApplication(scanBasePackages = "com.ihrm")
@EntityScan(value="com.ihrm.domain.company")
public class IhrmCompanysApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmCompanysApplication.class, args);
    }

//    配置IdWork进行主键的雪花算法计算
    @Bean //初始化
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
