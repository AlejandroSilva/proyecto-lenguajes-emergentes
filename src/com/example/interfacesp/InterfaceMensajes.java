package com.example.interfacesp;
import servicios.ServiceConfig;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class InterfaceMensajes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interfacemensajes);
	}
		
	
	// MENU INFERIOR
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aplicacion_settings, menu);
		return true;
	}
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.settings_application:
        		Intent i = new Intent(this, ServiceConfig.class);
        		startActivity(i);
               break;
        }
        // true -> consumimos el item, detener la propagacion
        return true; 
    }
}
