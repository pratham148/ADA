import java.util.*;
class PrimsAlgo
{
	public static void prim(int adj[][],boolean selected[],int v)
	{
		int no_of_edges = 0;
		int min = 0;
		int sum = 0;
		while(no_of_edges<v-1)
		{
			min = 9999; 
			int x = 0; // Row
			int y = 0; // Column
			for(int i=0;i<v;i++)
			{
				if(selected[i] == true)
				{
					for(int j=0;j<v;j++)
					{
						if(selected[j] == false && adj[i][j]!=0)
						{
							if(min > adj[i][j])
							{	
								min = adj[i][j];
								sum = sum + min;
								x = i;
								y = j;
							}
						}
					}
				}
			}
			System.out.println(x + "-->" + y + "  : "+adj[x][y]);
			selected[y] = true;
			no_of_edges++;
		}
		System.out.println("Total weight : "+sum);
	} 
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t PRIM's ALGORITHM ");
		System.out.println("Enter the number of vertices");
		int v = s.nextInt();
		boolean selected[] = new boolean[v];
		selected[0] = true;
		/*System.out.println("\n\nPlease enter the order of your adjacency matrix : ")
		System.out.println("No of rows : ");
		int r = s.nextInt();
		System.out.println("No of columns : ");
		int col = s.nextInt();
		int adj = new int[r][col];*/
		int adj[][] = new int[v][v];
		System.out.println("Please Enter the values into the adjacency matrix");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print("Enter i["+i+"]["+j+"] : ");
				adj[i][j] = s.nextInt();
			}
		}
		long start = System.nanoTime();
		prim(adj,selected,v);
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.println("Total time taken : "+elapsed);


	}
}