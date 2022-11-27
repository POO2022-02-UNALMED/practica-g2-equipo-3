class Vuelo:
    vuelos=[]
    totalCreado=0
    def __init__(self,avion,origen,destino,horaSalida,horaLlegada,fecha,tarifaBase,puerto,tiquetes=None):
        self.idVuelo=Vuelo.totalCreado
        self.avion=avion
        self.origen=origen
        self.destino=destino
        self.horaSalida=horaSalida
        self.tarifaBase=tarifaBase
        self.puerto=puerto
        self.tiquetes=tiquetes
        self.fecha=fecha
        Vuelo.vuelos.append(self)
        Vuelo.totalCreado+=1
    
    @staticmethod
    def filtroVuelos(origen):
        result = []
        for vuelo in Vuelo.getVuelos():
            if vuelo.getOrigen().getNombre()==origen:
                result.append(vuelo)
        return result
    
    def agregarTiquete(self,tiquete):
        self.tiquetes.append(tiquete)
    
    def eliminarVuelo(self):
        for tiquete in Tiquete.getTiquetes():
            if tiquete.getVuelo().getIdVuelo() == self.getIdVuelo():
                for user in Usuario.getUsuarios():
                    for i in range(len(user.getTiquetes())):
                        if user.getTiquetes()[i].getIdTiquete()==(tiquetes.getIdTiquete()):
                            print("tiquete reembolsado")
                            user.Reembolsar(i)
                tiquete.delete()
        Vuelo.vuelos.remove(self)
    
    
    def getIdVuelo(self):
        return self.idVuelo
    def setIdVuelo(self,id):
        self.idVuelo = id
    def getAvion(self):
        return self.avion
    def setAvion(self,avion):
        self.avion = avion
    def getOrigen(self):
        return self.origen
    def setOrigen(self,origen):
        self.origen = origen
    def getDestino(self):
        return self.destino
    def setDestino(self,destino):
        self.destino = destino
    def getHoraSalida(self):
        return self.horaSalida
    def setHoraSalida(self,horaSalida):
        self.horaSalida = horaSalida
    def getHoraLlegada(self):
        return self.horaLlegada
    def setHoraLlegada(self,horaLlegada):
        self.horaLlegada = horaLlegada
    def getFecha(self):
        return self.fecha
    def setFecha(self,fecha):
        self.fecha = fecha
    def getTarifaBase(self):
        return self.tarifa
    def setTarifaBase(self,tarifa):
        self.tarifa = tarifa
    def getPuerto(self):
        return self.puerto 
    def setPuerto(self,puerto):
        self.puerto = puerto
    @classmethod
    def getVuelos(cls):
        return cls.vuelos
    @classmethod
    def setVuelo(cls,vuelos):
        cls.vuelos = vuelos
    def getTiquetes(self):
        return self.tiquetes
    def setTiquetes(self,tiquetes):
        self.tiquetes = tiquetes
    @classmethod
    def getTotalCreado(cls):
        return cls.totalCreado
    @classmethod
    def setTotalCreado(cls,totalCreado):
        cls.totalCreado = totalCreado