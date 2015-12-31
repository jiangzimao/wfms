package org.jqiaofu.wfms.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration("org.jqiaofu.wfms")
@ComponentScan("org.jqiaofu.wfms")
@EntityScan("org.jqiaofu.wfms.model")
@EnableJpaRepositories("org.jqiaofu.wfms.repository")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
