package fgo.xiaox.archar.common.statuscode;

import fgo.xiaox.archar.common.base.web.JsonResult;

public class JsonResultStatus {

    public static final JsonResult<Object> ERROR = JsonResult.fail(1000, "未知的错误");

    public static final JsonResult<Object> NOT_FOUND_EXCEPTION = JsonResult.fail(1001, "404");

}
