import java.util.*;
class mergeSort
{
	public static void mergesort(int a[],int lb,int ub)
	{
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
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\t\t\t\t MERGE SORT \n");
		System.out.print("Enter number of elements -->");
		int size = sc.nextInt();
		int array[] = new int[size];
		System.out.println("Enter "+size+" elements in array :");
		for (int i = 0 ; i < size ; i++)
		{
			System.out.print("Enter element -->");
			array[i] = sc.nextInt();
		}
		long start = System.nanoTime();

		mergesort(array,0,size-1);

		long end = System.nanoTime();

		System.out.println("\n\nSorted Array (Merge Sort) : "+Arrays.toString(array));

		long elaspedTime = end - start;
		System.out.println("\n\nElasped Time in ns -->"+elaspedTime);
		System.out.println("Elasped Time in ms -->"+(elaspedTime)/Math.pow(10,6));

	}
}