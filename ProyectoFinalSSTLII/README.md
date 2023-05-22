Proyecto Final de Seminario Para la Solución de Problemas de Traductores de Lenguajes II. 

El código a analizar se introduce desde el archivo "test.txt", para este ejemplo se usará el siguiente código, que tiene una función de suma y otra de resta.

<img width="382" alt="image" src="https://github.com/DankerVV/SSTLII/assets/123404725/b517f615-e6b4-4dce-87bd-38cd061ca08b">. 

Al correr el código, lo primero que se hace es imprimir el código que recibió, para asegurarnos así de que la entrada fue la que se deseaba en "test.text".

<img width="392" alt="image" src="https://github.com/DankerVV/SSTLII/assets/123404725/8ca854f2-9b5f-412d-a740-b7d1be1e0239">. 

Lo siguiente es la impresion del Análisis Léxico. La impresión da informacion sobre el símbolo y tipo de cada Token. 

![image](https://github.com/DankerVV/SSTLII/assets/123404725/6b41296b-73c5-428e-920e-ce3f29d5fcc9)


Una vez impreso el Análisis Léxico, se procede con la impresion del Árbol Sintáctico. 

![image](https://github.com/DankerVV/SSTLII/assets/123404725/3cc24cea-56e2-4bf5-9031-50a4642f9551)
![image](https://github.com/DankerVV/SSTLII/assets/123404725/b7f0ccbf-7db9-4e39-9f97-69810264e446)


En este ejemplo no hay errores semánticos, por lo que el código no tiene erroes que mostrar. De lo contrario, informa una entrada no válida. 

![image](https://github.com/DankerVV/SSTLII/assets/123404725/91f0a297-569f-4000-b704-ff782361cd76)

Aquí pongo otro ejemplo donde no se declare el tipo de dato de la variable resul1, por lo que se alerta de un error.
![image](https://github.com/DankerVV/SSTLII/assets/123404725/ee848e45-048d-484f-a80f-7f9614c914d1)
![image](https://github.com/DankerVV/SSTLII/assets/123404725/0b69f785-5944-49f5-a615-64ec4b56468b)


Por último, se procede a la generación de código en lenguaje ensamblador. Este proyecto genera el siguiente código código para MASM:
![image](https://github.com/DankerVV/SSTLII/assets/123404725/65c60602-07aa-4fc4-ac59-01ac9cd2e3dc)
