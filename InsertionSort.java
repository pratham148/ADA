//Insertion Sort

import java.util.*;
class InsertionSort
{
	public static void insertsort(int a[],int l)
	{
		int i,j,swap=0;
		long start_time = System.nanoTime();
		for(i=1;i<l;i++)
		{
			for(j=i;j>0;j--)
			{
				if(a[j]<a[j-1])
				{
					swap = a[j];
					a[j] = a[j-1];
					a[j-1] = swap;
				}
			}
		}
		long end_time = System.nanoTime();
		System.out.println("After Using Insertion Sort : ");
		for(i=0;i<l;i++)
		{
			System.out.println(a[i]);
		}
		long elapsed_time = end_time - start_time;
		System.out.println();
		System.out.println("Elapsed time in nanoseconds is : "+elapsed_time);
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t Insertion SORT ");
		System.out.print("\n\nEnter the maximum number of elements : ");
		int l = s.nextInt();
		int arr[] = new int[l];
		System.out.println("\nStart Entering the elements : ");
		for(int i=0;i<l;i++)
		{
			System.out.print("arr["+(i+1)+"] : ");
			arr[i] = s.nextInt();
		}
		insertsort(arr,l);
	}
}