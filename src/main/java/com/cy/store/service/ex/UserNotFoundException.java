package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 23:51
 * @Description: 账号不存在异常
 */
@SuppressWarnings({"all"})
public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
