package com.acme.entities.ejemplos.flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
		String rutaArchivo = "D:\\DELETE_ME\\archivo.json";
		
		//System.out.println(contenido);
		
		try {
			//guardarArchivo(rutaArchivo, contenido);
			String contenidoArchivo = leerArchivo(rutaArchivo);
			
			JsonArray nuevaLista = gson.fromJson(contenidoArchivo, JsonArray.class);
			
			for(JsonElement elemento : nuevaLista) {
				JsonObject objeto = (JsonObject) elemento;
				
				System.out.println(objeto.get("nombre"));
			}
			
		} catch (IOException e) {
			System.out.println("Error guardando el archivo");
		}
	}

	public static void guardarArchivo(String nombreArchivo, String contenido) throws IOException {
		File archivo = new File(nombreArchivo);
		
		if(archivo.exists()) {
			System.out.println("El archivo ya existe, lo voy a sobre-escribir");
		}
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
		    writer.write(contenido);
		}
	}
	
	public static String leerArchivo(String nombreArchivo) throws IOException {
		StringBuilder builder = new StringBuilder();
		File archivo = new File(nombreArchivo);
		
		if(archivo.exists()) {
			try(BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
				String currentLine = reader.readLine();
			    while (currentLine != null) {
			        builder.append(currentLine);
			        builder.append("\n");
			        currentLine = reader.readLine();
			    }
			}
		} else {
			System.out.println("Al archivo no existe");
		}
		
		return builder.toString();
	}
}
