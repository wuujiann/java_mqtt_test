package is.techlab.java_mqtt_test;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;
import lombok.Data;

@Data
public class CommonResult<T> implements Serializable {

    public static Integer CODE_SUCCESS = 0;

    private Integer code;
    private String message;
    private T data;

    public static <T> CommonResult<T> error(CommonResult<?> result) {
        return error(result.getCode(), result.getMessage());
    }

    private static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!CODE_SUCCESS.equals(code), "Code must be wrong");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = CODE_SUCCESS;
        result.data = data;
        result.message = "";
        return result;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return CODE_SUCCESS.equals(code);
    }
}


