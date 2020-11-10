package fgo.xiaox.archar.common.spring.exeception;

import fgo.xiaox.archar.common.base.web.JsonResult;
import fgo.xiaox.archar.common.statuscode.JsonResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public JsonResult<Object> noHandlerFoundException(HttpServletRequest request, Exception exception) {
        String url = request.getRequestURL().toString();
        log.warn("404-exception url: {}, message: {}", url, exception);
        return JsonResultStatus.NOT_FOUND_EXCEPTION;
    }

    @ExceptionHandler(Exception.class)
    public JsonResult<Object> exception(HttpServletRequest request, Exception exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception);
        return JsonResultStatus.ERROR;
    }

}
