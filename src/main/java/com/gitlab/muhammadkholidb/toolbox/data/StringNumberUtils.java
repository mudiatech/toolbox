package com.gitlab.muhammadkholidb.toolbox.data;

import java.math.BigDecimal;

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

    public static String toStringOrDefault(Long num, String dflt) {
        return num == null ? dflt : num.toString();
    }

    public static String toStringOrNull(Long num) {
        return toStringOrDefault(num, null);
    }

    public static String toStringOrEmpty(Long num) {
        return toStringOrDefault(num, "");
    }

    public static String toStringOrDefault(Double num, String dflt) {
        return num == null ? dflt : num.toString();
    }

    public static String toStringOrNull(Double num) {
        return toStringOrDefault(num, null);
    }

    public static String toStringOrEmpty(Double num) {
        return toStringOrDefault(num, "");
    }

    public static String toStringOrDefault(Float num, String dflt) {
        return num == null ? dflt : num.toString();
    }

    public static String toStringOrNull(Float num) {
        return toStringOrDefault(num, null);
    }

    public static String toStringOrEmpty(Float num) {
        return toStringOrDefault(num, "");
    }

    public static BigDecimal toBigDecimalOrDefault(String str, BigDecimal dflt) {
        return str == null ? dflt : NumberUtils.toScaledBigDecimal(str);
    }

    public static BigDecimal toBigDecimalOrNull(String str) {
        return toBigDecimalOrDefault(str, null);
    }

    public static Integer toIntegerOrDefault(String str, Integer dflt) {
        return str == null ? dflt : Integer.valueOf(str);
    }

    public static Integer toIntegerOrNull(String str) {
        return toIntegerOrDefault(str, null);
    }

    public static Long toLongOrDefault(String str, Long dflt) {
        return str == null ? dflt : Long.valueOf(str);
    }

    public static Long toLongOrNull(String str) {
        return toLongOrDefault(str, null);
    }

    public static Double toDoubleOrDefault(String str, Double dflt) {
        return str == null ? dflt : Double.valueOf(str);
    }

    public static Double toDoubleOrNull(String str) {
        return toDoubleOrDefault(str, null);
    }

    public static Float toFloatOrDefault(String str, Float dflt) {
        return str == null ? dflt : Float.valueOf(str);
    }

    public static Float toFloatOrNull(String str) {
        return toFloatOrDefault(str, null);
    }

}
