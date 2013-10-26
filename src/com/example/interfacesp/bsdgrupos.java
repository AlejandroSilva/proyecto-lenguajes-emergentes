package com.example.interfacesp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bsdgrupos extends SQLiteOpenHelper  {
	
	private static final int VERSION_BASEDATOS = 1;
	
	//NOMBRE DE NUESTRO ARCHIVO DE BASE DE DATOS
	private static final String NOMBRE_BASEDATOS = "gruposbd.bd";
	
	private static final String TABLA_GRUPOS = "CREATE TABLE GRUPOS"+
			"(_id IN PRIMARY KEY, nombreGrupo TEXT, descripcion TEXT, Estado Bool)";
	
	// Contructor de la clase 
	public bsdgrupos(Context context)
	{
		super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
	}
	
	@Override
	public void onCreate (SQLiteDatabase db)
	{
		db.execSQL(TABLA_GRUPOS);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int NewVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS"+TABLA_GRUPOS);
		onCreate(db);
	}
	public void InsertarGrupo(int id, String nombre, String descrip, Boolean Est )
	{
		SQLiteDatabase db = getWritableDatabase();
		if(db != null)
		{
			ContentValues valores = new ContentValues();
			valores.put("_id", id);
			valores.put("nombreGrupo", nombre);
			valores.put("descripcion",descrip);
			valores.put("Estado", Est);
			db.insert("GRUPOS", null, valores);
			db.close();
		}
	}
	public void modificarGrupos(int id, String nombre, String descrip, Boolean Est )
	{
		SQLiteDatabase db = getWritableDatabase();
		ContentValues valores = new ContentValues();
		valores.put("_id", id);
		valores.put("nombreGrupo", nombre);
		valores.put("descripcion",descrip);
		valores.put("Estado", Est);
		db.update("GRUPOS", valores, "_id="+id, null);
		db.close();
		
	}
	public void borrarGrupo(int id)
	{
		SQLiteDatabase db = getWritableDatabase();
		db.delete("GRUPOS", "_id="+id, null);
		db.close();
	}
	
	

}
