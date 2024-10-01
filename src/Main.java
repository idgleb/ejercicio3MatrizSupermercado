import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado("COTO2");

        Cliente cliente = supermercado.crearCliente();

        Carito carito = supermercado.crearCarrito(cliente);

        String[] opc = {"mostrarCarrito", "carito-agregarProducto", "mostrarStock"};
        Runnable[] ac = new Runnable[]{
                carito::mostrarCarrito,
                carito::agregarProducto,
                supermercado::mostrarStock
        };
        MisFunciones.interfaz(ac, opc, supermercado::reporte);

    }
}