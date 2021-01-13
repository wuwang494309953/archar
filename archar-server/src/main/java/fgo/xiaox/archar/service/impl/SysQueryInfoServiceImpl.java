package fgo.xiaox.archar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fgo.xiaox.archar.common.util.BeanUtil;
import fgo.xiaox.archar.entity.SysQueryInfo;
import fgo.xiaox.archar.mapper.SysQueryInfoMapper;
import fgo.xiaox.archar.pojo.table.TableInfo;
import fgo.xiaox.archar.service.SysQueryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 查询数据 服务实现类
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Service
public class SysQueryInfoServiceImpl extends ServiceImpl<SysQueryInfoMapper, SysQueryInfo> implements SysQueryInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TableInfo> getAllTableAndColumns() {
        List<Map<String, Object>> tables = jdbcTemplate.queryForList("show table status");
        List<TableInfo> tableInfos = BeanUtil.mapToList(tables, TableInfo.class);
        for (TableInfo tableInfo : tableInfos) {
//            List<Map<String, Object>> colums = jdbcTemplate.queryForList("SHOW FULL COLUMNS FROM "+ tableInfo.getName(), rcch);
            SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SHOW FULL COLUMNS FROM " + tableInfo.getName());
            sqlRowSet.getString("Field");
//            tableInfo.setColumnInfos(columnInfos);
        }
        return tableInfos;
    }

}
