package com.dl.dralayout;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* Fragmento que mostrará las notificaciones al usuario */

public class FragmentoHome extends Fragment {
	
	private List<String> mDataSourceList = new ArrayList<String>();
	@SuppressWarnings("unused")
	private List<FragmentTransaction> mBackStackList = new ArrayList<FragmentTransaction>();
    
	//public FragmentoHome(){}
     
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home, container, false);  // Se retorna nuestra actividad ya "inflada"
    }
	
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Agregamos información a la ListView
		for(int i=0, count=100; i<count; i++){
			mDataSourceList.add("Nombre " + i);
		}
		
		ListView lista = (ListView) getActivity().findViewById(R.id.lista_noticias);
		lista.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mDataSourceList));
		
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				//Fragment detailFragment = new DetalleFLista();
				
				Fragment Dflista = new DetalleLista();
				Bundle mbundle = new Bundle();
				mbundle.putString("arg", mDataSourceList.get(position));
				Dflista.setArguments(mbundle);
				
				android.app.FragmentManager fm = getFragmentManager();
				fm.beginTransaction().replace(R.id.content_frame, Dflista).commit();
				
				
				/* THIS IS WORKING ATM 
				Bundle mbundle = new Bundle();
				mbundle.putString("arg", mDataSourceList.get(position));
				//detailFragment.setArguments(mbundle);
				Intent accion = new Intent(getActivity(), dflista.class);
				accion.putExtras(mbundle);
				startActivity(accion);
				ShowToast("");
				*/
				
				
				
				//final FragmentManager FragmentManager = getActivity().getFragmentManager();
				//final FragmentTransaction fragmentTransaction = FragmentManager.beginTransaction();
				
				//fragmentTransaction.replace(R.id.lista, detailFragment);
				//fragmentTransaction.commit();
			}
		});
	}
    
    /*
	@SuppressWarnings("unused")
	private void ShowToast(String msg){
    	Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();;
    }*/
	
}