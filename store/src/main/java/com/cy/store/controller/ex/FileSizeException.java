package com.cy.store.controller.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 0:08
 * @Description:上传文件大小不符合异常
 */
@SuppressWarnings({"all"})
public class FileSizeException extends FileUploadException{
    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
