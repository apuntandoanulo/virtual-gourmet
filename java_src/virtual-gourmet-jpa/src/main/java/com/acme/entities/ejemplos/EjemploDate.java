package com.acme.entities.ejemplos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploDate {

	public static void main(String[] args) throws ParseException {
		Date f1 = new Date();
		
		Calendar cl = Calendar.getInstance();
		cl.setTime(f1);
		
		
		
		System.out.println("Dia del mes: " + cl.get(Calendar.DAY_OF_MONTH));
		System.out.println("Mes: " + + (cl.get(Calendar.MONTH) + 1));
		System.out.println("Semana del año: " + cl.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Año: " + cl.get(Calendar.YEAR));
		
		System.out.println("Hora: " + cl.get(Calendar.HOUR_OF_DAY));
		System.out.println("Milis: " + cl.get(Calendar.MILLISECOND));
		
		cl.add(Calendar.HOUR_OF_DAY, 16);
		
		System.out.println("---------------");
		
		System.out.println("Dia del mes: " + cl.get(Calendar.DAY_OF_MONTH));
		System.out.println("Mes: " + + (cl.get(Calendar.MONTH) + 1));
		System.out.println("Semana del año: " + cl.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Año: " + cl.get(Calendar.YEAR));
		
		System.out.println("---------------");
		
		System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(f1));
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(f1));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2015-05-10"));
	}
}
