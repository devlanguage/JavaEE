/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.common.data.Constants.java is created on 2007-10-19 上午09:07:25
 */
package org.feitian.pwdp.common.data;

import javax.swing.Icon;
import javax.swing.plaf.metal.MetalIconFactory;

import org.feitian.pwdp.util.MessageUtil;

/**
 * 
 */
public class Constants {

    public final static String LAST_STORE_LOCATION = "pwdp.config.last.store.location";
    public final static String DEFAULT_CHARSET = "pwdp.config.default.charset";

    public final static String KEY_VALUE_FILE = "KeyValues.xml";
    public final static String PASSWORD_SOURCE_DATA_FILE = "passwords.xml";

    public static final String WINDOW_RESIZABLE = MessageUtil
            .getMessage("pwdp.config.window.resizable");
    public static final String WINDOW_ALWAYS_ON_TOP = MessageUtil
            .getMessage("pwdp.config.window.always_on_top");

    public static final String WINDOW_LOCATION_TOP = MessageUtil
            .getMessage("pwdp.config.window.location.top");
    public static final String WINDOW_LOCATION_LEFT = MessageUtil
            .getMessage("pwdp.config.window.location.left");
    public static final String WINDOW_DIMENSION_WIDTH = MessageUtil
            .getMessage("pwdp.config.window.dimension.width");
    public static final String WINDOW_DIMENSION_HEIGHT = MessageUtil
            .getMessage("pwdp.config.window.dimension.height");

    public static final String NEW_FILE_PREFIX = MessageUtil.getMessage(
            "pwdp.config.new.file.prefix", "Untitled");
    public static final String WINDOW_TITLE = MessageUtil.getMessage("pwdp.label.window.title");
    public final static String MENU_FILE = MessageUtil.getMessage("pwdp.label.menu.file");
    public final static String MENUITEM_FILE_NEW = MessageUtil
            .getMessage("pwdp.label.menuitem.file.new");
    public final static String MENUITEM_FILE_OPEN = MessageUtil
            .getMessage("pwdp.label.menuitem.file.open");
    public final static String MENUITEM_FILE_SAVE = MessageUtil
            .getMessage("pwdp.label.menuitem.file.save");
    public final static String MENUITEM_FILE_EXIT = MessageUtil
            .getMessage("pwdp.label.menuitem.file.exit");
    public final static String MENU_CIPHER = MessageUtil.getMessage("pwdp.label.menu.cipher");
    public static final String MENUITEM_CIPHER_ENCRYPT_BY_MD5 = MessageUtil
            .getMessage("pwdp.label.menuitem.cipher.encrypt_by_md5");
    public static final String MENUITEM_CIPHER_ENCRYPT_BY_DES = MessageUtil
            .getMessage("pwdp.label.menuitem.cipher.encrypt_by_des");
    public static final String MENUITEM_CIPHER_DECRYPT_BY_DES = MessageUtil
            .getMessage("pwdp.label.menuitem.cipher.decrypt_by_des");
    public final static String MENU_TOOL = MessageUtil.getMessage("pwdp.label.menu.tool");
    public final static String MENU_HELP = MessageUtil.getMessage("pwdp.label.menu.help");

    public static final String TOOL_BAR_FONT_BOLD = MessageUtil
            .getMessage("pwdp.label.toolbar.font.bold");
    public static final String TOOL_BAR_FONT_PLAIN = MessageUtil
            .getMessage("pwdp.label.toolbar.font.plain");
    public static final String TOOL_BAR_FONT_ITALIC = MessageUtil
            .getMessage("pwdp.label.toolbar.font.italic");
    public static final Icon TOOL_BAR_FONT_EXPAND = new MetalIconFactory.PaletteCloseIcon();
    public static final Icon TOOL_BAR_FONT_SHRINK = new MetalIconFactory.TreeLeafIcon ();

}
