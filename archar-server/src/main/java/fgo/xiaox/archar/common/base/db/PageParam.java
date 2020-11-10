package fgo.xiaox.archar.common.base.db;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageParam implements Serializable {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private List<Condition> conditionList;

}
