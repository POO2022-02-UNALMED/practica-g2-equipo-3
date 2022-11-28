from tkinter import *
from tkinter import messagebox

class FieldFrame(Frame):
    def __init__(self, master, tituloCriterios, Criterios, tituloValores, Valores, habilitado):
        super().__init__(master)

        self.valores={}
        self.valoresIngresados=[]
        self.pack()
        ###########
        self.criterios=Criterios
        self.tituloCriterios= Label(self,text=tituloCriterios, font=("Times New Roman",14))
        self.grid(row=0,column=0,padx=60,pady=10)
        self.tituloValores= Label(self,text=tituloValores,font=("Times New Roman",14))
        self.grid(row=0,column=1,padx=60,pady=10)
        self.boton1=Button(self,text="Aceptar",font=("Times New Roman",12),command=self.aceptar)
        self.boton1.grid(row=len(Criterios)+1, column=0, padx=10, pady=5)
        self.boton2=Button(self,text="Borrar",font=("Times New Roman",12),command=self.borrar)
        self.boton2.grid(row=len(Criterios)+1, column=1, padx=10, pady=5)
        #######################
        for i in range(len(Criterios)):
            texto=Label(self,width=30,height=2,text=Criterios[i],font=("Times New Roman",12))
            entrada=Entry(self)
            if Valores!=None:
                entrada.insert(0,Valores[i])
                self.valoresIngresados.append(Valores[i])
            if habilitado!=None:
                if habilitado[i]:
                    entrada.configure(state=NORMAL)
                else:
                    entrada.configure(state=DISABLED)
            texto.grid(row=i+1,column=0,padx=5,pady=2)
            entrada.grid(row=i+1,column=1,padx=5,pady=2)
            self.valores[Criterios[i]]=entrada

    def aceptar(self):
        self.valoresIngresados=[]
        for i in self.valores:
            self.valoresIngresados.append(self.valores[i].get())
        try:
            for i in range(len(self.valoresIngresados)):
                if self.valoresIngresados[i]=="":
                    raise ExcepcionAceptar
        except ExcepcionAceptar as excepcion:
            messagebox.showerror(title="Error",message=excepcion.mensaje)



    def borrar(self):
        for i in self.valores:
            self.valores[i].delete(0,"end")

class ExcepcionAceptar(Exception):

    def __init__(self):
        self.mensaje = f"Por favor rellene todas las entradas antes de Aceptar"
        super().__init__(self.mensaje)