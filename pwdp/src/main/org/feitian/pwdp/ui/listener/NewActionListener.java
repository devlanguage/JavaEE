/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.listener.NewListener.java is created on 2007-10-19 上午08:27:51
 */
package org.feitian.pwdp.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;

import org.feitian.pwdp.ui.window.PasswordManagerWindow;
import org.feitian.pwdp.util.FileUtil;

/**
 * 
 */
public class NewActionListener extends BasicActionListener {

    public NewActionListener(Component parent) {

        super(parent);
    }

    public void actionPerformed(ActionEvent e) {

        PasswordManagerWindow parent = (PasswordManagerWindow) this.parent;        
        parent.addEditArea(FileUtil.generateNewFile(parent));
        
    }
}
