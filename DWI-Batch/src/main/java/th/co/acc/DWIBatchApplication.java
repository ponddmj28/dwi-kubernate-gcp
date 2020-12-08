package th.co.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients("th.co.acc.dwi.service")
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableScheduling
public class DWIBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DWIBatchApplication.class, args);
	}

}
