package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import fgo.xiaox.archar.service.SysDictService;
import fgo.xiaox.archar.entity.SysDict;

import fgo.xiaox.archar.common.base.db.BaseController;

/**
    *    <p>
    *   数据字典表 前端控制器
    *   SysDict
    *   ServiceImpl
    *   </p>
*
* @author archar
* @since 2020-12-10
*/
@RestController
@RequestMapping("/sysDict")
public class SysDictController extends BaseController<SysDictService, SysDict> {

    @Autowired
    private SysDictService sysDictService;

    @Override
    public SysDictService getService() {
        return sysDictService;
    }

    @GetMapping("/list")
    public JsonResult<List<SysDict>> sysDictList() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<SysDict>> sysDictPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<SysDict> sysDictGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> sysDictSaveOrUpdate(@RequestBody SysDict sysDict) {
        super.saveOrUpdate(sysDict);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<SysDict> sysDictRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}