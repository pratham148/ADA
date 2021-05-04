import java.util.*;
class RecursiveFibonacci
{ 
	static int n1=0,n2=1,n3=0;    
	public static void fib(int n)
	{
		if(n>0)
    	{
    		n3 = n1 + n2;    
        	n1 = n2;    
        	n2 = n3;    
        	System.out.print(" "+n3);   
        	fib(n-1);    
    	}
	}
    public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the value of n : ");
    	int n = s.nextInt();
    	System.out.println();    
  		System.out.print(n1+" "+n2);  
  		fib(n-2);  
 	}  
}  

