import java.util.*;
class BruteForce
{
	public static int knapsackRec(int w[],int p[],int n,int c)
	{
		if(n<=0)
			return 0;
		else if(w[n-1]>c)
		{
			return knapsackRec(w,p,n-1,c);
		}
		else
		{
			return Math.max(knapsackRec(w,p,n-1,c),p[n-1]) + knapsackRec(w,p,n-1,c-w[n-1]);
		}
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
		int max = knapsackRec(w,p,n,c);
		System.out.println("Total maximum profit : "+ max);
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.println("\nTime elapse : "+elapsed);
	}
}