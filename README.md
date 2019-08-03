# Virtual Gourmet

## Configurando el ambiente de desarrollo

El proyecto de Virtual Gourmet es una solucion Java, basada en JEE6. Usa Maven para compilar y empaquetar el artefacto final.

### 1. Pre-requisitos
* Java Development Kit - JDK 8 (Configure el directorio de instalacion del JDK como variable de entorno **JAVA_HOME**)
* Alguna utilidad para descomprimir archivos
* Algun programa para edicion de archivos (Notepad++, Atom)

<br/>

### 2. Configuring the Apache TomEE Server
* Decargue [Apache TomEE 7.1.x](http://tomee.apache.org/download-ng.html), seleccione la  select **PLUS** version

* Descomprima el archivo descargado (La carpeta donde queda el contenido la llamaremos **TOMEE_HOME**). Vaya a la carpeta _TOMEE_HOME/bin_, agregue un nuevo archivo llamado ‘setenv.bat’ y agregue el siguiente contenido (Para ajustar la memoria):

```
set CATALINA_OPTS=-Xms1024m -Xmx1536m
```

* Vaya a la carpeta _TOMEE_HOME/conf_:
  - **server.xml:** Configure los puertos de TomEE, por ejemplo: Java HTTP Connector, Java AJP Connector, APR (HTTP/AJP) Connector.
  
  A continuación un ejemplo de como el puerto HTTP es cambiado al 80 (Por defecto esta definido en el 8080)
    
  ```xml
  <Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" server="Apache TomEE" xpoweredBy="false"/>
  ```
 
* Para habilitar el proveedor de persistencia Hibernate, debe agregar manualmente las librerias a TomEE. Copie el contenido de la carpeta _resources/tomee-1.7.1/added-libs_ a _TOMEE_HOME/lib_

* Inicia el servidor ejecutando _TOMEE_HOME/bin/startup.bat_. 

<br/>
