package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.BaseController;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import fgo.xiaox.archar.entity.SysQueryInfo;
import fgo.xiaox.archar.service.SysQueryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
    *    <p>
    *   查询数据 前端控制器
    *   SysQueryInfo
    *   ServiceImpl
    *   </p>
*
* @author archar
* @since 2020-12-10
*/
@RestController
@RequestMapping("/sysQueryInfo")
public class SysQueryInfoController extends BaseController<SysQueryInfoService, SysQueryInfo> {

    @Autowired
    private SysQueryInfoService sysQueryInfoService;

    @Override
    public SysQueryInfoService getService() {
        return sysQueryInfoService;
    }

    @GetMapping("/list")
    public JsonResult<List<SysQueryInfo>> sysQueryInfoList() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<SysQueryInfo>> sysQueryInfoPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<SysQueryInfo> sysQueryInfoGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> sysQueryInfoSaveOrUpdate(@RequestBody SysQueryInfo sysQueryInfo) {
        super.saveOrUpdate(sysQueryInfo);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<SysQueryInfo> sysQueryInfoRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}