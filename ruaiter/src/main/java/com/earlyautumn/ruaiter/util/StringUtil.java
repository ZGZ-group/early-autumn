package com.earlyautumn.ruaiter.util;

public class StringUtil {

    private static final String EMPTY_STRING = "";
    private static final String ONE_SPACE_STRING = " ";

    public static String trim(String str) {
        if (isEmpty(str)) {
            return EMPTY_STRING;
        }

        return str.replaceAll(ONE_SPACE_STRING, EMPTY_STRING);

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
