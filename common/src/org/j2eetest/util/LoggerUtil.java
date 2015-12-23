/**
 * Tellabs Inc. ShangHai R&D Center, 2007 Copyright
 * NbiLogger.java
 * Desc: 
 * Created by: pxuan
 * Created Time: Apr 3, 2007 11:00:57 AM
 * Updated by: 
 * Updated Time: 
*/

package org.j2eetest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;


public class LoggerUtil {
    public static final int OFF = Level.OFF_INT;
    public static final int FATAL = Level.FATAL_INT;
    public static final int ERROR = Level.ERROR_INT;
    public static final int WARN = Level.WARN_INT;
    public static final int INFO = Level.INFO_INT;
    public static final int DEBUG = Level.DEBUG_INT;
    public static final int ALL = Level.ALL_INT;

    public final static Map<String, Integer> SUPPORTED_LEVELS = new HashMap<String, Integer>();
    
    // Log4J logger instance
    private   Logger logger;
    private   static int nLevel=-1;

    private final static String szPropertyFile="tmfnbi.properties";
    
    //Performance Logger
    private final static String PERFORMANCE = "com.tellabs.test.performace";
    private final static String TMFNBI = "com.tellabs.tmfnbi";
    private final static String NOTIFYCLIENT = "com.tellabs.notifyClient";
    
    //Log4j Configuration only once
    static {
        SUPPORTED_LEVELS.put("OFF", Integer.valueOf(OFF));
        SUPPORTED_LEVELS.put("FATAL", Integer.valueOf(FATAL));
        SUPPORTED_LEVELS.put("ERROR", Integer.valueOf(ERROR));
        SUPPORTED_LEVELS.put("WARN", Integer.valueOf(WARN));
        SUPPORTED_LEVELS.put("INFO", Integer.valueOf(INFO));
        SUPPORTED_LEVELS.put("DEBUG", Integer.valueOf(DEBUG));
        SUPPORTED_LEVELS.put("ALL", Integer.valueOf(ALL));
        
        try {
            Properties props = new Properties();
            InputStream in = LoggerUtil.class.getClassLoader().getResourceAsStream(szPropertyFile);
            props.load(in);
            PropertyConfigurator.configure(props);
        } catch (IOException ex) {
            BasicConfigurator.configure();
            ex.printStackTrace();
        }
    }

    private static Map<String,LoggerUtil> NBI_LOGGER_MAP=new ConcurrentHashMap<String,LoggerUtil>();
    private static Map<String,LoggerUtil> NBI_LOGGER_UPPER_MAP=new ConcurrentHashMap<String,LoggerUtil>();
    
    static PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p - %m%n");


    /**
     * @return NbiLogger Logger for logging messages at the top level
     */
    //public static NbiLogger topLogger = getLogger("com.tellabs.tmfnbi");
    
    /**
     * Private constructor
     * @param level
     */
    private LoggerUtil(String className) {

    	logger = Logger.getLogger(className); 
    }
    
    //Gong Genping make thie method private, please don't modify it to public
    private static synchronized LoggerUtil getLogger(String className) {
    	
    	if (NBI_LOGGER_MAP.get(className)!=null)
    		  return (LoggerUtil)NBI_LOGGER_MAP.get(className); 
    	 else
    	 {
    		 LoggerUtil nbiLogger=new LoggerUtil(className);
    		 
    		 if (nLevel>-1) nbiLogger.setLoggingLevel(nLevel);
    		 
    		 NBI_LOGGER_MAP.put(className, nbiLogger);
    		 NBI_LOGGER_UPPER_MAP.put(className.toUpperCase(), nbiLogger);
      		 
      		 //TMFNBI t71mr00084282
      		 if( NBI_LOGGER_MAP.get(TMFNBI) == null ) {
      			LoggerUtil tmfnbiLogger = new LoggerUtil(TMFNBI);
      			NBI_LOGGER_MAP.put(TMFNBI, tmfnbiLogger);
      			NBI_LOGGER_UPPER_MAP.put(TMFNBI.toUpperCase(), nbiLogger);
      		 }
    		 return nbiLogger;
    	 }
    }
    
    public static LoggerUtil getLogger(Class<? extends Object> className) {

        return getLogger(className.getName());
    }

    /*
     * Acquire Performance Logger
     */
    public static LoggerUtil getPerformanceLogger() {
    	return getLogger(PERFORMANCE);
    }
    
    /*
     * Acquire notify client Logger
     */
    public static LoggerUtil getNotifyClientLogger() {
        return getLogger(NOTIFYCLIENT);
    }
   
    private Logger getLogger() {
        return logger;
    }
   
