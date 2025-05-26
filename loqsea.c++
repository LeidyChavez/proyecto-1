#include <iostream>
#include <string>
#include <list>
#include <iterator>

using namespace std;

struct Articulo {
    int codigo;
    string nombre;
    float precio;
    int cantidad;
};

void incrementarPrecio(Articulo &articulo) {
    if (articulo.precio < 500000) {
        articulo.precio *= 1.12;
    }
    else if (articulo.precio < 1500000) {
        articulo.precio *= 1.10;
    }
    else if (articulo.precio < 2500000) {
        articulo.precio *= 1.08;
    }
    else if (articulo.precio < 5000000) {
        articulo.precio *= 1.06;
    }
    else if (articulo.precio < 8000000) {
        articulo.precio *= 1.04;
    }
}

bool eliminarArticulo(const Articulo &articulo) {
    if ((articulo.precio < 100 && articulo.cantidad < 10) ||
        (articulo.precio > 2500000 && articulo.cantidad < 3)) {
        return true;
    }
    return false;
}

void insertarConDescuento(list<Articulo> &lista, const Articulo &articulo) {
    Articulo articuloDescuento = articulo;
    articuloDescuento.precio *= 0.50; 
    lista.push_back(articuloDescuento); 
}

int main() {
    list<Articulo> listaArticulos;


    Articulo a1 = {1, "Articulo1", 400000, 20};
    Articulo a2 = {2, "Articulo2", 1600000, 5};
    Articulo a3 = {3, "Articulo3", 250000, 2};
    Articulo a4 = {4, "Articulo4", 3000000, 15};
    Articulo a5 = {5, "Articulo5", 5000000, 8};

  
    listaArticulos.push_back(a1);
    listaArticulos.push_back(a2);
    listaArticulos.push_back(a3);
    listaArticulos.push_back(a4);
    listaArticulos.push_back(a5);

    for (auto &articulo : listaArticulos) {
        incrementarPrecio(articulo);
    }
  
    listaArticulos.remove_if(eliminarArticulo);

    cout << "Lista de artículos después de incrementos y eliminaciones:\n";
    for (const auto &articulo : listaArticulos) {
        cout << "Código: " << articulo.codigo << ", Nombre: " << articulo.nombre
             << ", Precio: " << articulo.precio << ", Cantidad: " << articulo.cantidad << endl;
    }


    for (auto &articulo : listaArticulos) {
        if (articulo.cantidad < 10) {
            insertarConDescuento(listaArticulos, articulo);
        }
    }

    cout << "\nLista final de artículos con descuento aplicado:\n";
    for (const auto &articulo : listaArticulos) {
        cout << "Código: " << articulo.codigo << ", Nombre: " << articulo.nombre
             << ", Precio: " << articulo.precio << ", Cantidad: " << articulo.cantidad << endl;
    }

    return 0;
}
