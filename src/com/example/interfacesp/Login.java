package com.example.interfacesp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
	}
	public void InterfaceGrupos(View view){
		
		Intent registro = new Intent (this, InterfaceGrupos.class);
		startActivity(registro);
		
	}

	

}
