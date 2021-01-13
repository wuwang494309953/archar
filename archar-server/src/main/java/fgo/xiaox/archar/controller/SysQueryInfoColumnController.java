package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.BaseController;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import fgo.xiaox.archar.entity.SysQueryInfoColumn;
import fgo.xiaox.archar.service.SysQueryInfoColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
    *    <p>
    *   查询数据的字段信息（前端列表展示和查询用） 前端控制器
    *   SysQueryInfoColum
    *   ServiceImpl
    *   </p>
*
* @author archar
* @since 2020-12-10
*/
@RestController
@RequestMapping("/sysQueryInfoColumn")
public class SysQueryInfoColumnController extends BaseController<SysQueryInfoColumnService, SysQueryInfoColumn> {

    @Autowired
    private SysQueryInfoColumnService sysQueryInfoColumService;

    @Override
    public SysQueryInfoColumnService getService() {
        return sysQueryInfoColumService;
    }

    @GetMapping("/list")
    public JsonResult<List<SysQueryInfoColumn>> sysQueryInfoColumnList() {
        return JsonResult.success(super.list());
    }

    @GetMapping("/columns/{queryInfoId}")
    JsonResult<List<SysQueryInfoColumn>> getSysQueryInfoColumnsWithQueryInfoId(@PathVariable Long queryInfoId) {
        return JsonResult.success(sysQueryInfoColumService.getSysQueryInfoColumnsWithQueryInfoId(queryInfoId));
    }

    @PostMapping("/page")
    public JsonResult<Page<SysQueryInfoColumn>> sysQueryInfoColumnPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<SysQueryInfoColumn> sysQueryInfoColumnGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> sysQueryInfoColumSaveOrUpdate(@RequestBody SysQueryInfoColumn sysQueryInfoColum) {
        super.saveOrUpdate(sysQueryInfoColum);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<SysQueryInfoColumn> sysQueryInfoColumnRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}