package org.j2eetest.exception;

public class BaseException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8483693534896991855L;
    public final static int EX_IN_EMS_SYNC = -20200;
    public final static int EX_IN_NBI_SYNC = -20201;
    
    public enum Type_T {
        MESSAGING_EXCEPTION,
        
        //Indicate NBI internal exception
        NBI_INTERNAL_EXCEPTION,
        
        DB_EXCEPTION,
        UNKNOWN_TYPE
    }

    public enum Subtype_T {
        // Messaging Exceptions
        MESSAGE_TIME_OUT ("Message timed out"),
        MESSAGE_UNDELIVERABLE("Unable to deliver message"),
        JMS_CONNECTION_LOST ("Connection lost to JMS Broker"),
        WAIT_INTERRUPTED ("Thread is interrupted"),
        
        NBI_NOT_IMPLEMENTED("NBI_NOT_IMPLEMENTED"),
        NBI_INTERNAL_ERROR("NBI_INTERNAL_ERROR"),
        NBI_INVALID_INPUT("NBI_INVALID_INPUT"),
        NBI_OBJECT_IN_USE("NBI_OBJECT_IN_USE"),
        NBI_ENTITY_NOT_FOUND("NBI_ENTITY_NOT_FOUND"),
        NBI_UNABLE_TO_COMPLY("NBI_UNABLE_TO_COMPLY"),
        NBI_USERLABEL_IN_USE("NBI_USERLABEL_IN_USE"),
        NBI_NE_COMM_LOSS("NBI_NE_COMM_LOSS"),        
        
        UNKNOWN_TYPE("Unknown")
        ;
        
        private String errorMsg;
        
       Subtype_T(String errorMsg) {
            this.errorMsg = errorMsg;
        }
        
        public String getErrorMsg() {
            return errorMsg;
        }
    }

    private Type_T type = Type_T.UNKNOWN_TYPE;
    
    private Subtype_T subtype = Subtype_T.UNKNOWN_TYPE;

    private String detailErrorInfo;
    
    public BaseException(String errorMsg) {
        super(errorMsg);
    }

    public BaseException(Type_T exType, Subtype_T exSubType) {
        super(exSubType.getErrorMsg());                
        this.type = exType;
        this.subtype = exSubType;
    }
    
    public BaseException(Type_T exType, Subtype_T exSubType, String errorMsg ) {
    	super(errorMsg);                
    	this.type = exType;
    	this.subtype = exSubType;
    }

    public BaseException(Type_T exType, Exception ex) {
        super(ex.getMessage());
        this.type = exType;
        super.fillInStackTrace();
    }
    
    public BaseException(Type_T exType, Subtype_T exSubType, Exception ex) {
        super(ex.getMessage());
        this.type = exType;
        this.subtype = exSubType;
        super.fillInStackTrace();
    }
    
    public BaseException(Type_T exType, String detailErrorInfo) {
        super(detailErrorInfo);
        this.type = exType;
       
    }
    
    public BaseException(Exception ex) {
        super(ex.getMessage());
        super.fillInStackTrace();
    }
    
    public BaseException(String msg, Throwable t) {
        super(msg, t);
    }
    
    public BaseException(Type_T exType, String msg, Throwable t) {
        super(msg, t);
        this.type = exType;
    }
    
    public BaseException(Type_T exType, Subtype_T exSubType, String msg, Throwable t) {
        super(msg, t);
        this.type = exType;
        this.subtype = exSubType;
    }

    public void setDetailErrorInfo(String detailErrorInfo) {
        this.detailErrorInfo = detailErrorInfo;
    }
    
    public void setType(Type_T nbiType) {
        this.type = nbiType;    
    }
    
    public void setSubtype(Subtype_T nbiSubtype) {
        this.subtype = nbiSubtype;    
    }
    
    public String getDetailErrorInfo() {
        return detailErrorInfo;
    }

	/**
	 * @return the subtype
	 */
	public Subtype_T getSubtype() {
		return subtype;
	}

	/**
	 * @return the type
	 */
	public Type_T getType() {
		return type;
	}
    
}
