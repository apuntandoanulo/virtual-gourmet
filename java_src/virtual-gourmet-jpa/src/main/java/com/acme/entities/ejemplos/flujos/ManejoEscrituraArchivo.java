package com.acme.entities.ejemplos.flujos;

import java.util.ArrayList;

import com.acme.core.InventarioIngredientes;
import com.acme.core.ingredientes.Carne;

public class ManejoEscrituraArchivo {

	public static void main(String[] args) {
		Carne pollo = new Carne("Pollo");
		pollo.setStock(20);
		
		Carne pescado = new Carne("Pescado");
		pescado.setStock(15);
		
		Carne cerdo = new Carne("Cerdo");
		cerdo.setStock(5);
		
		ArrayList<Carne> carnes = new ArrayList<Carne>();
		carnes.add(pollo);
		carnes.add(pescado);
		carnes.add(cerdo);
		
		InventarioIngredientes inventario = new InventarioIngredientes(carnes);
		
		try {
//			String rutaArchivo = "D:\\DELETE_ME\\virtual_gourmet.json";
//			UtilitarioJSON.guardarArchivo(rutaArchivo, inventario);
			
			String rutaArchivo = "D:\\DELETE_ME\\virtual_gourmet.xml";
			UtilitarioXML.guardarArchivo(rutaArchivo, inventario);
			
			System.out.println("Archivo guardado correctamente");
			
		} catch (Exception ex) {
			System.out.println("Error guardando el archivo");
			ex.printStackTrace();
		}
	}
}
