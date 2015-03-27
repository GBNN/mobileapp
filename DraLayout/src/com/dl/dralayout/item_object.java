/* CLASE PARA FACILITAR EL USO DEL MENU EN EL ADAPTARDOR DEL LISTVIEW 
 * 
 * CONTIENE LOS MÉTODOS PARA PODER ASIGNARLE A UN ITEM UN NOMBRE Y UNA IMAGEN
 *  
 *  */
package com.dl.dralayout;

public class item_object {

	private String titulo;
	private int icono;
	
	
	public item_object(String titulo, int icono){
		this.titulo = titulo;
		this.icono = icono;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public int getIcono(){
		return icono;
	}

	public void setIcono(int icono){
		this.icono = icono;
	}
}