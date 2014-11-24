/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String dat="HolaXYMundoHolaMundo";
        int pos= dat.indexOf("Mundo");
        System.out.println("pos="+pos+"  Subcadena="+dat.substring(2,pos));
    }
}
