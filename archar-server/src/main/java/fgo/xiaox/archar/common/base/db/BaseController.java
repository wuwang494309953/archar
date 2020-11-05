package fgo.xiaox.archar.common.base.db;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController <T extends IService<M>, M> {

    @Autowired
    private T iService;

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    public boolean save(M entity) {
        return iService.save(entity);
    }

}
