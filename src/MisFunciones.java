import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/*
String[] opc = {"mostrarCarrito", "carito::agregarProducto", "mostrarStock"};
        MisFunciones.interfaz(
        carito::mostrarCarrito,
        carito::agregarProducto,
        supermercado::mostrarStock,
        opc, supermercado::reporte
);
*/

public abstract class MisFunciones {

    public static int eligirEn(String[][] matriz) {

        String[] listaElementosEnMatriz = new String[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            listaElementosEnMatriz[i] = Arrays.toString(matriz[i]);
        }

        String elementoEligido = (String) JOptionPane.showInputDialog(null,
                "Elege...", "Ursol",
                JOptionPane.QUESTION_MESSAGE, null, listaElementosEnMatriz, null);

        if (elementoEligido != null) {
            int item = Arrays.asList(listaElementosEnMatriz).indexOf(elementoEligido);
            return item;
        }

        return -1;

    }

    public static boolean isNumeroDe_1_10000000(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 10000000) return false;
        }
        return true;
    }

    public static int pedirNumeroMasCero(String msg) {
        String str;
        do {
            str = JOptionPane.showInputDialog(null, msg);
            if (str == null) return 0;
        } while (str.isEmpty() || !isNumeroDe_1_10000000(str));
        return Integer.parseInt(str);
    }

    public static String pedirStrNoVacio(String msg) {
        String str;
        do {
            str = JOptionPane.showInputDialog(null, msg);
            if (str == null) return null;
        } while (str.isEmpty());
        return str;
    }

    public static LocalDate pedirFechaMasDeHoy(String msg, String msgError) {
        LocalDate fechaEntr;
        do {
            fechaEntr = LocalDate.parse(JOptionPane.showInputDialog(null, msg));
            if (fechaEntr.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, msgError);
            }
        } while (fechaEntr.isBefore(LocalDate.now()));
        return fechaEntr;
    }

    public static LocalDate pedirFechaMasDeOtraFecha(LocalDate otraFecha, String msg, String msgError) {
        LocalDate fecha;
        do {
            fecha = LocalDate.parse(JOptionPane.showInputDialog(null, msg));
            if (fecha.isBefore(otraFecha)) {
                JOptionPane.showMessageDialog(null, msgError);
            }
        } while (fecha.isBefore(otraFecha));
        return fecha;
    }

    public static void interfaz(Runnable[] ac, String[] opc, Supplier<String> report) {
        List<String> opcList = new ArrayList<>(Arrays.asList(opc));
        opcList.addFirst("Salir");
        int select = 0;
        do {
            select = JOptionPane.showOptionDialog(
                    null,
                    report.get(),
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcList.toArray(),
                    opcList.getFirst()
            );

            if (select > 0) ac[select-1].run();

        } while (select > 0);
    }

}
