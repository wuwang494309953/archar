package fgo.xiaox.archar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fgo.xiaox.archar.entity.SysQueryInfo;
import fgo.xiaox.archar.pojo.table.TableInfo;

import java.util.List;

/**
 * <p>
 * 查询数据 服务类
 * </p>
 *
 * @author archar
 * @since 2020-12-10
 */
public interface SysQueryInfoService extends IService<SysQueryInfo> {

    List<TableInfo> getAllTableAndColumns();
}
