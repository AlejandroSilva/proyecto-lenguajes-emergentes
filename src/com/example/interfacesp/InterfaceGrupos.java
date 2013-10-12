package com.example.interfacesp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InterfaceGrupos extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interfacegrupo1);
		
		
		ArrayList<String> locales = new ArrayList<String>();
        ListaGrupos lista = new ListaGrupos();
        locales = lista.getLista();


		//locales.add("Grupo 1");
		//locales.add("Grupo 2");
		//locales.add("Grupo 3");

		
		IconListViewAdapter ilva = new IconListViewAdapter(this, R.layout.interfacegrupo, locales );
		setListAdapter(ilva);
		
		
	}

	public void InterfaceMensajes(View view){
		
		Intent a = new Intent (this, InterfaceMensajes.class);
		startActivity(a);
	}

    public class IconListViewAdapter extends ArrayAdapter<String> {

        private ArrayList<String> items;
        
        protected void onCreate(Bundle savedInstanceState) {
    	
        	
        }
        
        public IconListViewAdapter(Context context, int textViewResourceId, ArrayList<String> items) {
                super(context, textViewResourceId, items);
                this.items = items;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.interfacegrupo, null);
                }
                
                final String o = items.get(position);
                if (o != null) {
                	
                	//poblamos la lista de elementos
                	
                        TextView tt = (TextView) v.findViewById(R.id.tipogrupo);
                        tt.setText(o);
                
                
		                CheckBox checkBox1 = (CheckBox) v.findViewById(R.id.checkBox1);
		       		 
		        		checkBox1.setOnClickListener(new OnClickListener() {
		        	 
		        		  @Override
		        		  public void onClick(View v) {
		        	                //is chkIos checked?
		        			if (((CheckBox) v).isChecked()) {
		        				Toast.makeText(InterfaceGrupos.this,
		        			 	   "Entrando en "+o, Toast.LENGTH_LONG).show();
		        			}
		        			
		        			else {
		        				Toast.makeText(InterfaceGrupos.this,
		        					 	   "Saliendo de "+o, Toast.LENGTH_LONG).show();
		        						
		        			}
		        		  }
		        		});
                }
                
                return v;
        }
}
}