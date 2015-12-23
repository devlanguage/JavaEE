package org.feitian.chat.exception;

public class FChatException extends Exception {

    private static final long serialVersionUID = -3454988359732453137L;

    public FChatException() {

        super();
    }

    public FChatException(String message) {

        super(message);
    }

    public FChatException(String message, Throwable t) {

        super(message, t);
    }

}
