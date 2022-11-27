from logistica import *
class Equipaje(CargaExtra):
    equipajes=[]
    
    def __init__(self,precio,tamaño):
        super(precio, tamaño)
        Equipaje.equipajes.append(self)
    
    def agregar(self):
        Equipaje.equipajes.append(self)
    
    @classmethod
    def getEquipajes(cls):
        return cls.equipajes
    @classmethod
    def setEquipajes(cls,equipaje):
        cls.equipajes = equipaje