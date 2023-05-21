from io import open
import os
import subprocess
from analisisLexico2 import analizador
from pila import stack
import arbolSintactico
import elementoPila
import analisisSemantico

class sintactico:

    def __init__(self):
        self.pila = stack()
        self.gramatica = []
        self.popElements = []
        self.nombreRegla = []
        self.matrizGramatica = []

    def ejercicio_1(self, entrada):
        self.pila.limpiar()
        lexico = analizador(entrada)
        entrada = entrada + " $"#Divide la entrada por espacios
        entradaDividida = entrada.split(" ")
        tabla_1 = [[2,0,0,4,0],[0,0,3,0,0],[0,-1,0,0,-2],[1,0,0,0,0]]#Tabla LR para el primer ejercicio
        primerNT = elementoPila.noTerminal("$")#Se crea el primer elementoPila
        primerEstado = elementoPila.estado("0")#Segundo elementoPila
        self.pila.push(primerNT)#Push a los elementos creados
        self.pila.push(primerEstado)

        valor = 0
        valida = False
        cont = 0
        
        while valida==False:
            if entradaDividida[cont] != "$":
                type = lexico.returnTipo(lexico.evaluaElemento(entradaDividida[cont]))

                if type == "Identificador": 
                    valor = tabla_1[0][int(self.pila.top().returnValor())]
                
                    if valor == 0:#Si es 0 es un error
                        break

                    else:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        terminal = elementoPila.terminal(entradaDividida[cont])
                        estado = elementoPila.estado(str(valor))
                        self.pila.push(terminal)
                        self.pila.push(estado)

                elif type == "+":
                    valor = tabla_1[1][int(self.pila.top().returnValor())]
                    if valor == 0:
                        break

                    else:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        terminal = elementoPila.terminal(entradaDividida[cont])
                        estado = elementoPila.estado(str(valor))
                        self.pila.push(terminal)
                        self.pila.push(estado)

                cont=cont+1
            
            if entradaDividida[cont] == "$":
                valor = tabla_1[2][int(self.pila.top().returnValor())]
                if valor == 0:
                    break
                elif valor == -1:
                    print("Entrada: "+entrada+ " Aceptada")
                    valida = True

                elif valor < 0:
                    for i in range(6):
                        self.pila.pop()

                    print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                    noTerminal = elementoPila.noTerminal("E")
                    estado = elementoPila.estado(str(abs(valor+1)))
                    self.pila.push(noTerminal)
                    self.pila.push(estado)

    def ejercicio_2(self,entrada):
        self.pila.limpiar()
        tabla_2 = [[2,0,0,2,0],[0,0,3,0,0],[0,-1,-3,0,-2],[1,0,0,4,0]]
        lexico = analizador(entrada)
        entrada = entrada + " $"
        entradaDividida = entrada.split(" ")
        primerNT = elementoPila.noTerminal("$")
        primerE = elementoPila.estado("0")
        self.pila.push(primerNT)
        self.pila.push(primerE)
        valor = 0
        valida = False
        cont = 0

        while valida == False:
            type = lexico.returnTipo(lexico.evaluaElemento(entradaDividida[cont]))
            if type != "$":
                if type == "Identificador":
                    valor = tabla_2[0][int(self.pila.top().returnValor())]

                elif type == "+":
                    valor = tabla_2[1][int(self.pila.top().returnValor())]

                if valor > 0:
                    print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                    terminal = elementoPila.terminal(entradaDividida[cont])
                    estado = elementoPila.estado(str(valor))
                    self.pila.push(terminal)
                    self.pila.push(estado)   
                    cont+=1

                elif valor < 0:
                    if valor == -1:
                        print("Entrada: "+entrada+ " Aceptada")
                        valida = True
                        
                    elif valor == -3:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        for i in range(2):
                            self.pila.pop()

                        valorE = tabla_2[3][int(self.pila.top().returnValor())]
                        noTerminal = elementoPila.noTerminal("E")
                        estado = elementoPila.estado(str(valorE))
                        self.pila.push(noTerminal)
                        self.pila.push(estado)
                            
                    elif valor == -2:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        for i in range(6):
                            self.pila.pop()

                        valorE = tabla_2[3][int(self.pila.top())]
                        noTerminal = elementoPila.noTerminal("E")
                        estado = elementoPila.estado(str(valorE))
                        self.pila.push(noTerminal)
                        self.pila.push(estado)

                elif valor == 0:
                    print("Entrada No Valida")
                    break
            else:
                valor = tabla_2[2][int(self.pila.top().returnValor())]   
                if valor > 0:
                    print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                    terminal = elementoPila.terminal(entradaDividida[cont])
                    estado = elementoPila.estado(str(valor))
                    self.pila.push(terminal)
                    self.pila.push(estado)   
                    cont+=1

                elif valor < 0:
                    if valor == -1:
                        print("Entrada: "+entrada+ " Aceptada")
                        valida = True
                        
                    elif valor == -3:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        for i in range(2):
                            self.pila.pop()

                        valorE = tabla_2[3][int(self.pila.top().returnValor())]
                        noTerminal = elementoPila.noTerminal("E")
                        estado = elementoPila.estado(str(valorE))
                        self.pila.push(noTerminal)
                        self.pila.push(estado)
                            
                    elif valor == -2:
                        print("Entrada: "+entradaDividida[cont]+"  Accion: "+str(valor))
                        for i in range(6):
                            self.pila.pop()

                        valorE = tabla_2[3][int(self.pila.top().returnValor())]
                        noTerminal = elementoPila.noTerminal("E")
                        estado = elementoPila.estado(str(valorE))
                        self.pila.push(noTerminal)
                        self.pila.push(estado)
                elif valor == 0:
                    print("Entrada No Valida")
                    break
                
    def readFile(self):
        file = open("compilador.lr","r")
        fullString = file.readlines()
        self.gramatica.append("52")
        self.popElements.append("0")
        self.nombreRegla.append(" ")

        for i in range(1,54):
            line = fullString[i]
            line = line[:-1].split("\t")

            if i != 53:
                self.gramatica.append(line[0])
                self.popElements.append(line[1])
                self.nombreRegla.append(line[2])

            elif i == 53:
                self.gramatica.append(line[0])
                self.popElements.append(line[1])
                self.nombreRegla.append(" ")


        for i in range(54,148):
            line = fullString[i]
            line = line[:-1].split("\t")
            self.matrizGramatica.append(line)
        file.close()

    def compilador(self,e):
        self.readFile()
        self.pila.limpiar()
        lexico = analizador(e)      
        e = e + " $"
        entradaDividida = e.split(" ")
        primerNT = elementoPila.noTerminal("$","$",2)
        primerEstado = elementoPila.estado("0","",3)
        self.pila.push(primerNT)
        self.pila.push(primerEstado)

        valida = False
        cont = 0
        valorTabla = ""

        while valida == False:
            (tipo,valor) = lexico.returnTipo(lexico.evaluaElemento(entradaDividida[cont]))
            topePila = int(self.pila.top().returnValor())
            valorTabla = int(self.matrizGramatica[topePila][valor])
                
            if valorTabla == 0:
                print("Entrada no valida")
                break

            elif valorTabla > 0:
                terminal = elementoPila.terminal(entradaDividida[cont],"",1)
                estado = elementoPila.estado(str(valorTabla),"",3)
                self.pila.push(terminal)
                self.pila.push(estado)
                cont+=1

            elif valorTabla < 0:
                if valorTabla == -1:
                    valida = True
                    print("\n\n----------ÀRBOL SINTÁCTICO----------\n")
                    arbolFinal = arbolSintactico.arbolSintactico()
                    analizadorSem = analisisSemantico.Semantico()
                    self.pila.pop()#POP AL ULTIMO ELEMENTO QUE ES UN ESTADO
                    elemento = self.pila.pop()
                    elemento.nodo.printRegla()
                    analizadorSem.crearArchivo()
                    file = open('CodigoTraducido.asm','a+')#CREAR EL ARCHIVO EN ENSAMBALDOR
                    analizadorSem.analiza(elemento.nodo,file)
                    file.close()
                    analizadorSem.muestraSimbolos()
                    
                    break
                
                nodo = arbolSintactico.Nodo()
                valorTabla+=1
                numeroEliminar = int(self.popElements[abs(valorTabla)])
                nomRegla = self.nombreRegla[abs(valorTabla)]
                nodo.regla = nomRegla

                if numeroEliminar > 0:
                    for i in range(int(numeroEliminar)*2):
                        elemento = self.pila.pop()
                        if i%2 == 1:
                            nodo.elementosEliminados.append(elemento)
                    
                topePila = int(self.pila.top().returnValor())
                reglaReal = str(abs(valorTabla))
                regla = int(self.gramatica[abs(valorTabla)])
                valorTabla = self.matrizGramatica[topePila][regla]

                noTerminal = elementoPila.noTerminal(reglaReal,nomRegla,2)
                noTerminal.nodo = nodo
                estado = elementoPila.estado(str(valorTabla),"",3)

                self.pila.push(noTerminal)
                self.pila.push(estado)
