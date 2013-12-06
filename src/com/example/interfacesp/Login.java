package com.example.interfacesp;

import org.json.JSONObject;
import webservice.AplicacionWeb;
import webservice.AppWebException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
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
		new InnerloginClass(this).execute();
	}

	public void loginCorrecto(){
		Intent registro = new Intent (this, InterfaceGrupos.class);
		startActivity(registro);
		Log.i("INTERNET", "login correcto! :D");
	}

	private class InnerloginClass extends AsyncTask<Void, String, Void>{ // <param, progress, result>
		// el ProgressDialog de "cargando", 
		private ProgressDialog pDialog;
		// el contexto en donde se muestran los mensajes,
		private Context context;
		// y una variable para almacenar mensajes de excepcion
		private String errorMessage = null;

		public InnerloginClass(Context context){
			this.context = context;
		}

		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			// antes de comenzar el proceso, mostrar un ProgressDialog de "cargando"
			pDialog = new ProgressDialog(context);
			pDialog.setMessage("Entrando al sistema");
			pDialog.setCancelable(false);
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.show();
		}
		@Override
		protected Void doInBackground(Void... params) {
			try{
				// PRIMERO: Enviar el POST y obtener el string de retorno
				AplicacionWeb aplicacion = new AplicacionWeb();
				String loginResponse = aplicacion.loginUsuario("juanito", "passwod123");

				publishProgress("leyendo respuesta...");
				// SEGUNDO: Convertir el String a JSON
				JSONObject jsonLogin = new JSONObject( loginResponse );

				//TERCERO: se ha logeado correctamente?
				if( jsonLogin.getString("status").compareTo("ok")==0 ){
					publishProgress("Bienvenido al sistema :)");
					// si todo salio correctamente, logear en el sistema
					loginCorrecto();
				}
				else
					errorMessage = "Usuario o password invalidos";
			}catch(AppWebException ex){
				errorMessage = ex.getMessage();
			}catch(org.json.JSONException e2){
				errorMessage = "JSON mal formateado o desconocido";
			}
			return null;
		}
		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			// actualizar el mensaje mostrado en el ProgressDialog
			pDialog.setMessage(values[0]);
		}
		@Override
		protected void onPostExecute(Void unused) {
			// oculta el ProgressDialog que muestra "cargando"
			pDialog.dismiss();

			// si ocurrio un error en la ejecucion (Exception), mostrar el mensaje de error
			if(errorMessage!=null){
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("ocurrio un problema");
				builder.setMessage( errorMessage );
				builder.setPositiveButton("OK", null);
				AlertDialog dialog = builder.create();
				dialog.show();
			}	
		}
	}
}
