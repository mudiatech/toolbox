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
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    private TimeUtils() {
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

    public static Instant toInstant(LocalDateTime ldt) {
        return toInstant(ldt, ZoneOffset.UTC);
    }

    public static Instant toInstant(LocalDate ld, LocalTime lt) {
        return toInstant(ld.atTime(lt));
    }

    public static Instant toInstant(LocalDate ld, OffsetTime ot) {
        return toInstant(ld.atTime(ot));
    }

    public static Instant toInstant(LocalDate ld) {
        return toInstant(ld.atStartOfDay());
    }

    public static Instant toInstant(LocalDate ld, LocalTime lt, ZoneOffset zo) {
        return toInstant(ld, OffsetTime.of(lt, zo));
    }

    public static Instant toInstant(LocalTime lt, ZoneOffset zo) {
        return toInstant(LocalDate.now(), lt, zo);
    }

    public static Instant toInstant(LocalTime lt) {
        return toInstant(lt, ZoneOffset.UTC);
    }

    public static ZoneOffset parseZoneOffset(Date datetime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);
        // The same as datetime.getTimezoneOffset() (deprecated)
        int offsetMinutes = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000);
        return ZoneOffset.ofTotalSeconds(offsetMinutes * 60);
    }

    public static ZoneId parseZoneId(Date datetime) {
        return ZoneId.ofOffset("", parseZoneOffset(datetime));
    }

}
