package is.techlab.java_mqtt_test;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.integration.mqtt.support.MqttHeaders;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {    
    /**     * Send to default topic   */    
    void sendToMqtt(String payload);    

    /**     * Send to specified topic     */    
    void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);    

    /**     * Send to specified topic, specifying QOS     */    
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);

}