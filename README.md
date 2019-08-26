# Virtual Gourmet

El proyecto Virtual Gourmet es una aplicacion Java, con componentes Web y de servicios, que busca cubrir las necesidades descritas [aqui](https://apuntandoanulo.com/2016/04/25/planteando-el-primer-problema/).

***

## Tabla de contenido

* [Primero pasos](#primeros-pasos-que-necesita-saber)
* [Configuracion del ambiente de desarrollo](#configurando-el-ambiente-de-desarrollo)

***

## Primeros pasos: ¿Que necesita saber?

Los artículos publicados en el [blog](https://apuntandoanulo.com) abordan la definición del proyecto desde las primeras lineas de código y la configuración requerida, usted solo necesita tener:

* Conocimientos básicos de Java 7
* Conocimientos básicos en bases de datos
* Conocimientos en aplicaciones web

***

## Configurando el ambiente de desarrollo

El proyecto de Virtual Gourmet es una solucion Java, basada en JEE6. Usa Apache Maven para compilar y empaquetar el artefacto final.

### 1. Pre-requisitos

* Alguna utilidad para descomprimir archivos (7-Zip, WinZip)
* Algun programa para edicion de archivos (Notepad++, Atom)
* Base de datos Postgresql (En los ejemplos se usa la version 11)

<br/>

### 2. Java Development Kit

Usaremos JDK 11, disponible para descarga [aqui](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

La versión ofrecida por Oracle la podemos utilizar para desarrollo, pero usted puede usar otra implementación del JDK como las ofrecidas por [OpenJDK](https://openjdk.java.net/) o [Azul systems](https://www.azul.com/downloads/zulu-community/)

Una vez instalado asegurese de configurar la variable de entorno **JAVA_HOME** apuntando a su directorio de instalacion. Al ejecutar el comando Java en la linea de comandos, debería mostrar algo como:

<p align="center">
<img src="https://github.com/apuntandoanulo/virtual-gourmet/blob/master/resources/docs/img/java-version.png?raw=true" width="500" />
</p>

### 3. Configurando el servidor de aplicaciones Apache TomEE Server

* Decargue [Apache TomEE 7.1.x](http://tomee.apache.org/download-ng.html), seleccione la  select **PLUS** version

* Descomprima el archivo descargado (La carpeta donde queda el contenido la llamaremos **TOMEE_HOME**). Vaya a la carpeta _TOMEE_HOME/bin_, agregue un nuevo archivo llamado ‘setenv.bat’ y agregue el siguiente contenido (Para ajustar la memoria usada por el servidor):

```
set CATALINA_OPTS=-Xms1024m -Xmx1536m
```

* Vaya a la carpeta _TOMEE_HOME/conf_:
  - **server.xml:** Configure los puertos de TomEE, inicialmente solo necesitamos el HTTP:
  
  A continuación un ejemplo de como el puerto HTTP es cambiado al 80 (Por defecto esta definido en el 8080)
    
  ```xml
  <Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" xpoweredBy="false" server="Apache TomEE" />
  ```
 
* Para habilitar el proveedor de persistencia para JPA _Hibernate_, debe:

  * Agregar manualmente las librerias a TomEE. Copie el contenido de la carpeta [resources/tomee-1.7.1/added-libs](https://github.com/apuntandoanulo/virtual-gourmet/tree/master/resources/tomee-1.7.1/added-libs) a _TOMEE_HOME/lib_
  * Eliminar manualmente las siguientes librerias de _TOMEE_HOME/lib_: bval-core-1.1.2.jar, bval-jsr-1.1.2.jar y openjpa-2.4.3.jar

* Finalmente, inicie el servidor ejecutando _TOMEE_HOME/bin/startup.bat_. Abra un navegador web e ingrese la dirección http://localhost. Deberá ver la pagina de inicio de TomEE.

<p align="center">
<img src="https://github.com/apuntandoanulo/virtual-gourmet/blob/master/resources/docs/img/tomee-startup.png?raw=true" width="700" />
</p>

<br/>

### 4. Descarga y configuracion del IDE Eclipse

* Descargue el Eclipse desde el sitio oficial [eclipse.org](https://www.eclipse.org/downloads/packages/), seleccione la version para desarrolladores Java (Eclipse IDE for Enterprise Java Developers)

* Descomprima el archivo descargado (La carpeta donde queda el contenido la llamaremos **ECLIPSE_HOME**. Vaya al ECLIPSE_HOME y edite el archivo ‘eclipse.ini’, y ajuste los valores de memoria:

```
-Xms512m
-Xmx1536m
```

* Ejecute el eclipse.exe y seleccione su espacio de trabajo. Luego vaya al menu: Windows -> Preferences -> Java -> Installed JREs. Verifique que el nuevo JDK instalado esta seleccionado o agreguelo manualmente.

* Instale el plugin 'JBoss Tools’. Vaya al menu Help -> Eclipse Marketplace... busque ‘JBoss Tools 4’ e instale la versión mas reciente.
Una vez el proceso de instalación termine, reinicie el Eclipse.

### 5. Configuración de Apache Maven

* Descargue [Apache Maven](https://maven.apache.org/download.cgi#), seleccione la version 3.6.x (Binary zip archive)

* Descomprima el archivo descargado. La carpeta donde queda el contenido la llamaremos **MAVEN_HOME**.

* Ahora configure Eclipse para que use la versión descargada de Maven. Vaya al menu Window -> Preferences -> Maven -> Installations. Seleccione el botón 'Add'

* Busque su MAVEN_HOME. El campo “installation name” es automaticamente llenado cuando el directorio es escogido. De clic en 'Finish’

<p align="center">
<img src="https://github.com/apuntandoanulo/virtual-gourmet/blob/master/resources/docs/img/mvn_conf.png?raw=true" width="500" />
</p>

* Finalmente, seleccione en Eclipse la nueva instalación de Maven.

<br/>
