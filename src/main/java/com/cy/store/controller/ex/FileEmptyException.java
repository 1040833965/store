package com.cy.store.controller.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 0:07
 * @Description: 文件为空异常
 */
@SuppressWarnings({"all"})
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
