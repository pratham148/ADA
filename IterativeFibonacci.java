import java.util.*;
class IterativeFibonacci
{
	public static void fib(int n)
	{
		int a = 0;
		int b = 1;
		int s = 0;
		System.out.print(a + " " + b); 
		for(int i=2;i<n;i++)
		{
			s = a + b;
			System.out.print(" " + s);
			a = b;
			b = s;
		}
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the value of n : ");
		int n = s.nextInt();
		System.out.println();
		fib(n);
	}
}
