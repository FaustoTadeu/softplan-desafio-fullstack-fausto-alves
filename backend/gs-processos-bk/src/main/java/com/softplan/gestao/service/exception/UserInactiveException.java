package com.softplan.gestao.service.exception;

public class UserInactiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserInactiveException(String msg) {
        super(msg);
    }

    public UserInactiveException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
