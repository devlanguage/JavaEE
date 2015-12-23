package org.feitian.chat.p2pchat.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;

import org.feitian.chat.ui.ChatServerMainUIAbstract;

public class P2pChatServerMainUI extends ChatServerMainUIAbstract {

    private static final long serialVersionUID = -2849480361584699847L;

    public P2pChatServerMainUI() {

    }

    public void updateMenuBar() {

        JMenuBar menuBar_1 = new JMenuBar();
        this.setJMenuBar(menuBar_1);

        // 1. File Menu
        JMenu fileMenu_11 = new JMenu("File");
        fileMenu_11.setMnemonic('F');
        menuBar_1.add(fileMenu_11);

        JMenuItem exitMenuItem_111 = new JMenuItem("Exit");
        exitMenuItem_111.setMnemonic(KeyEvent.VK_X);
        fileMenu_11.add(exitMenuItem_111);

        // 2. Edit Menu
        JMenu editMenu_12 = new JMenu("Edit");
        exitMenuItem_111.setMnemonic(KeyEvent.VK_E);
        menuBar_1.add(editMenu_12);

        JMenuItem copyMenuItem_121 = new JCheckBoxMenuItem("Copy");
        copyMenuItem_121.setMnemonic(KeyEvent.VK_C);
        editMenu_12.add(copyMenuItem_121);
        JMenuItem cutMenuItem_122 = new JCheckBoxMenuItem("Cut");
        editMenu_12.add(cutMenuItem_122);
        JMenuItem pasteMenuItem_123 = new JCheckBoxMenuItem("Paste");
        editMenu_12.add(pasteMenuItem_123);

        editMenu_12.addSeparator();

        JMenuItem deleteMenuItem_123 = new JMenuItem("Delete");
        deleteMenuItem_123.setArmed(true);
        deleteMenuItem_123.setEnabled(false);
        editMenu_12.add(deleteMenuItem_123);

        // 3. Tool Menu
        JMenu toolMenu_13 = new JMenu("Tool");
        menuBar_1.add(toolMenu_13);
        JMenuItem emptyIMenuItem = new JMenuItem("[Empty]");
        emptyIMenuItem.setEnabled(false);
        toolMenu_13.add(emptyIMenuItem);
    }

    public void updateCotentPanl() {

        JPanel jpanel = new JPanel();
        Container contentPanel = this.getContentPane();
        contentPanel.add(jpanel, BorderLayout.CENTER);
        //
        JTabbedPane tabbedPane = new JTabbedPane();
        jpanel.add(tabbedPane);

        JList userList = new JList(new Object[] { "Zhangsan-1", "Zhangsan-2", "Zhangsan-3", "Zhangsan-4" });
        userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        userList.setDragEnabled(true);
                
        JTree corpStructure = new JTree();
        
    
        JScrollPane leftPanel = new JScrollPane(userList);
        leftPanel.setAutoscrolls(true);
        JScrollPane rightPanel = new JScrollPane(new JTextArea(23, 23));
        rightPanel.setAutoscrolls(true);

        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPanel.setDividerSize(20);
        splitPanel.setLeftComponent(leftPanel);
        splitPanel.setRightComponent(rightPanel);

        ImageIcon icon = createImageIcon("../images/middle.gif");
        tabbedPane.addTab("Chat Server 1", icon, splitPanel, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

//        JComponent panel2 = makeTextPanel("Panel #2");
        JComponent panel2 = new UserTree();
        tabbedPane.addTab("Chat Server 2", icon, panel2, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

//        JComponent panel3 = makeTextPanel("Panel #3");
        JComponent panel3 = new UserTable();
        tabbedPane.addTab("Chat Server 3", icon, panel3, "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Chat Server 4", icon, panel4, "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        // The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // // left
        // JPanel westPanel = new JPanel();
        // contentPanel.add(westPanel, BorderLayout.WEST);
        // westPanel.add(new Button("Start"));
        //
        // // center
        // JPanel centerPanel = new JPanel();
        // contentPanel.add(centerPanel, BorderLayout.CENTER);
        // centerPanel.add(new JTextArea("Start", 33, 34));
        //
        // // right
        // JPanel eastPanel = new JPanel();
        // contentPanel.add(eastPanel, BorderLayout.EAST);
        // eastPanel.add(new Button("Start"));

    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {

        java.net.URL imgURL = P2pChatServerMainUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    protected JComponent makeTextPanel(String text) {

        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        
        JComboBox combo = new JComboBox();
        for (int i = 0; i < 5; i++) {
        combo.addItem(Integer.toString(i));
        }
        panel.add(combo);

        
        return panel;
    }

    public void updateToolBar() {

        JToolBar tb = new JToolBar();
        JButton b;
        b = new JButton("New");
        b.setRequestFocusEnabled(false);
        tb.add(b);
        b = new JButton("Open");
        b.setRequestFocusEnabled(false);
        tb.add(b);
        b = new JButton("Save");
        b.setRequestFocusEnabled(false);
        b = new JButton("Print");
        b.setRequestFocusEnabled(false);
        tb.add(b);
        b = new JButton("Preview");
        b.setRequestFocusEnabled(false);
        tb.add(b);
        tb.setFloatable(false);

        this.getContentPane().add(tb, BorderLayout.NORTH);
    }

    public void updateStatusBar() {

    }

    public void updateBasicAttribute() {

        
//        this.setResizable(true);
        // this.setClosable(true);
        // this.setIconifiable(true);
        // this.setMaximizable(true);
    }

}
