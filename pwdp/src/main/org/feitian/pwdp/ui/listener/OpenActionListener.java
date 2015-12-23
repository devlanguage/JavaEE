/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.listener.OpenListener.java is created on 2007-10-19 上午08:26:17
 */
package org.feitian.pwdp.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

import org.feitian.pwdp.ui.window.PasswordManagerWindow;

/**
 * 
 */
public class OpenActionListener extends BasicActionListener {

    public OpenActionListener(Component parent) {

        super(parent);
    }

    public void actionPerformed(ActionEvent e) {

        PasswordManagerWindow parentWindow = (PasswordManagerWindow) this.parent;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(parentWindow);
        fileChooser.setAutoscrolls(true);
        fileChooser.setMultiSelectionEnabled(true);

        File[] selectedFiles = fileChooser.getSelectedFiles();
        for (File file : selectedFiles) {
            System.out.println(file);
        }
        System.err.println(fileChooser.getSelectedFile());
    }

}
