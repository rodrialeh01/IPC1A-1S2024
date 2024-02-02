# Guía para empezar a programar la Práctica 1 y no morir en el intento

<p align="center">
  <img src="https://media.giphy.com/media/3o7520JM4Eah9ntP2g/giphy.gif" alt="Gif programando">
</p>

### 1. Pasos para empezar cualquier enunciado

1. **Leer el enunciado**. Es importante leer el enunciado para saber qué se nos pide y qué se nos va a evaluar. Además, es importante leerlo varias veces para entenderlo bien y no perderse nada.

2. **Entender el enunciado**. Una vez leído el enunciado, es importante entenderlo. Si no se entiende algo, es importante preguntar al auxiliar o al grupo con los compañeros. No hay que tener miedo a preguntar, ya que es mejor preguntar y entenderlo bien que no preguntar y hacerlo mal.

3. **Divide y vencerás**. Una vez entendido el enunciado, es importante dividirlo en partes más pequeñas. De esta forma, se puede abordar el problema de forma más sencilla y se puede ir avanzando poco a poco.

### 2. Pasos para empezar la Práctica 1

**OJO:** Esta solo es una idea, pero lo ideal por si andas perdido en el enunciado es que lo leas y luego sigas estos pasos.

1. _Empieza diseñando el menú principal_: Esto debieron de haberlo hecho en la `Tarea 1` entonces no debería ser un problema. Si no lo hicieron, entonces es momento de hacerlo.

2. _Dibuja el tablero_: Para esto tenes que tener que crear una matriz de 8x8. Posteriormente revisa si el ultimo dígito de tu carnet es par o impar. Dependiendo de eso sabras desde donde tienes que empezar a enumerar.

3. _Crear una matriz de movimiento_: Para esto puedes crear una matriz de 8x8 que te permita moverte entre las casillas del tablero.

4. _Crear una matriz de penalizaciones_: Para esto puedes crear una matriz de 8x8 que te permita colocar las penalizaciones por cada linea o casilla.

5. _Crear el dado_: Para esto importa la libreria `java.util.Random`, mira sus propiedades para generar números aleatorios entre un rango.

6. _Generar la lectura de solicitud del usuario_: Tiene que leer "d" para lanzar el dado, "p" para pausadr, son las unicas condiciones.

7. _Comparar la matriz de movimiento con la matriz de penalizaciones_: Compare las posiciones de ambos y si hacen `MATCH` entonces se debe de aplicar la penalización.

8. _Revisa en que fila se encuentra para poder aplicar los tipos penalizaciones_

9. _Comienza a realizar las penalizaciones_: Parte desde la penalización facil, luego la intermedia y por ultimo la avanzada(le recomiendo gauss jordan para la matriz inversa).

10. _Valida si la posicion es >= 64 para finalizar el juego_

11. _Configura la pausa por medio de variables estaticas_

12. _Configura la reanudación del juego_

13. ¡LISTO! Ya tienes tu juego de Tablero Matemático.