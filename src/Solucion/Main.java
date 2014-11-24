/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solucion;

/**
 *
 * @author oarboleda
 */
import java.util.Scanner;

public class Main
{
	/**
	 * @author Daniel Alvarez
	 * @verdict Accepted
	 */
	public static void main(String[] a3d)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt())
		{
			int i = in.nextInt();
			int j = in.nextInt();
			System.out.print(i + " " + j + " ");
			int may = 0;
			if(i > j)
			{
				int aux = i;
				i = j;
				j = aux;
			}
			for(int k = i; k <= j; k++)
			{
				int a = algoritmo(k, 0);
				if(a > may)
					may = a;
			}
			System.out.println(may);
		}
	}
	public static int algoritmo(int n, int c)
	{
		if(n != 1)
			if(n % 2 == 1)
				return algoritmo(3 * n + 1, c + 1) ;
			else
				return algoritmo(n / 2, c + 1);
		return c + 1;
	}
}
