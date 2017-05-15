package com.mycompany.webservice;

import com.mycompany.webservice.config.WebServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@Import(WebServiceConfiguration.class)
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }


}
