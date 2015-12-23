/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.common.util.MessageUtil.java is created on Sep 26, 2007 11:25:26 AM
 */
package org.feitian.chat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;

import org.feitian.chat.exception.FChatException;

public class PropertyUtil {

    private static final FChatLogger logger = FChatLogger.getLogger(PropertyUtil.class);
    private static Properties PROPERTY_LIST;
    // private final static Logger logger = Logger.getLogger(MessageUtil.class);

    static {
        PROPERTY_LIST = new Properties();
        try {
            PROPERTY_LIST.load(PropertyUtil.class.getClassLoader().getResourceAsStream(FChatConstant.COMMON_MESSAGES));
            PropertyUtil.addMessages(PROPERTY_LIST.getProperty(FChatConstant.FILE_P2PCHAT_UI), null, null);
        } catch (Exception e) {
            SystemUtil.catchException(logger, "Failed to load the configuration information", e);
        }
    }

    public final static String getMessage(String key) {

        return getMessage(key, null);
    }

    public final static String getMessage(String key, String defaultValue) {

        try {
            return PROPERTY_LIST.getProperty(key);
        } catch (MissingResourceException e) {
            return defaultValue;
        }
    }

    public final static void addMessage(String key, String defaultValue) {

        PROPERTY_LIST.put(key, defaultValue);

    }

    public final static void addMessages(Map<Object, Object> messageEntries) {

        PROPERTY_LIST.putAll(messageEntries);
    }

    /**
     * @param messageFile
     * @param fileType
     * @param relativePath
     * @throws FChatException
     */
    public final static void addMessages(String messageFile, FileType fileType, RelativePath relativePath)
            throws FChatException {

        fileType = fileType == null ? FileType.PROPERTIES : fileType;
        relativePath = relativePath == null ? RelativePath.CLASS_PATH : relativePath;

        InputStream ins = null;
        Properties messageEntries = new Properties();
        try {
            switch (relativePath) {
                case CLASS_PATH: {
                    messageEntries.load(StreamUtil.getInputStreamFromClassPath(messageFile));
                    PROPERTY_LIST.putAll(messageEntries);
                    break;
                }

                case OPERATE_SYSTEM_ABSOLUTE_PATH: {
                    messageEntries.load(StreamUtil.getInputStreamFromAbosulateClassPath(messageFile));
                    PROPERTY_LIST.putAll(messageEntries);
                    break;
                }

                default:
                    break;

            }
        } catch (IOException e) {
            SystemUtil.catchException(logger, "Failed to load the message file [FilePath=" + messageFile + "", e);
        } finally {
            StreamUtil.close(ins);
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println(PROPERTY_LIST.getProperty(FChatConstant.FILE_P2PCHAT_UI));
//        System.out.println(PROPERTY_LIST.getProperty(FChatConstant.MAINUI_POSITION_LEFT));
//        try {
//            PropertyUtil.addMessages(PROPERTY_LIST.getProperty(FChatConstant.FILE_P2PCHAT_UI), null, null);
//            // MessageUtil.addMessages("config.properties", null, null);
//        } catch (FChatException e) {
//            SystemUtil.catchException(logger, "", e);
//
//        }
//    }
}
