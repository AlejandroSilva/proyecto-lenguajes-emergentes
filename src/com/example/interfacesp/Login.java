package com.example.interfacesp;

import org.json.JSONObject;

import webservice.AplicacionWeb;
import webservice.AppWebException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// asociar con la vista principal (login)
		setContentView(R.layout.principal);
	}
	
	// al hacer click en el boton de login
	public void InterfaceGrupos(View view){
		 new InnerloginClass().execute();
	}
	
	public void loginCorrecto(){
		Intent registro = new Intent (this, InterfaceGrupos.class);
		startActivity(registro);
	}
	public void loginIncorrecto(String mensaje){
		// TODO: hacer esto...
		Log.i("INTERNET", "login incorrecto: "+mensaje);
	}

	
	private class InnerloginClass extends AsyncTask{
		 @Override
		 protected Integer doInBackground(Object... arg0) {
			 
			String loginResponse;
			// PRIMERO: Enviar el POST y obtener el string de retorno
			try{
				AplicacionWeb aplicacion = new AplicacionWeb();
				loginResponse = aplicacion.loginUsuario("juanito", "passwod123");
				
				loginCorrecto();
			}catch(AppWebException ex){
				loginIncorrecto(ex.getMessage());
				return -1;
			}
			
			// SEGUNDO: Convertir el String a JSON
			/*JSONObject jso_resumen;
			try{
				jso_resumen = new JSONObject( loginResponse );
			}catch( org.json.JSONException e2){
				loginIncorrecto("JSON mal formateado o desconocido");
				return -1;
			}*/
			
			// TERCERO: se ha logeado correctamente?
			return 0;
		 }
	}	
}
