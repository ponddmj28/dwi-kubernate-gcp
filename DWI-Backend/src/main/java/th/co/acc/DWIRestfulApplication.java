package th.co.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@SpringBootApplication(exclude = {ServerTracingAutoConfiguration.class,FeignTracingAutoConfiguration.class,AsyncDefaultAutoConfiguration.class})
public class DWIRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DWIRestfulApplication.class, args);
	}

}
