/**
 * 
 */
package org.feitian.chat.p2pchat.main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.feitian.chat.ui.ChatServerMainUIFactory;
import org.feitian.chat.ui.ChatServerType;
import org.feitian.chat.ui.IChatServerMainUI;

/**
 * @author feiye
 * 
 */
public class P2pServerMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // String lookAndFeel = "";
        // lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        // lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
        // lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        // lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                // Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
            }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        IChatServerMainUI p2pServer = ChatServerMainUIFactory.createChatServerMainUI(ChatServerType.P2P_CHAT);
        p2pServer.display();
    }
}
