package com.cloud.sims.common.config.exception;


import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import org.springframework.http.HttpStatus;

import java.util.Collection;

/**
 * @author Long
 */
public class Assert {
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new CloudException(message);
        }
    }
    /*public static void isNull(Object object, String message) {
        if (ServiceUtil.isNotNull(object)) {
            throw new CloudException(message, HttpStatus.NOT_FOUND);
        }
    }*/

    public static void notNull(Object object, String message) {
        if (ServiceUtil.isNull(object)) {
            throw new CloudException(message, HttpStatus.NOT_FOUND);
        }
    }

    public static void notNull(Object object) {
        if (ServiceUtil.isNull(object)) {
            throw new CloudException(ErrorMsg.NOT_FOUNT, HttpStatus.NOT_FOUND);
        }
    }

    public static void notNull(Collection<?> coll) {
        if (ServiceUtil.isNull(coll)) {
            throw new CloudException(ErrorMsg.NOT_FOUNT, HttpStatus.NOT_FOUND);
        }
    }
}
