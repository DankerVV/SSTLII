import xlrd
from io import open
import elementoPila
from analisisLexico2 import analizador
from pila import stack
from analisisSintactico import sintactico
from analisisLexico import *

analizador = sintactico()
file = open("test.txt")
test = file.read()
print("\n----------CÓDIGO ORIGINAL----------\n\n", test)
lexicoAux = AnalisisLexico(test)
lexicoAux = lexicoAux.rstrip(lexicoAux[-1])
#print("TEST2: ", lexicoAux)
analizador.compilador(lexicoAux)
