from tkinter import *

class VentanaPrincipal(Toplevel):

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.geometry("1078x860")
        self.title("Ventana Principal")
        self.resizable(0,0)
        self.imagen=PhotoImage(file=".\Imagenes\Fondo.png")
        self.fondo=Label(self, image=self.imagen)
        self.fondo.pack(fill="both", expand=True)
        self.Boton1=Button(self, text="Hola")
        self.Boton1.place(relx=0.5,rely=0.5)
        self.mainloop()