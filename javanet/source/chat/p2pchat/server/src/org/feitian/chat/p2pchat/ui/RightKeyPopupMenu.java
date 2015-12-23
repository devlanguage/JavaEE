package org.feitian.chat.p2pchat.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

public class RightKeyPopupMenu extends JPopupMenu implements ActionListener {

    JMenuItem sayHello, sayHelloAgain, sayByeBye;

    public RightKeyPopupMenu(JTree tree) {

        sayHello = new JMenuItem("Say Hello");
        sayHelloAgain = new JMenuItem("Say Hello again");
        sayByeBye = new JMenuItem("Say Bye Bye");
        sayHello.addActionListener(this);
        sayHelloAgain.addActionListener(this);
        sayByeBye.addActionListener(this);
        add(sayHello);
        this.addSeparator();
        add(sayHelloAgain);
        add(sayByeBye);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sayHello) {
            System.out.println();
        } else if (e.getSource() == sayHelloAgain) {
            System.out.println("Hello! Hello!");
        } else if (e.getSource() == sayByeBye) {
            System.out.println("Bye Bye!");
        }
    }

}
