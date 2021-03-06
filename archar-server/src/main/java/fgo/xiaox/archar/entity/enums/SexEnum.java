package fgo.xiaox.archar.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  SexEnum {

    /**
     *
     */
    MAN(1, "男"),
    WOMAN(2, "女");

    @EnumValue
    private final int code;

    private final String descp;

    SexEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    public int getCode() {
        return code;
    }

    public String getDescp() {
        return descp;
    }
}
