package com.example.interfacesp;

import android.widget.Button;

public class Suscribir {
	public void operar(){
		basededatos b = new basededatos(null);
		String usuario = "pamela";
		String ngrupo = "grupo 1";
		Button btn = R.id.btnsus; //capturar el texto del boton para realizar la accion del IF
		if(btn.getText()=="Suscribir"){
			b.suscribir(usuario, ngrupo);
		}else{
			b.eliminarsuscribir(usuario, ngrupo);
		}
	}
}
