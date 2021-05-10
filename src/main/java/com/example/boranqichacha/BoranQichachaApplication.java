package com.example.boranqichacha;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoranQichachaApplication {

    private static final Logger logger = LoggerFactory.getLogger(BoranQichachaApplication.class);

    public static void main(String[] args) {
        logger.info("\n===============项目启动了===============");
        SpringApplication.run(BoranQichachaApplication.class, args);
        logger.info("\n===============启动成功了===============");
    }

}
