package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import fgo.xiaox.archar.service.SysQueryInfoColumService;
import fgo.xiaox.archar.entity.SysQueryInfoColum;

import fgo.xiaox.archar.common.base.db.BaseController;

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
@RequestMapping("/sysQueryInfoColum")
public class SysQueryInfoColumController extends BaseController<SysQueryInfoColumService, SysQueryInfoColum> {

    @Autowired
    private SysQueryInfoColumService sysQueryInfoColumService;

    @Override
    public SysQueryInfoColumService getService() {
        return sysQueryInfoColumService;
    }

    @GetMapping("/list")
    public JsonResult<List<SysQueryInfoColum>> sysQueryInfoColumList() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<SysQueryInfoColum>> sysQueryInfoColumPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<SysQueryInfoColum> sysQueryInfoColumGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> sysQueryInfoColumSaveOrUpdate(@RequestBody SysQueryInfoColum sysQueryInfoColum) {
        super.saveOrUpdate(sysQueryInfoColum);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<SysQueryInfoColum> sysQueryInfoColumRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}