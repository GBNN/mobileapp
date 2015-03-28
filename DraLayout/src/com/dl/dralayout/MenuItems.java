/* CLASE PARA FACILITAR EL USO DEL MENU EN EL ADAPTARDOR DEL LISTVIEW 
 * 
 * CONTIENE LOS MÉTODOS PARA PODER ASIGNARLE A UN ITEM UN NOMBRE Y UNA IMAGEN
 *  
 *  */
package com.dl.dralayout;

public class MenuItems {

	private String titulo;
	private int imagen;
	
	
	public MenuItems(String titulo, int imagen){
		this.titulo = titulo;
		this.imagen = imagen;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public int getImagen(){
		return imagen;
	}

	public void setImagen(int imagen){
		this.imagen = imagen;
	}
}