package Otros;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class ProblemD_Digit2 {

    static final int TAMAÑO = 40000000;
    static final int NO_CALCULADO = -1;
    static int[] resultados = new int[TAMAÑO];
//    static int[] resultados2 = new int[TAMAÑO];    

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
        
//        System.out.println("Numeros mayoresEnteros:"+Integer.MAX_VALUE+"\nNumeros MenoresEnteros:"+Integer.MIN_VALUE);
//        System.out.println("Numeros mayoresLong:"+Long.MAX_VALUE+"\nNumeros MenoresLong:"+Long.MIN_VALUE);        

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
                    total += procesaNumero(j);
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

    public static int procesaNumero(int val) {
        int res = NO_CALCULADO;

        if (val < resultados.length) {
            res = resultados[val];
        }

//        System.out.println(val+ " -- " +res);
        if (res == NO_CALCULADO || val >= resultados.length) {
            res = sumaDigitos(val);

            if (val < resultados.length) {
                for (int i = val % 10, incremento = 0; i < 10; i++, incremento++) {
                    if (val + incremento < resultados.length) {
                        resultados[val + incremento] = res + incremento;
                    }
                }
            }
        }

        return res;
    }

    public static int sumaDigitos(int val) {
        int res = 0;
        while (val > 9) {
            res += val % 10;
            val /= 10;
        }
        res += val;

        return res;
    }
}
