package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 18:23
 * @Description:数据在插入时候产生的异常
 */
@SuppressWarnings({"all"})
public class InsertExcetion extends ServiceException{
    public InsertExcetion() {
        super();
    }

    public InsertExcetion(String message) {
        super(message);
    }

    public InsertExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertExcetion(Throwable cause) {
        super(cause);
    }

    protected InsertExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
