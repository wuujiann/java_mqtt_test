package is.techlab.java_mqtt_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;


@Configuration
public class MqttInboundConfig {    
    @Autowired    
    private MqttConfig mqttConfig;    
    
    @Autowired    
    private MqttClientFactoryConfig mqttClientFactoryConfig;

    @Bean    
    public MessageChannel mqttInputChannel() {        
        return new DirectChannel();    
    }    

    @Bean    
    public MessageProducer inbound() {        
        MqttPahoMessageDrivenChannelAdapter adapter =  
            new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId(), mqttClientFactoryConfig.mqttClientFactory(), mqttConfig.getDefaultTopic());        
        adapter.setCompletionTimeout(5000);        
        adapter.setConverter(new DefaultPahoMessageConverter());        
        adapter.setQos(1);        
        adapter.setOutputChannel(mqttInputChannel());        
        return adapter;    
    }    

    @Bean    
    @ServiceActivator(inputChannel = "mqttInputChannel")    
    public MessageHandler handler() {        
        return new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.printf("handleMessage : %s\n",message.getPayload());            
            }            
        };    
    }
}