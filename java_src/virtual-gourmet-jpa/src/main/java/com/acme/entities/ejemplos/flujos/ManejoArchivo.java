package com.acme.entities.ejemplos.flujos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ManejoArchivo {

	public static void main(String[] args) {
		JsonObject js1 = new JsonObject();
		js1.addProperty("nombre", "Pollo");
		js1.addProperty("cantidad", 20);
		
		JsonObject js2 = new JsonObject();
		js2.addProperty("nombre", "Pescado");
		js2.addProperty("cantidad", 15);
				
		JsonObject js3 = new JsonObject();
		js3.addProperty("nombre", "Cerdo");
		js3.addProperty("cantidad", 5);
		
		JsonArray lista = new JsonArray();
		lista.add(js1);
		lista.add(js2);
		lista.add(js3);
		
		// Utilitario
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String contenido = gson.toJson(lista);
		
		System.out.println(contenido);
		
		try {
			guardarArchivo("D:\\DELETE_ME\\archivo.json", contenido);
		} catch (IOException e) {
			System.out.println("Error guardando el archivo");
		}
	}

	private static void guardarArchivo(String nombreArchivo, String contenido) throws IOException {
		File archivo = new File(nombreArchivo);
		
		if(archivo.exists()) {
			System.out.println("El archivo ya existe, lo voy a sobre-escribir");
		}
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
		    writer.write(contenido);
		}
	}
}
