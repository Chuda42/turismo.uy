# turismo.uy
Proyecto de la materia taller de programación, Fing UdelaR.

## Versiones de las tecnologias

```
OpenJdk 11
```
```
Apache Maven 3.8.7 
```

## Run
0. Tener instaladas las versiones de las tecnologias antes mencionadas, y agregadas a las variables de entorno y al path.

1. Modificar .properties (servidor y web), configurar las variables según se donde se ejecuta y guardarlos en /home/.turismoUy/. En la variable file_path inidicar la carpeta donde se guardan las imagenes estas se pueden encontrar en turismo.uy/src/main/webapp/media/imagenes/.

2. Modificar el archivo persistence.xml que se encuentra en turismo.uy/servidor-central/src/META-INF/, especificamente la linea 13 colocando la dirección donde se generara la base de datos.

3. Estando en el directorio del proyecto ejecutar el script.sh (chequear si tiene Maven instalado).

4. Ejecutar el servidor.jar ubicado en servidor-central/target usando java -jar servidor.jar. Además con el programa principal abierto publicar los webservices, que se encuentran en pestaña sistema.

5. Realizar el war file deployment con tomcat, a los archivos web.war y movil.war, ubicados en turismo.uy/target y servidor-movil/target respectivamente.

6. Disfrute.
