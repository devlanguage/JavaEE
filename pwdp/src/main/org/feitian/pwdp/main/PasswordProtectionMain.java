/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.main.PasswordProtectionUtiity.java is created on 2007-10-19 上午08:20:52
 */
package org.feitian.pwdp.main;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.ui.window.PasswordManagerWindow;

/**
 * 
 */
public class PasswordProtectionMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // -Dswing.defaultlaf=org.fife.plaf.OfficeXP.OfficeXPLookAndFeel
        // org.fife.plaf.Office2003.Office2003LookAndFeel
        // org.fife.plaf.VisualStudio2005.VisualStudio2005LookAndFeel
        // javax.swing.plaf.metal.MetalLookAndFeel
        new PasswordManagerWindow(Constants.WINDOW_TITLE).setVisible(true);
    }
}
