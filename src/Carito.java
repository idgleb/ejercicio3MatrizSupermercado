import javax.swing.*;
import java.util.Arrays;

public class Carito {
    private String[][] productosEnCarrito;
    private int cantidatProductosCarito;
    private Cliente cliente;
    private Supermercado supermercado;


    public Carito(Cliente cliente, Supermercado supermercado) {
        this.productosEnCarrito = new String[10][3];
        this.cantidatProductosCarito = 0;
        this.cliente = cliente;
        this.supermercado = supermercado;
    }

    public Boolean agregarProducto() {

        int numeroProductoElejido = supermercado.eligirProducto();
        if (numeroProductoElejido == -1) return false;

        int cantidad = MisFunciones.pedirNumeroMasCero("cuantos?");

        if (isDisponibleEnStock(numeroProductoElejido, cantidad) && isSuficienteFilasEnCarrito() && cantidad > 0) {


            this.productosEnCarrito[cantidatProductosCarito] = Arrays.copyOf(supermercado.getStock()[numeroProductoElejido], supermercado.getStock()[numeroProductoElejido].length);

            this.productosEnCarrito[cantidatProductosCarito][2] = String.valueOf(cantidad);

            supermercado.disminuirProductoEnStock(numeroProductoElejido, cantidad);

            cantidatProductosCarito++;
            JOptionPane.showMessageDialog(null, "Producto agregado");
            return true;
        }

        JOptionPane.showMessageDialog(null, "Error no agregado nada");
        return false;

    }

    private boolean isSuficienteFilasEnCarrito() {
        return cantidatProductosCarito < productosEnCarrito.length;
    }

    private boolean isDisponibleEnStock(int numeroProductoElejido, int cantidad) {
        return cantidad <= Integer.parseInt(supermercado.getStock()[numeroProductoElejido][2]);
    }

    public String[][] getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void mostrarCarrito() {
        String carritoStr = "";
        for (int i = 0; i < productosEnCarrito.length; i++) {
            carritoStr += Arrays.toString(productosEnCarrito[i]) + "\n";
        }
        JOptionPane.showMessageDialog(null, "En Carrito: \n" + carritoStr);
    }


    public String reporte() {
        return "Carrito \n" + Arrays.deepToString(productosEnCarrito) + "\n";
    }
}
