package ${package.Controller};


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fgo.xiaox.archar.common.base.db.PageParam;
import fgo.xiaox.archar.common.base.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
    *    <p>
    *   ${table.comment!} 前端控制器
    *   ${entity}
    *   ${superServiceImplClass}
    *   </p>
*
* @author ${author}
* @since ${date}
*/
@RestController
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName}, ${entity}> {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @Override
    public ${table.serviceName} getService() {
        return ${table.serviceName?uncap_first};
    }

    @GetMapping("/list")
    public JsonResult<List<${entity}>> ${entity?uncap_first}List() {
        return JsonResult.success(super.list());
    }

    @PostMapping("/page")
    public JsonResult<Page<${entity}>> ${entity?uncap_first}Page(@RequestBody PageParam pageParam) {
        return JsonResult.success(super.pageCondition(pageParam));
    }

    @GetMapping("/{id}")
    public JsonResult<${entity}> ${entity?uncap_first}GetById(@PathVariable Long id) {
        return JsonResult.success(super.getById(id));
    }

    @PutMapping
    public JsonResult<Object> ${entity?uncap_first}SaveOrUpdate(@RequestBody ${entity} ${entity?uncap_first}) {
        super.saveOrUpdate(${entity?uncap_first});
        return JsonResult.success("保存或更新数据成功");
    }

    @DeleteMapping("{id}")
    public JsonResult<${entity}> ${entity?uncap_first}RemoveById(@PathVariable Long id) {
        super.removeById(id);
        return JsonResult.success("删除数据成功");
    }

}