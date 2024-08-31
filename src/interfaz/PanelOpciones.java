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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para las opciones.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para mostrar el producto m�s vendido.
     */
    private static final String MAS_VENDIDO = "MasVendido";

    /**
     * Comando para mostrar el producto menos vendido.
     */
    private static final String MENOS_VENDIDO = "MenosVendido";

    /**
     * Comando para mostrar el promedio de ventas.
     */
    private static final String PROMEDIO_VENTAS = "PromedioVentas";

    /**
     * Comando para mostrar el dinero en caja.
     */
    private static final String DINERO_CAJA = "DineroCaja";

    /**
     * Comando Opci�n 1.
     */
    private static final String OPCION_1 = "InferiorPromedio";

    /**
     * Comando Opci�n 2.
     */
    private static final String OPCION_2 = "ProductoMasBarato";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazTienda principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para mostrar el m�s vendido.
     */
    private JButton btnMasVendido;

    /**
     * Bot�n para mostrar el menos vendido.
     */
    private JButton btnMenosVendido;

    /**
     * Bot�n para mostrar el promedio de ventas.
     */
    private JButton btnPromedioVentas;

    /**
     * Bot�n para ventas en volumen.
     */
    private JButton btnDineroCaja;

    /**
     * Bot�n Opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     *
     * @param pPrincipal Ventana principal. pPrincipal != null.
     */
    public PanelOpciones(InterfazTienda pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridLayout(2, 3));

        btnMasVendido = new JButton("Producto mas vendido");
        btnMasVendido.setActionCommand(MAS_VENDIDO);
        btnMasVendido.addActionListener(this);
        add(btnMasVendido);

        btnMenosVendido = new JButton("Producto menos vendido");
        btnMenosVendido.setActionCommand(MENOS_VENDIDO);
        btnMenosVendido.addActionListener(this);
        add(btnMenosVendido);

        btnPromedioVentas = new JButton("Promedio ventas");
        btnPromedioVentas.setActionCommand(PROMEDIO_VENTAS);
        btnPromedioVentas.addActionListener(this);
        add(btnPromedioVentas);

        btnDineroCaja = new JButton("Dinero en caja");
        btnDineroCaja.setActionCommand(DINERO_CAJA);
        btnDineroCaja.addActionListener(this);
        add(btnDineroCaja);

        btnOpcion1 = new JButton("Inferior al promedio");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);

        btnOpcion2 = new JButton("Promedio mas barato");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();
        if (comando.equals(MAS_VENDIDO)) {
            principal.mostrarMasVendido();
        } else if (comando.equals(MENOS_VENDIDO)) {
            principal.mostrarMenosVendido();
        } else if (comando.equals(DINERO_CAJA)) {
            principal.mostrarDineroEnCaja();
        } else if (comando.equals(PROMEDIO_VENTAS)) {
            principal.mostrarPromedioVentas();
        } else if (comando.equals(OPCION_1)) {
            principal.reqFuncOpcion1();
        } else if (comando.equals(OPCION_2)) {
            principal.reqFuncOpcion2();
        }
    }

}
