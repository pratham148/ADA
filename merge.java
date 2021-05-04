//Merge Sort

import java.util.*;
class merge
{
	public static void mergesort(int a[],int lb,int ub)
	{
		//int le = l;
		//int mid = 0;
		if(lb<ub)
		{
			int mid = (lb + ub)/2;
			mergesort(a,lb,mid);
			mergesort(a,mid+1,ub);
			merges(a,lb,mid,ub);
		}
		
	}
	public static void merges(int a[],int lb,int mid,int ub)
	{
		int i = lb;
		int j = mid+1;
		int k = lb;
		int b[] = new int[ub+1];
		while(i<=mid && j<=ub)
		{
			if(a[i]<=a[j])
			{
				b[k] =a[i];
				i++;
				k++; 
			}
			else
			{
				b[k] = a[j];
				j++;
				k++;
			}
		}
		if(i>mid)
		{
			while(j<=ub)
			{
				b[k] = a[j];
				j++;
				k++;
			}
		}
		else
		{
			while(i<=mid)
			{
				b[k] = a[i];
				i++;
				k++;
			}
		}
		for(k=lb;k<=ub;k++)
		{
			a[k]=b[k];
		}
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\n\n\tMERGE SORT\n\n");
		System.out.println("Enter the length of your Array : ");
		int l = s.nextInt();
		int a[] = new int[l];
		System.out.println("\nStart Entering the elements : ");
		for(int i=0;i<l;i++)
		{
			System.out.print("arr["+(i+1)+"] : ");
			a[i] = s.nextInt();
		}
		long start = System.nanoTime();
		mergesort(a,0,a.length-1);
		long end = System.nanoTime();
		System.out.println("\n\nAfter Sorting : ");
		for(int i=0;i<=a.length-1;i++)
		{
			System.out.println(a[i]);
		}
		long elapsed = end - start;
		System.out.println("Elapse Time : "+elapsed);

	}
}