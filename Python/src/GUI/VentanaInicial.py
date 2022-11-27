from tkinter import *
from VentanaPrincipal import VentanaPrincipal
class VentanaInicial(Tk):

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.geometry("900x700")
        self.title("Ventana Inicial")
        self.resizable(0,0)

        self.option_add("*tearOff",False)
        self.menubar=Menu(self)
        self.menuInicial=Menu(self.menubar)
        self.menubar.add_cascade(menu=self.menuInicial, label="Inicio")
        self.menuInicial.add_command(label="Descripción",command=self.menuDescripción)
        self.menuInicial.add_command(label="Salir",command=self.menuSalir)
        self.configure(menu=self.menubar)

        self.P1=Frame(self, width=450,height=700)
        self.P1.pack(side=LEFT)

        self.P2=Frame(self, width=450,height=700)
        self.P2.pack(side=RIGHT)

        self.P3=Frame(self.P1, width=450,height=233)
        self.bienvenida=Label(self.P3,text="Bienvenido a Aerounal!\nPulse la imágen de abajo para comenzar!",font=("Times New Roman",15))
        self.bienvenida.place(relx=0.5,rely=0.25,anchor=CENTER)
        self.stringDescripcion=StringVar()
        self.textoDescripcion=Label(self.P3,textvariable=self.stringDescripcion,font=("Times New Roman",10))
        self.textoDescripcion.place(relx=0.5,rely=0.66,anchor=CENTER)
        self.P3.grid(row=0,column=0)

        self.P4=Frame(self.P1, width=450,height=467,bg="Green")
        self.P4.grid(row=1,column=0)
        self.imagenRelacionada=PhotoImage(file="./Imagenes/Relacionada0.png")
        self.ubicacionImagen=Button(self.P4,image=self.imagenRelacionada,command=self.nuevaVentana)
        self.ubicacionImagen.bind("<Enter>",self.cambioImagen)
        self.ubicacionImagen.place(relx=0.5,rely=0.5,anchor=CENTER)

        self.P5=Frame(self.P2, width=450,height=233,bg="Grey")
        self.P5.grid(row=0,column=0)
        self.stringDesarrolladores=StringVar()
        self.stringDesarrolladores.set("Desarrolladores")
        self.textoDesarroladores=Label(self.P5,textvariable=self.stringDesarrolladores,font=("Times New Roman",12))
        self.textoDesarroladores.bind("<ButtonPress-1>",self.cambioDesarroladores)
        self.textoDesarroladores.place(relx=0.5,rely=0.5,anchor=CENTER)
        
        self.P6=Frame(self.P2, width=450,height=467,bg="Grey")
        self.P6.grid(row=1,column=0)
        self.foto1=Label(self.P6,width=225,height=233)
        self.foto2=Label(self.P6,width=225,height=234)
        self.foto3=Label(self.P6,width=225,height=233)
        self.foto4=Label(self.P6,width=225,height=234)
        self.foto1.place(relx=0,rely=0)
        self.foto2.place(relx=0.5,rely=0)
        self.foto3.place(relx=0,rely=0.5)
        self.foto4.place(relx=0.5,rely=0.5)

        self.imagen=0
        self.desarrollador=0

        self.mainloop()

    def nuevaVentana(self):
        self.nuevaVentana=VentanaPrincipal()

    def menuDescripción(self):
        self.stringDescripcion.set("Administre los tiquetes de su cuenta o compre nuevos.\nRevise los vuelos y destinos disponibles")
    
    def menuSalir(self):
        quit()
        #Falta modificarlo para que cierre las bases de datos

    
    def cambioImagen(self,evento):
        self.imagen+=1
        self.imagenRelacionada=PhotoImage(file="./Imagenes/Relacionada"+str(self.imagen%4)+".png")
        self.ubicacionImagen.configure(image=self.imagenRelacionada)
    
    def cambioDesarroladores(self,evento):
        self.desarrollador+=1
        self.desImagen1=PhotoImage(file="./Imagenes/DesarrolladorA"+str(self.desarrollador%2)+".png")
        self.desImagen2=PhotoImage(file="./Imagenes/DesarrolladorB"+str(self.desarrollador%2)+".png")
        self.desImagen3=PhotoImage(file="./Imagenes/DesarrolladorC"+str(self.desarrollador%2)+".png")
        self.desImagen4=PhotoImage(file="./Imagenes/DesarrolladorD"+str(self.desarrollador%2)+".png")
        self.foto1.configure(image=self.desImagen1)
        self.foto2.configure(image=self.desImagen2)
        self.foto3.configure(image=self.desImagen3)
        self.foto4.configure(image=self.desImagen4)
        if self.desarrollador%2==0:
            self.stringDesarrolladores.set("Felipe Muños Echeverry\n20 años\nEstudiante de Ingeniería de Sistemas\n(No ha mandado fotos)")
        else:
            self.stringDesarrolladores.set("Juan Pablo Gómez Reyes\n19 años\nEstudiante de Ingeniería de Sistemas")

if __name__=="__main__":
    ventana=VentanaInicial()
    ventana.mainloop()