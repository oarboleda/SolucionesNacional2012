package Otros;

import java.io.*;

public class VersionSteven3n_1 
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while((linea=lector.readLine()) != null)
            {
                int i=Integer.parseInt(linea.split(" ")[0]),j=Integer.parseInt(linea.split(" ")[1]), max=0;
                int desde=Math.min(i, j),hasta=Math.max(i, j);
                for(int k=desde;k<=hasta;k++)
                    max=Math.max(max, VersionSteven3n_1.iteraciones(k,0));
                System.out.println(i + " " + j + " " + max);
            }
        }
        catch(IOException ie)
        { System.out.println(ie);  }
    }
    
    public static int iteraciones(int n,int cant)
    {
        if(n==1)
            return cant+1;
        else
            return iteraciones((n % 2)==0 ?  n/2 : (3*n)+1,cant+1);
    }
}
