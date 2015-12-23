/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.common.data.BasicFont.java is created on 2007-10-19 下午02:30:08
 */
package org.feitian.pwdp.common.data;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

/**
 * <pre>
 *  Agency FB,
 *  Arial,
 *  Arial Black,
 *  Arial Narrow,
 *  Arial Rounded MT Bold,
 *  Basemic,
 *  Basemic Symbol,
 *  Basemic Times,
 *  Batang,
 *  BatangChe,
 *  Blackadder ITC,
 *  Bodoni MT,
 *  Bodoni MT Black,
 *  Bodoni MT Condensed,
 *  Book Antiqua,
 *  Bookman Old Style,
 *  Bookshelf Symbol 7,
 *  Bradley Hand ITC,
 *  Calisto MT,
 *  Castellar,
 *  Century Gothic,
 *  Century Schoolbook,
 *  Comic Sans MS,
 *  Copperplate Gothic Bold,
 *  Copperplate Gothic Light,
 *  Courier New,
 *  Curlz MT,
 *  Dialog,
 *  DialogInput,
 *  Dotum,
 *  DotumChe,
 *  Edwardian Script ITC,
 *  Elephant,
 *  Engravers MT,
 *  Eras Bold ITC,
 *  Eras Demi ITC,
 *  Eras Light ITC,
 *  Eras Medium ITC,
 *  Estrangelo Edessa,
 *  Felix Titling,
 *  Forte,
 *  Franklin Gothic Book,
 *  Franklin Gothic Demi,
 *  Franklin Gothic Demi Cond,
 *  Franklin Gothic Heavy,
 *  Franklin Gothic Medium,
 *  Franklin Gothic Medium Cond,
 *  French Script MT,
 *  Garamond,
 *  Gautami,
 *  Georgia,
 *  Gigi,
 *  Gill Sans MT,
 *  Gill Sans MT Condensed,
 *  Gill Sans MT Ext Condensed Bold,
 *  Gill Sans Ultra Bold,
 *  Gill Sans Ultra Bold Condensed,
 *  Gloucester MT Extra Condensed,
 *  Goudy Old Style,
 *  Goudy Stout,
 *  Gulim,
 *  GulimChe,
 *  Gungsuh,
 *  GungsuhChe,
 *  Haettenschweiler,
 *  Impact,
 *  Imprint MT Shadow,
 *  Kartika,
 *  Kingsoft Phonetic Plain,
 *  Latha,
 *  Lucida Bright,
 *  Lucida Console,
 *  Lucida Sans,
 *  Lucida Sans Typewriter,
 *  Lucida Sans Unicode,
 *  Maiandra GD,
 *  Mangal,
 *  Marlett,
 *  MentorGDT,
 *  MentorSTD,
 *  Microsoft Sans Serif,
 *  MingLiU,
 *  Monospaced,
 *  Monotype Corsiva,
 *  MS Gothic,
 *  MS Mincho,
 *  MS Outlook,
 *  MS PGothic,
 *  MS PMincho,
 *  MS Reference Sans Serif,
 *  MS Reference Specialty,
 *  MS UI Gothic,
 *  MV Boli,
 *  NSimSun,
 *  OCR A Extended,
 *  Palace Script MT,
 *  Palatino Linotype,
 *  Papyrus,
 *  Perpetua,
 *  Perpetua Titling MT,
 *  PMingLiU,
 *  Pristina,
 *  Raavi,
 *  Rage Italic,
 *  Rockwell,
 *  Rockwell Condensed,
 *  Rockwell Extra Bold,
 *  SansSerif,
 *  SAPDings,
 *  Script MT Bold,
 *  Serif,
 *  Shruti,
 *  SimHei,
 *  SimSun,
 *  Sylfaen,
 *  Symbol,
 *  Tahoma,
 *  Times New Roman,
 *  Trebuchet MS,
 *  Tunga,
 *  Tw Cen MT,
 *  Tw Cen MT Condensed,
 *  Tw Cen MT Condensed Extra Bold,
 *  Verdana,
 *  VeriBest BC,
 *  VeriBest Gerber 0,
 *  VeriBest Gerber 1,
 *  Vrinda,
 *  Webdings,
 *  Wingdings,
 *  Wingdings 2,
 *  Wingdings 3;
 *  
 *  family=Agency FB,name=Agency FB,style=plain,size=1]
 *  family=Agency FB,name=Agency FB Bold,style=plain,size=1]
 *  family=Arial,name=Arial,style=plain,size=1]
 *  family=Arial Black,name=Arial Black,style=plain,size=1]
 *  family=Arial,name=Arial Bold,style=plain,size=1]
 *  family=Arial,name=Arial Bold Italic,style=plain,size=1]
 *  family=Arial,name=Arial Italic,style=plain,size=1]
 *  family=Arial Narrow,name=Arial Narrow,style=plain,size=1]
 *  family=Arial Narrow,name=Arial Narrow Bold,style=plain,size=1]
 *  family=Arial Narrow,name=Arial Narrow Bold Italic,style=plain,size=1]
 *  family=Arial Narrow,name=Arial Narrow Italic,style=plain,size=1]
 *  family=Arial Rounded MT Bold,name=Arial Rounded MT Bold,style=plain,size=1]
 *  family=Basemic,name=Basemic,style=plain,size=1]
 *  family=Basemic Symbol,name=Basemic Symbol,style=plain,size=1]
 *  family=Basemic Times,name=Basemic Times,style=plain,size=1]
 *  family=Batang,name=Batang,style=plain,size=1]
 *  family=BatangChe,name=BatangChe,style=plain,size=1]
 *  family=Blackadder ITC,name=Blackadder ITC,style=plain,size=1]
 *  family=Bodoni MT,name=Bodoni MT,style=plain,size=1]
 *  family=Bodoni MT Black,name=Bodoni MT Black,style=plain,size=1]
 *  family=Bodoni MT Black,name=Bodoni MT Black Italic,style=plain,size=1]
 *  family=Bodoni MT,name=Bodoni MT Bold,style=plain,size=1]
 *  family=Bodoni MT,name=Bodoni MT Bold Italic,style=plain,size=1]
 *  family=Bodoni MT Condensed,name=Bodoni MT Condensed,style=plain,size=1]
 *  family=Bodoni MT Condensed,name=Bodoni MT Condensed Bold,style=plain,size=1]
 *  family=Bodoni MT Condensed,name=Bodoni MT Condensed Bold Italic,style=plain,size=1]
 *  family=Bodoni MT Condensed,name=Bodoni MT Condensed Italic,style=plain,size=1]
 *  family=Bodoni MT,name=Bodoni MT Italic,style=plain,size=1]
 *  family=Book Antiqua,name=Book Antiqua,style=plain,size=1]
 *  family=Book Antiqua,name=Book Antiqua Bold,style=plain,size=1]
 *  family=Book Antiqua,name=Book Antiqua Bold Italic,style=plain,size=1]
 *  family=Book Antiqua,name=Book Antiqua Italic,style=plain,size=1]
 *  family=Bookman Old Style,name=Bookman Old Style,style=plain,size=1]
 *  family=Bookman Old Style,name=Bookman Old Style Bold,style=plain,size=1]
 *  family=Bookman Old Style,name=Bookman Old Style Bold Italic,style=plain,size=1]
 *  family=Bookman Old Style,name=Bookman Old Style Italic,style=plain,size=1]
 *  family=Bookshelf Symbol 7,name=Bookshelf Symbol 7,style=plain,size=1]
 *  family=Bradley Hand ITC,name=Bradley Hand ITC,style=plain,size=1]
 *  family=Calisto MT,name=Calisto MT,style=plain,size=1]
 *  family=Calisto MT,name=Calisto MT Bold,style=plain,size=1]
 *  family=Calisto MT,name=Calisto MT Bold Italic,style=plain,size=1]
 *  family=Calisto MT,name=Calisto MT Italic,style=plain,size=1]
 *  family=Castellar,name=Castellar,style=plain,size=1]
 *  family=Century Gothic,name=Century Gothic,style=plain,size=1]
 *  family=Century Gothic,name=Century Gothic Bold,style=plain,size=1]
 *  family=Century Gothic,name=Century Gothic Bold Italic,style=plain,size=1]
 *  family=Century Gothic,name=Century Gothic Italic,style=plain,size=1]
 *  family=Century Schoolbook,name=Century Schoolbook,style=plain,size=1]
 *  family=Century Schoolbook,name=Century Schoolbook Bold,style=plain,size=1]
 *  family=Century Schoolbook,name=Century Schoolbook Bold Italic,style=plain,size=1]
 *  family=Century Schoolbook,name=Century Schoolbook Italic,style=plain,size=1]
 *  family=Comic Sans MS,name=Comic Sans MS,style=plain,size=1]
 *  family=Comic Sans MS,name=Comic Sans MS Bold,style=plain,size=1]
 *  family=Copperplate Gothic Bold,name=Copperplate Gothic Bold,style=plain,size=1]
 *  family=Copperplate Gothic Light,name=Copperplate Gothic Light,style=plain,size=1]
 *  family=Courier New,name=Courier New,style=plain,size=1]
 *  family=Courier New,name=Courier New Bold,style=plain,size=1]
 *  family=Courier New,name=Courier New Bold Italic,style=plain,size=1]
 *  family=Courier New,name=Courier New Italic,style=plain,size=1]
 *  family=Curlz MT,name=Curlz MT,style=plain,size=1]
 *  family=Dialog,name=Dialog.bold,style=plain,size=1]
 *  family=Dialog,name=Dialog.bolditalic,style=plain,size=1]
 *  family=Dialog,name=Dialog.italic,style=plain,size=1]
 *  family=Dialog,name=Dialog.plain,style=plain,size=1]
 *  family=DialogInput,name=DialogInput.bold,style=plain,size=1]
 *  family=DialogInput,name=DialogInput.bolditalic,style=plain,size=1]
 *  family=DialogInput,name=DialogInput.italic,style=plain,size=1]
 *  family=DialogInput,name=DialogInput.plain,style=plain,size=1]
 *  family=Dotum,name=Dotum,style=plain,size=1]
 *  family=DotumChe,name=DotumChe,style=plain,size=1]
 *  family=Edwardian Script ITC,name=Edwardian Script ITC,style=plain,size=1]
 *  family=Elephant,name=Elephant,style=plain,size=1]
 *  family=Elephant,name=Elephant Italic,style=plain,size=1]
 *  family=Engravers MT,name=Engravers MT,style=plain,size=1]
 *  family=Eras Bold ITC,name=Eras Bold ITC,style=plain,size=1]
 *  family=Eras Demi ITC,name=Eras Demi ITC,style=plain,size=1]
 *  family=Eras Light ITC,name=Eras Light ITC,style=plain,size=1]
 *  family=Eras Medium ITC,name=Eras Medium ITC,style=plain,size=1]
 *  family=Estrangelo Edessa,name=Estrangelo Edessa,style=plain,size=1]
 *  family=Felix Titling,name=Felix Titling,style=plain,size=1]
 *  family=Forte,name=Forte,style=plain,size=1]
 *  family=Franklin Gothic Book,name=Franklin Gothic Book,style=plain,size=1]
 *  family=Franklin Gothic Book,name=Franklin Gothic Book Italic,style=plain,size=1]
 *  family=Franklin Gothic Demi,name=Franklin Gothic Demi,style=plain,size=1]
 *  family=Franklin Gothic Demi Cond,name=Franklin Gothic Demi Cond,style=plain,size=1]
 *  family=Franklin Gothic Demi,name=Franklin Gothic Demi Italic,style=plain,size=1]
 *  family=Franklin Gothic Heavy,name=Franklin Gothic Heavy,style=plain,size=1]
 *  family=Franklin Gothic Heavy,name=Franklin Gothic Heavy Italic,style=plain,size=1]
 *  family=Franklin Gothic Medium,name=Franklin Gothic Medium,style=plain,size=1]
 *  family=Franklin Gothic Medium Cond,name=Franklin Gothic Medium Cond,style=plain,size=1]
 *  family=Franklin Gothic Medium,name=Franklin Gothic Medium Italic,style=plain,size=1]
 *  family=French Script MT,name=French Script MT,style=plain,size=1]
 *  family=Garamond,name=Garamond,style=plain,size=1]
 *  family=Garamond,name=Garamond Bold,style=plain,size=1]
 *  family=Garamond,name=Garamond Italic,style=plain,size=1]
 *  family=Gautami,name=Gautami,style=plain,size=1]
 *  family=Georgia,name=Georgia,style=plain,size=1]
 *  family=Georgia,name=Georgia Bold,style=plain,size=1]
 *  family=Georgia,name=Georgia Bold Italic,style=plain,size=1]
 *  family=Georgia,name=Georgia Italic,style=plain,size=1]
 *  family=Gigi,name=Gigi,style=plain,size=1]
 *  family=Gill Sans MT,name=Gill Sans MT,style=plain,size=1]
 *  family=Gill Sans MT,name=Gill Sans MT Bold,style=plain,size=1]
 *  family=Gill Sans MT,name=Gill Sans MT Bold Italic,style=plain,size=1]
 *  family=Gill Sans MT Condensed,name=Gill Sans MT Condensed,style=plain,size=1]
 *  family=Gill Sans MT Ext Condensed Bold,name=Gill Sans MT Ext Condensed Bold,style=plain,size=1]
 *  family=Gill Sans MT,name=Gill Sans MT Italic,style=plain,size=1]
 *  family=Gill Sans Ultra Bold,name=Gill Sans Ultra Bold,style=plain,size=1]
 *  family=Gill Sans Ultra Bold Condensed,name=Gill Sans Ultra Bold Condensed,style=plain,size=1]
 *  family=Gloucester MT Extra Condensed,name=Gloucester MT Extra Condensed,style=plain,size=1]
 *  family=Goudy Old Style,name=Goudy Old Style,style=plain,size=1]
 *  family=Goudy Old Style,name=Goudy Old Style Bold,style=plain,size=1]
 *  family=Goudy Old Style,name=Goudy Old Style Italic,style=plain,size=1]
 *  family=Goudy Stout,name=Goudy Stout,style=plain,size=1]
 *  family=Gulim,name=Gulim,style=plain,size=1]
 *  family=GulimChe,name=GulimChe,style=plain,size=1]
 *  family=Gungsuh,name=Gungsuh,style=plain,size=1]
 *  family=GungsuhChe,name=GungsuhChe,style=plain,size=1]
 *  family=Haettenschweiler,name=Haettenschweiler,style=plain,size=1]
 *  family=Impact,name=Impact,style=plain,size=1]
 *  family=Imprint MT Shadow,name=Imprint MT Shadow,style=plain,size=1]
 *  family=Kartika,name=Kartika,style=plain,size=1]
 *  family=Kingsoft Phonetic Plain,name=Kingsoft Phonetic,style=plain,size=1]
 *  family=Latha,name=Latha,style=plain,size=1]
 *  family=Lucida Bright,name=Lucida Bright Demibold,style=plain,size=1]
 *  family=Lucida Bright,name=Lucida Bright Demibold Italic,style=plain,size=1]
 *  family=Lucida Bright,name=Lucida Bright Italic,style=plain,size=1]
 *  family=Lucida Bright,name=Lucida Bright Regular,style=plain,size=1]
 *  family=Lucida Console,name=Lucida Console,style=plain,size=1]
 *  family=Lucida Sans,name=Lucida Sans Demibold,style=plain,size=1]
 *  family=Lucida Sans,name=Lucida Sans Demibold Italic,style=plain,size=1]
 *  family=Lucida Sans,name=Lucida Sans Demibold Roman,style=plain,size=1]
 *  family=Lucida Sans,name=Lucida Sans Italic,style=plain,size=1]
 *  family=Lucida Sans,name=Lucida Sans Regular,style=plain,size=1]
 *  family=Lucida Sans Typewriter,name=Lucida Sans Typewriter Bold,style=plain,size=1]
 *  family=Lucida Sans Typewriter,name=Lucida Sans Typewriter Bold Oblique,style=plain,size=1]
 *  family=Lucida Sans Typewriter,name=Lucida Sans Typewriter Oblique,style=plain,size=1]
 *  family=Lucida Sans Typewriter,name=Lucida Sans Typewriter Regular,style=plain,size=1]
 *  family=Lucida Sans Unicode,name=Lucida Sans Unicode,style=plain,size=1]
 *  family=MS Gothic,name=MS Gothic,style=plain,size=1]
 *  family=MS Mincho,name=MS Mincho,style=plain,size=1]
 *  family=MS Outlook,name=MS Outlook,style=plain,size=1]
 *  family=MS PGothic,name=MS PGothic,style=plain,size=1]
 *  family=MS PMincho,name=MS PMincho,style=plain,size=1]
 *  family=MS Reference Sans Serif,name=MS Reference Sans Serif,style=plain,size=1]
 *  family=MS Reference Specialty,name=MS Reference Specialty,style=plain,size=1]
 *  family=MS UI Gothic,name=MS UI Gothic,style=plain,size=1]
 *  family=MV Boli,name=MV Boli,style=plain,size=1]
 *  family=Maiandra GD,name=Maiandra GD,style=plain,size=1]
 *  family=Mangal,name=Mangal,style=plain,size=1]
 *  family=Marlett,name=Marlett,style=plain,size=1]
 *  family=MentorGDT,name=MentorGDT,style=plain,size=1]
 *  family=MentorSTD,name=MentorSTD,style=plain,size=1]
 *  family=Microsoft Sans Serif,name=Microsoft Sans Serif,style=plain,size=1]
 *  family=MingLiU,name=MingLiU,style=plain,size=1]
 *  family=Monospaced,name=Monospaced.bold,style=plain,size=1]
 *  family=Monospaced,name=Monospaced.bolditalic,style=plain,size=1]
 *  family=Monospaced,name=Monospaced.italic,style=plain,size=1]
 *  family=Monospaced,name=Monospaced.plain,style=plain,size=1]
 *  family=Monotype Corsiva,name=Monotype Corsiva,style=plain,size=1]
 *  family=NSimSun,name=NSimSun,style=plain,size=1]
 *  family=OCR A Extended,name=OCR A Extended,style=plain,size=1]
 *  family=PMingLiU,name=PMingLiU,style=plain,size=1]
 *  family=Palace Script MT,name=Palace Script MT,style=plain,size=1]
 *  family=Palatino Linotype,name=Palatino Linotype,style=plain,size=1]
 *  family=Palatino Linotype,name=Palatino Linotype Bold,style=plain,size=1]
 *  family=Palatino Linotype,name=Palatino Linotype Bold Italic,style=plain,size=1]
 *  family=Palatino Linotype,name=Palatino Linotype Italic,style=plain,size=1]
 *  family=Papyrus,name=Papyrus,style=plain,size=1]
 *  family=Perpetua,name=Perpetua,style=plain,size=1]
 *  family=Perpetua,name=Perpetua Bold,style=plain,size=1]
 *  family=Perpetua,name=Perpetua Bold Italic,style=plain,size=1]
 *  family=Perpetua,name=Perpetua Italic,style=plain,size=1]
 *  family=Perpetua Titling MT,name=Perpetua Titling MT Bold,style=plain,size=1]
 *  family=Perpetua Titling MT,name=Perpetua Titling MT Light,style=plain,size=1]
 *  family=Pristina,name=Pristina,style=plain,size=1]
 *  family=Raavi,name=Raavi,style=plain,size=1]
 *  family=Rage Italic,name=Rage Italic,style=plain,size=1]
 *  family=Rockwell,name=Rockwell,style=plain,size=1]
 *  family=Rockwell,name=Rockwell Bold,style=plain,size=1]
 *  family=Rockwell,name=Rockwell Bold Italic,style=plain,size=1]
 *  family=Rockwell Condensed,name=Rockwell Condensed,style=plain,size=1]
 *  family=Rockwell Condensed,name=Rockwell Condensed Bold,style=plain,size=1]
 *  family=Rockwell Extra Bold,name=Rockwell Extra Bold,style=plain,size=1]
 *  family=Rockwell,name=Rockwell Italic,style=plain,size=1]
 *  family=SAPDings,name=SAPDings Normal,style=plain,size=1]
 *  family=SansSerif,name=SansSerif.bold,style=plain,size=1]
 *  family=SansSerif,name=SansSerif.bolditalic,style=plain,size=1]
 *  family=SansSerif,name=SansSerif.italic,style=plain,size=1]
 *  family=SansSerif,name=SansSerif.plain,style=plain,size=1]
 *  family=Script MT Bold,name=Script MT Bold,style=plain,size=1]
 *  family=Serif,name=Serif.bold,style=plain,size=1]
 *  family=Serif,name=Serif.bolditalic,style=plain,size=1]
 *  family=Serif,name=Serif.italic,style=plain,size=1]
 *  family=Serif,name=Serif.plain,style=plain,size=1]
 *  family=Shruti,name=Shruti,style=plain,size=1]
 *  family=SimHei,name=SimHei,style=plain,size=1]
 *  family=SimSun,name=SimSun,style=plain,size=1]
 *  family=Sylfaen,name=Sylfaen,style=plain,size=1]
 *  family=Symbol,name=Symbol,style=plain,size=1]
 *  family=Tahoma,name=Tahoma,style=plain,size=1]
 *  family=Tahoma,name=Tahoma Bold,style=plain,size=1]
 *  family=Times New Roman,name=Times New Roman,style=plain,size=1]
 *  family=Times New Roman,name=Times New Roman Bold,style=plain,size=1]
 *  family=Times New Roman,name=Times New Roman Bold Italic,style=plain,size=1]
 *  family=Times New Roman,name=Times New Roman Italic,style=plain,size=1]
 *  family=Trebuchet MS,name=Trebuchet MS,style=plain,size=1]
 *  family=Trebuchet MS,name=Trebuchet MS Bold,style=plain,size=1]
 *  family=Trebuchet MS,name=Trebuchet MS Bold Italic,style=plain,size=1]
 *  family=Trebuchet MS,name=Trebuchet MS Italic,style=plain,size=1]
 *  family=Tunga,name=Tunga,style=plain,size=1 
 *  family=Tw Cen MT,name=Tw Cen MT,style=plain,size=1]
 *  family=Tw Cen MT,name=Tw Cen MT Bold,style=plain,size=1]
 *  family=Tw Cen MT,name=Tw Cen MT Bold Italic,style=plain,size=1]
 *  family=Tw Cen MT Condensed,name=Tw Cen MT Condensed,style=plain,size=1]
 *  family=Tw Cen MT Condensed,name=Tw Cen MT Condensed Bold,style=plain,size=1]
 *  family=Tw Cen MT Condensed Extra Bold,name=Tw Cen MT Condensed Extra Bold,style=plain,size=1]
 *  family=Tw Cen MT,name=Tw Cen MT Italic,style=plain,size=1]
 *  family=Verdana,name=Verdana,style=plain,size=1]
 *  family=Verdana,name=Verdana Bold,style=plain,size=1]
 *  family=Verdana,name=Verdana Bold Italic,style=plain,size=1]
 *  family=Verdana,name=Verdana Italic,style=plain,size=1]
 *  family=VeriBest BC,name=VeriBest Bold Condensed ,style=plain,size=1]
 *  family=VeriBest Gerber 0,name=VeriBest Gerber 0,style=plain,size=1]
 *  family=VeriBest Gerber 1,name=VeriBest Gerber 1,style=plain,size=1]
 *  family=Vrinda,name=Vrinda,style=plain,size=1]
 *  family=Webdings,name=Webdings,style=plain,size=1]
 *  family=Wingdings,name=Wingdings,style=plain,size=1]
 *  family=Wingdings 2,name=Wingdings 2,style=plain,size=1]
 *  family=Wingdings 3,name=Wingdings 3,style=plain,size=1]
 * 
 * </pre>
 * 
 */
