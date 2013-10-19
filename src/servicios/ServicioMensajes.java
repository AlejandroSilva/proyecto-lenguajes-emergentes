package servicios;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServicioMensajes extends Service {
	       //MediaPlayer reproductor;
	 
	       @Override
	       public void onCreate() {
	             Toast.makeText(this,"Servicio creado", Toast.LENGTH_SHORT).show();
	             Log.i("SERVICE", "servicio creado");
	       }
	       
	       /*
	       @Override
	       public void onStart(Intent intent, int idArranque) {
	              Toast.makeText(this, "Servicio arrancado " + idArranque,Toast.LENGTH_SHORT).show();
	              Log.i("SERVICE", "servicio arrancado "+idArranque);
	              //reproductor.start();
	       }
	        */
	       /**
	       		intent		intent usado en startService( intent );
	       		flags		Informaci�n sobre como comienza la solicitud. Puede ser: 0, START_FLAG_REDELIVERY, START_FLAG_RETRY. 
	       					Un valor distinto de 0 se utiliza para reiniciar un servicio tras detectar alg�n problema.
	       		idArranque 	representa el numero de solicitud de arranque. Usar este mismo estero en el m�todo stopSelfResult(int idArranque).
	       		return		Como debe comportarse el sistema cuando el servicio sea matado. (ej. pore el sistema por falta de memoria)
	       */
	       @Override
	       public int onStartCommand(Intent intent, int flags, int idArranque) {
	             Toast.makeText(this,"Servicio "+idArranque+" arrancado ", Toast.LENGTH_SHORT).show();
	             Log.i("SERVICE", "Servicio "+idArranque+" arrancado ");
	             	             
	             // revisar si hay mensajes nuevos
	             stopSelf();
	             return START_NOT_STICKY;
	       }

	 
	       @Override
	       public void onDestroy() {
	             Toast.makeText(this,"Servicio detenido", Toast.LENGTH_SHORT).show();
	             Log.i("SERVICE", "servicio detenido");
	       }
	 
	       @Override
	       public IBinder onBind(Intent intencion) {
	             return null;
	       }
	}
