
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
public class VersionArboleda_3n_1 {
    static final int MAXIMO = 20;    
//    static final int MAXIMO = 40*1000000;
    static int resultados[] = new int[MAXIMO];
    static String traza="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        resultados[0]=1;
        resultados[1]=2;
        try
        {
            BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while((linea=lector.readLine()) != null)
            {
                int i=Integer.parseInt(linea.split(" ")[0]),j=Integer.parseInt(linea.split(" ")[1]), max=0;
                int desde=Math.min(i, j),hasta=Math.max(i, j);
                for(int k=desde;k<=hasta;k++){
                    int res = iteraciones(k,0)-1;
                    max=Math.max(max, res);
                   /* System.out.println("\n ***** \n"+traza+"\n k="+k+"  res="+res+"  max="+max);
                    traza ="";
                    * 
                    */
                }    
                System.out.println(i + " " + j + " " + max);
            }
        }
        catch(IOException ie)
        { System.out.println(ie);  }
    }
    
    public static int iteraciones(int n, int cant)
    {
        traza+="\n n="+n+ "\t cant="+cant;
        int veces=0;
        
        if (n<=MAXIMO){
            if (resultados[n-1] == 0){
                veces = iteraciones((n % 2)==0 ?  n/2 : (3*n)+1, cant+1);
                resultados[n-1]= veces;
                traza+=" A  veces="+veces+" ["+n+"]<=="+veces;
            }else{
                veces = resultados[n-1];
                traza+=" B  veces="+veces;
            }
        }else{
            veces = iteraciones2((n % 2)==0 ?  n/2 : (3*n)+1, cant+1);
            traza+=" C  veces="+veces;
        }
        return veces+1;
    }  
    
    public static int iteraciones2(int n,int cant)
    {     
        int veces = 0;
        int auxCant = (n % 2)==0 ?  n/2 : (3*n)+1;

        if (auxCant <= MAXIMO){
            veces = iteraciones(auxCant, cant+1);
        }else{
            veces = iteraciones2(auxCant, cant)+cant;
        }
        return veces+1;          
    }    
    
    public static String mirar()
    {   
        String res="Veces diferente de cero:";
        for(int i=0; i<resultados.length; i++){
            if (resultados[i]!=0){
                res+="\n Pos:"+i+"  Valor:"+resultados[i];
            }
        }
        return res;
    }    
    
}
