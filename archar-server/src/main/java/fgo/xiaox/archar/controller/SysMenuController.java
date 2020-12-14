package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import fgo.xiaox.archar.service.SysMenuService;
import fgo.xiaox.archar.entity.SysMenu;

import fgo.xiaox.archar.common.base.db.BaseController;

/**
    *    <p>
    *   菜单栏表 前端控制器
    *   SysMenu
    *   ServiceImpl
    *   </p>
*
* @author archar
* @since 2020-12-10
*/
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController<SysMenuService, SysMenu> {

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public SysMenuService getService() {
        return sysMenuService;
    }

    @GetMapping("/list")
    public JsonResult<List<SysMenu>> sysMenuList() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<SysMenu>> sysMenuPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<SysMenu> sysMenuGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> sysMenuSaveOrUpdate(@RequestBody SysMenu sysMenu) {
        super.saveOrUpdate(sysMenu);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<SysMenu> sysMenuRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}