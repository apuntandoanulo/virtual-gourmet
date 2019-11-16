package com.acme.entities.ejemplos.flujos;

import com.acme.core.InventarioCarnes;
import com.acme.core.ingredientes.Carne;

public class ManejoLecturaArchivo {

	public static void main(String[] args) {
		
		try {
//			String rutaArchivo = "D:\\DELETE_ME\\virtual_gourmet.json";
//			InventarioCarnes inventario = (InventarioCarnes) UtilitarioJSON.leerArchivo(rutaArchivo, InventarioCarnes.class);
			
			String rutaArchivo = "D:\\DELETE_ME\\virtual_gourmet.xml";
			InventarioCarnes inventario = (InventarioCarnes) UtilitarioXML.leerArchivo(rutaArchivo, InventarioCarnes.class);
			
			for(Carne carne : inventario.getListaCarnes()) {
				System.out.println(carne.getNombre() + ", " + carne.getStock());
			}
						
			
			
			//String rutaArchivo = "D:\\DELETE_ME\\virtual_gourmet.xml";
			
			/*JsonArray nuevaLista = (JsonArray) UtilitarioJSON.leerArchivo(rutaArchivo, JsonArray.class);
			
			for(JsonElement elemento : nuevaLista) {
				JsonObject objeto = (JsonObject) elemento;
				
				System.out.println(objeto.get("nombre"));
			}*/
			
			
			
		} catch (Exception ex) {
			System.out.println("Error guardando el archivo");
			ex.printStackTrace();
		}
	}
}
