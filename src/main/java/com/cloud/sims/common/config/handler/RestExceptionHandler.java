package com.cloud.sims.common.config.handler;


import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * @ ClassName: ControllerExceptionHandler
 * @ Author: longxin
 * @ CreatTime: 2020/4/13 0013 17:35
 * @ version: 1.0
 * @author Long
 */

@Slf4j
@ResponseBody
//加了改注解会拦截所有抛出的异常
@ControllerAdvice
public class RestExceptionHandler {


    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //自定义通用异常处理

    @ExceptionHandler(CloudException.class)
    public Result<?> exceptionHander(HttpServletRequest request, CloudException e) {
        log.error("路由 : {}，Cloud错误信息 : {}", request.getRequestURL(), e.getStatus() + " " + e);

        e.printStackTrace();

        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> exceptionHander(HttpServletRequest request, MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        log.error("路由 : {}，RequestBody-Valid错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(400, message);
    }



    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result<?> exceptionHander(HttpServletRequest request, BindException e)  {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        log.error("路由 : {}，Get-Valid错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(400, message);
    }


    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<?> exceptionHander(HttpServletRequest request, NullPointerException e)  {
        log.error("路由 : {}，空指针异常错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(400, e.getMessage());
    }

    /**
     * 数据不存在异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> exceptionHander(HttpServletRequest request, IllegalArgumentException e)  {
        log.error("路由 : {}，空指针异常错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(404, e.getMessage());
    }


    /**
     * 运行时异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<?> exceptionHander(HttpServletRequest request, RuntimeException e) {
        log.error("路由 : {}，错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(400, e.getMessage());
    }




    /**
     * 请求方式错误
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> exceptionHander(HttpServletRequest request, HttpRequestMethodNotSupportedException e){
        StringBuffer sb = new StringBuffer();
        sb.append("该链接不支持");
        sb.append(e.getMethod());
        sb.append("请求，");
        sb.append("支持以下请求：");
        String[] methods = e.getSupportedMethods();
        if(methods!=null){
            for(String str:methods){
                sb.append(str);
                sb.append("、");
            }
        }
        log.error("路由 : {}，错误信息 : {}", request.getRequestURL(), e);

        e.printStackTrace();

        return Result.error(405, sb.toString());
    }

    /**
     * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<?> exceptionHander(HttpServletRequest request, MaxUploadSizeExceededException e) {
        log.error("路由 : {}，错误信息 : {}", request.getRequestURL(), "文件大小超出10MB限制, 请压缩或降低文件质量!\n " + e);

        e.printStackTrace();

        return Result.error("文件大小超出10MB限制, 请压缩或降低文件质量! ");
    }



    /**
     * 其它异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<?> exceptionHander(HttpServletRequest request, Exception e) {
        log.error("路由 : {}，错误信息 : {}", request.getRequestURL(), e.getMessage());

        e.printStackTrace();

        return Result.error(0, "操作失败," + e.getMessage());
    }
}
