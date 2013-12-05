/*
package NotifacionManager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.example.interfacesp.InterfaceMensajes;
import com.example.interfacesp.R;

public class NotificacionManager {

	// Ejemplo: NotificacionManager.mostrarNotificacion("este es un titulo", "este es un contexto", this);
	
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
		
		nm.notify(987654321, notificacion);
	}
}
*/