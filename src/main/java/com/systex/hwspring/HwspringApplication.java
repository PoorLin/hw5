package com.systex.hwspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HwspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwspringApplication.class, args);
    }

}
