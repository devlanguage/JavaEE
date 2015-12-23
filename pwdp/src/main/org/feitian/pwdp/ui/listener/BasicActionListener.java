/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.listener.BasicActionListener.java is created on 2007-10-19 上午08:25:19
 */
package org.feitian.pwdp.ui.listener;

import java.awt.Component;
import java.awt.event.ActionListener;

/**
 * 
 */
public abstract class BasicActionListener implements ActionListener {

    protected Component parent;

    protected BasicActionListener(Component parent) {

        this.parent = parent;
    }

    /**
     * @return get method for the field parent
     */
    public Component getParent() {

        return this.parent;
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(Component parent) {

        this.parent = parent;
    }
}
