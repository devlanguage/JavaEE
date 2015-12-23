/**
 * 
 */
package org.feitian.chat.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author feiye
 * 
 */
public class FChatLogger {

    private Logger logger;
    private final static Map<String, FChatLogger> logCategories = new HashMap<String, FChatLogger>();

    public final static FChatLogger getLogger(String category) {

        FChatLogger logger = logCategories.get(category);
        if (SystemUtil.isNullOrBlank(logger)) {
            logger = new FChatLogger();
        }
        return logger;
    }

    public final static FChatLogger getLogger(Class category) {

        return getLogger(category.getName());
    }

    public final static Level getLoggerLevel(FChatLoggerLevel loggerLevel) {

        Level log4jLevel;
        switch (loggerLevel) {
            case DEBUG: {
                log4jLevel = Level.DEBUG;
                break;
            }
            case INFO: {
                log4jLevel = Level.INFO;
                break;
            }
            case WARN: {
                log4jLevel = Level.WARN;
                break;
            }
            case ERROR: {
                log4jLevel = Level.ERROR;
                break;
            }
            case FATAL: {
                log4jLevel = Level.FATAL;
                break;
            }
            default:
                log4jLevel = Level.ALL;
                break;
        }
        return log4jLevel;
    }

    public void log(Object message) {

        logger.log(getLoggerLevel(FChatLoggerLevel.DEBUG), message);
    }

    public void log(FChatLoggerLevel level, Object message) {

        logger.log(getLoggerLevel(level), message);
    }

    public void log(FChatLoggerLevel level, Object message, Throwable t) {

        logger.log(getLoggerLevel(level), message, t);
    }

    public void debug(Object message) {

        logger.debug(message);
    }

    public void info(Object message) {

        logger.info(message);
    }

    public void warn(Object message) {

        logger.warn(message);
    }

    public void error(Object message) {

        logger.error(message);
    }

    public void fatal(Object message) {

        logger.fatal(message);
    }
}
