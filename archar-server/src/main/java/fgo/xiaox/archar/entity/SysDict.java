package fgo.xiaox.archar.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 字典code，唯一
     */
    private String dictCode;

    private String dictName;

    /**
     * 父节点id。root节点为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
