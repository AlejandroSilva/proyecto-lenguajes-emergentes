package com.example.interfacesp;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import servicios.ServiceConfig;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class InterfaceGrupos extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        // TODO Ap&#xfffd;ndice de m&#xfffd;todo generado autom&#xfffd;ticamente
		super.onCreate(savedInstanceState);
		// asociar el codigo a la vista interfacegrupo1
		setContentView(R.layout.interfacegrupo1);
		
		ArrayList<String> locales = new ArrayList<String>();
		locales.add("Grupo 1");
		locales.add("Grupo 2");
		locales.add("Grupo 3");
		
		IconListViewAdapter ilva = new IconListViewAdapter(this, R.layout.interfacegrupo, locales );
		setListAdapter(ilva);
	}

	public void InterfaceMensajes(View view){
		// mostrar la actividad InterfaceMensajes
		Intent a = new Intent (this, InterfaceMensajes.class);
		startActivity(a);
	}

    public class IconListViewAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;
        
        protected void onCreate(Bundle savedInstanceState) {
        	// falta codigo??
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
		        			 	   "Entrando en "+o, Toast.LENGTH_SHORT).show();
		        			}
		        			
		        			else {
		        				Toast.makeText(InterfaceGrupos.this,
		        					 	   "Saliendo de "+o, Toast.LENGTH_SHORT).show();
		        			}
		        		  }
		        		});
                }
                
                return v;
        }
    }
    
	// MENU INFERIOR
    @Override public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aplicacion_settings, menu);
		return true;
	}
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.settings_application:
        		Intent i = new Intent(this, ServiceConfig.class);
        		startActivity(i);
               break;
        }
        // true -> consumimos el item, detener la propagacion
        return true; 
    }
}