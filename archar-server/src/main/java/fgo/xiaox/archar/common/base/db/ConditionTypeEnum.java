package fgo.xiaox.archar.common.base.db;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConditionTypeEnum {
    /**
     * 支持的类型
     */
    EQ("eq"),
    NE("ne"),
    GT("gt"),
    GE("ge"),
    LT("lt"),
    LE("le"),
    BETWEEN("between"),
    NOT_BETWEEN("notBetween"),
    LIKE("like"),
    NOT_LIKE("notLike"),
    LIKE_LEFT("likeLeft"),
    LIKE_RIGHT("likeRight"),
    ISNULL("isNull"),
    IS_NOT_NULL("isNotNull"),
    IN("in"),
    NOT_IN("notIn"),
    OR("or");

    @JsonValue
    private String type;

    ConditionTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
