class Pasajero:
    pasajeros = ArrayList()
    nombre = str()
    identificacion = int()
    tiquete = Tiquete()

    # constructores
    def __init__(self, nombre, identificacion):
        super(Pasajero, self).__init__()
        self.nombre = nombre
        self.identificacion = identificacion
        self.tiquete = None
        self.pasajeros.add(self)

    # metodos
    def __str__(self):
        return self.nombre + " " + self.identificacion

    # getter and setter
    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getIdentificacion(self):
        return self.identificacion

    def setIdentificacion(self, identificacion):
        self.identificacion = identificacion

    def getTiquete(self):
        return self.tiquete

    def setTiquete(self, tiquete):
        self.tiquete = tiquete

    @classmethod
    def getPasajeros(cls):
        return cls.pasajeros

    @classmethod
    def setPasajeros(cls, pasajeros):
        Pasajero.pasajeros = pasajeros