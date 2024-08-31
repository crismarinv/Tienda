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

import mundo.Producto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra la informaci�n de un producto.
 */
@SuppressWarnings("serial")
public class PanelProducto extends JPanel implements ActionListener {
    // ----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el combo box con los juegos.
     */
    private static final String CAMBIAR_PRODUCTO = "CambiarProducto";

    /**
     * Comando para el bot�n de comprar.
     */
    private static final String BOTON_ABASTECER = "Abastecer";

    /**
     * Comando para el bot�n de vender.
     */
    private static final String BOTON_VENDER = "Vender";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazTienda principal;

    /**
     * Producto del panel.
     */
    private Producto producto;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Tipo.
     */
    private JLabel lblTipo;

    /**
     * Etiqueta Valor unitario.
     */
    private JLabel lblValorUnitario;

    /**
     * Etiqueta Cantidad bodega.
     */
    private JLabel lblCantidadBodega;

    /**
     * Etiqueta Cantidad vendidas.
     */
    private JLabel lblCantidadVendidas;

    /**
     * Etiqueta Cantidad m�nima.
     */
    private JLabel lblCantidadMinima;

    /**
     * Campo de texto con el tipo.
     */
    private JTextField txtTipo;

    /**
     * Campo de texto con el valor unitario.
     */
    private JTextField txtValorUnitario;

    /**
     * Campo de texto con la cantidad en bodega.
     */
    private JTextField txtCantidadBodega;

    /**
     * Campo de texto con la cantidad de unidades vendidas.
     */
    private JTextField txtCantidadVendidas;

    /**
     * Campo de texto con la cantidad m�nima de unidades para abastecer,
     */
    private JTextField txtCantidadMinima;

    /**
     * Etiqueta para la imagen.
     */
    private JLabel lblImagen;

    /**
     * Bot�n para Vender unidades del producto.
     */
    private JButton btnVender;

    /**
     * Bot�n para abastecer el producto.
     */
    private JButton btnAbastecer;

    /**
     * Bot�n para cambiar el producto.
     */
    private JButton btnCambiarProducto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la informaci�n del producto.
     *
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelProducto(InterfazTienda pPrincipal) {
        principal = pPrincipal;

        setLayout(new BorderLayout());

        JPanel panelDatosJuego = new JPanel();
        add(panelDatosJuego, BorderLayout.CENTER);

        panelDatosJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
        setBorder(new TitledBorder("Producto"));

        panelDatosJuego.setLayout(new GridLayout(5, 1, 0, 5));

        lblTipo = new JLabel("Tipo: ");
        txtTipo = new JTextField(15);
        txtTipo.setEditable(false);
        panelDatosJuego.add(lblTipo);
        panelDatosJuego.add(txtTipo);

        lblCantidadBodega = new JLabel("Cantidad bodega: ");
        txtCantidadBodega = new JTextField(15);
        txtCantidadBodega.setEditable(false);
        panelDatosJuego.add(lblCantidadBodega);
        panelDatosJuego.add(txtCantidadBodega);

        lblValorUnitario = new JLabel("Valor unitario: ");
        txtValorUnitario = new JTextField(15);
        txtValorUnitario.setEditable(false);
        panelDatosJuego.add(lblValorUnitario);
        panelDatosJuego.add(txtValorUnitario);

        lblCantidadVendidas = new JLabel("Cantidad vendidas: ");
        txtCantidadVendidas = new JTextField(15);
        txtCantidadVendidas.setEditable(false);
        panelDatosJuego.add(lblCantidadVendidas);
        panelDatosJuego.add(txtCantidadVendidas);

        lblCantidadMinima = new JLabel("Cantidad minima: ");
        txtCantidadMinima = new JTextField(15);
        txtCantidadMinima.setEditable(false);
        panelDatosJuego.add(lblCantidadMinima);
        panelDatosJuego.add(txtCantidadMinima);

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new GridLayout(1, 3));

        btnAbastecer = new JButton("Abastecer");
        btnAbastecer.setActionCommand(BOTON_ABASTECER);
        btnAbastecer.addActionListener(this);
        panelSur.add(btnAbastecer);

        btnVender = new JButton("Vender");
        btnVender.setActionCommand(BOTON_VENDER);
        btnVender.addActionListener(this);
        panelSur.add(btnVender);

        btnCambiarProducto = new JButton("Cambiar");
        btnCambiarProducto.setActionCommand(CAMBIAR_PRODUCTO);
        btnCambiarProducto.addActionListener(this);
        panelSur.add(btnCambiarProducto);

        add(panelSur, BorderLayout.SOUTH);

        lblImagen = new JLabel();
        add(lblImagen, BorderLayout.WEST);

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n del panel con la informaci�n dada.
     *
     * @param pProducto Juego para actualizar la informaci�n. pJuego != null.
     */
    public void actualizarInfo(Producto pProducto) {
        producto = pProducto;
        setBorder(new TitledBorder(producto.darNombre()));
        ImageIcon icono = new ImageIcon("./data/imagenes/" + producto.darRutaImagen());
        lblImagen.setIcon(icono);
        String tipo = producto.darTipo();
        txtTipo.setText(tipo);
        txtValorUnitario.setText(producto.darValorUnitario() + " $");
        txtCantidadBodega.setText(producto.darCantidadBodega() + "");
        txtCantidadMinima.setText(producto.darCantidadMinima() + "");
        txtCantidadVendidas.setText(producto.darCantidadUnidadesVendidas() + "");
    }

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();

        if (comando.equals(BOTON_VENDER)) {
            principal.venderProducto(producto.darNombre());
        } else if (comando.equals(BOTON_ABASTECER)) {
            principal.abastecerUnidades(producto.darNombre());
        } else if (comando.equals(CAMBIAR_PRODUCTO)) {
            principal.mostrarDialogoCambiarProducto(producto.darNombre());
        }
    }

}
