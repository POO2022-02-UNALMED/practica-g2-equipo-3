class CargaExtra:
    cargas = []
    def __init__(self,precio,tamaño):
        self.precio = precio
        self.tamaño = tamaño
        CargaExtra.cargas.append(self)
    def agregar(self):pass
    
    def getPrecio(self):
        return self.precio
    def setPrecio(self,precio):
        self.precio = precio
    def getTamaño(self):
        return self.tamaño
    def setTamaño(self,tamaño):
        self.tamaño = tamaño
    @classmethod
    def getCargas(cls):
        return cls.cargas
    @classmethod
    def setCargas(cls,cargas):
        cls.cargas = cargas