    public static void defaultConfigure() {
        org.apache.log4j.BasicConfigurator.configure();
        PatternLayout defLayout = new PatternLayout();
        defLayout.setConversionPattern("%m%n");
        Logger.getRootLogger().removeAllAppenders();
        Logger.getRootLogger().addAppender(new ConsoleAppender(defLayout));

    }

    /**
     * Configure the logger with config file under configDir 
     * @param configDir Directory where property file is
     * @param filename Property file name
     */
    public static void configure(String configDir, String filename) {
        Properties props = new Properties();
        InputStream istream = null;
        String path = configDir + File.separator + filename;

        try {
            istream = new FileInputStream(path);
        } catch (Exception ex1) {
            System.err.println("Error reading log properties file " + 
                               ex1.toString());
        }

        if (istream != null) {
            try {
                props.load(istream);
                istream.close();
            } catch (IOException e) {
                System.err.println("Could not read configuration file [" + filename + "]." + e.toString());
                System.err.println("Ignoring configuration file [" + filename + "].");
                return;
            }
        }
        PropertyConfigurator.configure(props);
    }

    /**
     * Log message without throwable
     * @param level logging level defined in NbiLogger
     * @param target target area where logging happens, could be service name
     * @param message logging message
     */
    public void log(int level, Object target, Object message) {
        String logMsg = "[" + target + "] " + message;

        switch (level) {
            case Level.FATAL_INT:
                getLogger().fatal(logMsg);
                break;
            case Level.ERROR_INT:
                getLogger().error(logMsg);
                break;
            case Level.WARN_INT:
                getLogger().warn(logMsg);
                break;
            case Level.INFO_INT:
                getLogger().info(logMsg);
                break;
            case Level.DEBUG_INT:
                getLogger().debug(logMsg);
                break;
        }
    }
    public void logImportant(int level, Object target, Object message) {
        String logMsg = "[" + target + "] \n*************  " + message + " *************";

        switch (level) {
            case Level.FATAL_INT:
                getLogger().fatal(logMsg);
                break;
            case Level.ERROR_INT:
                getLogger().error(logMsg);
                break;
            case Level.WARN_INT:
                getLogger().warn(logMsg);
                break;
            case Level.INFO_INT:
                getLogger().info(logMsg);
                break;
            case Level.DEBUG_INT:
                getLogger().debug(logMsg);
                break;
        }
    }

    /**
     *  Check whether this Logger is enabled for the <code>DEBUG</code>
     *  Level.
     *
     *  This function is intended to lessen the computational cost of
     *  disabled log debug statements. If you check before logging, you
     *  will not incur the cost of parameter construction. So, the preferred
     *  way for logging debug messages is as follows.
     *     <p> if(logger.isDebugEnabled()) {
     *        logger.log(NbiLogger.DEBUG, "Common", "This is entry number: " + i );
     *      }
     *
     *  @return boolean - <code>true</code> if this category is debug
     *  enabled, <code>false</code> otherwise.
     *
     */
    public boolean isDebugEnabled() {
    	
        return logger.isDebugEnabled();
    }
   
    public void info(Object o)
    {
    	getLogger().info(o);
    }
    
    public void error(Object o)
    {
    	getLogger().error(o);
    }
    /**
     * Log message with throwable
     * @param level logging level defined in NbiLogger
     * @param target target area where logging happens, could be service name
     * @param message logging message
     * @param t exception object
     */
    public void log(int level, Object target, Object message, Throwable t) {
        String logMsg = "[" + target + "] " + message;

        switch (level) {
        case FATAL:
            getLogger().fatal(logMsg, t);
            break;
        case ERROR:
            getLogger().error(logMsg, t);
            break;
        case WARN:
            getLogger().warn(logMsg, t);
            break;
        case INFO:
            getLogger().info(logMsg, t);
            break;
        case DEBUG:
            getLogger().debug(logMsg, t);
            break;
        }
    }
    public void logImportant(int level, Object target, Object message, Throwable t) {
        String logMsg = "[" + target + "]  \n*************  " + message + " *************";

        switch (level) {
        case FATAL:
            getLogger().fatal(logMsg, t);
            break;
        case ERROR:
            getLogger().error(logMsg, t);
            break;
        case WARN:
            getLogger().warn(logMsg, t);
            break;
        case INFO:
            getLogger().info(logMsg, t);
            break;
        case DEBUG:
            getLogger().debug(logMsg, t);
            break;
        }
    }


