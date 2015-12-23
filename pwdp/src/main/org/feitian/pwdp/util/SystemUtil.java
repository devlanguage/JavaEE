/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.util.SystemUtil.java is created on 2007-10-19 上午09:28:03
 */
package org.feitian.pwdp.util;

import org.apache.log4j.Logger;
import org.feitian.pwdp.common.data.Constants;

public class SystemUtil {

    public static void handleException(Logger logger, Exception e, String message)
            throws BasicException {

        logger.info(message);
        e.printStackTrace();
        throw new BasicException(message);
    }

    public final static String getCharset() {

        return MessageUtil.getMessage(Constants.DEFAULT_CHARSET, "gb2312");
    }

    public static boolean isNullOrBlank(Object obj) {

        return (obj == null) || obj.toString().trim().equals("");
    }
}