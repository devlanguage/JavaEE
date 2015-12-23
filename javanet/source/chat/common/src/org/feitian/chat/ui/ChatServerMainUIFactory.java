package org.feitian.chat.ui;

import org.feitian.chat.chatroom.ui.ChatRoomServerMainUI;
import org.feitian.chat.p2pchat.ui.P2pChatServerMainUI;

public class ChatServerMainUIFactory {

    private static ChatServerMainUIFactory factory;

    private ChatServerMainUIFactory() {

    }

    public synchronized final static ChatServerMainUIFactory getInstance() {

        if (factory == null) {
            factory = new ChatServerMainUIFactory();
        }

        return factory;
    }

    public final static IChatServerMainUI createChatServerMainUI(ChatServerType serverType) {

        ChatServerMainUIDiector chatServerMainUIDiector;
        switch (serverType) {
            case CHAT_ROOM:
                chatServerMainUIDiector = new ChatServerMainUIDiector(new ChatRoomServerMainUI());
                break;

            default:
                chatServerMainUIDiector = new ChatServerMainUIDiector(new P2pChatServerMainUI());
                break;
        }
        return chatServerMainUIDiector.decorateMainUI();
    }
}
