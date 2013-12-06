package servicios;
import java.util.Calendar;

//import NotifacionManager.NotificacionManager;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.interfacesp.R;

public class ServiceConfig extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_config);
		
		// iniciar servicio
		Button btnIniciar = (Button)findViewById(R.id.btn_iniciarServicio); 
		btnIniciar.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				ServiceConfig.startService( getBaseContext() );
			}
		});
		// detener servicio
		Button btnDetener = (Button)findViewById(R.id.btn_detenerServicio);
		btnDetener.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				ServiceConfig.stopService( getBaseContext() );
			}
		});
		
		//NotificacionManager.mostrarNotificacion("este es un titulo", "este es un contexto", this);
	}
	
	
	public static void startService(Context context ){
        Intent intent = new Intent( context, ServicioMensajes.class);
        PendingIntent pintent = PendingIntent.getService( context, 0, intent, 0);
        // pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent,0);
        
        // 2) Setear los datos del calendario
        Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.SECOND, 2);
         	
        // 3) configurar el AlarmManager
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 10*1000, pintent);			// levantar el servicio cada 10 segundos
        Log.i("SERVICE", "TIMER INICIADO");
	}
	
	public static void stopService(Context context){
		// detener servicio
		//  Intent serviceIntent = new Intent(ServiceConfig.this, ServicioMensajes.class);
		//  stopService( serviceIntent );
		
		// detener el timer
		// 1) definir el intent
		Intent intent = new Intent( context, ServicioMensajes.class);
		PendingIntent pintent = PendingIntent.getService( context, 0, intent, 0);
		
		// 2) Alarm Manager
		AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
		alarm.cancel( pintent );
		Log.i("SERVICE", "TIMER DETENIDO");
	}
}