    /**
     *
     */
    public void log(int level, Object classname, Object method, Object message, Throwable t) {
        String logMsg = "[" + classname + "] " + method + "():" + message;

        switch (level) {
        case FATAL:
            getLogger().fatal(logMsg, t);
            break;
        case ERROR:
            getLogger().error(logMsg, t);
            break;
        case WARN:
            getLogger().warn(logMsg, t);
            break;
        case INFO:
            getLogger().info(logMsg, t);
            break;
        case DEBUG:
            getLogger().debug(logMsg, t);
            break;
        }
    }
    /**
     * Translate level from string to integer
     * @param level
     * @return
     */
    public static int getLoggingLevel(String level) {
        if (level == null)
            return ALL;
        if (level.equalsIgnoreCase("ALL"))
            return LoggerUtil.ALL;
        if (level.equalsIgnoreCase("DEBUG"))
            return LoggerUtil.DEBUG;
        if (level.equalsIgnoreCase("INFO"))
            return LoggerUtil.INFO;
        if (level.equalsIgnoreCase("WARN"))
            return LoggerUtil.WARN;
        if (level.equalsIgnoreCase("ERROR"))
            return LoggerUtil.ERROR;
        if (level.equalsIgnoreCase("FATAL"))
            return LoggerUtil.FATAL;
        if (level.equalsIgnoreCase("OFF"))
            return LoggerUtil.OFF;
        return ALL;
    }

    /**
     * Translate level from integer to string
     * @param level
     * @return
     */
    public static String getLoggingLevel(int level) {
        if (level == LoggerUtil.ALL)
            return "ALL";
        if (level == LoggerUtil.DEBUG)
            return "DEBUG";
        if (level == LoggerUtil.INFO)
            return "INFO";
        if (level == LoggerUtil.WARN)
            return "WARN";
        if (level == LoggerUtil.ERROR)
            return "ERROR";
        if (level == LoggerUtil.FATAL)
            return "FATAL";
        if (level == LoggerUtil.OFF)
            return "OFF";
        return "INVALID";
    }

    /**
     * Set the repository wide (for all the loggers) Logging Level
     * @param level
     */
    public   void setLoggingLevel(int level) {
    	/*
        Logger topLogger = Logger.getRootLogger();
        if (topLogger != null)
            topLogger.setLevel(Level.toLevel(level));
            */
    	//t71mr00084282 
    	if( this.logger != null )
    		this.logger.setLevel(Level.toLevel(level));
    }
    
    public static void setNbiLoggingLevel(int level) {

        Iterator<String> iter = NBI_LOGGER_MAP.keySet().iterator();
        nLevel = level;
        while (iter.hasNext()) {
            String szKey = (String) iter.next();
            LoggerUtil logger = (LoggerUtil) NBI_LOGGER_MAP.get(szKey);
            logger.setLoggingLevel(level);

            NBI_LOGGER_MAP.remove(szKey);
            NBI_LOGGER_UPPER_MAP.remove(szKey);
            
            NBI_LOGGER_MAP.put(szKey, logger);
            NBI_LOGGER_UPPER_MAP.put(szKey.toUpperCase(), logger);
        }
    }

    /**
     * Set logger level for given logger name
     * @param loggerName
     * @param level
     */
    public final static void setLoggingLevel(String loggerName, int level) {
        Logger logger = Logger.getLogger(loggerName);
        if (logger != null)
            logger.setLevel(Level.toLevel(level));
    }
    
    public final static void setLogLevel(String loggerUpperName, int level){
        LoggerUtil logger = NBI_LOGGER_UPPER_MAP.get(loggerUpperName);
        if (logger != null) {
//            logger.getLogger().setLevel(Level.toLevel(level));
            logger.setLoggingLevel(level);
        }
    }

    /**
     * Get the logging level at root level
     */
    public static int getLoggingLevel() {
        Logger topLogger = Logger.getRootLogger();
        return topLogger.getLevel().toInt();
    }
    
    public final static int getLoggerLevel(String levelName){        
        Integer levelNumber = SUPPORTED_LEVELS.get(levelName.toUpperCase());
        return levelNumber == null ? -1 : levelNumber.intValue();
    }
    
    public final static String listLoggers(){        
        String defaultLoggerLevel = NBI_LOGGER_MAP.get(TMFNBI).getLogger().getLevel().toString();
        StringBuffer loggerCategory = new StringBuffer(NBI_LOGGER_MAP.keySet().size() * 40);
        for(Entry<String, LoggerUtil> entry:  NBI_LOGGER_MAP.entrySet()){
            Level currentLoggerLevel = entry.getValue().getLogger().getLevel();
            loggerCategory.append(entry.getKey()
                    + ":  "
                    + (SystemUtil.isNullOrBlank(currentLoggerLevel) ? defaultLoggerLevel
                            : currentLoggerLevel)  +"\n");
        }
        return loggerCategory.toString();
    }
    
    public final static boolean existedLogger(String loggerName) {

        return NBI_LOGGER_UPPER_MAP.keySet().contains(loggerName);
    }
}
