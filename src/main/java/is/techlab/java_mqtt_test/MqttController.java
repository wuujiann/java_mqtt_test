package is.techlab.java_mqtt_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "MqttController", description = "MQTT测试接口")
@RestController
@RequestMapping("/mqtt")
public class MqttController {    
    
    @Autowired    
    private MqttGateway mqttGateway;    

    @PostMapping("/sendToDefaultTopic")    
    @ApiOperation("Send to default topic")  
    public CommonResult<?> sendToDefaultTopic(String payload) {        
        mqttGateway.sendToMqtt(payload);        
        return CommonResult.success(null);    
    }    

    @PostMapping("/sendToTopic")    
    @ApiOperation("Send to specified topic")    
    public CommonResult<?> sendToTopic(String payload, String topic) {        
        mqttGateway.sendToMqtt(payload, topic);        
        return CommonResult.success(null);    
    }
}
