#TAREA: Mini Generador Léxico, Seminario de Traductores de Lenguajes II
import numbers

print("\n----\tMini Generador Léxico\t----\n")

file = open("read.txt")

identificador = {'a' : 'id', 'b':'id', 'c':'id', 'x':'id', 'y':'id', 'z':'id'}#diccionario con los identificadores y sus significados
identificador_key = identificador.keys()

operadores = {'+' : 'Suma', '-' : 'Resta', '*' : 'Multiplicación', '/' : 'División','=' : 'Asignación'}#diccionario con los operadores y sus significados
operadores_key = operadores.keys()

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

    print("----------------------------------------------\n")

