package com.prosesol.api.kyckglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class KyckGlobalApplication {
    public static void main(String[] args) {
        SpringApplication.run(KyckGlobalApplication.class, args);
    }
}
