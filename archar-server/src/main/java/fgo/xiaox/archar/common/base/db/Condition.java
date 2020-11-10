package fgo.xiaox.archar.common.base.db;

import fgo.xiaox.archar.common.util.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Condition implements Serializable {

    private ConditionTypeEnum type;

    private String column;

    /**
     * 可能时数组和其他属性
     */
    private Object value;

    public static void main(String[] args) {
        List<Condition> conditions = new ArrayList<>();
        Condition condition1 = new Condition();
        condition1.setType(ConditionTypeEnum.EQ);
        condition1.setColumn("id");
        condition1.setValue(1);

        Condition condition2 = new Condition();
        condition2.setType(ConditionTypeEnum.BETWEEN);
        condition2.setColumn("sex");

        List<Integer> sex = new ArrayList<>();
        sex.add(1);
        sex.add(3);
        condition2.setValue(sex);

        conditions.add(condition1);
        conditions.add(condition2);

        String json = JSON.obj2String(conditions);
        System.out.println(json);
    }

}
