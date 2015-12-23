/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.util.FileUtil.java is created on 2007-10-19 下午02:05:06
 */
package org.feitian.pwdp.util;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.ui.window.PasswordManagerWindow;

/**
 * 
 */
public class FileUtil {

    private final static String NEW_FILE_PREFIX = Constants.NEW_FILE_PREFIX;

    public final static String generateNewFile(PasswordManagerWindow mainWindow) {

        return NEW_FILE_PREFIX + (mainWindow.getEditAreas().size() + 1);
    }

}
