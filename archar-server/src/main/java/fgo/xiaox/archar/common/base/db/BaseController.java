package fgo.xiaox.archar.common.base.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController <T extends IService<M>, M> {

    public abstract T getService();

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    public boolean save(M entity) {
        return getService().save(entity);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    boolean updateById(M entity) {
        return getService().updateById(entity);
    }

    public List<M> list() { return  getService().list(); }

    public M getById(Serializable id) { return  getService().getById(id); }

    public boolean saveOrUpdate(M m) {
        return getService().save(m);
    };

    public boolean removeById(Serializable id) {
        return getService().removeById(id);
    };

    public Page<M> pageCondition(PageParam pageParam) {
        Page<M> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        QueryWrapper<M> wrapper = AWrappers.parseWhereSql(pageParam.getConditionList());
        return getService().page(page, wrapper);
    }

}
