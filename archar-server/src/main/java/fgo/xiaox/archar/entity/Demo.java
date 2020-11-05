package fgo.xiaox.archar.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author archar
 * @since 2020-11-05
 */
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
    private Boolean sex;

    /**
     * 生日
     */
    private LocalDateTime birthday_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public LocalDateTime getBirthday_time() {
        return birthday_time;
    }

    public void setBirthday_time(LocalDateTime birthday_time) {
        this.birthday_time = birthday_time;
    }

    @Override
    public String toString() {
        return "Demo{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", sex=" + sex +
            ", birthday_time=" + birthday_time +
        "}";
    }
}
