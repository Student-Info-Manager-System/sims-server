package com.cloud.sims.common.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author Long
 */
@Slf4j
public class CloudException extends AbstractException {

    private HttpStatus httpStatus;

    /*public CloudException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }*/

    public CloudException(String message) {
        this(message, message);
    }

    public CloudException(String message, String errMsg) {
        super(message);
        log.error(errMsg);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CloudException(String message, HttpStatus httpStatus) {
        this(message, message);
        this.httpStatus = httpStatus;
    }

    public CloudException(String message, HttpStatus httpStatus, Throwable e, String errMsg) {
        super(message, e);
        this.httpStatus = httpStatus;
        log.error(errMsg);
        e.printStackTrace();
    }

    public CloudException(String message, Exception e, String errMsg) {
        this(message, errMsg);
        e.printStackTrace();
    }

    public CloudException(Exception e, String errMsg) {
        this(errMsg);
        e.printStackTrace();
    }


    public CloudException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return this.httpStatus == null ? HttpStatus.METHOD_NOT_ALLOWED : this.httpStatus;
    }

    public Integer getCode(){
        return this.httpStatus.value();
    }


    public static void log(Throwable e, String errMsg){
        log.error(errMsg);
        e.printStackTrace();
    }
    public static void log(String errMsg){
        log.error(errMsg);
    }
}
