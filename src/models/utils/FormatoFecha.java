package models.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoFecha {
    public static String formatoFecha(Date date) {
        String patron = "dd/MM/yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patron);
        return simpleDateFormat.format(date);
    }
}
