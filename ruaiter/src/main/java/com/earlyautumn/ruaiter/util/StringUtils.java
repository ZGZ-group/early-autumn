package com.earlyautumn.ruaiter.util;

public class StringUtils {

    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    public static String trim(String str) {
        if (isEmpty(str)) {
            return EMPTY_STRING;
        }

        return str.replaceAll(SPACE, EMPTY_STRING);

    }

    public static boolean isEmpty(String str) {
        if (null == str || str.length() == 0) {
            return true;
        }

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (' ' != c) {
                return false;
            }

        }

        return true;

    }

}
