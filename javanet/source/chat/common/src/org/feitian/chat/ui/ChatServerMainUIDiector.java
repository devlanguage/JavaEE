/**
 * 
 */
package org.feitian.chat.ui;

/**
 * @author feiye
 * 
 */
public class ChatServerMainUIDiector {

    private ChatServerMainUIAbstract mainUI;

    public ChatServerMainUIDiector(ChatServerMainUIAbstract mainUI) {

        this.mainUI = mainUI;
    }

    public ChatServerMainUIAbstract decorateMainUI() {

        mainUI.init();
        mainUI.updateMenuBar();
        mainUI.updateToolBar();
        mainUI.updateCotentPanl();
        mainUI.updateStatusBar();
        mainUI.processBasicEvent();
        
        return mainUI;
    }
}
