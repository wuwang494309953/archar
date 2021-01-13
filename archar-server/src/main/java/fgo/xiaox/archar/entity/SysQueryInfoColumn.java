package fgo.xiaox.archar.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 查询数据的字段信息（前端列表展示和查询用）
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysQueryInfoColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * sys_query_info表id
     */
    private Long queryInfoId;

    /**
     * 列名
     */
    private String colum;

    /**
     * 数据库类型
     */
    private String jdbcType;

    /**
     * 字段描述
     */
    private String description;

    /**
     * 查询type
     */
    private String queryType;

    /**
     * query_type是枚举时会查询sys_dict的code
     */
    private String queryCode;

    /**
     * 是否快速查询（0-否，1-是）
     */
    private Integer isQuickQuery;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