public class BasicFonts {

    private final static GraphicsEnvironment genv = GraphicsEnvironment
            .getLocalGraphicsEnvironment();

    public final static Font[] getAllAvailableFonts() {

        return genv.getAllFonts();
    }

    public final static String[] getAvailableFontFamilyNames() {

        return genv.getAvailableFontFamilyNames();
    }

    private final static int FONT_SMALL = 10;
    private final static int FONT_MEDIUM = 20;
    private final static int FONT_LARGE = 30;
    private final static String FONT_STYLE_ARIAL = "Arial";
    private final static String FONT_STYLE_TIMES_NEW_ROMAN = "Times New Roman";
    private final static String FONT_STYLE_DEFAULT = "Dialog";

    public final static Font ARIAL_BOLD_SMALL = new Font(FONT_STYLE_ARIAL, Font.BOLD, FONT_SMALL);
    public final static Font ARIAL_BOLD_MEDIUM = new Font(FONT_STYLE_ARIAL, Font.BOLD, FONT_MEDIUM);
    public final static Font ARIAL_BOLD_LARGE = new Font(FONT_STYLE_ARIAL, Font.BOLD, FONT_LARGE);

    public final static Font ARIAL_PLAIN_SMALL = new Font(FONT_STYLE_ARIAL, Font.PLAIN, FONT_SMALL);
    public final static Font ARIAL_PLAIN_LARGE = new Font(FONT_STYLE_ARIAL, Font.PLAIN, FONT_MEDIUM);
    public final static Font ARIAL_PLAIN_MEDIUM = new Font(FONT_STYLE_ARIAL, Font.PLAIN, FONT_LARGE);

