package com.dl.dralayout;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class AdaptadorMenu extends BaseAdapter {
	
	private Activity activity;
	ArrayList<MenuItems> arrayitems;
	
	public AdaptadorMenu(Activity activity, ArrayList<MenuItems> arrayitems){
		super();
		this.activity = activity;
		this.arrayitems = arrayitems;
	}
	
	@Override
	public int getCount() {
		return arrayitems.size();
	}

	@Override
	public Object getItem(int position) {
		// Retorna objeto item_object del ArrayList;
		return arrayitems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// Declaramos una clase estática que representa a la fila.
	public static class Fila{
		TextView titulo_item;
		ImageView icono;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Fila view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if(convertView==null){
		
			view = new Fila();
			// Creamos un objeto del tipo MenuItems y lo obtenemos del arreglo.
			MenuItems item = arrayitems.get(position);
			convertView = inflator.inflate(R.layout.itm, null);
			
			// Título
			view.titulo_item = (TextView) convertView.findViewById(R.id.title_item);
			// Inicializamos el campo titulo con el nombre correspondiente que obtenemos del objeto
			view.titulo_item.setText(item.getTitulo());
			// El ícono
			view.icono = (ImageView) convertView.findViewById(R.id.icon);
			// Se agrega el ícono
			view.icono.setImageResource(item.getImagen());
			convertView.setTag(view);
		}
		return convertView;
	}

}
