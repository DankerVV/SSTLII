#TAREA:  Analizador Sintáctico, Seminario de Traductores de Lenguajes II
#Carlos Uriel Salcido Aviña
import numbers

print("\n----\tAnalizador Sintáctico\t----\n")

file = open("read.txt")

identificador = {'a' : 'id', 'b':'id', 'c':'id', 'x':'id', 'y':'id', 'z':'id'}#diccionario con los identificadores y sus significados
identificador_key = identificador.keys()

operadores = {'+' : 'Suma', '-' : 'Resta', '*' : 'Multiplicación', '/' : 'División','=' : 'Asignación','<':'Menor que', 
                '>':'Mayor que',  '<=':'Menor o Igual', '>=':'Mayor o Igual', '!=':'Diferente', '==':'Igual',
                '&&':'And', '||':'Or', '!':'Not'}#diccionario con los operadores y sus significados
operadores_key = operadores.keys()

puntuacion = {';': 'Punto y Coma', '(':'Abrir Paréntesis', ')':'Cerrar Paréntesis', '{':'Abrir Llave', '}':'Cerrar Llave'}
puntuacion_keys = puntuacion.keys()

palabras_reservadas = {'if':'Si', 'while':'Mientras', 'return':'Retornar', 'else': 'Si no', 'int':'Entero', 'float':'flotante'}
palabras_reservadas_keys = palabras_reservadas.keys()

stack = []

a=file.read()

cont = 0
program = a.split("\n")

for line in program:
    cont = cont + 1
    print("Linea ", cont, "\n", line)

    tokens = line.split(' ')
    print("Los Tokens son: ", tokens)

    print("Linea ", cont, "Propiedades: \n")

    for token in tokens:
        if token in operadores_key:
            print("El operador es ", operadores[token])

        if token in identificador_key:
            print(token, " identificador: ", [token])

        if token in puntuacion_keys:
            print(token, " puntuacion: ", puntuacion[token])

        if token in palabras_reservadas_keys:
            print(token, " identificador: ", [token])    

        if ''.join(token).isdigit() == True:
            print(token, "es un número entero")

        elif token.replace('.', '', 1).isdigit() == True:
            print(token, "es un número flotante")

        elif token.replace('-', '', 1).isdigit() == True:
            print(token, "es un número entero negativo")

        else:
            temp1 = token.replace('.', '', 1)
            temp2 = temp1.replace('-', '', 1)
            if temp2.isdigit() == True:
                print(token, "es un número negativo flotante")

        stack.append(token)
    print("----------------------------------------------\n")

#print(len(stack))

it = 1
if stack[0] in identificador_key:
    pass
else:
    print("Error de sintáxis")

while (it != len(stack)):
    if (stack[it] in operadores_key) and ((stack[it+1] in identificador_key) or (stack[it+1] == None)):
        pass
    else:
        print("Error de sintáxis")
        break

    it = it + 2