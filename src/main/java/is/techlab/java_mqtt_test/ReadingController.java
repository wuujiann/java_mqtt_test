package is.techlab.java_mqtt_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.iotnet.mqtt.MqttGateway;

// import biz.iotnet.mqtt.MqttGateway;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;

// @Api(tags = "MqttController", description = "MQTT测试接口")
@RestController
@RequestMapping("/mqtt")
public class ReadingController {    
    
    @Autowired    
    @Lazy
    private MqttGateway mqttGateway;    

    @GetMapping("/")
    public Reading getReading() {
        Reading reading = new Reading("meter1", 1234567L);
        mqttGateway.sendToMqtt(reading.toString());
        return reading;
    }

    // @PostMapping("/sendToDefaultTopic")    
    // @ApiOperation("Send to default topic")  
    // public Reading sendToDefaultTopic(String payload) {        
    //     mqttGateway.sendToMqtt(payload);        
    //     return null;    
    // }    

    // @PostMapping("/sendToTopic")    
    // @ApiOperation("Send to specified topic")    
    // public Reading sendToTopic(String payload, String topic) {        
    //     mqttGateway.sendToMqtt(payload, topic);        
    //     return null;    
    // }
}
