package Otros;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class PruebaArgumentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando argumentos");
        for(int i=0; i<args.length; i++){
            System.out.println("args["+i+"]="+args[i]);
        }
    }
}
