package com.vincent.utils;

/**
 * Created by renwu on 2017/6/19.
 */
public class PageNotSupportException extends RuntimeException{

    public PageNotSupportException() {
        super();
    }

    public PageNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotSupportException(String message) {
        super(message);
    }

    public PageNotSupportException(Throwable cause) {
        super(cause);
    }
}
