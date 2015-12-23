package org.feitian.chat.p2pchat.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

class UseRightButton extends JFrame implements MouseListener {

    JPanel panel;
    JLabel display;

    public UseRightButton() {

        setTitle("Use right button and popup menu");
        setSize(400, 300);
        panel = new JPanel();
        display = new JLabel(" ");
        display.setOpaque(true);
        display.setBackground(Color.yellow);
        panel.add(display);
        panel.addMouseListener(this);
        display.addMouseListener(this);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public final static void main(String[] args) {

        UseRightButton rb = new UseRightButton();
        rb.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {

        if (e.getSource() == panel && e.getButton() == MouseEvent.BUTTON3) {
            MyPopupMenu popup = new MyPopupMenu(this);
            popup.show((Component) panel, e.getX(), e.getY());
        } else if (e.getSource() == display && e.getButton() == MouseEvent.BUTTON3) {
            MyPopupMenu popup = new MyPopupMenu(this);
            popup.show((Component) display, e.getX(), e.getY());
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
}

public class MyPopupMenu extends JPopupMenu implements ActionListener {

    JMenuItem sayHello, sayHelloAgain, sayByeBye;
    UseRightButton useRightButton;

    public MyPopupMenu(UseRightButton urb) {

        useRightButton = urb;
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
            useRightButton.display.setText("Hello!");
        } else if (e.getSource() == sayHelloAgain) {
            System.out.println("Hello! Hello!");
            useRightButton.display.setText("Hello! Hello!");
        } else if (e.getSource() == sayByeBye) {
            System.out.println("Bye Bye!");
            useRightButton.display.setText("Bye Bye!");
        }
    }
}
