class Ciudad:
    ciudades = ArrayList()
    nombre = str()
    pais = str()

    # constructores
    def __init__(self, nombre, pais):
        super(Ciudad, self).__init__()
        self.nombre = nombre
        self.pais = pais
        self.ciudades.add(self)

    # metodos
    def __str__(self):
        return self.nombre

    def EliminarCiudad(self):
        # constructores
        # metodos
        i = 0
        while i < Vuelo.getVuelos().size():
            # constructores
            # metodos
            if Vuelo.getVuelos().get(i).getOrigen().getNombre() == self.nombre | Vuelo.getVuelos().get(i).getDestino().getNombre() == self.nombre:
                Vuelo.getVuelos().get(i).eliminarVuelo()
            i += 1
        self.ciudades.remove(self)

    # getter and setter
    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    @classmethod
    def getCiudades(cls):
        return cls.ciudades

    @classmethod
    def setCiudades(cls, ciudades):
        Ciudad.ciudades = ciudades

    def getPais(self):
        return self.pais

    def setPais(self, pais):
        self.pais = pais