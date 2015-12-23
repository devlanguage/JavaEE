/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.ui.window.FileTab.java is created on 2007-10-19 下午02:10:40
 */
package org.feitian.pwdp.ui.window;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.feitian.pwdp.common.data.BasicFonts;

/**
 * 
 */
public class EditArea extends JScrollPane {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3757594948811169482L;
    private JTextArea textArea;
    private String name;

    /**
     * @return get method for the field name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    public EditArea(String name) {

        this(BasicFonts.DEFAULT_PLAIN_MEDIUM, name);
    }

    public EditArea(Font font, String name) {

        this.setTextArea(new JTextArea());
        this.setName(name);

        textArea.setFont(font);
        setViewportView(textArea);
    }

    /**
     * @return get method for the field textArea
     */
    public JTextArea getTextArea() {

        return this.textArea;
    }

    /**
     * @param textArea
     *            the textArea to set
     */
    public void setTextArea(JTextArea textArea) {

        this.textArea = textArea;
    }

    public void setFontSize(int fontSize) {

        Font font = new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), fontSize);
        // this.setFont(font);
        textArea.setFont(null);
        textArea.setFont(font);
    }

    public void bold() {

        Font font = new Font(textArea.getFont().getName(), Font.BOLD, textArea.getFont().getSize());
        // this.setFont(font);
        textArea.setFont(null);
        textArea.setFont(font);
    }

    public void plain() {

        Font font = new Font(textArea.getFont().getName(), Font.PLAIN, textArea.getFont().getSize());
        // this.setFont(font);textArea.setFont(null);
        textArea.setFont(font);
    }

    public void italic() {

        System.out.println("italic： " + textArea.getFont());
        Font font = new Font(textArea.getFont().getName(), Font.ITALIC, textArea.getFont()
                .getSize());
        // this.setFont(font);textArea.setFont(null);
        textArea.setFont(font);

    }

    public void expand() {

        System.out.println("expand： " + textArea.getFont());
        Font font = new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea
                .getFont().getSize() + 1);
        // this.setFont(font);textArea.setFont(null);
        textArea.setFont(font);

    }

    public void shrink() {

        System.out.println("shrink： " + textArea.getFont());
        Font font = new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea
                .getFont().getSize() - 1);
        // this.setFont(font);
        textArea.setFont(null);
        textArea.setFont(font);

    }

}
