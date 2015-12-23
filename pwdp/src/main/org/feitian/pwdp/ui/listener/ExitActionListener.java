/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.listener.ExitActionListener.java is created on 2007-10-19 上午08:27:24
 */
package org.feitian.pwdp.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class ExitActionListener extends BasicActionListener {

    public ExitActionListener(Component parent) {

        super(parent);

    }

    public void actionPerformed(ActionEvent e) {

        System.exit(0);
    }
}
