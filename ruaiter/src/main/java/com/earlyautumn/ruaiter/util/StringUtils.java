package com.earlyautumn.ruaiter.util;

public class StringUtils {

    public static final String EMPTY = "";
    public static final String SPACE = " ";

    /**
     * 去除字符串内所有空格
     */
    public static String trimAll(String str) {
        if (isEmpty(str)) {
            return EMPTY;
        }

        return str.replaceAll(SPACE, EMPTY);

    }

    /**
     * 判断字符串是否为空
     */
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
    /**
     * 获取本机ip地址
     * @return
     */
    public static String getLocalhostIp(){
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

}
