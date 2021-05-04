import java.util.*;
import java.util.Arrays;
public class QuickSort
{
    static void quickSort(int a[],int lb, int ub)
    {
       int i,j,t,x=0;
       i=lb;
       j=ub;
       while(i<j) 
       {
           while (a[i] < a[j] && x == 1) 
           {
               i++;
           }
           while (a[j] > a[i] && x == 0) 
           {
               j--;
           }
           if (i < j) 
           {
               t = a[i];
               a[i] = a[j];
               a[j] = t;
           }
           if (x == 0) 
           {
               x = 1;
           } 
           else 
           {
               x = 0;
           }
       }
       if(lb<i)
       {
           quickSort(a,lb,i-1);
       }
       if(ub>i)
       {
           quickSort(a,i+1,ub);
       }
    }
    static void display(int a[],int lb,int ub)
    {
        for(int i=lb;i<=ub;i++)
        {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of elements you wish to enter");
        int n = s.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter arr["+(i+1)+"] : ");
            arr[i]= s.nextInt();
        }
        int lb = 0;
        int ub = n-1;
	long start = System.nanoTime();
        quickSort(arr,lb,ub);
	long end = System.nanoTime();
	long elapsed = end-start;
        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr)); 
	System.out.println("Elapsed Time : "+elapsed);
    }
}