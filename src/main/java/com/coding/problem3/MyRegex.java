package com.coding.problem3;

import static java.util.regex.Pattern.compile;

public class MyRegex {

    private final static String IP_REGEX = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";

    public static boolean validateIP(String Ip) {
        return compile(IP_REGEX)
                .matcher(Ip)
                .matches();
    }
}