    public final static Font ARIAL_ITALIC_SMALL = new Font(FONT_STYLE_ARIAL, Font.ITALIC,
            FONT_SMALL);
    public final static Font ARIAL_ITALIC_MEDIUM = new Font(FONT_STYLE_ARIAL, Font.ITALIC,
            FONT_MEDIUM);
    public final static Font ARIAL_ITALIC_LARGE = new Font(FONT_STYLE_ARIAL, Font.ITALIC,
            FONT_LARGE);

    public final static Font TIMES_NEW_ROMAN_BOLD_SMALL = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.BOLD, FONT_SMALL);
    public final static Font TIMES_NEW_ROMAN_BOLD_MEDIUM = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.BOLD, FONT_MEDIUM);
    public final static Font TIMES_NEW_ROMAN_BOLD_LARGE = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.BOLD, FONT_LARGE);

    public final static Font TIMES_NEW_ROMAN_PLAIN_SMALL = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.PLAIN, FONT_SMALL);
    public final static Font TIMES_NEW_ROMAN_PLAIN_MEDIUM = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.PLAIN, FONT_MEDIUM);
    public final static Font TIMES_NEW_ROMAN_PLAIN_LARGE = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.PLAIN, FONT_LARGE);

    public final static Font TIMES_NEW_ROMAN_ITALIC_SMALL = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.ITALIC, FONT_SMALL);
    public final static Font TIMES_NEW_ROMAN_ITALIC_MEDIUM = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.ITALIC, FONT_MEDIUM);
    public final static Font TIMES_NEW_ROMAN_ITALIC_LARGE = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.ITALIC, FONT_LARGE);

    public final static Font DEFAULT__BOLD_SMALL = new Font(FONT_STYLE_DEFAULT, Font.BOLD, FONT_SMALL);
    public final static Font DEFAULT_BOLD_MEDIUM = new Font(FONT_STYLE_DEFAULT, Font.BOLD,
            FONT_MEDIUM);
    public final static Font DEFAULT_BOLD_LARGE = new Font(FONT_STYLE_DEFAULT, Font.BOLD, FONT_LARGE);

    public final static Font DEFAULT_PLAIN_SMALL = new Font(FONT_STYLE_DEFAULT, Font.PLAIN,
            FONT_SMALL);
    public final static Font DEFAULT_PLAIN_MEDIUM = new Font(FONT_STYLE_DEFAULT, Font.PLAIN,
            FONT_MEDIUM);
    public final static Font DEFAULT_PLAIN_LARGE = new Font(FONT_STYLE_DEFAULT, Font.PLAIN,
            FONT_LARGE);

    public final static Font DEFAULT_ITALIC_SMALL = new Font(FONT_STYLE_DEFAULT, Font.ITALIC,
            FONT_SMALL);
    public final static Font DEFAULT_ITALIC_MEDIUM = new Font(FONT_STYLE_TIMES_NEW_ROMAN,
            Font.ITALIC, FONT_MEDIUM);
    public final static Font DEFAULT_ITALIC_LARGE = new Font(FONT_STYLE_DEFAULT, Font.ITALIC,
            FONT_LARGE);

}
