
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

(En este diagrama se obvian los Getters y Setters)

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

## uiMain

La clase Funcion contiene todas las funciones principales que interactuan directamente con el usuario,
entre estas estan:
ReservaTiquetes es probablemente la funcion mas completa de todas, esta le pedira un input al usuario
para realizar una busqueda en el array que contiene todos los vuelos, una vez encuentra vuelos que
satisfagan las condiciones entregadas, le pedira al usuario que escoja cual de los vuelos desea tomar,
le preguntara la clase de silla que desea, le mostrara una lista con las sillas disponisbles y le pedira
que escoja una. Tras esto se le pedira la informacion de la persona a nombre de la cual se hara 
el tiquete. Por ultimo, se le preguntara si desea agregar equipaje extra o mascotas. El usuario
determinara cuales y cuantas de estas cargas extras deseara tomar. Tras haber suministrado toda esta
informacion, se haran dos procesos: Se generara una factura que contenga todos los costos 
relacionados con el vuelo y las cargas extra, se preguntara al usuario si todo es correcto y, 
si la respuesta es afirmativa, se generara un tiquete nuevo asociado al usuario con todas las
especificaciones que fueron pasadas por consola.

MisTiquetes contacta tanto con el usuario como con sus tiquetes, la opcion de reembolsar recibe
un input del usuario para buscar el tiquete apropiado y efectuar cambios sobre este, despues de
tener el tiquete, se llama a la funcion reembolsar de la clase usuario, la cual elimina el 
tiquete para el usuario y le reembolsa el costo a su cartera, la cual puede usar para futuros pagos.
Ver cartera devuelve el valor en cartera del usuario actual.
Agregar carga extra llama a la funcionagregarCargaExtra, la cual sera explicada mas adelante, 
a esta funcion se accede una vez se crea un tiquete, sin embargo, tambien se la incluye aqui en caso
que el usuario olvide alguna carga, o tenga que agregar una nueva carga que antes no tenia prevista.

CheckIn es una funcion esencial, pues esta se encarga de administrar el estado del tiquete,
un tiquete al cual no se le ha hecho check-in puede ser editado sin limitaciones, sin embargo,
tras hacer el Check-in no se pueden realizar mas cambios al respectivo tiquete, devoluciones
incluidas. Esta funcion le mostrara al usuario todos sus tiquetes actualmente asignados con toda la
informacion correspondiente, y le pedira que escoja en cual de estos desea realizar su
Check-in, posteriormente se le volvera a mostrar la informacion importante del tiquete y se
le pedira una ultima confirmacion. Tras hacer la confirmacion se cambiara el valor de Check-in
del tiquete seleccionado, esto significa que no se podra ejecutar ninguna funcion mas sobre este tiquete.
Idealmente, no realizar el Check-in a tiempo significa que el usuario no puede utilizar su tiquete.

VerTodosLosVuelos Se explica por si misma, se hace un print por cada vuelo actualmente en la
base de datos.

AgregarCargaExtra no es una funcion que el usuario llame directamente, esta es una funcion que
se utiliza a la hora de reservar un tiquete, una vez el usuario ha terminado de brindar toda la informacion,
o cuando es llamada desde la funcion misTiquetes.
Esta funcion es un ciclo que constantemente le pregunta al usuario si desea agregar carga extra
a su tiquete, en caso de una respuesta positiva, generara un nuevo objeto de la clase que el
usuario determine, con las caracteristicas que el usuario determine, para posteriormente ser agregada
al tiquete del usuario y ser utilizada en el calculo del recibo, asi como en el calculo del reembolso,
de ser necesario.

En la clase Main se utiliza ligadura dinamica a la hora de asignar usuarios y administradores,
pues un administrador es un usuario y se hace uso de esto a la hora de utilizar un administrados.