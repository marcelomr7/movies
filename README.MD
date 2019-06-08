# Se utilizo:
* Java 8
* Maven 3.6.1
* Eclipse STS (Spring Tool Suite) 4.
* Spring Boot 1.5.6
* Se puede usar otro eclipse, por ejemplo tambien lo probe con eclipse "201903" que es una de las ultimas versiones.

# Ambiente
* Tener configurado java, mvn, y eclipse.
* Descargar el proyecto de github.
* Descomprimir el proyecto "movies-master.zip" en el workspace y dejarlo con el nombre de "movies"

#### Desde eclipse importar el proyecto como "Existing Maven Projects"
##### Correr por consola (siempre estando parado dentro del proyecto):
* mvn clean
* mvn eclipse:clean
* mvn eclipse:eclipse
* mvn compile
* mvn test-compile
* mvn test
* Hacer un F5 "refresh" sobre el projecto, desde eclipse.
* o tambien podemos ejecutar el AppTest.java (modo run/debug) desde eclipse.

##### Diagrama

![alt text](https://github.com/marcelomr7/movies/raw/master/src/main/resources/movies.png)
