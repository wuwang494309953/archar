package fgo.xiaox.archar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fgo.xiaox.archar.entity.SysQueryInfoColumn;
import fgo.xiaox.archar.mapper.SysQueryInfoColumnMapper;
import fgo.xiaox.archar.service.SysQueryInfoColumnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 查询数据的字段信息（前端列表展示和查询用） 服务实现类
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
@Service
public class SysQueryInfoColumnServiceImpl extends ServiceImpl<SysQueryInfoColumnMapper, SysQueryInfoColumn> implements SysQueryInfoColumnService {


    @Override
    public List<SysQueryInfoColumn> getSysQueryInfoColumnsWithQueryInfoId(Long queryInfoId) {
        QueryWrapper<SysQueryInfoColumn> wrapper = Wrappers.query();
        wrapper.eq("query_info_id", queryInfoId);
        return this.getBaseMapper().selectList(wrapper);
    }

}
