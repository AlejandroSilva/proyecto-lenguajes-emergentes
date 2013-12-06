package broadcastReceiver;
import servicios.ServiceConfig;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {
	
    @Override
    public void onReceive(final Context context, final Intent intent) {

    	if (!intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION) &&
    			!intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION) &&
    			!intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
    		//Log.i("CONNECTION", "ignorar accion");
    		return;
    	}
    	
    	if( isConnected(context) ){
    		Log.i("SERVICE", "esta conectado a la red, iniciando servicio");
    		ServiceConfig.startService( context );
    	}
    	else{
    		Log.i("SERVICE", "se ha desconectado de la red, deteniendo servicio");
    		ServiceConfig.stopService(context);
    	}
    }
    
    public boolean isConnected(Context context){
    	// obtener la informacion de la coneccion activa 
    	ConnectivityManager cm = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE);
    	NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    	
    	boolean isConnected = activeNetwork!=null && activeNetwork.isConnectedOrConnecting();
    	return isConnected;
    }
}