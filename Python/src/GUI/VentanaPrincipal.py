from tkinter import *
from tkinter import messagebox
from tkinter.ttk import Combobox
from FieldFrame import *

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
        self.labelPrincipal=Label(self.framePrincipal,text="Una vez clickee en una de ellas, podrá consultarla desde esta ventana",font=("Times New Roman",10),height=3)
        self.labelPrincipal.pack()
        ###############
        
        

        self.mainloop()

    def menuAplicacion(self):
        self.popup=messagebox.showinfo(title="Aplicación",message="Información sobre AeroUnal", detail=
            "En esta aplicación podrá consultar los vuelos disponibles con su información relacionada, reservar tiquetes y modificarlos")

    def menuSalir(self):
        quit()

    def acercaDe(self):
        self.popup=messagebox.showinfo(title="Información", message= "Desarrollado por Juan Pablo Gómez Reyes")

    def verVuelos(self):
        a

    def reservarTiquete(self):
        self.labelTitulo.configure(text="Reserva de tiquetes")
        self.labelDescripcion.configure(text="Consulte los vuelos disponibles, Encuentre y reserve su vuelo ideal")
        self.framePrincipal.pack_forget()
        self.framePrincipal=Frame(self.frame)
        self.framePrincipal.pack(padx=3,pady=3,fill=BOTH,expand=TRUE)
        self.frameParaCentrarlo=Frame(self.framePrincipal)
        self.frameParaCentrarlo.pack(padx=200)
        self.reserTexto=Label(self.frameParaCentrarlo,text="filtrar vuelos por:",font=("Times New Roman",15))
        self.reserTexto.grid(row=0,column=0,columnspan=2,pady=5)
        self.reserBoton1=Button(self.frameParaCentrarlo,text="Destino",height=3,width=20,command=self.filtrarPorDestino)
        self.reserBoton1.grid(row=1,column=0,padx=10)
        self.reserBoton2=Button(self.frameParaCentrarlo,text="Destino y Salida",height=3,width=20,command=self.filtrarPorSalidaYDestino)
        self.reserBoton2.grid(row=1,column=1,padx=10)

    def filtrarPorDestino(self):
        self.frameParaCentrarlo.pack_forget()
        self.frameParaCentrarlo=Frame(self.framePrincipal)
        self.frameParaCentrarlo.pack(padx=200)
        self.reserTexto=Label(self.frameParaCentrarlo,text="filtrar vuelos por:",font=("Times New Roman",15))
        self.reserTexto.grid(row=0,column=0,columnspan=2,pady=5)
        self.reserBoton1=Button(self.frameParaCentrarlo,text="Destino",height=3,width=20,command=self.filtrarPorDestino)
        self.reserBoton1.grid(row=1,column=0,padx=10)
        self.reserBoton2=Button(self.frameParaCentrarlo,text="Destino y Salida",height=3,width=20,command=self.filtrarPorSalidaYDestino)
        self.reserBoton2.grid(row=1,column=1,padx=10)
        self.labelTitulo.configure(text="Ha escogido filtrar por Destino")
        self.labelDescripcion.configure(text="Escoja la ciudad a la que partirá el vuelo")
        self.destinos=Combobox(self.frameParaCentrarlo, state="readonly", values=("Bogotá","Titiribi","Medellín","Ibagué","Cartagena"),width=22)
        self.destinos.grid(row=2,column=0,padx=10,pady=20)
        self.reserBoton3=Button(self.frameParaCentrarlo,text="Continuar",height=2,width=20,command=self.continuarReserva1)
        self.reserBoton3.grid(row=2,column=1,padx=10,pady=20)
        
    def filtrarPorSalidaYDestino(self):
        self.frameParaCentrarlo.pack_forget()
        self.frameParaCentrarlo=Frame(self.framePrincipal)
        self.frameParaCentrarlo.pack(padx=200)
        self.reserTexto=Label(self.frameParaCentrarlo,text="filtrar vuelos por:",font=("Times New Roman",15))
        self.reserTexto.grid(row=0,column=0,columnspan=2,pady=5)
        self.reserBoton1=Button(self.frameParaCentrarlo,text="Destino",height=3,width=20,command=self.filtrarPorDestino)
        self.reserBoton1.grid(row=1,column=0,padx=10)
        self.reserBoton2=Button(self.frameParaCentrarlo,text="Destino y Salida",height=3,width=20,command=self.filtrarPorSalidaYDestino)
        self.reserBoton2.grid(row=1,column=1,padx=10)
        self.labelTitulo.configure(text="Ha escogido filtrar por Destino")
        self.labelDescripcion.configure(text="Escoja la ciudad de donde partirá el vuelo y su destino")
        self.texto1=StringVar()
        self.texto1.set("Destino")
        self.EntryBloqueada1=Entry(self.frameParaCentrarlo,textvariable=self.texto1,state=DISABLED,font=("Times New Roman",12))
        self.EntryBloqueada1.grid(row=2,column=0,padx=10,pady=20)
        self.texto2=StringVar()
        self.texto2.set("Salida")
        self.EntryBloqueada2=Entry(self.frameParaCentrarlo,textvariable=self.texto2,state=DISABLED,font=("Times New Roman",12))
        self.EntryBloqueada2.grid(row=2,column=1,padx=10,pady=20)
        self.destinos=Combobox(self.frameParaCentrarlo, state="readonly", values=("Bogotá","Titiribi","Medellín","Ibagué","Cartagena"),width=22)
        self.destinos.grid(row=3,column=0,padx=10,pady=20)
        self.destinos=Combobox(self.frameParaCentrarlo, state="readonly", values=("Bogotá","Titiribi","Medellín","Ibagué","Cartagena"),width=22)
        self.destinos.grid(row=3,column=1,padx=10,pady=20)
        self.reserBoton3=Button(self.frameParaCentrarlo,text="Continuar",height=2,width=20,command=self.continuarReserva2)
        self.reserBoton3.grid(row=4,column=1,padx=10,pady=20)


    def continuarReserva1(self):
        self.labelTitulo.configure(text="Vuelos disponíbles hacia su destino")
        self.labelDescripcion.configure(text="Por favor, tome nota de la ID de su vuelo deseado")
        self.framePrincipal.pack_forget()
        self.framePrincipal=Frame(self.frame)
        self.framePrincipal.pack(padx=3,pady=3,fill=BOTH,expand=TRUE)
        self.reserBoton4=Button(self.framePrincipal,text="Continuar",height=2,width=20,command=self.continuarReserva3)
        self.reserBoton4.place(relx=0.8,rely=0.8)

    def continuarReserva2(self):
        self.labelTitulo.configure(text="Vuelos disponíbles")
        self.labelDescripcion.configure(text="Por favor, tome nota de la ID de su vuelo deseado")
        self.framePrincipal.pack_forget()
        self.framePrincipal=Frame(self.frame)
        self.framePrincipal.pack(padx=3,pady=3,fill=BOTH,expand=TRUE)
        self.reserBoton4=Button(self.framePrincipal,text="Continuar",height=2,width=20,command=self.continuarReserva3)
        self.reserBoton4.place(relx=0.8,rely=0.8)

    def continuarReserva3(self):
        self.framePrincipal.pack_forget()
        self.framePrincipal=Frame(self.frame)
        self.framePrincipal.pack(padx=3,pady=3,fill=BOTH,expand=TRUE)
        self.frameParaCentrarlo.pack_forget()
        self.frameParaCentrarlo=Frame(self.framePrincipal)
        self.frameParaCentrarlo.pack(padx=200)
        self.labelTitulo.configure(text="Generar Tiquete")
        self.labelDescripcion.configure(text="Rellene la siguiente información para la generación de su tiquete")
        self.fieldFrame= FieldFrame(self.frameParaCentrarlo,"Información",["ID del vuelo","Nombre del usuario","Documento de Identidad","Carga extra? S/N"],"Respuesta",None,None)

        
    def misTiquetes(self):
        a
        
    def checkIn(self):
        a

    def cargaExtra(self):
        a