package fgo.xiaox.archar.service;

import fgo.xiaox.archar.entity.SysQueryInfoColumn;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 查询数据的字段信息（前端列表展示和查询用） 服务类
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
public interface SysQueryInfoColumnService extends IService<SysQueryInfoColumn> {

    List<SysQueryInfoColumn> getSysQueryInfoColumnsWithQueryInfoId(Long queryInfoId);
}
