class Usuario(PreciosExtra):
    usuarios = ArrayList()
    totalUsuarios = len(usuarios)
    id = str()
    password = str()
    tiquetes = ArrayList()
    cartera = int()

    # constructores
    @overloaded
    def __init__(self, id, password, cartera, tiquetes):
        super(Usuario, self).__init__()
        self.id = id
        self.password = password
        self.cartera = cartera
        self.tiquetes = tiquetes
        self.usuarios.add(self)
        self.totalUsuarios = len(usuarios)

    @__init__.register(object, str, str, int)
    def __init___0(self, id, password, cartera):
        super(Usuario, self).__init__()
        self.__init__(id, password, cartera, ArrayList())

    @__init__.register(object)
    def __init___1(self):
        super(Usuario, self).__init__()

    # metodos
    def Reembolsar(self, tiquete):
        tiqueteReembolsado = self.tiquetes.get(tiquete)
        if tiqueteReembolsado.isCheckIn() == True:
            print("Ya se hizo Chek-in en este tiquete, no se puede reembolsar")
            return
        self.cartera += tiqueteReembolsado.precioTotal()
        self.tiquetes.remove(tiquete)
        print("Reembolso exitoso")

    @classmethod
    def isUsuarioExist(cls, user):
        for u in Usuario.getUsuarios():
            if u.getId() == user:
                return True
        return False

    def descontarCartera(self, desc):
        self.cartera = self.cartera - desc

    # getter and setter
    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getPassword(self):
        return self.password

    def setPassword(self, password):
        self.password = password

    def getTiquetes(self):
        return self.tiquetes

    def setTiquetes(self, tiquetes):
        self.tiquetes = tiquetes

    def getCartera(self):
        return self.cartera

    def setCartera(self, cartera):
        self.cartera = cartera

    def AddTiquete(self, tiquete):
        self.tiquetes.add(tiquete)

    @classmethod
    def getUsuarios(cls):
        return cls.usuarios

    @classmethod
    def setUsuarios(cls, usuarios):
        Usuario.usuarios = usuarios

    @classmethod
    def setTotalUsuarios(cls, totalUsuarios):
        Usuario.totalUsuarios = totalUsuarios

    @classmethod
    def getTotalUsuarios(cls):
        return cls.totalUsuarios