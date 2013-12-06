package com.example.interfacesp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
                Intent registro = new Intent (this, InterfaceGrupos.class);
                startActivity(registro);
                
                // Configuracion de servicio
                //Intent serviceConfig = new Intent( this, ServiceConfig.class);
                //startActivity( serviceConfig );
        }
}
