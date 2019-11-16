package com.acme.entities.ejemplos.flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtilitarioJSON {

	public static void guardarArchivo(String nombreArchivo, Object objeto) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String contenido = gson.toJson(objeto);
		
		File archivo = new File(nombreArchivo);
		
		if(archivo.exists()) {
			System.out.println("El archivo ya existe, lo voy a sobre-escribir");
		}
		
		// try-with-resources
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
		    writer.write(contenido);
		}
	}
	
	public static Object leerArchivo(String nombreArchivo, Class<?> claseObjeto) throws IOException {
		// Utilitario
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
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
			
			return null;
		}
		
		return gson.fromJson(builder.toString(), claseObjeto);
	}
}
