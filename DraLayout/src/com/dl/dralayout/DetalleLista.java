package com.dl.dralayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleLista extends Fragment {

	TextView texto;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return  inflater.inflate(R.layout.activity_detail_notf, container, false); // Tenemos que inflar la actividad para poderle agregar el layout.
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		texto = (TextView) getView().findViewById(R.id.texto_detalle);
		Bundle mbundle = getArguments();
		texto.setText(mbundle.getString("arg"));
	}
}

/*
public class dflista extends Activity{

	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_notf);
		texto = (TextView) findViewById(R.id.texto_detalle);
	
		Intent i = getIntent();
		String text = i.getExtras().getString("arg").toString();
		texto.setText(text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	
}
*/