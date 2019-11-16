package com.acme.entities.ejemplos.flujos;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilitarioXML {

	public static void guardarArchivo(String nombreArchivo, Object objeto) throws JAXBException {
		File archivo = new File(nombreArchivo);

		if (archivo.exists()) {
			System.out.println("El archivo ya existe, lo voy a sobre-escribir");
		}

		// Create JAXB Context
		JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());

		// Create Marshaller
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// Required formatting??
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write XML to StringWriter
		jaxbMarshaller.marshal(objeto, archivo);
	}

	public static Object leerArchivo(String nombreArchivo, Class<?> claseObjeto) throws JAXBException {
		File xmlFile = new File(nombreArchivo);

		JAXBContext jaxbContext = JAXBContext.newInstance(claseObjeto);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		return jaxbUnmarshaller.unmarshal(xmlFile);
	}
}
