import java.util.*;
class IterativeFactorial
{
	public static void fact(int n)
	{
		int f = 1;
		if(n==0)
			System.out.println("Factorial is : "+1);
		else
		{
			for(int i=1;i<=n;i++)
			{
				f = f*i;			
			}
			System.out.println("Factorial is equal to : "+f);
		}
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = s.nextInt();
		System.out.println();
		fact(n);
	}
}