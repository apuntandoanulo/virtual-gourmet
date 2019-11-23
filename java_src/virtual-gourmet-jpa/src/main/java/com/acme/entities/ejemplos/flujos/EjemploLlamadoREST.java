package com.acme.entities.ejemplos.flujos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class EjemploLlamadoREST {

	public static void main(String[] args) throws IOException {
		// Tomado de https://www.baeldung.com/java-http-request
		
		URL url = new URL("https://httpbin.org/get");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		//Agregando headers
		con.setRequestProperty("Saludo", "Curso uniremington");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer contenido = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			contenido.append(inputLine);
		}
		
		//Cerrando el flujo de lectura
		in.close();
		
		//Utilitarios para la manipulacion de JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject objetoJSON = gson.fromJson(contenido.toString(), JsonObject.class);
		
		System.out.println("Origen: " + objetoJSON.get("origin"));
		
		//Cerrando la conexion
		con.disconnect();
	}
}
