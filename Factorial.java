import java.util.*;
class Factorial
{
	public static int fact(int n)
	{
		if(n==0)
			return 1;
		else
			return n*fact(n-1);
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = s.nextInt();
		System.out.print("Factorial of number"+num+" is : ");
		System.out.println(fact(num));
	}
}