package com.foshanshop.ejb3;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback=true)
public class TransException extends Exception {
    public TransException (String message) { 
        super(message);
    }
}
