package Notificaciones;

/**
 * Created by mario on 29-11-13.
 */
import java.util.Calendar;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.example.interfacesp.InterfaceMensajes;
import com.example.interfacesp.R;
import android.support.v4.app.NotificationCompat;


public class Notificaciones_Barra_Estado {

    public static void mostrarNotificacion(String titulo, String contenido, Activity contexto){
        NotificationManager nm = (NotificationManager)contexto.getSystemService(contexto.NOTIFICATION_SERVICE);
        PendingIntent intencionPendiente = PendingIntent.getActivity(contexto, 0, new Intent(contexto, InterfaceMensajes.class), 0);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(contexto)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(titulo)
                        .setContentText(contenido)
                        .setContentIntent(intencionPendiente);
        Notification notificacion = mBuilder.build();
        //esconde la notificación despues de seleccionarla
        notificacion.flags |= Notification.FLAG_AUTO_CANCEL;
        //sonido por defecto
        notificacion.defaults |= Notification.DEFAULT_SOUND;
        // vibracion por defecto
        notificacion.defaults |= Notification.DEFAULT_VIBRATE;
        nm.notify(987654321, notificacion);
    }
}
