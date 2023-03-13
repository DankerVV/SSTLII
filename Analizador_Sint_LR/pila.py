import constantes
class Stack:
    items = []
    def __init__(self):
        self.items = []
        self.push(constantes.SIGNOPESOS)
        self.push(constantes.IDENTIFICADOR)

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