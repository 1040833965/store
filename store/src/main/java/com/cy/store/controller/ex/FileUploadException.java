package com.cy.store.controller.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 0:07
 * @Description: 是文件上传的基类
 */
@SuppressWarnings({"all"})
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
