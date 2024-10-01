import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Supermercado {
    private String nombre;
    private String[][] stock;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.stock = new String[][]{
                {"Coca", "100.0", "10"},
                {"Pan", "100.0", "10"},
                {"Helado", "100.0", "10"},
        };
    }

    public int eligirProducto() {
        return MisFunciones.eligirEn(stock);
    }

    public Boolean disminuirProductoEnStock(int numeroProducto, int candidat) {
        stock[numeroProducto][2] = String.valueOf(Integer.parseInt(stock[numeroProducto][2]) - candidat);
        return true;
    }

    public Cliente crearCliente() {
        String nombreCliente = MisFunciones.pedirStrNoVacio("Nombre de Cliente?");
        return new Cliente(nombreCliente);
    }

    public Carito crearCarrito(Cliente cliente) {
        return new Carito(cliente, this);
    }

    public String getNombre() {
        return nombre;
    }

    public String[][] getStock() {
        return stock;
    }

    public String reporte(){
        return "Stock \n" + Arrays.deepToString(stock) + "\n";
    }

    public void mostrarStock() {
        String stockStr = "";
        for (int i = 0; i < stock.length; i++) {
            stockStr += Arrays.toString(stock[i]) + "\n";
        }
        JOptionPane.showMessageDialog(null, "El stock: \n" + stockStr);
    }
}
