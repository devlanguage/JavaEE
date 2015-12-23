/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.menu.PasswordManagerMenuBar.java is created on 2007-10-19 上午08:23:53
 */
package org.feitian.pwdp.ui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.ui.listener.CipherActionListener;
import org.feitian.pwdp.ui.listener.ExitActionListener;
import org.feitian.pwdp.ui.listener.NewActionListener;
import org.feitian.pwdp.ui.listener.OpenActionListener;
import org.feitian.pwdp.ui.listener.SaveActionListener;
import org.feitian.pwdp.ui.window.PasswordManagerWindow;

/**
 * 
 */
public class PasswordManagerMenuBar extends BasicMenuBar {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4403633467386555397L;
    private PasswordManagerWindow parentWindow;

    public PasswordManagerMenuBar(PasswordManagerWindow parentWindow) {

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
    public void buildMenuBar() {

        addFileMenu();
        addCipherMenu();
        addHelpMenu();
    }

    private void addHelpMenu() {

        JMenu helpMenu = new JMenu(Constants.MENU_HELP);

        this.add(helpMenu);
    }

    private void addCipherMenu() {

        JMenu cipherMenu = new JMenu(Constants.MENU_CIPHER);
        cipherMenu.setMnemonic('C');
        
        JMenuItem encryptByMD5MenuItem = new JMenuItem(Constants.MENUITEM_CIPHER_ENCRYPT_BY_MD5);
        encryptByMD5MenuItem.addActionListener(new CipherActionListener(parentWindow));
        cipherMenu.add(encryptByMD5MenuItem);

        JMenuItem encryptByDESMenuItem = new JMenuItem(Constants.MENUITEM_CIPHER_ENCRYPT_BY_DES);
        encryptByDESMenuItem.addActionListener(new CipherActionListener(parentWindow));
        cipherMenu.add(encryptByDESMenuItem);

        JMenuItem decryptByDESMenuItem = new JMenuItem(Constants.MENUITEM_CIPHER_DECRYPT_BY_DES);
        decryptByDESMenuItem.addActionListener(new CipherActionListener(parentWindow));
        cipherMenu.add(decryptByDESMenuItem);

        this.add(cipherMenu);
    }

    private void addFileMenu() {

        JMenu fileMenu = new JMenu(Constants.MENU_FILE);
        fileMenu.setMnemonic('F');

        JMenuItem newMenuItem = new JMenuItem(Constants.MENUITEM_FILE_NEW);
        newMenuItem.addActionListener(new NewActionListener(parentWindow));
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem(Constants.MENUITEM_FILE_OPEN);
        openMenuItem.addActionListener(new OpenActionListener(parentWindow));
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem(Constants.MENUITEM_FILE_SAVE);
        saveMenuItem.addActionListener(new SaveActionListener(parentWindow));
        fileMenu.add(saveMenuItem);

        JMenuItem exitMenuItem = new JMenuItem(Constants.MENUITEM_FILE_EXIT);
        exitMenuItem.addActionListener(new ExitActionListener(parentWindow));
        fileMenu.add(exitMenuItem);

        this.add(fileMenu);
    }

}
