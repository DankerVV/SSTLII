import arbolSintactico

class elementoPila:

    def __init__(self,v,rNombre,id):

        self.valor = v
        self.nombreRegla = rNombre
        self.id = id
        self.nodo = arbolSintactico.Nodo()

    def printValor(self):

        print(self.valor)

    def returnValor(self):

        return self.valor

class terminal(elementoPila):
    pass

class noTerminal(elementoPila):
    pass

class estado(elementoPila):
    pass
