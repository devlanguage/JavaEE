/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.listener.SaveActionListener.java is created on 2007-10-19 上午08:26:57
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
public class SaveActionListener extends BasicActionListener {

    public SaveActionListener(Component parent) {

        super(parent);
    }

    public void actionPerformed(ActionEvent e) {

        PasswordManagerWindow parentWindow = (PasswordManagerWindow) this.parent;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(parentWindow);        
        fileChooser.setAutoscrolls(true);
        
        fileChooser.setMultiSelectionEnabled(true);

        File[] selectedFiles = fileChooser.getSelectedFiles();
//        for (File file : selectedFiles) {
            System.out.println(fileChooser.getSelectedFile());
//        }

    }
}
