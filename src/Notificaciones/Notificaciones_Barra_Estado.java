package Notificaciones;

/**
 * Created by mario on 29-11-13.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.interfacesp.InterfaceGrupos;
import com.example.interfacesp.InterfaceMensajes;
import com.example.interfacesp.R;

/**
 * Created by mario on 18-10-13.
 */
public class Notificaciones_Barra_Estado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
    }

    public void Notificacion(){
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intento = new Intent(getBaseContext(), InterfaceMensajes.class);
        PendingIntent Pintent = PendingIntent.getActivity(getApplicationContext(), 0, intento, 0);
        Notification.Builder crearNotificacion =
                new Notification.Builder (this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("saluos washos")
                        .setContentText("dale click acá")
                        .setContentIntent(Pintent);
        Notification notificacion = crearNotificacion.build();
        //esconde la notificación despues de seleccionarla
        notificacion.flags |= Notification.FLAG_AUTO_CANCEL;
        //sonido por defecto
        notificacion.defaults |= Notification.DEFAULT_SOUND;
        // vibracion por defecto
        notificacion.defaults |= Notification.DEFAULT_VIBRATE;
        nm.notify(987654321, notificacion);
    }
}
