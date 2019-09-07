package com.ciwei.txmanager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @NAME AlibabaTxMangerApplication
 * @USER Ciwei
 * @DATE 2019/9/7 13:55
 **/
@SpringBootApplication
@EnableTransactionManagerServer
public class AlibabaTxMangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaTxMangerApplication.class, args);
	}

}
