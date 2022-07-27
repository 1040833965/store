package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 23:25
 * @Description: 商品无法找到时报错
 */
@SuppressWarnings({"all"})
public class ProductNotFoundException extends ServiceException{
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
