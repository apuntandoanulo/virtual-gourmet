package com.acme.entities.ejemplos.apache;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;

public class ComprimirArchivos {

	public static void main(String[] args) throws Exception {
		File miDirectorioArchivos = new File("D:\\DELETE_ME\\archivos_clase");
		String miArchivoDestino = "D:\\DELETE_ME\\comprimido.zip";
		
		OutputStream flujoSalida = new FileOutputStream(miArchivoDestino);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, flujoSalida);
        
        Collection<File> fileList = FileUtils.listFiles(miDirectorioArchivos, new String[] {"json","xml"}, true);

        System.out.println(fileList.size() + " archivos para comprimir...");
        
        for (File file : fileList) {
            String entryName = getEntryName(miDirectorioArchivos, file);
            
            System.out.println("Agregando: " + entryName);
            
            ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
            archive.putArchiveEntry(entry);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));

            IOUtils.copy(input, archive);
            input.close();
            archive.closeArchiveEntry();
        }

        System.out.println("Archivo creado!");
        
        archive.finish();
        flujoSalida.close();
	}
	
	/**
     * Remove the leading part of each entry that contains the source directory name
     *
     * @param source the directory where the file entry is found
     * @param file   the file that is about to be added
     * @return the name of an archive entry
     * @throws IOException if the io fails
     */
    private static String getEntryName(File source, File file) throws IOException {
        int index = source.getAbsolutePath().length() + 1;
        String path = file.getCanonicalPath();

        return path.substring(index);
    }
}
