package org.j2eetest.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringUtil {

    public final static List<String> stringToStringList(String originalString, String delimeter) {

        List<String> list = new ArrayList<String>();
        if (SystemUtil.isNullOrBlank(originalString) || originalString.equals(delimeter)) {
            return list;
        }
        if (null == delimeter || "".equals(delimeter)) {
            list.add(originalString);
            return list;
        }

        StringTokenizer tokenizer = new StringTokenizer(originalString);
        String value = tokenizer.nextToken(delimeter);
        if (!SystemUtil.isNullOrBlank(value)) {
            list.add(value);
        }
        while (tokenizer.hasMoreTokens()) {
            value = tokenizer.nextToken(delimeter);
            if (!SystemUtil.isNullOrBlank(value)) {
                list.add(value);
            }
        }

        return list;
    }

    public final static List<Integer> stringToIntegerList(String originalString, String delimeter) {

        List<Integer> list = new ArrayList<Integer>();
        if (SystemUtil.isNullOrBlank(originalString)) {
            return list;
        }
        if (SystemUtil.isNullOrBlank(delimeter)) {
            list.add(Integer.valueOf(originalString));
            return list;
        }

        StringTokenizer tokenizer = new StringTokenizer(originalString);
        String value = tokenizer.nextToken(delimeter);
        if (!SystemUtil.isNullOrBlank(value)) {
            list.add(Integer.valueOf(value));
        }
        while (tokenizer.hasMoreTokens()) {
            value = tokenizer.nextToken(delimeter);
            if (!SystemUtil.isNullOrBlank(value)) {
                list.add(Integer.valueOf(value));
            }
        }

        return list;
    }

    public final static Map<String, String> stringToMap(String original, String entryDelimiter, String kvDelimiter) {

        entryDelimiter = SystemUtil.isNullOrBlank(entryDelimiter) ? BasseConstants.STRING_DELIMITER_THREE_BAR
                : entryDelimiter;
        kvDelimiter = SystemUtil.isNullOrBlank(kvDelimiter) ? BasseConstants.STRING_DELIMITER_EQUAL : kvDelimiter;
        Map<String, String> kvEntries = new HashMap<String, String>();
        StringTokenizer entryTokenzier = new StringTokenizer(original, entryDelimiter);
        while (entryTokenzier.hasMoreElements()) {
            StringTokenizer kvTokenzier = new StringTokenizer((String) entryTokenzier.nextElement(), kvDelimiter);
            if (kvTokenzier.countTokens() == 2) {
                kvEntries.put((String) kvTokenzier.nextElement(), (String) kvTokenzier.nextElement());
            }
        }
        return kvEntries;
    }

    private static Pattern STARDARD_CHARACTER_PARTTERN = Pattern.compile("\\w*");
    private static Pattern STARDARD_CHARACTER_PARTTERN_WITH_BLANK = Pattern.compile("[\\w ]*");

    /**
     * Is Standard Character
     */
    public static boolean isStanderdCharacter(String value) {

        return STARDARD_CHARACTER_PARTTERN.matcher(value).matches();
    }

    /**
     * Is Standard Character With Blank
     */
    public static boolean isStanderdCharacterWithBlank(String value) {

        return STARDARD_CHARACTER_PARTTERN_WITH_BLANK.matcher(value).matches();
    }

    /**
     * Is String match the regex
     */
    public static boolean isStringMatchRegex(String str, String regex) {

        if (str == null || regex == null)
            return false;

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

    /**
     * If str is null or str.length <= length, return true, else return false
     */
    public static boolean validateStrLength(String str, int length) {

        if (str == null || str.length() <= length) {
            return true;
        } else {
            return false;
        }
    }

    public static BigDecimal toBigDecimal(String str) {

        return new BigDecimal(str);
    }
}
