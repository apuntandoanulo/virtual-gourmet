package com.acme.entities.ejemplos;

import java.util.StringTokenizer;

public class EjemploStringTokenizer {

	static String in = "title=Java: La referencia;author=Schild;publisher=Oracle Corp;copyright=2019";
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(in, "=;");
		
		while (st.hasMoreElements()) {
			String key = st.nextToken();
			String val = st.nextToken();
						
			System.out.println("Key = " + key + "\nValue = " + val + "\n\n");
		}
		
		for(String s1 : in.split("=")) {
			for(String s2 : s1.split(";")) {
				System.out.println(s2);
			}
		}
	}
}
