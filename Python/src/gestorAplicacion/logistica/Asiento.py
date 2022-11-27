class Asiento:

    # constructores
    def __init__(self, numero_asiento, avion, clase):
        self.numeroAsiento = numero_asiento
        self.disponibilidad = True
        self.avion = avion
        self.clase = clase

    # methods
    def __str__(self):
        if self.clase == Clase.PREMIUM:
            txt = self.numeroAsiento+"PR"
            return txt
        elif self.clase == Clase.EJECUTIVA:
            txt = self.numeroAsiento+"EJ"
            return txt
        else:
            txt = self.numeroAsiento+"EC"
            return txt

    # getter and setter
    def getNumeroAsiento(self):
        return self.numeroAsiento

    def setNumeroAsiento(self, numero_asiento):
        self.numeroAsiento = numero_asiento

    def getDisponibilidad(self):
        return self.disponibilidad

    def setDisponibilidad(self, disponibilidad):
        self.disponibilidad = disponibilidad

    def getAvion(self):
        return self.avion

    def setAvion(self, avion):
        self.avion = avion

    def getClase(self):
        return self.clase

    def setClase(self, clase):
        self.clase = clase