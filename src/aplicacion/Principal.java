package aplicacion;
import java.time.*;

public class Principal {
    public static void main (String[] args) {
        ZoneId zonaCaracas = ZoneId.of ("America/Caracas");
        ZonedDateTime fechaHoraCaracas = ZonedDateTime.now(zonaCaracas);
        LocalDate fechaActualLocal = LocalDate.now();
        LocalTime horaActualLocal = LocalTime.now();
        horaActualLocal = horaActualLocal.withNano(0);

        int anoDescubrimiento = 1492;
        int anosTranscurridos = LocalDate.now().getYear() - anoDescubrimiento;

        LocalTime horaCaracas = fechaHoraCaracas.toLocalTime();
        horaCaracas = horaCaracas.withNano(0);

        ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");
        ZoneId zonaCanarias = ZoneId.of("Atlantic/Canary");
        LocalTime horaCanarias = LocalTime.now(zonaCanarias).withNano(0);
        ZonedDateTime fechaHoraMadrid = ZonedDateTime.now(zonaMadrid);

        int caracasSegundos = fechaHoraCaracas.getOffset().getTotalSeconds();
        int madridSegundos = fechaHoraMadrid.getOffset().getTotalSeconds();
        int diferenciaDeHoras = (madridSegundos - caracasSegundos) / 3600;

        ZonedDateTime armstrongLunaUTC = ZonedDateTime.of(1969, 7, 21, 3, 56, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime armstrongLunaEspana = armstrongLunaUTC.withZoneSameInstant(zonaMadrid);

        System.out.println("1. Fecha actual en Espana: " + fechaActualLocal);
        System.out.println("2. Fecha actual en Caracas: " + fechaHoraCaracas.toLocalDate());
        System.out.println("3. Anos transcurridos desde el descubrimiento de América: " + anosTranscurridos);
        System.out.println("4. Hora actual en Espana: " + horaActualLocal + " en la península,  " + horaCanarias + " en Canarias." );
        System.out.println("5. Hora actual en Caracas: " + horaCaracas);
        System.out.println("6. Horas de diferencia entre Madrid y Caracas: " + diferenciaDeHoras + " horas.");
        System.out.println("7. Fecha y hora en Espana cuando Neil Armstrong pisó la luna: " + armstrongLunaEspana.toLocalDate() + " a las " + armstrongLunaEspana.toLocalTime());
    }
}
