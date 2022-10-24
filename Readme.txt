El objetivo del proyecto es crear un sistema de administracion de tiquetes para una aerolinea,
el cual permita agendar, cancelar, modificar y revisar los vuelos asignados al usuario que la
utilice. A continuacion se explicaran las funciones de cada clase y la relacion que tienen entre
estas.

En el paquete logistica:

La clase asiento se usa para determinar que asientos estan ocupados en un vuelo, además de su clase.
Un vuelo tiene multiples asientos. La disponibilidad del asiento es utilizada por la funcion reservar
tiquete, la cual filtrara todos los asientos no ocupados de un vuelo elegido por el usuario. La clase
del asiento es utilizada tambien en este filtro, ademas, se la utiliza como un "multiplicador" a la hora
de calcular el coste del vuelo.

La clase avion principalmente es utilizada para almacenar la informacion de los asientos, asi como el
modelo del avion y la 