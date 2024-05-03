from Nodo import Nodo


class ListaEnlazada:
    def __init__(self):
        self.primero = None
        self.ultimo = None
        self.tamano = 0

    def insertar(self, numero):
        nuevo = Nodo(numero)
        if self.primero is None and self.ultimo is None:
            self.primero = nuevo
            self.ultimo = nuevo
        elif self.primero == self.ultimo:
            self.ultimo = nuevo
            self.primero.siguiente = self.ultimo
        else:
            self.ultimo.siguiente = nuevo
            self.ultimo = nuevo
        self.tamano += 1

    def mostrar(self):
        temporal = self.primero
        print("[", end="")
        while temporal != None:
            if temporal != self.ultimo:
                print(str(temporal.numero) + ", ", end="")
            else:
                print(str(temporal.numero), end="")
            temporal = temporal.siguiente
        print("]")