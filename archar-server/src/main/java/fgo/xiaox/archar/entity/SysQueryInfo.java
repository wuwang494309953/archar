package fgo.xiaox.archar.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 查询数据
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysQueryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 查询code
     */
    private String queryCode;

    /**
     * 查询名字
     */
    private String queryName;

    /**
     * 注释说明
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
