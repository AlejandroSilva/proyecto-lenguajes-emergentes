package com.example.interfacesp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;


/**
 * Created by victor on 28-11-13.
 */
public class insertDatos {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
    }
    public void InterfaceGrupos(View view){

        Intent registro = new Intent (this, InterfaceGrupos.class);
        startActivity(registro);

    }
    public void hola(){

        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        // Escribimos 4 registros en nuestra tabla
        MDB.insertarCONTACTO(1, "Pedro", 111111111, "pedro@DB.es");
        MDB.insertarCONTACTO(2, "Sandra", 222222222, "sandra@DB.es");
        MDB.insertarCONTACTO(3, "Maria", 333333333, "maria@DB.es");
        MDB.insertarCONTACTO(4, "Daniel", 444444444, "daniel@DB.es");

        // Recuperamos los 4 registros y los mostramos en el log
        Log.d("TOTAL", Integer.toString(MDB.recuperarCONTACTOS().size()));
        int[] ids = new int[MDB.recuperarCONTACTOS().size()];
        String[] noms = new String[MDB.recuperarCONTACTOS().size()];
        int[] tlfs = new int[MDB.recuperarCONTACTOS().size()];
        String[] emls = new String[MDB.recuperarCONTACTOS().size()];
        for (int i = 0; i < MDB.recuperarCONTACTOS().size(); i++) {
            ids[i] = MDB.recuperarCONTACTOS().get(i).getID();
            noms[i] = MDB.recuperarCONTACTOS().get(i).getNOMBRE();
            tlfs[i] = MDB.recuperarCONTACTOS().get(i).getTELEFONO();
            emls[i] = MDB.recuperarCONTACTOS().get(i).getEMAIL();
            Log.d(""+ids[i], noms[i] + ", " + tlfs[i] + ", " + emls[i]);
        }

        // Modificamos el registro 3
        MDB.modificarCONTACTO(3, "PPPPP", 121212121, "xxxx@xxxx.es");

        // Recuperamos el 3 registro y lo mostramos en el log
        int id = MDB.recuperarCONTACTO(3).getID();
        String nombre = MDB.recuperarCONTACTO(3).getNOMBRE();
        int telefono = MDB.recuperarCONTACTO(3).getTELEFONO();
        String email = MDB.recuperarCONTACTO(3).getEMAIL();
        Log.d(""+id, nombre + ", " + telefono + ", " + email);

        // Borramos el registro 3
        MDB.borrarCONTACTO(3);
    }

}
