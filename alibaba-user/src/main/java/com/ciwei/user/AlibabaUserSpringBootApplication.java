package com.ciwei.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@EnableFeignClients
@SpringBootApplication
public class AlibabaUserSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaUserSpringBootApplication.class, args);
    }

//    @Bean
//    public ObjectMapper objectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        objectMapper.setDateFormat(dateFormat);
//        return objectMapper;
//    }

}
