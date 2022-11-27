from logistica import *
class Mascota(CargaExtra):
    mascotas= []
    def __init__(self,precio,tamaño):
        super(precio, tamaño)
        Mascota.mascotas.append(self)
    
    def agregar(self):
        Mascota.mascotas.append(self)
    
    @classmethod
    def getEquipajes(cls):
        return cls.mascotas
    @classmethod
    def setEquipajes(cls,mascota):
        cls.mascotas = mascota