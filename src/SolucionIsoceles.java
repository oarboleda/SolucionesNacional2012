
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class SolucionIsoceles {

    public static void main(String[] args) {
        // TODO code application logic here
        Coordenada[] datos = {
            new Coordenada(1.0,2.0), new Coordenada(2.0,5.0),
            new Coordenada(3.0,3.0), new Coordenada(4.0,7.0),
            new Coordenada(5.0,4.0), new Coordenada(7.0,2.0),
            new Coordenada(8.0,6.0), new Coordenada(9.0,5.0),
                             };        
        
      System.out.println("Cantidad de Isoceles = "+cantidadIsoceles(datos));        
    }
    
    public static int cantidadIsoceles(Coordenada[] info)            
    {
        int iguales = 0;
                
        for (int i=1; i< info.length-1; i++)
        {
            System.out.println("Procesando punto "+info[i]);
            HashMap<Double, Integer> bd = new HashMap<Double, Integer>();
            
            // Computa todas las distancias con los puntos previos
            for (int antes=0; antes < i; antes++)
            {
                // Busca si esa distancia ya fue guardada
                Double dist = info[i].distancia(info[antes]);
                System.out.println("Distancia "+antes+"-"+i+" = "+dist);
                if (bd.containsKey(dist))
                {
                    int count = bd.get(dist);
                    bd.put(dist, count+1);
                }
                else
                {
                    bd.put(dist, 1);
                }
            }

            // Computa todas las distancias con los puntos posteriores
            for (int despues=i+1; despues < info.length; despues++)
            {
                // Busca si esa distancia ya fue guardada
                Double dist = info[i].distancia(info[despues]);
                if (bd.containsKey(dist))
                {
                    // Incrementa cantidad de lados iguales
                    System.out.println("  ... Distancia encontrada "+dist+"  veces="+bd.get(dist));
                    iguales += bd.get(dist);
                }
            }
            
        }
        return iguales;
    }
}

class Coordenada {
    private double cordX;
    private double cordY;

    public Coordenada(double cordX, double cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }

    public double getCordX() {
        return cordX;
    }

    public void setCordX(double cordX) {
        this.cordX = cordX;
    }

    public double getCordY() {
        return cordY;
    }

    public void setCordY(double cordY) {
        this.cordY = cordY;
    }

    @Override
    public String toString() {
        return "( " + cordX + " , " + cordY + " )";
    }
    
    public Double distancia(Coordenada P2) {
        double deltaX = cordX-P2.getCordX();
        double deltaY = cordY-P2.getCordY();
        return new Double(Math.sqrt(deltaX*deltaX+deltaY*deltaY));
    }
}
