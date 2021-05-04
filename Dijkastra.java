import java.util.*;
class Dijkastra
{
	public static int minDistance(int distance[], boolean visited[])
	{
		int min = 999;
		int distance_value = -1;
		for(int i=0;i<distance.length;i++)
		{
			if(visited[i]==false && distance[i]<min)
			{
				min = distance[i];
				distance_value = i;
			}
		}

		return distance_value;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices : ");
		int n = sc.nextInt();

		boolean visited[] = new boolean[n];
		int distance[] = new int[n];
		Arrays.fill(distance,999);
		System.out.print("Enter the source vertix = ");
		int source = sc.nextInt();
		distance[source-1] = 0;
		int array[][] = new int[n][n];
		int i=0 , j=0;
		long start = System.nanoTime();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j)
				{
					System.out.print("v"+(i+1)+" --> v"+(j+1)+" = 0\n");
					array[i][j] = 0;
					System.out.println(array[i][j]);
				}
				else
				{	
					System.out.print("v"+(i+1)+" --> v"+(j+1)+" = ");
					array[i][j] = sc.nextInt();
					System.out.println(array[i][j]);
				}
			}
		}
		for(i=0;i<n;i++)
		{
			int u = DijkastraRitik.minDistance(distance,visited);
			System.out.print(u);
			visited[i] = true;

			for(int v=0;v<n;v++)
			{
				if(visited[i] == false && array[u][v] != 0)
				{
					if(distance[v] > distance[u]+array[u][v])
						distance[v] = distance[u] + array[u][v];
				}
			}
		}
		long end = System.nanoTime();
		System.out.println("\n\n\n"+Arrays.toString(distance));
		long elaspedTime = end - start ;
		System.out.println("\nElasped Time in ns --> "+elaspedTime);
		System.out.println("Elapsed Time in ms --> "+(elaspedTime/Math.pow(10,6)));
	}
}
