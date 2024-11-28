package pojo;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author csw
 * @date 2022/3/21 15:32
 */
@ToString
public class BooleanTest3 implements Serializable {

    private static final long serialVersionUID = -5606136522015653592L;
    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getOthers() {
        return "hello world";
    }
}
