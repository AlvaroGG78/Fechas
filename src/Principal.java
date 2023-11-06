import java.time.*;

public class Principal {
    public static void main (String[] args) {
        LocalDate fechaActualLocal = LocalDate.now();
        LocalTime horaActualLocal = LocalTime.now();
        horaActualLocal = horaActualLocal.withNano(0);

        ZoneId zonaCaracas = ZoneId.of ("America/Caracas");
        ZonedDateTime fechaHoraCaracas = ZonedDateTime.now(zonaCaracas);

        int añoDescubrimiento = 1492;
        int añosTranscurridos = LocalDate.now().getYear() - añoDescubrimiento;

        LocalTime horaCaracas = fechaHoraCaracas.toLocalTime();
        horaCaracas = horaCaracas.withNano(0);

        ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");
        ZoneId zonaCanarias = ZoneId.of("Atlantic/Canary");
        LocalTime horaCanarias = LocalTime.now(zonaCanarias).withNano(0);
        ZonedDateTime fechaHoraMadrid = ZonedDateTime.of(fechaActualLocal, horaActualLocal, zonaMadrid);
        //ZoneOffset zonaMadrid2 = ZoneId.of("Europe/Madrid").getRules().getOffset(fechaActualLocal);
        //int diferenciaHoraria = (zonaMadrid.getTotalSeconds() - zonaCaracas.getTotalSeconds()) /3600;
        long horasDiferencia = ZoneId.from(fechaHoraCaracas).getRules().getOffset(fechaHoraMadrid.toInstant()).getTotalSeconds() / 3600;

        LocalDateTime neilArmstrongLuna = LocalDateTime.of(1969, Month.JULY, 21, 3, 56);

        System.out.println("1. Fecha actual en España: " + fechaActualLocal);
        System.out.println("2. Fecha actual en Caracas: " + fechaHoraCaracas.toLocalDate());
        System.out.println("3. Años transcurridos desde el descubrimiento de América: " + añosTranscurridos);
        System.out.println("4. Hora actual en España: " + horaActualLocal + " en la península,  " + horaCanarias + " en Canarias." );
        System.out.println("5. Hora actual en Caracas: " + horaCaracas);
        System.out.println("6. Horas de diferencia entre Madrid y Caracas: " + horasDiferencia + " horas.");
        System.out.println("7. Fecha y hora en España cuando Neil Armstrong pisó la luna: " + neilArmstrongLuna);
    }
}