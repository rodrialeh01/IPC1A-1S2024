from ListaEnlazada import ListaEnlazada

lista = []

lista.append(1)
lista.append(2)
lista.append(3)

print(lista)


lista2 = ListaEnlazada()

lista2.insertar(1)
lista2.insertar(2)
lista2.insertar(3)

print("LISTA ENLAZADA:")
lista2.mostrar()