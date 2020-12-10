package fgo.xiaox.archar.service;

import fgo.xiaox.archar.ArcharApplicationTests;
import fgo.xiaox.archar.common.util.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
public class SysTableInfoServiceTest extends ArcharApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {

        List<Map<String, Object>> tables = jdbcTemplate.queryForList("show table status ");
        log.info("结果：{}", JSON.obj2String(tables));
    }

}
