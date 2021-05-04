import java.util.*;
class MtrxMultiplication
{
	public static void main(String[] args) 
	{
		int A[][] = {{6,8},{1,4}};
		int B[][] = {{2,6},{5,7}};
		int M[][] = new int[2][2];
		System.out.println("\nFirst Matrix : ");
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\nSecond Matrix : ");
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		long strt = System.nanoTime();
		System.out.println("\nResultant matrix after Matrix Multiplication : "); 
		for(int i=0;i<2;i++)
		{
			for (int j=0;j<2;j++) 
			{
				M[i][j] = 0;
				for(int k=0;k<2;k++)
				{
					M[i][j] += (A[i][k]*B[k][j]);
				}
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
		long end = System.nanoTime();
		long elapsed = end - strt;
		System.out.println("Time taken : "+elapsed);
	}
}