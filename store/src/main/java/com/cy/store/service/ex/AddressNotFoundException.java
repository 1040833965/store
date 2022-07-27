package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/23 23:46
 * @Description:
 */
@SuppressWarnings({"all"})
public class AddressNotFoundException extends ServiceException{
    public AddressNotFoundException() {
        super();
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
