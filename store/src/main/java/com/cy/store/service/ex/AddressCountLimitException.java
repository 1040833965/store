package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 23:44
 * @Description: 这个异常表示收货地址超出限制异常（20）
 */
@SuppressWarnings({"all"})
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
