package com.dl.dralayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleFLista extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_detail_notf, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
			// Obtenemos la información de la lista.
			Bundle mbundle = getArguments();
			String data = mbundle.getString("arg");
			
			TextView texto = (TextView) getActivity().findViewById(R.id.texto_detalle);
			texto.setText(data);
	}

		
}
