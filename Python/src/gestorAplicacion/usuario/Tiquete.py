from logistica import *
class Tiquete:
    tiquetes = []
    totalCreado = 0
    
    def __init__(self,pasajero,vuelo,asiento,cargaExtra,descuento,checkIn=False):
        self.idTiquete = Tiquete.totalCreado
        self.pasajero = pasajero
        self.vuelo = vuelo
        self.asiento = asiento
        self.descuento = descuento
        self.cargaExtra = cargaExtra
        self.checkIn=checkIn
        Tiquete.tiquetes.append(self)
        Tiquete.totalCreado += 1
    
    def precioTotal(self):
        p= self.vuelo.getTarifaBase()*self.asiento.getClase().type
        if self.cargaExtra != None:
            for extra in self.cargaExtra:
                p+= extra.getPrecio()
        p=p-self.descuento
        return p
    
    def getIdTiquete(self):
        return self.idTiquete
    def setIdTiquete(self,id):
        self.idTiquete = id
    def getVuelo(self):
        return self.vuelo
    def setVuelo(self,vuelo):
        self.vuelo = vuelo
    def getAsiento(self):
        return self.asiento
    def setAsiento(self,asiento):
        self.asiento = asiento
    def getDescuento(self):
        return self.descuento
    def setDescuento(self,descuento):
        self.descuento = descuento
    def getCargaextra(self):
        return self.cargaextra
    def setCargaextra(self,cargaextra):
        self.cargaExtra = cargaextra
    def getPasajero(self):
        return self.pasajero
    def setPasajero(self,pasajero):
        self.pasajero = pasajero
    @classmethod
    def getTotalCreado(cls):
        return cls.getTotalCreado
    @classmethod
    def setTotalCreado(cls,totalCreado):
        cls.totalCreado = totalCreado
    @classmethod
    def getTiquetes(cls):
        return cls.getTiquetes
    @classmethod
    def setTiquetes(cls,tiquetes):
        cls.tiquetes = tiquetes
    def getCheckIn(self):
        return self.checkIn
    def setCheckIn(self,checkIn):
        self.checkIn = checkIn