package models.factories;

import models.adopcion.PreferenciaRecordatorio;
import models.notificador.*;

public class FactoryEstrategiaNotificacion {
    public static EstrategiaNotificacion crearEstrategiaNotificacion(PreferenciaRecordatorio preferencia){
        switch (preferencia){
            case SMS:
               return new NotificacionSMS(new AdapterSMSTwilio());
            case EMAIL:
               return new NotificacionEmail(new AdapterEmailJavaMail());
            default:
                return new NotificacionWhatsApp(new AdapterWhatsAppTwilio());
        }
    }

    public static EstrategiaNotificacion crearEstrategiaNotificacionPush(){
        return new NotificacionPush(new AdapterNotificacionPushCelular());
    }
}
