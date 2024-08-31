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

public class Producto {
    private String nombre;
    private String tipo;
    private double valorUnitario;
    private int cantidadBodega;
    private int cantidadMinima;
    private int cantidadUnidadesVendidas;
    private String rutaImagen;

    public Producto(String pTipo, String pNombre, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        tipo = pTipo.toLowerCase();
        nombre = pNombre;
        valorUnitario = pValorUnitario;
        cantidadBodega = pCantidadBodega;
        cantidadMinima = pCantidadMinima;
        rutaImagen = pRutaImagen;
        cantidadUnidadesVendidas = 0;
    }

    public String darNombre() {
        return nombre;
    }

    public String darTipo() {
        return tipo.toLowerCase();
    }

    public double darValorUnitario() {
        return valorUnitario;
    }

    public int darCantidadBodega() {
        return cantidadBodega;
    }

    public int darCantidadMinima() {
        return cantidadMinima;
    }

    public int darCantidadUnidadesVendidas() {
        return cantidadUnidadesVendidas;
    }

    public String darRutaImagen() {
        return rutaImagen;
    }

    public void cambiarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void cambiarTipo(String nuevoTipo) {
        this.tipo = nuevoTipo.toLowerCase();
    }

    public void cambiarValorUnitario(double nuevoValorUnitario) {
        this.valorUnitario = nuevoValorUnitario;
    }

    public void cambiarCantidadBodega(int nuevaCantidadEnBodega) {
        this.cantidadBodega = nuevaCantidadEnBodega;
    }

    public void cambiarCantidadMinima(int nuevaCantidadMinima) {
        this.cantidadMinima = nuevaCantidadMinima;
    }

    public void cambiardarCantidadUnidadesVendidas(int nuevaCantidadUnidadesVendidas) {
        this.cantidadUnidadesVendidas = nuevaCantidadUnidadesVendidas;
    }

    public void cambiarRutaImagen(String nuevaRutaImagen) {
        this.rutaImagen = nuevaRutaImagen;
    }

    public double calcularPrecioFinal() {
        return valorUnitario * (1 + darIVA());
    }

    public double darIVA() {
        double iva = 0.0;
        switch (tipo) {
            case "supermercado":
                iva = 0.04;
                break;
            case "drogueria":
                iva = 0.12;
                break;
            case "papeleria":
                iva = 0.16;
                break;
        }
        return iva;
    }

    public int vender(int pCantidad) {
        int cantidadVendida = Math.min(pCantidad, cantidadBodega);
        cantidadBodega -= cantidadVendida;
        cantidadUnidadesVendidas += cantidadVendida;
        return cantidadVendida;
    }

    public void abastecer(int pCantidad) {
        cantidadBodega += pCantidad;
    }

    public boolean puedeAbastecer() {
        return cantidadBodega < cantidadMinima;
    }
}