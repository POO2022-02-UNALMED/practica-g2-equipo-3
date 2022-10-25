
# Proyecto de Programación Orientada a Objetos
El objetivo del proyecto es crear un sistema de administracion de tiquetes para una aerolinea,
el cual permita agendar, cancelar, modificar y revisar los vuelos asignados al usuario que la
utilice. A continuacion se explicaran las funciones de cada clase y la relacion que tienen entre
estas.

## Integrantes
- Juan Pablo Gomez Reyes
- Felipe Muñoz Echeverri
  
## Diagrama de clases
[Diagrama de clases](https://app.genmymodel.com/api/projects/_ilWKYCTREe2TQ77rRj9fOQ/diagrams/_ilWKYyTREe2TQ77rRj9fOQ/svg)

## En el paquete logistica:

La clase Asiento se usa para determinar que asientos estan ocupados en un vuelo, además de su clase.
Un vuelo tiene multiples asientos. La disponibilidad del asiento es utilizada por la funcion reservar
tiquete, la cual filtrara todos los asientos no ocupados de un vuelo elegido por el usuario. La clase
del asiento es utilizada tambien en este filtro, ademas, se la utiliza como un "multiplicador" a la hora
de calcular el coste del vuelo.

La clase Avion principalmente es utilizada para almacenar la informacion de los asientos, asi como el
modelo del avion y la cantidad de sillas totales que tiene; tambien contiene una lista con todos los 
aviones registrados hasta el momento.

CargaExtra es una clase abstracta que sirve para plantear las reglas que han de seguir los dos tipos de 
cargas: Mascota y Equipaje, estas clases tambien utilizan el constructor de CargaExtra.

La clase Ciudad guarda el nombre y el pais al que pertenece. Esta clase se utiliza para asignarle un 
origen y un destino a los vuelos, ademas, es utlizada en la funcion reservar tiquete, donde los vuelos
disponibles pueden ser filtrados por ciudad asociada.

El enum Clase es utilizado para asignarle una Clase (calidad) a los asientos, y para realizar las
respectivas multiplicaciones de precio.

La clase Vuelo es la segunda clase mas importante del programa, esta almacena toda la informacion
pertinente a los vuelos -la base de la aerolinea-, almacena un avion que contiene asientos,
almacena la id del vuelo, una ciudad de origen y destino, la hora de salida y llegada, la fecha de
salida, la tarifa base, el puerto, y una lista de todos los tiquetes vendidos hasta el momento para
dicho vuelo, ademas de una lista con todos los vuelos creados y un int con esta misma funcion.
La clase Vuelo es accesada constantemente por practicamente todas las funciones, es utilizada a la hora
de crear o editar un tiquete, es lo que se le muestra al usuario a la hora de comprar un nuevo tiquete,
y es ella quien contiene la gran mayoria de la informacion que el tiquete utilizara.

## En el paquete usuario:

La clase Admin se utiliza a la hora de hacer el log-in, un usuario que se loguee como Admin tendra
acceso a multiples opciones extra que le permitiran modificar la base de datos, hacer cosas como
agregar vuelos, ciudades, aviones, etc.

La clases Equipaje y Mascota heredan de CargaExtra, son los dos tipos de carga extra que se pueden asignar
a un tiquete, cada una con su respectivo impacto en el costo final.

La clase Pasajero se utiliza para guardar la informacion del pasajero que se registrara en el tiquete,
esta informacion se requerira a la hora de reservar un tiquete. Esta clase es importante, pues un
usuario puede comprar un tiquete a nombre de alguien mas si tiene su informacion, por ejemplo, para
regalar el tiquete.

PreciosExtra es una interfaz que guarda los precios correspondientes a las cargas extras. A esta
interfaz se la llama a la hora de calcular precios.

La clase tiquete es, definitivamente, la clase mas importante de todas. Esta clase almacena informacion
y llama a todas las clases anteriores, las funciones principales se centran en ella, y es el interes
principal del usuario. Un tiquete almacena toda la informacion que tanto el usuario como las funciones
necesitan, es llamado, modificado, y creado por el usuario por medio de los metodos del main. Un usuario
puede tener asignados multiples tiquetes.

La clase Usuario es la que interactua con el programa, tiene un usuario y contraseña que
seran utilizados a la hora de hacer el login. Sin un usuario no se puede accesar al programa. Un usuario
tendra un array de tiquetes que puede estar vacio, y una "cartera", la cual servira para almacenar cualquier
reembolso que el usuario realice