package com.infoprice.teste.modules.comum.util;

public class StringUtil {

    public static String getOnlyNumbers(String value) {
        return value.replaceAll("[^0-9]", "");
    }

}
