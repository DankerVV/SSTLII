class ElementoPila:
    ERROR = -1;
    IDENTIFICADOR = 0;
    SIMBOLO = 1;
    SIGNOPESO = 2;
    E = 3;
    INICIAL = 5;

    def __init__(self, tipo, simbolo):
        self.tipo = 5
        self.simbolo = simbolo
    
    def __str__(self) -> str:
        return str(self.simbolo)

class Terminal(ElementoPila):
    
    def __init__(self, tipo, simbolo=None):
        self.tipo = tipo
        self.simbolo = simbolo
        if tipo == ElementoPila.SIGNOPESO:
            self.simbolo = '$'
    
    #def Terminal(self, tipo, simbolo):
     #   super().__init__(tipo, )
    

class NoTerminal(ElementoPila):
    
    def __init__(self, tipo, simbolo):
        super().__init__(tipo, simbolo)

class Estado(ElementoPila):
    
    def __init__(self, tipo, simbolo):
        super().__init__(tipo, simbolo)
    
class Pila:
    items = []

    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.insert(len(self.items),item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items)]

    def size(self):
        return len(self.items)

    def clear(self):
        self.items.clear()

    def mostrarPila(self):
        for dato in self.items:
            print(str(dato), end=" ")
        print()

