package org.feitian.chat.ui;

import javax.swing.JFrame;

import org.feitian.chat.util.FChatConstant;
import org.feitian.chat.util.PropertyUtil;

public abstract class ChatServerMainUIAbstract extends JFrame implements IChatServerMainUI {

    public void init() {

        this.setBounds(Integer.parseInt(PropertyUtil.getMessage(FChatConstant.MAINUI_POSITION_LEFT)), Integer
                .parseInt(PropertyUtil.getMessage(FChatConstant.MAINUI_POSITION_TOP)), Integer.parseInt(PropertyUtil
                .getMessage(FChatConstant.MAINUI_SIZE_WIDTH)), Integer.parseInt(PropertyUtil
                .getMessage(FChatConstant.MAINUI_SIZE_HEIGHT)));
    }

    public void display() {

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void updateBasicAttribute() {

    }

    public void updateMenuBar() {

    }

    public void updateToolBar() {

    }

    public void updateCotentPanl() {

    }

    public void updateStatusBar() {

    }

    public void processBasicEvent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
