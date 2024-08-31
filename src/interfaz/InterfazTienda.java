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
package interfaz;

import controlador.ControladorTienda;
import javax.swing.*;
import java.awt.*;
import mundo.Producto;

public class InterfazTienda extends JFrame {
    private static final long serialVersionUID = 1L;
    private ControladorTienda controlador;

    // Paneles
    private PanelImagen panelImagen;
    private PanelOpciones panelOpciones;
    private PanelProducto panelProducto1;
    private PanelProducto panelProducto2;
    private PanelProducto panelProducto3;
    private PanelProducto panelProducto4;

    public InterfazTienda(ControladorTienda controlador) {
        this.controlador = controlador;

        setTitle("Tienda");
        setSize(800, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar paneles
        panelImagen = new PanelImagen();
        panelOpciones = new PanelOpciones(this);
        panelProducto1 = new PanelProducto(this);
        panelProducto2 = new PanelProducto(this);
        panelProducto3 = new PanelProducto(this);
        panelProducto4 = new PanelProducto(this);

        // Agregar paneles a la interfaz
        add(panelImagen, BorderLayout.NORTH);
        add(panelOpciones, BorderLayout.SOUTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(2, 2));

        panelCentro.add(panelProducto1);
        panelCentro.add(panelProducto2);
        panelCentro.add(panelProducto3);
        panelCentro.add(panelProducto4);

        add(panelCentro, BorderLayout.CENTER);

        // Actualizar la vista con los datos iniciales de los productos
        actualizarVista();
    }

    public void actualizarVista() {
        // Actualizar cada panel de producto con la información correspondiente
        panelProducto1.actualizarInfo(controlador.darPrimerProducto());
        panelProducto2.actualizarInfo(controlador.darSegundoProducto());
        panelProducto3.actualizarInfo(controlador.darTercerProducto());
        panelProducto4.actualizarInfo(controlador.darCuartoProducto());

        // Forzar repintado y revalidación de la interfaz
        revalidate();
        repaint();
    }

    public void abastecerUnidades(String nombreProducto) {
        String cantidadStr = JOptionPane.showInputDialog(this, "Cantidad de unidades para abastecer:");
        if (cantidadStr != null) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad > 0) {
                    boolean abastecido = controlador.abastecerProducto(nombreProducto, cantidad);
                    mostrarMensajeAbastecimiento(abastecido);
                    actualizarVista();
                } else {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.");
            }
        }
    }

    public void cambiarProducto(String nombreActual, String nombreNuevo, String tipo, double valorUnitario, int cantidadBodega, int cantidadMinima, String rutaImagen) {
        boolean cambiado = controlador.cambiarProducto(nombreActual, nombreNuevo, tipo, valorUnitario, cantidadBodega, cantidadMinima, rutaImagen);
        if (cambiado) {
            actualizarVista();
        } else {
            mostrarMensajeErrorCambioProducto(nombreNuevo);
        }
    }

    public void mostrarDineroEnCaja() {
        double dineroEnCaja = controlador.darDineroEnCaja();
        JOptionPane.showMessageDialog(this, "Dinero en caja: $" + dineroEnCaja);
    }

    public void mostrarMasVendido() {
        Producto masVendido = controlador.darProductoMasVendido();
        mostrarMensajeProductoMasVendido(masVendido);
    }

    public void mostrarMenosVendido() {
        Producto menosVendido = controlador.darProductoMenosVendido();
        mostrarMensajeProductoMenosVendido(menosVendido);
    }

    public void mostrarPromedioVentas() {
        double promedio = controlador.darPromedioVentas();
        mostrarMensajePromedioVentas(promedio);
    }

    public void reqFuncOpcion1() {
        int cantidad = controlador.metodo1();
        mostrarMensajeOpcion1(cantidad);
    }

    public void reqFuncOpcion2() {
        String nombreProducto = controlador.metodo2();
        mostrarMensajeOpcion2(nombreProducto);
    }

    public void venderProducto(String nombreProducto) {
        String cantidadStr = JOptionPane.showInputDialog(this, "Cantidad de unidades a vender:");
        if (cantidadStr != null) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad > 0) {
                    int cantidadVendida = controlador.venderProducto(nombreProducto, cantidad);
                    mostrarMensajeVenta(cantidadVendida);
                    actualizarVista();
                } else {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.");
            }
        }
    }

    public void mostrarMensajeVenta(int cantidadVendida) {
        JOptionPane.showMessageDialog(this, "Vendidas " + cantidadVendida + " unidades.");
    }

    public void mostrarMensajeAbastecimiento(boolean exitoso) {
        if (exitoso) {
            JOptionPane.showMessageDialog(this, "Abastecimiento exitoso.");
        } else {
            JOptionPane.showMessageDialog(this, "Error en el abastecimiento.");
        }
    }

    public void mostrarMensajeErrorCambioProducto(String nombreNuevo) {
        JOptionPane.showMessageDialog(this, "Ya existe un producto con el nombre " + nombreNuevo + ".", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeProductoMasVendido(Producto producto) {
        if (producto != null) {
            JOptionPane.showMessageDialog(this, "El producto más vendido es: " + producto.darNombre());
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos vendidos.", "Producto más vendido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarMensajeProductoMenosVendido(Producto producto) {
        if (producto != null) {
            JOptionPane.showMessageDialog(this, "El producto menos vendido es: " + producto.darNombre());
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos vendidos.", "Producto menos vendido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarMensajePromedioVentas(double promedio) {
        JOptionPane.showMessageDialog(this, "El promedio de ventas es: " + promedio, "Promedio ventas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeOpcion1(int cantidad) {
        JOptionPane.showMessageDialog(this, "Cantidad de productos con precio inferior al promedio: " + cantidad);
    }

    public void mostrarMensajeOpcion2(String nombreProducto) {
        JOptionPane.showMessageDialog(this, "El producto más barato es: " + nombreProducto);
    }

    public void mostrarDialogoCambiarProducto(String nombreProducto) {
        DialogoCambiarProducto dialogo = new DialogoCambiarProducto(this, nombreProducto);
        dialogo.setVisible(true);
    }
}