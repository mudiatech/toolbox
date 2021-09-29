package com.gitlab.muhammadkholidb.toolbox.data;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringNumberUtils {

    private StringNumberUtils() {
    }

    public static String toStringOrDefault(BigDecimal num, String dflt) {
        return num == null ? dflt : num.setScale(0).toString();
    }

    public static String toStringOrNull(BigDecimal num) {
        return toStringOrDefault(num, null);
    }

    public static String toStringOrEmpty(BigDecimal num) {
        return toStringOrDefault(num, "");
    }

    public static String toStringOrDefault(Integer num, String dflt) {
        return num == null ? dflt : num.toString();
    }

    public static String toStringOrNull(Integer num) {
        return toStringOrDefault(num, null);
    }

    public static String toStringOrEmpty(Integer num) {
        return toStringOrDefault(num, "");
    }

    public static BigDecimal toBigDecimalOrDefault(String str, BigDecimal dflt) {
        return str == null ? dflt : NumberUtils.toScaledBigDecimal(str);
    }

    public static BigDecimal toBigDecimalOrNull(String str) {
        return toBigDecimalOrDefault(str, null);
    }

    public static Integer toIntegerOrDefault(String str, Integer dflt) {
        return StringUtils.isNumeric(str) ? Integer.valueOf(str) : dflt;
    }

    public static Integer toIntegerOrNull(String str) {
        return toIntegerOrDefault(str, null);
    }

}
