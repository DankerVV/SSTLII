
def AnalisisLexico(test):
    identificador = {'a' : 'id', 'b':'id', 'c':'id', 'x':'id', 'y':'id', 'z':'id'}#diccionario con los identificadores y sus significados
    identificador_key = identificador.keys()
    operadores = {'+' : 'opSuma', '-' : 'opSuma', '*' : 'opMult', '/' : 'opMult','=' : 'opRelac','<':'opRelac', 
                    '>':'opRelac',  '<=':'opRelac', '>=':'opRelac', '!=':'opIguald', '==':'opIguald',
                    '&&':'opAnd', '||':'opOr', '!':'opNot'}#diccionario con los operadores y sus significados
    operadores_key = operadores.keys()
    puntuacion = {';': 'puntYcom', '(':'abrirPar', ')':'cerrarPar', '{':'abrirLlv', '}':'cerrarLlv',',': 'coma'}
    puntuacion_keys = puntuacion.keys()
    palabras_reservadas = {'if':'Si', 'while':'Mientras', 'return':'retornar', 'else': 'Si no', 'int':'entero', 'float':'real', 'main':'principal'}
    palabras_reservadas_keys = palabras_reservadas.keys()

    cont = 0
    band=0
    test = test.split("\n")
    #print("TEST: ",test)
    cadena=""

    print("\n----------ANÁLISIS LÉXICO----------\n\n-TOKEN-\t\t-SÍMBOLO-\t\t-TIPO-")
    for line in test:
        cont = cont + 1
        tokens = line.split(' ')

        for token in tokens:
            tipo=""
            #print(token)

            if token in operadores_key:#OPERADORES
                if(token=='+' or token=='-'):
                    tipo="5"
                elif(token=='*' or token=='/'):
                    tipo="6"
                elif(token=='<' or token=='<=' or token=='>' or token=='>='):
                    tipo="7"
                elif(token=='||'):
                    tipo="8"
                elif(token=='&&'):
                    tipo="9"
                elif(token=='!'):
                    tipo="10"
                elif(token=='='):
                    tipo="18"
                cadena = cadena + token + " "
                print(token, "\t\t", operadores[token], "\t\t",tipo)

            elif token in identificador_key:#IDENTIFICADORES
                tipo="0"
                cadena = cadena + token + " "
                print(token, "\t\tidentificador","\t\t",tipo)

            elif token in puntuacion_keys:#PUNTUACION
                if(token==';'):
                    tipo="12"
                elif(token==','):
                    tipo="13"
                if(token=='('):
                    tipo="14"
                elif(token==')'):
                    tipo="15"
                if(token=='{'):
                    tipo="16"
                elif(token=='}'):
                    tipo="17"
                cadena = cadena + token + " "
                print(token, "\t\t",puntuacion[token],"\t\t",tipo)

            elif token in palabras_reservadas_keys:#PALABRAS RESERVADAS
                if(token=='if'):
                    tipo="19"
                elif(token=='while'):
                    tipo="20"
                if(token=='return'):
                    tipo="21"
                elif(token=='main'):
                    tipo="0"
                if(token=='int'):
                    tipo="4"
                elif(token=='float'):
                    tipo="4"
                elif(token=='print'):
                    tipo="0"
                cadena = cadena + token + " "
                print(token, "\t\t",palabras_reservadas[token],"\t\t",tipo)    

            elif ''.join(token).isdigit() == True:#ENTEROS
                tipo:"1"
                cadena = cadena + token + " "
                print(token, "\t\tnumEnt\t\t\t1")

            elif token.replace('.', '', 1).isdigit() == True:#REALES
                tipo:"2"
                cadena = cadena + token + " "
                print(token, "\t\tnumReal\t\t2")

            elif len(''.join(token))>=1:
                if ''.join(token[0])>= 'a' and ''.join(token[0])<='z': #PALABRAS
                    cadena = cadena + token + " "
                    print(token, "\t\tVariable\t\t")

            elif (token==' ' or '\n'):
                pass
    return(cadena)
