package com.example.interfacesp;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by victor on 10-10-13.
 */
public class ListaGrupos{

    public ArrayList <String> getLista(){
    ArrayList <String> ListaGrupo = new ArrayList<String>(); // Puedo obtener datos desde el telefono.
        ListaGrupo.add("Hola");
        ListaGrupo.add("Como");
        ListaGrupo.add("estas");
        ListaGrupo.add("Espero");
        ListaGrupo.add("que bien");
        return ListaGrupo;
    }
}
