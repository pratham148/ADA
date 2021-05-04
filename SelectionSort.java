//Selection Sort

import java.util.*;
class SelectionSort
{
	public static void select(int a[],int l)
	{
		int i,j,k,min,swap,index = 0;
		long start_time = System.nanoTime();
		for(i=0;i<l;i++)
		{
			min = a[i];
			for(j=i+1;j<l;j++)
			{
				if(a[j]<min)
				{
					min = a[j];
					index = j;
				}
			}
			if(a[i]>min)
			{
				swap = a[i];
				a[i] = min;
				a[index] = swap;
			}
		}
		long end_time = System.nanoTime();
		System.out.println("After Using Selection Sort : ");
		for(i=0;i<l;i++)
		{
			System.out.print(a[i] + " ");
		}
		long elapsed_time = end_time - start_time;
		System.out.println();
		System.out.println("Elapsed time in nanoseconds is : "+elapsed_time);

	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t Selection SORT ");
		System.out.print("\n\nEnter the maximum number of elements : ");
		int l = s.nextInt();
		int arr[] = new int[l];
		System.out.println("\nStart Entering the elements : ");
		for(int i=0;i<l;i++)
		{
			System.out.print("arr["+(i+1)+"] : ");
			arr[i] = s.nextInt();
		}
		select(arr,l);
	}
}