package org.j2eetest.exception;

public class BaseRuntimeException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5082470568544104532L;

    public BaseRuntimeException(String message) {

        super(message);
    }

    public BaseRuntimeException(String message, Throwable t) {

        super(message, t);
    }

    public BaseRuntimeException(String message, String source, Throwable t) {

        super(message + ". Exception is thrown in ", t);
    }
}
