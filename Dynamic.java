import java.util.*;
class Dynamic
{
	public static int knapsackDp(int w[],int p[],int n,int c)
	{
		if(n<=0||c<=0)
		{
			return 0;
		}
		int[][] tb = new int[n+1][c+1];
		for(int j=0;j<=c;j++)
		{
			tb[0][j] = 0;
		}
		for(int j=0;j<=n;j++)
		{
			tb[j][0] = 0;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=c;j++)
			{
				if(w[i-1]>j)
				{
					tb[i][j] = tb[i-1][j];
				}
				else
				{
					tb[i][j] = Math.max(tb[i-1][j],tb[i-1][j-w[i-1]]+p[i-1]);
				}
			}
		}
		return tb[n][c];
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of items : ");
		int n = s.nextInt();
		System.out.println();
		System.out.print("Enter the Knapsack Capacity : ");
		int c = s.nextInt();
		System.out.println();
		int p[] = new int[n];
		int w[] = new int[n];
		System.out.println("Start entering the weights and profit of each item : ");
		for(int i=0;i<n;i++)
		{
			System.out.println("For Item"+(i+1));
			System.out.print("Weight : ");
			w[i] = s.nextInt();
			System.out.print("Profit : ");
			p[i] = s.nextInt();
			System.out.println();
		}
		long start = System.nanoTime();
		System.out.println("Total max profit : "+knapsackDp(w,p,n,c));
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.println("\nTime elapsed : "+elapsed);

	}
}