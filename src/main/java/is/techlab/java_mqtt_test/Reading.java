package is.techlab.java_mqtt_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
    private String meterId;
    private long reading;
}
