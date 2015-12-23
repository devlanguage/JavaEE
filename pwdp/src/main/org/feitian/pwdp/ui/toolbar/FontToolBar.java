/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.toolbar.FontToolBar.java is created on 2007-10-19 下午03:25:01
 */
package org.feitian.pwdp.ui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.ui.window.EditArea;
import org.feitian.pwdp.ui.window.PasswordManagerWindow;

/**
 * 
 */
public class FontToolBar extends BasicToolBar {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8504338347194652108L;
    /**
     * Notes:<br>
     * You get this warning as soon as you access a private member (fields or methods) of the
     * enclosing class inside an inner class (anonymous, local or member classes).
     * 
     * The compiler uses a static access method to access the private member in order to workaround
     * the VM access violation. You cannot access directly a private member from another class. From
     * the VM point of view, an inner class is a different class and has no relation with its
     * enclosing class.
     * 
     * So doing this access to a private member you pay the price of a method invocation each time
     * you access the member at runtime. This is not the case if the member is package visible.
     * 
     */
    PasswordManagerWindow parentWindow;

    public FontToolBar(PasswordManagerWindow parentWindow) {

        this.parentWindow = parentWindow;

    }

    /**
     * @return get method for the field parentWindow
     */
    public PasswordManagerWindow getParentWindow() {

        return this.parentWindow;
    }

    /**
     * @param parentWindow
     *            the parentWindow to set
     */
    public void setParentWindow(PasswordManagerWindow parentWindow) {

        this.parentWindow = parentWindow;
    }

    @Override
    public void buildToolBar() {

        JButton btnBold = new JButton(Constants.TOOL_BAR_FONT_BOLD);
        btnBold.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                EditArea editArea = parentWindow.getSelectedEditArea();
                editArea.bold();
            }
        });
        add(btnBold);

        JButton btnPlain = new JButton(Constants.TOOL_BAR_FONT_PLAIN);
        btnPlain.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                EditArea editArea = parentWindow.getSelectedEditArea();
                editArea.plain();
            }
        });
        add(btnPlain);

        JButton btnItalic = new JButton(Constants.TOOL_BAR_FONT_ITALIC);
        btnItalic.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                EditArea editArea = parentWindow.getSelectedEditArea();
                // String selectedText = editArea.getTextArea().getSelectedText();
                editArea.italic();

                // editArea.setSelectionStart(editArea.getSelectionStart());
                // editArea.setSelectionEnd(editArea.getSelectionEnd());
            }
        });
        add(btnItalic);

        JButton btnExpand = new JButton(Constants.TOOL_BAR_FONT_EXPAND);
        btnExpand.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                EditArea editArea = parentWindow.getSelectedEditArea();
                editArea.expand();
            }
        });
        add(btnExpand);

        JButton btnShrink = new JButton(Constants.TOOL_BAR_FONT_SHRINK);
        btnShrink.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                EditArea editArea = parentWindow.getSelectedEditArea();
                editArea.shrink();
            }
        });
        add(btnShrink);
    }

}
