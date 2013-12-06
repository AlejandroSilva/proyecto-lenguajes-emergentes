package com.example.interfacesp;

import java.util.ArrayList;
import servicios.ServiceConfig;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class InterfaceGrupos extends ListActivity {

	public String nombreg="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Apéndice de método generado automáticamente
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interfacegrupo1);
		
		//comprovar la cantidad de grupos que hay para crear
		basededatos s = new basededatos(null);
		int z = s.contargrupos();
		
		ArrayList<String> locales = new ArrayList<String>();
		//FOR que traera los nombre de los grupos para crear la lista
		
		for(int i=0;i<z;i++){
			nombreg = s.nombregrupos(i);
			locales.add(nombreg);
		}
				
		IconListViewAdapter ilva = new IconListViewAdapter(this, R.layout.interfacegrupo, locales );
		setListAdapter(ilva);				
	}

	public void InterfaceMensajes(View view){
		
		Intent a = new Intent (this, InterfaceMensajes.class);
		startActivity(a);
	}

    public class IconListViewAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;
        
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
                        TextView ngrupo = (TextView) v.findViewById(R.id.nombregrupo);
                        ngrupo.setText(o);
                        TextView nmemsajes = (TextView) v.findViewById(R.id.numeromensajes);
                        Button b = (Button) v.findViewById(R.id.btnsus);
                        
                        //verificamos a que grupo esta suscrito el usuarios
                        basededatos bd = new basededatos(null);
                        Boolean x = bd.verificarsuscripcion("pamela", nombreg);//pamela debe ser el nombre de usuario
                        if (x == true){
                        	b.setText("Suscrito");
                        }else{
                        	b.setText("Suscribir");
                        }
                        
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

    
        // MENU INFERIOR
    @Override public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.aplication_setting, menu);
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
