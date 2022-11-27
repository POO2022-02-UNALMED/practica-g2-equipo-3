class Avion:
    
    aviones = []
    
    def __init__(self, modelo, cantidad_asientos):
        self.modelo = modelo
        self.cantidad_asientos = cantidad_asientos
        self.asientos = []
        
        distribucion = calcular_asientos(cantidad_asientos)
        for i in range(cantidad_asientos+1):
            if i<=distribucion[0]:
                self.asientos.append(Asiento(i,self, Clase.PREMIUM))
            elif i<=distribucion[1]+distribucion[0]:
                self.asientos.append(Asiento(i,self, Clase.EJECUTIVA))
            else:
                self.asientos.append(Asiento(i,self, Clase.ECONOMICA))
        
        Avion.aviones.append(self)
            
        
    def calcular_asientos(numero_asientos):
        distribucion=[]
        if math.ceil((numero_asientos/6)%2)==0:
            premium = math.ceil(numero_asientos/6)
        else:
            premium = math.ceil((numero_asientos/6)+1)
            
        if math.ceil((numero_asientos*2/6)%2)==0:
            ejecutiva = math.ceil(numero_asientos*2/6)
        else:
            ejecutiva = math.ceil((numero_asientos*2/6)+1)
        economica=numero_asientos - (premium+economica)
        distribucion.append(premium)
        distribucion.append(ejecutiva)
        distribucion.append(economica)
        return distribucion
    
    def filtrar_asientos(self,clase):
        resultado = []
        for asiento in self.asientos:
            if asiento.getClase()==clase:
                resultado.append(asiento)
    
    def eliminar_avion(self):
        Avion.aviones.remove(self)
    
    
    def getModelo(self):
        return self.modelo
    def setModelo(self,modelo):
        self.modelo = modelo
    
    def getCantidadAsientos(self):
        return self.cantidad_asientos
    def setCantidadAsientos(self,cantidad_asientos):
        self.cantidad_asientos = cantidad_asientos
        
    def getAsientos(self):
        return self.asientos
    def setAsientos(self,asientos):
        self.asientos = asientos
    
    @classmethod
    def getAviones(cls):
        return cls.aviones
    @classmethod
    def setAviones(cls,aviones):
        cls.aviones = avionesi