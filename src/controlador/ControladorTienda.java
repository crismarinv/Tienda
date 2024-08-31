package controlador;

import mundo.Tienda;
import mundo.Producto;

public class ControladorTienda {
    private Tienda tienda;

    public ControladorTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public int venderProducto(String nombreProducto, int cantidad) {
        return tienda.venderProducto(nombreProducto, cantidad);
    }

    public boolean abastecerProducto(String nombreProducto, int cantidad) {
        return tienda.abastecerProducto(nombreProducto, cantidad);
    }

    public boolean cambiarProducto(String nombreActual, String nombreNuevo, String tipo, double valorUnitario, int cantidadBodega, int cantidadMinima, String rutaImagen) {
        return tienda.cambiarProducto(nombreActual, nombreNuevo, tipo, valorUnitario, cantidadBodega, cantidadMinima, rutaImagen);
    }

    public Producto darProductoMasVendido() {
        return tienda.darProductoMasVendido();
    }

    public Producto darProductoMenosVendido() {
        return tienda.darProductoMenosVendido();
    }

    public double darPromedioVentas() {
        return tienda.darPromedioVentas();
    }

    public double darDineroEnCaja() {
        return tienda.darDineroEnCaja();
    }

    public int metodo1() {
        return tienda.metodo1();
    }

    public String metodo2() {
        return tienda.metodo2();
    }

    public Producto darPrimerProducto() {
        return tienda.darPrimerProducto();
    }

    public Producto darSegundoProducto() {
        return tienda.darSegundoProducto();
    }

    public Producto darTercerProducto() {
        return tienda.darTercerProducto();
    }

    public Producto darCuartoProducto() {
        return tienda.darCuartoProducto();
    }
}