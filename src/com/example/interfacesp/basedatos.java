package com.example.interfacesp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class basededatos extends SQLiteOpenHelper  {
        
        private static final int VERSION_BASEDATOS = 1;
        
        //NOMBRE DE NUESTRO ARCHIVO DE BASE DE DATOS
        private static final String NOMBRE_BASEDATOS = "gruposbd.bd";
        
        private static final String TABLA_GRUPOS = "CREATE TABLE GRUPOS"+
                        "(_id IN PRIMARY KEY, nombreGrupo TEXT, descripcion TEXT, Estado Bool)";
        
        private static final String TABLA_USUARIOS = "CREATE TABLE USUARIOS"+
                "(id NUMBER, nombreusuario TEXT, nombregrupo TEXT, Suscripcion TEXT)";
        
        // Contructor de la clase 
        public basededatos(Context context)
        {
                super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
        }
        
        @Override
        public void onCreate (SQLiteDatabase db)
        {
                db.execSQL(TABLA_GRUPOS);
                db.execSQL(TABLA_USUARIOS);
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
        
        //verificar si el usuario se encuentra suscrito al grupo
        public boolean verificarsuscripcion(String id, String ng){
        	SQLiteDatabase db = getWritableDatabase();
        	if(db.execSQL("SELECT Suscripcion FROM USUARIOS WHERE nombreusuario="+id+" AND nombregrupo="+ng+" AND Suscripcion= Suscrito")!=null){
        		return true;
			}else{
				return false;
			}
        	
        }
        //cuenta cuantos grupos existen para crear la lista de grupos
        public int contargrupos(){
        	SQLiteDatabase db = getWritableDatabase();
        	int z = db.execSQL("SELECT COUNT(*) FROM GRUPOS WHERE _id=_id");//no comprendo este error
			return z;
        	
        }
        //esta funcion devuelve los nombres de los grupos
        public String nombregrupos(int i){
        	SQLiteDatabase db = getWritableDatabase();
        	String q = db.execSQL("SELECT nombreGrupo FROM GRUPOS WHERE _id="+i);
			return q;
        	
        }
        
        //esta funcion suscribe al usuario
        public void suscribir(String usuario, String ngrupo){
			SQLiteDatabase db = getWritableDatabase();
			int c = db.execSQL("SELECT count(*) FROM USUARIOS WHERE id=id");
			c = c+1; 
			ContentValues valores = new ContentValues();
			valores.put("id", c);
			valores.put("nombreusuario", usuario);
			valores.put("nombregrupo",ngrupo);
			valores.put("Suscripcion", "Suscrito");
			db.insert("USUARIOS", null, valores);
			db.close();
        }
        
        //esta funcion elimina la suscripcion
        public void eliminarsuscribir(String usuario, String ngrupo){
	        SQLiteDatabase db = getWritableDatabase();
	        int id = db.execSQL("Select id from USUARIOS WHERE nombreusuario="+usuario+" AND nombregrupo="+ngrupo);
	        ContentValues valores = new ContentValues();
	        valores.put("_id", id);
	        valores.put("nombreusuario", usuario);
	        valores.put("nonbregrupo",ngrupo);
	        valores.put("Suscripcion", "Suscribir");
	        db.update("GRUPOS", valores, "_id="+id, null);
	        db.close();
        }
}

