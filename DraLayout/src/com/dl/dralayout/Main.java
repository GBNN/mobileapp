package com.dl.dralayout;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@SuppressLint({ "InflateParams", "Recycle" })
public class Main extends Activity {
	
	private DrawerLayout NavDrawerLayout;
	private ListView NavList;
	private String[] titulos;
	private ArrayList<MenuItems> NavItems;
	private TypedArray NavIconos;
	AdaptadorMenu NavAdapter;
	
	/**/
	private ActionBarDrawerToggle mDrawerToggle;
	//private ActionBarDrawerToggle mDrawerToggle; //Para el botón que abre el menu
	private CharSequence mDrawerTitle;
    private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Cambiar el color del ActionBar.
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#424242")));
		
		NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		NavList = (ListView) findViewById(R.id.lista);
		
		// Declaramos el header que será header.xml
		View header = getLayoutInflater().inflate(R.layout.header, null);
		// Establecemos el header
		NavList.addHeaderView(header);
		//Tomamos listado de imgs desde drawable
		NavIconos = getResources().obtainTypedArray(R.array.nav_icons);
		//Tomamos listado de titulos desde string-array de los recursos @string/nav_options
		titulos = getResources().getStringArray(R.array.nav_options);
		//Listado de titulos de barra de navegación
		NavItems = new ArrayList<MenuItems>();
		//Agregamos objetos items_object al ArrayList.
		
		NavItems.add(new MenuItems(titulos[0], NavIconos.getResourceId(0, -1))); // Inicio
		NavItems.add(new MenuItems(titulos[1], NavIconos.getResourceId(1, -1))); // Perfil
		NavItems.add(new MenuItems(titulos[2], NavIconos.getResourceId(2, -1))); // Acerca de
		NavItems.add(new MenuItems(titulos[3], NavIconos.getResourceId(3, -1))); // Salir
		
		//Declaramos e inicializamos nuestro adaptador al cual le pasaremos el array con los titulos.
		NavAdapter = new AdaptadorMenu(this, NavItems);
		NavList.setAdapter(NavAdapter);
		
		mTitle = mDrawerTitle = getTitle();
		Log.e("e", mDrawerTitle+" "+mTitle); // Para que no marque advertencia el proyecto XD
		
		// Declaramos el mDrawerToggle y las imagenes a utilizar
		mDrawerToggle = new ActionBarDrawerToggle(
				this, // actividad host
				NavDrawerLayout, //Objeto DrawerLayout
				R.drawable.ic_drawer, // imagen del icono de navegación 
				R.string.app_name,
				R.string.hello_world
				){
			
			public void onDrawerClosed(View view){
				Log.e("Cerrado completo", "!!");
			}
			
			public void onDrawerOpened(View drawerView){
				Log.e("Apertura completa", "!!");
			}
		};
		
		// Establecemos que el mDrawerToggle declarado anteriormente sea el DrawerListener
		NavDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Establecemos que el ActionBar muestre el Boton Home.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		NavList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				MostratFragmento(position);
			}
		});
		MostratFragmento(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.e("mDrawerToggle pushed", "x");
          return true;
        }
        
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }
	
	
	// Recibe como parámetro la posición de la opción en el menu elegida.
	@SuppressLint("ShowToast")
	public void MostratFragmento(int posicion){
		
		Fragment fragmento = null;
		
		switch(posicion){
			case 1: 
				fragmento = new FragmentoHome();
			break;
			case 4: 
				finish();
				break;
			default:
				Toast.makeText(getApplicationContext(), "Algo salió mal!", Toast.LENGTH_SHORT).show();;
				fragmento = new FragmentoHome();
				posicion = 1;
			break;
		}
		
		// Validamos que el fragmento no sea nulo.
		
			if(fragmento != null){
				
				android.app.FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.content_frame, fragmento).commit();
				
				// Actualizamos según la opción elegida
				
				NavList.setItemChecked(posicion, true);
				NavList.setSelection(posicion);
				
				// Cambiamos el título en donde decía "
				setTitle(titulos[posicion-1]);
				NavDrawerLayout.closeDrawer(NavList);
			}
			 else 
		            Log.e("Error  ", "MostrarFragment "+posicion);
		        
	}
}
