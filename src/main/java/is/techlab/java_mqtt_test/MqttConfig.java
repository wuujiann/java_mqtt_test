package is.techlab.java_mqtt_test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
@ConfigurationProperties(prefix = "rabbitmq.mqtt")
public class MqttConfig {
    private String username;
    private String password;
    private String defaultTopic;
    private String url;
    private String clientId;
}
