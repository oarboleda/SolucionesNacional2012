package Otros;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class ProblemD_Digit {

    static final int TAMAÑO = 40000000;
    static final int NO_CALCULADO = -1;
    static int[] resultados = new int[TAMAÑO];

    public static void main(String[] args) {        
        String[] entrada = {
            "3 8",
            "5 18",
            "1 50",
            "20 80",
            "40 300000",
            "10 900000",  
            "5 950000",   
            "1000 5000000",     
            "100 30000000",    
            "5 50000000",               
            "2 1000000000",
//            "20000 500000000",
//            "2000000 20000000",
//            "600000 80000000",
//            "20 900000000",
//            "3599000 390599000",
//            "9900000 990000000",
//            "5550000 600000000",
//            "49020000 949020000",
            "0 0",
            "5550000 600000000",
            "49020000 949020000"
        };

        iniciar();

        long tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < entrada.length; i++) {
            String[] valores = entrada[i].split(" ");
            int inf = Integer.parseInt(valores[0]);
            int sup = Integer.parseInt(valores[1]);
            if (inf == 0 && sup == 0) {
                break;
            } else {
                int total = 0;

                for (int j = inf; j <= sup; j++) {
                    total += sumaDigitos(j);
                }
                System.out.println("(" + inf + " , " + sup + ") = " + total);
            }
        }
        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo :" + totalTiempo/1000.0 + " segs");
    }

    public static void iniciar() {
        for (int i = 0; i < resultados.length; i++) {
            resultados[i] = NO_CALCULADO;
        }
    }

    public static int sumaDigitos(int val) {
        int copiaVal = val;
        int res = NO_CALCULADO;

        if (val < resultados.length) {
            res = resultados[val];
        }

        if (res == NO_CALCULADO || val >= resultados.length) {
            res = 0;
            while (val > 9) {
                res += val % 10;
                val /= 10;
            }
            res += val;

            if (copiaVal < resultados.length) {
                resultados[copiaVal] = res;
            }
        }

        return res;
    }
}
