package com.cy.store.service.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/19 23:24
 * @Description: 表示用户在更新数据时产生的未知异常
 */
@SuppressWarnings({"all"})
public class UpdateExcetion extends ServiceException{
    public UpdateExcetion() {
        super();
    }

    public UpdateExcetion(String message) {
        super(message);
    }

    public UpdateExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateExcetion(Throwable cause) {
        super(cause);
    }

    protected UpdateExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
