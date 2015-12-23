/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.basic.util.SystemUtil.java is
 * created on Sep 22, 2007 11:27:17 AM
 */
package org.feitian.chat.util;

import org.feitian.chat.exception.FChatException;

public class SystemUtil {

    public static void catchException(FChatLogger logger, String message, Throwable t) {

        logger.log(FChatLoggerLevel.ERROR, message, t);
    }

    public static void catchException(FChatLogger logger, Throwable t) {

        logger.log(FChatLoggerLevel.ERROR, t);
    }

    public static void rethrowException(FChatLogger logger, String message, Throwable t) throws FChatException {

        logger.log(FChatLoggerLevel.ERROR, message, t);
        throw new FChatException(message, t);
    }

    public static boolean isNullOrBlank(Object obj) {

        return (obj == null) || obj.toString().trim().equals("");
    }

}
