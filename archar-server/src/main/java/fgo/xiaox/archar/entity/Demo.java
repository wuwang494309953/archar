package fgo.xiaox.archar.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author archar
 * @since 2020-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别(1-男，2-女)
     */
    private Integer sex;

    /**
     * 生日
     */
    private LocalDateTime birthdayTime;


}
