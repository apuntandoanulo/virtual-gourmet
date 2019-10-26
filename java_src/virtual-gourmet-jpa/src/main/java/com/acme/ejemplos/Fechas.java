package com.acme.ejemplos;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Fechas {

	public static void main(String[] args) throws Exception {
		TimeZone tzCol = TimeZone.getTimeZone("GMT-05:00");
		
		SimpleDateFormat sdfGMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		sdfGMT.setTimeZone(tzCol);
		
		Date fecha1 = sdfGMT.parse("2019-10-15 20:25:32 -0000");
		Date fecha2 = sdfGMT.parse("2019-10-15 20:25:32 +0000");
		Date fecha3 = sdfGMT.parse("2019-10-15 20:25:32 -1000");
		Date fecha4 = sdfGMT.parse("2019-10-15 20:25:32 +1800");
		Date fecha5 = sdfGMT.parse("2019-10-15 20:25:32 -0800");
		Date fecha6 = sdfGMT.parse("2019-10-15 20:25:32 GMT-05:00");
		Date fecha7 = sdfGMT.parse("2019-10-15 20:25:32 PDT");
		
		sdfGMT.setTimeZone(tzCol);
		
		System.out.println(sdfGMT.format(fecha1));
		System.out.println(sdfGMT.format(fecha2));
		System.out.println(sdfGMT.format(fecha3));
		System.out.println(sdfGMT.format(fecha4));
		System.out.println(sdfGMT.format(fecha5));
		System.out.println(sdfGMT.format(fecha6));
		System.out.println(sdfGMT.format(fecha7));
		
		System.out.println("----");
		System.out.println("----");
		System.out.println("----");
		
		DateTimeFormatter dtfGMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		
		ZonedDateTime zdtCol1 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT-00:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol2 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT+00:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol3 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT-10:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol4 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT+18:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol5 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT-08:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol6 = ZonedDateTime.parse("2019-10-15 20:25:32 GMT-05:00", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		ZonedDateTime zdtCol7 = ZonedDateTime.parse("2019-10-15 20:25:32 PDT", dtfGMT).toInstant().atZone(tzCol.toZoneId());
		
		System.out.println(zdtCol1.format(dtfGMT));
		System.out.println(zdtCol2.format(dtfGMT));
		System.out.println(zdtCol3.format(dtfGMT));
		System.out.println(zdtCol4.format(dtfGMT));
		System.out.println(zdtCol5.format(dtfGMT));
		System.out.println(zdtCol6.format(dtfGMT));
		System.out.println(zdtCol7.format(dtfGMT));
		
		System.out.println("----");
		System.out.println("----");
		System.out.println("----");
	}
}
