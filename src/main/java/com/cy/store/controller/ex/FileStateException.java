package com.cy.store.controller.ex;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 0:11
 * @Description:
 */
@SuppressWarnings({"all"})
public class FileStateException extends FileUploadException{
    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
