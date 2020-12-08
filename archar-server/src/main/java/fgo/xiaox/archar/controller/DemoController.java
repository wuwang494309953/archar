package fgo.xiaox.archar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.BaseController;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import fgo.xiaox.archar.entity.Demo;
import fgo.xiaox.archar.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
*  前端控制器123
* </p>
*
* @author archar
* @since 2020-11-06
*/
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController<IDemoService, Demo> {

    @Autowired
    private IDemoService demoService;

    @Override
    public IDemoService getService() {
        return demoService;
    }

    @GetMapping("/list")
    public JsonResult<List<Demo>> demoList() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<Demo>> demoPage(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<Demo> demoGetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }


    @PutMapping
    public JsonResult<Object> demoSaveOrUpdate(@RequestBody Demo demo) {
        super.saveOrUpdate(demo);
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<Demo> demoRemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

    @PostMapping("/tt")
    public JsonResult<Demo> tt(String name) {
        return JsonResult.success(name);
    }

}
