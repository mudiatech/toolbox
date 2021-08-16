package com.gitlab.muhammadkholidb.toolbox.data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTimeUtils {

    // @formatter:off
    public static final DateTimeFormatter[] FORMATTERS = new DateTimeFormatter[] { 
            DateTimeFormatter.BASIC_ISO_DATE,
            DateTimeFormatter.ISO_DATE, 
            DateTimeFormatter.ISO_DATE_TIME, 
            DateTimeFormatter.ISO_INSTANT,
            DateTimeFormatter.ISO_ORDINAL_DATE, 
            DateTimeFormatter.ISO_TIME, 
            DateTimeFormatter.ISO_WEEK_DATE,
            DateTimeFormatter.RFC_1123_DATE_TIME };
    // @formatter:on

    private DateTimeUtils() {
    }

    public static Instant toInstant(ZonedDateTime zdt) {
        return zdt.toInstant();
    }

    public static Instant toInstant(OffsetDateTime odt) {
        return odt.toInstant();
    }

    public static Instant toInstant(OffsetTime ot) {
        return toInstant(ot.atDate(LocalDate.now()));
    }

    public static Instant toInstant(LocalDateTime ldt, ZoneOffset zo) {
        return toInstant(ldt.atOffset(zo));
    }

    public static Instant toInstant(LocalDateTime ldt, ZoneId zoneId) {
        return toInstant(ldt.atZone(zoneId));
    }

    public static Instant toInstant(LocalDateTime ldt) {
        return toInstant(ldt.atZone(ZoneId.systemDefault()));
    }

    public static Instant toInstant(LocalDate ld, LocalTime lt) {
        return toInstant(ld.atTime(lt));
    }

    public static Instant toInstant(LocalDate ld, OffsetTime ot) {
        return toInstant(ld.atTime(ot));
    }

    public static Instant toInstant(LocalDate ld) {
        return toInstant(ld.atStartOfDay(ZoneId.systemDefault()));
    }

    public static Instant toInstant(LocalDate ld, LocalTime lt, ZoneOffset zo) {
        return toInstant(ld.atTime(lt), zo);
    }

    public static Instant toInstant(LocalDate ld, LocalTime lt, ZoneId zoneId) {
        return toInstant(ld.atTime(lt), zoneId);
    }

    public static Instant toInstant(LocalTime lt, ZoneOffset zo) {
        return toInstant(lt.atDate(LocalDate.now()), zo);
    }

    public static Instant toInstant(LocalTime lt, ZoneId zoneId) {
        return toInstant(lt.atDate(LocalDate.now()), zoneId);
    }

    public static Instant toInstant(LocalTime lt) {
        return toInstant(lt, ZoneId.systemDefault());
    }

    public static ZoneOffset parseZoneOffset(Calendar calendar) {
        // The same as datetime.getTimezoneOffset() (deprecated)
        int offsetMinutes = (calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET)) / (60 * 1000);
        return ZoneOffset.ofTotalSeconds(offsetMinutes * 60);
    }

    public static ZoneId parseZoneId(Calendar calendar) {
        return calendar.getTimeZone().toZoneId();
    }

    /**
     * 
     * @param datetime
     * @return
     */
    public static Instant toInstant(String datetime) {
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                TemporalAccessor parsed = formatter.parse(datetime);
                if (DateTimeFormatter.ISO_INSTANT.equals(formatter)) {
                    return Instant.from(parsed);
                }
                if (DateTimeFormatter.BASIC_ISO_DATE.equals(formatter) 
                        || DateTimeFormatter.ISO_DATE.equals(formatter)
                        || DateTimeFormatter.ISO_ORDINAL_DATE.equals(formatter)
                        || DateTimeFormatter.ISO_WEEK_DATE.equals(formatter)) {
                    LocalDateTime ldt = LocalDate.from(parsed).atStartOfDay();
                    if (parsed.isSupported(ChronoField.OFFSET_SECONDS)) {
                        ZoneOffset zo = ZoneOffset.ofTotalSeconds(parsed.get(ChronoField.OFFSET_SECONDS));
                        return toInstant(ldt, zo);
                    }
                    return toInstant(ldt);
                }
                if (DateTimeFormatter.ISO_DATE_TIME.equals(formatter) || DateTimeFormatter.RFC_1123_DATE_TIME.equals(formatter)) {
                    if (parsed.isSupported(ChronoField.OFFSET_SECONDS)) {
                        return toInstant(ZonedDateTime.from(parsed));
                    }
                    return toInstant(LocalDateTime.from(parsed));
                }
                if (DateTimeFormatter.ISO_TIME.equals(formatter)) {
                    if (parsed.isSupported(ChronoField.OFFSET_SECONDS)) {
                        ZoneOffset zo = ZoneOffset.ofTotalSeconds(parsed.get(ChronoField.OFFSET_SECONDS));
                        return toInstant(LocalTime.from(parsed).atOffset(zo));
                    }
                    return toInstant(LocalTime.from(parsed));
                }
            } catch (DateTimeParseException e) {
                log.trace("Unable to parse datetime: {}", e.getMessage());
            }
        }
        throw new DateTimeParseException("Unable to parse datetime", datetime, datetime.length());
    }

}
