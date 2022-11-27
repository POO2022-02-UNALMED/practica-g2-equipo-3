class Clase:
    type_ = Double()

    def __init__(self, value):
        self.type_ = value

Clase.ECONOMICA = Clase(1.0)

Clase.EJECUTIVA = Clase(1.25)

Clase.PREMIUM = Clase(1.5)