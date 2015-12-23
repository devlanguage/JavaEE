/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * com.tellabs.tmfnbi.platform.server.util.SystemUtil.java is created on 2007-9-5 09:04:52 P.M
 */
package org.j2eetest.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;



public class SystemUtil {

    private static LoggerUtil logger = LoggerUtil.getLogger(SystemUtil.class);

    public final static Exception handleException(LoggerUtil logger, Exception e, String message) {

        logger.info(message);
        // e.printStackTrace();
        logger.log(LoggerUtil.ERROR, "handleException", message, e);
        return new Exception(message);
    }

    public final static boolean isNullOrBlank(Object obj) {

        return (obj == null) || obj.toString().trim().equals("");
    }

    public final static boolean isNullOrBlank(Collection<? extends Object> obj) {

        return obj == null || obj.isEmpty();
    }

    /**
     * If the parameter source is null or source.toString() is blank, it return the parameter defaultValue. Or else, it
     * returns the source.toString();
     * 
     * @param source
     * @param defaultValue
     * @return
     */
    public final static String nvl(Object source, String defaultValue) {

        if (isNullOrBlank(source)) {
            return defaultValue;
        }
        return source.toString();
    }

    /**
     * Assert if the parameter bool is true.<br>
     * If the parameter bool is 'Y', 'YES', 'T', 'TRUE', '1', it will return the boolean value true; Or else, false.
     * 
     * @param bool
     * @return
     */
    public final static boolean isTrue(String bool) {

        return "TRUE".equalsIgnoreCase(bool) || "T".equalsIgnoreCase(bool) || "YES".equalsIgnoreCase(bool)
                || "Y".equalsIgnoreCase(bool) || "1".equals(bool);
    }

    public final static void closeQuitely(Connection... dbConnections) {
        for (Connection dbConnection : dbConnections) {
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

    public final static void closeQuitely(Statement... stmts) {
        for (Statement dbConnection : stmts) {
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

    public final static void closeQuitely(InputStream... inputStreams) {
        for (InputStream inputStream : inputStreams) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

    public final static void closeQuitely(OutputStream... outputStreams) {
        for (OutputStream outputStream : outputStreams) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

    public final static void closeQuitely(Reader... readers) {
        for (Reader reader : readers) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

    public final static void closeQuitely(Writer... writers) {
        for (Writer writer : writers) {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }


    public final static void closeQuitely(ResultSet... adapters) {
        for (ResultSet adapter : adapters) {
            if (adapter != null) {
                try {
                    adapter.close();
                } catch (Exception e) {
                    logger.log(LoggerUtil.ERROR, "closeQuitely", "object close exception", e);
                }
            } else {
                logger.log(LoggerUtil.INFO, "closeQuitely", "object to be closed is NULL");
            }
        }
    }

}
