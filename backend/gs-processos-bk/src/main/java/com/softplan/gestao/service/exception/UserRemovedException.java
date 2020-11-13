package com.softplan.gestao.service.exception;

public class UserRemovedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserRemovedException(String msg) {
        super(msg);
    }

    public UserRemovedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
