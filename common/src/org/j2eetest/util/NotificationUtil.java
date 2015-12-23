package org.j2eetest.util;

public class NotificationUtil {

    public enum NotificationStatus_T {
        NULL("N/A"),
        FAILED_SUBSCRIPTION("Failed subscription"),
        SUCCESSFUL_SUBSCRIPTION("Successful subscription"),
        NORMAL_NOTIFICATION("Normal notification state"),
        EXCEPTION_NOTIFICATION("Unnormal Notification state");
        
        String value;
        NotificationStatus_T(String v) {
            value = v;
        }
        
        public String toString() {
            return value;
        }
    }
    
    public enum NotificationCommmand_T {
        SUBSCRIBE("subscribe"),
        UNSUBSCRIBE("unsubscribe"),
        SESSION_CLEARED("session cleared"),
        NOTIFY_STATUS_CHANGE("status change"),
        SUB_EXCEPTION("exception when subscribing"),
        UN_SUB_EXCEPTION("exception when unsubscribing"),
        ERROR_MESSAGE("log error message.");
        
        String value;
        NotificationCommmand_T(String v) {
            value = v;
        }
    }
}
