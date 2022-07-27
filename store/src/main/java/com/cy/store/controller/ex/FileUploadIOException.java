package com.cy.store.controller.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 0:10
 * @Description:文件读写异常
 */
@SuppressWarnings({"all"})
public class FileUploadIOException extends FileUploadException{
    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
