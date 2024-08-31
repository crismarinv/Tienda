package app;

import controlador.ControladorTienda;
import interfaz.InterfazTienda;
import mundo.Tienda;

public class AplicacionTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();  // Inicializa el modelo
        ControladorTienda controlador = new ControladorTienda(tienda);  // Crea el controlador y le pasa el modelo
        InterfazTienda vista = new InterfazTienda(controlador);  // Inicializa la vista con el controlador
        
        vista.setVisible(true);  // Hace visible la interfaz gráfica
    }
}