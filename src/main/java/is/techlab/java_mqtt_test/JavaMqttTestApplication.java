package is.techlab.java_mqtt_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication(scanBasePackages={"is.techlab", "biz.iotnet.mqtt"})
@IntegrationComponentScan({"biz.iotnet.mqtt"})
public class JavaMqttTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMqttTestApplication.class, args);
	}

}
