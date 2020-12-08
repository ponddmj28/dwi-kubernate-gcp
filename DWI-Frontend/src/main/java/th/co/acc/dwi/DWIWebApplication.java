package th.co.acc.dwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients("th.co.acc.dwi.service")
public class DWIWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DWIWebApplication.class, args);
	}

}
