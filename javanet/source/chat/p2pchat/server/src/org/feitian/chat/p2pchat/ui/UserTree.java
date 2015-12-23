package org.feitian.chat.p2pchat.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

// Takes an array of Strings and makes the first
// element a node and the rest leaves:
class Branch {

    DefaultMutableTreeNode r;

    public Branch(String[] data) {

        r = new DefaultMutableTreeNode(data[0]);
        for (int i = 1; i < data.length; i++)
            r.add(new DefaultMutableTreeNode(data[i]));
    }

    public DefaultMutableTreeNode node() {

        return r;
    }
}

public class UserTree extends JPanel {

    String[][] data = { { "Colors", "Red", "Blue", "Green" }, { "Flavors", "Tart", "Sweet", "Bland" },
            { "Length", "Short", "Medium", "Long" }, { "Volume", "High", "Medium", "Low" },
            { "Temperature", "High", "Medium", "Low" }, { "Intensity", "High", "Medium", "Low" }, };
    static int i = 0;
    DefaultMutableTreeNode root, child, chosen;
    JTree tree;
    DefaultTreeModel model;

    public UserTree() {

        setLayout(new BorderLayout());
        this.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {

                System.out.println(e.getClickCount());
                System.out.println(e.getButton());
                System.out.println(e.getPoint());

            }

            public void mouseEntered(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mouseExited(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mousePressed(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mouseReleased(MouseEvent e) {

                // TODO Auto-generated method stub

            }
        });
        root = new DefaultMutableTreeNode("root");
        tree = new JTree(root);
        // Add it and make it take care of scrolling:
        add(new JScrollPane(tree), BorderLayout.CENTER);
        // Capture the tree's model:
        model = (DefaultTreeModel) tree.getModel();
        JButton test = new JButton("Press me");
        test.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (i < data.length) {
                    child = new Branch(data[i++]).node();
                    // What's the last one you clicked?
                    chosen = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (chosen == null)
                        chosen = root;
                    // The model will create the
                    // appropriate event. In response, the
                    // tree will update itself:
                    model.insertNodeInto(child, chosen, 0);
                    // This puts the new node on the
                    // currently chosen node.
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {

                System.out.println(e.getSource());
                System.out.println(e.getNewLeadSelectionPath());
                System.out.println(e.getOldLeadSelectionPath());
                System.out.println(e.getPath());

            }
        });
        final RightKeyPopupMenu popup = new RightKeyPopupMenu(tree);
        tree.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {

                if (e.isMetaDown()) {
                    System.out.println("right click");
                    popup.show((Component) tree, e.getX(), e.getY());

                } else {
                    System.out.println("left");
                }

                if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
                    System.out.println("Left_Click");
                } else if ((e.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
                    System.out.println("Middle_Click");
                } else if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                    System.out.println("Right_Click");
                } else if ((e.getModifiers() & InputEvent.ALT_DOWN_MASK) != 0) {
                    System.out.println("ALT_DOWN_MASK");
                } else if ((e.getModifiers() & InputEvent.SHIFT_DOWN_MASK) != 0) {
                    System.out.println("SHIFT_DOWN_MASK");
                } else if ((e.getModifiers() & InputEvent.CTRL_DOWN_MASK) != 0) {
                    System.out.println("CTRL_DOWN_MASK");
                } else {
                    System.out.println("ELSE");
                }

                System.out.println(e.getClickCount());
                System.out.println(e.getButton());
                System.out.println(e.getPoint());
                System.out.println(e.getSource());
                JTree jtree = (JTree) e.getSource();
                System.out.println(jtree.getSelectionModel());

            }

            public void mouseEntered(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mouseExited(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mousePressed(MouseEvent e) {

                // TODO Auto-generated method stub

            }

            public void mouseReleased(MouseEvent e) {

                // TODO Auto-generated method stub

            }
        });

        // Change the button's colors:
        test.setBackground(Color.blue);
        test.setForeground(Color.white);
        JPanel p = new JPanel();
        p.add(test);
        add(p, BorderLayout.SOUTH);
    }

} // /:~
