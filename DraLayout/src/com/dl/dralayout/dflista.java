package com.dl.dralayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

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
