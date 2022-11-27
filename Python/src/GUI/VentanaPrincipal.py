from tkinter import *
from tkinter import messagebox
from tkinter.ttk import Combobox

class VentanaPrincipal(Toplevel):

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.geometry("900x700")
        self.title("Vuelos AeroUnal")
        self.resizable(0,0)
        self.focus()

        ###########
        self.option_add("*tearOff",False)
        self.menubar=Menu(self)

        self.menuArchivo=Menu(self.menubar)
        self.menuArchivo.add_command(label="Aplicacion",command=self.menuAplicacion)
        self.menuArchivo.add_command(label="Salir",command=self.menuSalir)
        self.menubar.add_cascade(menu=self.menuArchivo, label="Archivo")

        self.menuProcyCons=Menu(self.menubar)
        self.menuProcyCons.add_command(label="Ver y filtrar vuelos", command=self.verVuelos)
        self.menuProcyCons.add_command(label="Reservar Tiquete", command=self.reservarTiquete)
        self.menuProcyCons.add_command(label="Administrar Tiquetes", command=self.misTiquetes)
        self.menuProcyCons.add_command(label="Realizar CheckIn", command=self.checkIn)
        self.menuProcyCons.add_command(label="Agregar Carga Extra",command=self.cargaExtra)
        self.menubar.add_cascade(menu=self.menuProcyCons, label="Procesos y Consultas")
        
        self.menuArcercaDe=Menu(self.menubar)
        self.menuArcercaDe.add_command(label="Acerca de", command=self.acercaDe)
        self.menubar.add_cascade(menu=self.menuArcercaDe, label="Ayuda")
        self.configure(menu=self.menubar)
        ###############
        self.frame=Frame(self,bg="gray")
        self.frame.pack(padx=10, pady=5,expand=True,fill=BOTH)

        self.frameTitulo=Frame(self.frame)
        self.frameTitulo.pack(padx=3,pady=2,fill=X)
        self.labelTitulo=Label(self.frameTitulo,text="Bienvenido a AeroUnal",font=("Times New Roman",20),height=2)
        self.labelTitulo.pack()

        self.frameDescripcion=Frame(self.frame)
        self.frameDescripcion.pack(padx=3,pady=2,fill=X)
        self.labelDescripcion=Label(self.frameDescripcion,text="Consulte las funciones disponibles en los menús superiores",font=("Times New Roman",15),height=3)
        self.labelDescripcion.pack()

        self.framePrincipal=Frame(self.frame)
        self.framePrincipal.pack(padx=3,pady=3,fill=BOTH,expand=TRUE)
        self.labelDescripcion=Label(self.framePrincipal,text="Una vez clickee en una de ellas, podrá consultarla desde esta ventana",font=("Times New Roman",10),height=3)
        self.labelDescripcion.pack()
        ###############
        
        

        self.mainloop()

    def menuAplicacion(self):
        self.popup=messagebox.showinfo(title="Aplicación",message="Información sobre AeroUnal", detail=
            "En esta aplicación podrá consultar los vuelos disponibles con su información relacionada, reservar tiquetes y modificarlos")

    def menuSalir(self):
        quit()

    def verVuelos(self):
        a

    def reservarTiquete(self):
        a

    def misTiquetes(self):
        a
        
    def checkIn(self):
        a

    def cargaExtra(self):
        a

    def acercaDe(self):
        self.popup=messagebox.showinfo(title="Información", message= "Desarrollado por Juan Pablo Gómez Reyes")

test=VentanaPrincipal()