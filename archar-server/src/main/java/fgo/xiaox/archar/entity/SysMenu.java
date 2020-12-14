package fgo.xiaox.archar.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单栏表
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 父节点id（0是根节点）
     */
    private Long parentId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 图标
     */
    private String menuIcon;

    /**
     * 地址
     */
    private String menuUrl;

    /**
     * 是否有效(1-有效，0-无效)
     */
    private Boolean isValid;

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
