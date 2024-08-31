/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

public class Tienda {
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private double dineroEnCaja;

    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    public Producto darPrimerProducto() {
        return producto1;
    }

    public Producto darSegundoProducto() {
        return producto2;
    }

    public Producto darTercerProducto() {
        return producto3;
    }

    public Producto darCuartoProducto() {
        return producto4;
    }

    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    public Producto darProducto(String pNombre) {
        if (producto1.darNombre().equalsIgnoreCase(pNombre)) {
            return producto1;
        } else if (producto2.darNombre().equalsIgnoreCase(pNombre)) {
            return producto2;
        } else if (producto3.darNombre().equalsIgnoreCase(pNombre)) {
            return producto3;
        } else if (producto4.darNombre().equalsIgnoreCase(pNombre)) {
            return producto4;
        }
        return null;
    }

    public double darPromedioVentas() {
        int totalUnidadesVendidas = producto1.darCantidadUnidadesVendidas()
                + producto2.darCantidadUnidadesVendidas()
                + producto3.darCantidadUnidadesVendidas()
                + producto4.darCantidadUnidadesVendidas();
        return totalUnidadesVendidas > 0 ? dineroEnCaja / totalUnidadesVendidas : 0.0;
    }

    public Producto darProductoMasVendido() {
        Producto masVendido = producto1;
        if (producto2.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto2;
        }
        if (producto3.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto3;
        }
        if (producto4.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto4;
        }
        return masVendido.darCantidadUnidadesVendidas() > 0 ? masVendido : null;
    }

    public Producto darProductoMenosVendido() {
        Producto menosVendido = producto1;
        if (producto2.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto2;
        }
        if (producto3.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto3;
        }
        if (producto4.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto4;
        }
        return menosVendido.darCantidadUnidadesVendidas() > 0 ? menosVendido : null;
    }

    public int venderProducto(String pNombreProducto, int pCantidad) {
        Producto producto = darProducto(pNombreProducto);
        if (producto != null) {
            int cantidadVendida = producto.vender(pCantidad);
            dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal();
            return cantidadVendida;
        }
        return 0;
    }

    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        Producto producto = darProducto(pNombreProducto);
        if (producto != null) {
            producto.abastecer(pCantidad);
            return true;
        }
        return false;
    }

    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        if (darProducto(pNombreNuevo) == null) {
            Producto producto = darProducto(pNombreActual);
            if (producto != null) {
                producto.cambiarNombre(pNombreNuevo);
                producto.cambiarTipo(pTipo);
                producto.cambiarValorUnitario(pValorUnitario);
                producto.cambiarCantidadBodega(pCantidadBodega);
                producto.cambiarCantidadMinima(pCantidadMinima);
                producto.cambiardarCantidadUnidadesVendidas(0);  // Reset de unidades vendidas
                producto.cambiarRutaImagen(pRutaImagen);
                return true;
            }
        }
        return false;
    }

    public int metodo1() {
        double promedio = darPromedioVentas();
        int count = 0;
        if (producto1.calcularPrecioFinal() < promedio) count++;
        if (producto2.calcularPrecioFinal() < promedio) count++;
        if (producto3.calcularPrecioFinal() < promedio) count++;
        if (producto4.calcularPrecioFinal() < promedio) count++;
        return count;
    }

    public String metodo2() {
        Producto barato = producto1;
        if (producto2.calcularPrecioFinal() < barato.calcularPrecioFinal()) barato = producto2;
        if (producto3.calcularPrecioFinal() < barato.calcularPrecioFinal()) barato = producto3;
        if (producto4.calcularPrecioFinal() < barato.calcularPrecioFinal()) barato = producto4;
        return barato.darNombre();
    }
}