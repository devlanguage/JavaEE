/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.window.PasswordManagerWindow.java is created on 2007-10-19 上午08:23:10
 */
package org.feitian.pwdp.ui.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.ui.menu.PasswordManagerMenuBar;
import org.feitian.pwdp.ui.toolbar.FontToolBar;
import org.feitian.pwdp.util.FileUtil;

/**
 * 
 */
public class PasswordManagerWindow extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -9077593871186436835L;
    private JTabbedPane tabbedPane;
    private Map<String, EditArea> editAreas = new HashMap<String, EditArea>();

    public PasswordManagerWindow(String title) {

        this.setTitle(title);
        setGlobalParameter();
        buildMenuBar();
        buildMainContent();
        buildToolBar();
        buildStatusBar();

    }

    // public void addTab(String title, EditArea component) {
    //
    // tabbedPane.addTab(title, component);
    // }

    public void addEditArea(String title) {

        EditArea editArea = new EditArea(title);
        this.getEditAreas().put(title, editArea);
        tabbedPane.addTab(title, editArea);
    }

    public EditArea getSelectedEditArea() {

        return (EditArea) this.tabbedPane.getSelectedComponent();
    }

    private void buildStatusBar() {

    }

    private void buildMainContent() {

        tabbedPane = new JTabbedPane();
        if (getEditAreas().isEmpty()) {
            String newFileName = FileUtil.generateNewFile(this);
            addEditArea(newFileName);
        }
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    private void buildToolBar() {

        FontToolBar fontToolBar = new FontToolBar(this);
        fontToolBar.buildToolBar();
        this.add(fontToolBar, BorderLayout.BEFORE_FIRST_LINE);
    }

    private void buildMenuBar() {

        PasswordManagerMenuBar menuBar = new PasswordManagerMenuBar(this);
        menuBar.buildMenuBar();
        this.setJMenuBar(menuBar);

    }

    private void setGlobalParameter() {

        this.setBounds(Integer.parseInt(Constants.WINDOW_LOCATION_TOP), Integer
                .parseInt(Constants.WINDOW_LOCATION_LEFT), Integer
                .parseInt(Constants.WINDOW_DIMENSION_WIDTH), Integer
                .parseInt(Constants.WINDOW_DIMENSION_HEIGHT));
        this.setResizable(Boolean.parseBoolean(Constants.WINDOW_RESIZABLE));
        this.setAlwaysOnTop(Boolean.parseBoolean(Constants.WINDOW_ALWAYS_ON_TOP));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLUE);

    }

    /**
     * @return get method for the field editAreas
     */
    public Map<String, EditArea> getEditAreas() {

        return this.editAreas;
    }

    /**
     * @param editAreas
     *            the editAreas to set
     */
    public void setEditAreas(Map<String, EditArea> editAreas) {

        this.editAreas = editAreas;
    }

}
