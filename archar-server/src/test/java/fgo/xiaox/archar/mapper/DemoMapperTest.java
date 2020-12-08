package fgo.xiaox.archar.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.ArcharApplicationTests;
import fgo.xiaox.archar.common.util.JSON;
import fgo.xiaox.archar.entity.Demo;
import fgo.xiaox.archar.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author archar
 * @since 2020-11-06
 */
@Slf4j
public class DemoMapperTest extends ArcharApplicationTests {

    @Autowired
    private IDemoService demoService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void list() {
        List<Demo> list = demoService.list();
        log.info("查询结果: {}", JSON.obj2String(list));
    }

    @Test
    public void t1() {
        LocalDateTime parse = LocalDateTime.parse("2020-11-05T02:21:49", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        QueryWrapper<Demo> queryWrapper = Wrappers.query();
        queryWrapper.eq("birthday_time", parse);
        List<Demo> list = demoService.list(queryWrapper);
        log.info("查询结果: {}", JSON.obj2String(list));
    }

    @Test
    public void saveOrUpdate() {
        boolean b = demoService.saveOrUpdate(Demo.builder()
                .name("周小小")
                .age(220)
                .sex(1)
                .birthdayTime(LocalDateTime.now())
                .build());
        log.info("插入结果: {}", b);
    }

    @Test
    public void page() {
        Page<Demo> page = new Page<>();
        Page<Demo> demoPage = demoService.page(page);
        log.info("分页查询: {}", demoPage);
    }

    @Test
    public void test1() {
        String sql = "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_COMMENT, COLUMN_DEFAULT " +
                "FROM INFORMATION_SCHEMA.COLUMNS " +
                "WHERE " +
                "table_name = 'demo'";
        List<Integer> result = jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            ArrayList<Integer> integers = Lists.newArrayList();
            System.out.println(resultSet);
            return integers;
        });
        log.info("结果是: {}", result);
    }
}
