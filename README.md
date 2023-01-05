# turismo.uy
Proyecto de la materia taller de programación, Fing UdelaR.

## Run

1. Modificar .properties, configurar las variables según se donde se ejecuta y guardarlos en /home/.turismoUy/. En la variable file_path inidicar la carpeta donde se guardan las imagenes estas se pueden encontrar en turismo.uy/src/main/webapp/media/imagenes/. Tambien modificar la ruta en el archivo de script.sh, a donde se encuentran las carpetas del proyecto.

2. Modificar el archivo persistence.xml que se encuentra en turismo.uy/servidor-central/src/META-INF/, espesificamente la linea 13 colocando la dirección donde se generara la base de datos.

3. Ejecutar el script.sh (chequear si tiene Maven instalado).

4. Ejecutar el .jar, este es el servidor-central. Además con el programa principal abierto publicar los webservices, que se encuentran en pestaña sistema.

5. Realizar el war file deployment con tomcat.

6. Disfrute.
