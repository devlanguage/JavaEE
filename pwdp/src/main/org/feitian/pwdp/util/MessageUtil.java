/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.util.MessageUtil.java is created on 2007-10-19 上午08:48:28
 */
package org.feitian.pwdp.util;

import java.awt.Component;
import java.io.FileOutputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.feitian.pwdp.common.data.Constants;

/**
 * 
 */
public class MessageUtil {

    private static Properties MESSAGE_LIST;
    private final static Logger logger = Logger.getLogger(MessageUtil.class);

    static {
        MESSAGE_LIST = new Properties();
        try {
            MESSAGE_LIST.loadFromXML(MessageUtil.class.getClassLoader().getResourceAsStream(
                    Constants.KEY_VALUE_FILE));
        } catch (Exception e) {
            SystemUtil
                    .handleException(logger, e,
                            "Cannot found the key value file KeyValues.xml used to config the messsags and system options");
            showMessage("Cannot found the key value file KeyValues.xml used to config the messsags and system options");
        }

        // PropertyResourceBundle config = (PropertyResourceBundle) PropertyResourceBundle
        // .getBundle(LAYER_RATE_CONFIG_FILE);
        // for (Enumeration configs = config.getKeys(); configs.hasMoreElements();) {
        // String key = configs.nextElement().toString();
        // MESSAGE_LIST.setProperty(key, config.getString(key));
        // }

    }

    public final static void setMessage(String key, String value) {

        MESSAGE_LIST.setProperty(key, value);
        try {
            MESSAGE_LIST.storeToXML(new FileOutputStream(MessageUtil.class.getClassLoader()
                    .getResource(Constants.KEY_VALUE_FILE).getFile()), "Key value files");
        } catch (Exception e) {

        }
    }

    public final static String getMessage(String key) {

        return getMessage(key, null);
    }

    public final static String getMessage(String key, String defaultValue) {

        try {
            return MESSAGE_LIST.getProperty(key);
        } catch (MissingResourceException e) {
            return defaultValue;
        }
    }

    public final static void showMessage(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

    public final static void showMessage(Component parent, String message) {

        JOptionPane.showMessageDialog(parent, message);
    }
}
