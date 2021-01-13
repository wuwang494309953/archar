package fgo.xiaox.archar.pojo.table;

import lombok.Data;

@Data
public class ColumnInfo {


    /**
     * Field : id
     * Type : bigint(20)
     * Collation : null
     * Null : NO
     * Key : PRI
     * Default : null
     * Extra :
     * Privileges : select,insert,update,references
     * Comment :
     */

    private String field;
    private Integer type;
    private String comment;
}
