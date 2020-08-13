package com.infoprice.teste.modules.comum.util;

import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateUtils {

    public static final int HORA_ZERO = 0;
    public static final int MINUTO_ZERO = 0;
    public static final int SEGUNDO_ZERO = 0;
    public static final int NANOSEGUNDO_ZERO = 0;
    public static final int VINTE_TRES = 23;
    public static final int CINQUENTA_NOVE = 59;

    public static LocalDateTime parseDateTimeInicio(LocalDateTime data) {
        if (!ObjectUtils.isEmpty(data)) {
            LocalTime time = LocalTime.of(HORA_ZERO, MINUTO_ZERO, SEGUNDO_ZERO, NANOSEGUNDO_ZERO);
            return LocalDateTime.of(data.toLocalDate(), time);
        }
        return null;
    }

    public static LocalDateTime parseDateTimeFim(LocalDateTime data) {
        if (!ObjectUtils.isEmpty(data)) {
            LocalTime time = LocalTime.of(VINTE_TRES, CINQUENTA_NOVE, CINQUENTA_NOVE);
            return LocalDateTime.of(data.toLocalDate(), time);
        }
        return null;
    }

}
