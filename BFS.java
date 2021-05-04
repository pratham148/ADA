
public class BFS {
	public static int[] arr;
	public int front=-1;
	public int rear=-1;
	public void enqueue(int mx,int b){
		if(rear==mx-1){
			System.out.println("Queue is full");
		}
		else{
			if(front==-1)
				front=0;
			rear= rear+1;
			arr[rear]=b;
		}
	} 

	public int dequeue(){
		if(rear==-1){
			return -1;
		}
		else{
			if(rear==0){
				int temp=0;
				System.out.println("Dequeue element: "+arr[rear]);
				temp=rear;
				rear=-1;
				front=-1;
				return arr[temp];
			}
			else{
				int temp=0;
				System.out.println("Dequeue element: "+arr[front]);
				temp=front;
				front=front+1;
				return arr[temp];
			}
		}
	}

	public void display(){
		if(front==-1){
			System.out.println("Queue is empty");
		}
		else{
			System.out.println("Queue is:");
			for(int i=front;i<=rear;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vertex= {0,1,2,3,4,5};
		arr= new int[6];
		BFS q= new BFS();
		int[][] graph= {{100,1,100,100,100,1},{100,100,1,1,100,100},{100,100,100,1,100,100},{100,100,100,100,1,100},{100,100,100,100,100,1},{100,1,100,100,100,100}};
		String[] color= new String[6];
		int[] d= new int[6]; 
		int[] visited= new int[6];
		int u=0;
		for(int i=0;i<vertex.length;i++) {
			color[i]="white";
			d[i]=100;
		}
		int s=0;
		int count=0;
		color[s]="gray";
		d[s]=0;
		q.enqueue(6, s);
		while(count<6) {
			q.display();
			u= q.dequeue();
			for(int j=0;j<vertex.length;j++) {
				if(graph[u][j]==1) {
					if(color[j]=="white") {
						color[j]="gray";
						d[j]=d[u]+1;
						q.enqueue(6, j);
					}
				}
			}
			visited[count]=u;
			count++;
			color[u]="black";
		}
		System.out.println("BFS:");
		for(int m=0;m<vertex.length;m++) {
			System.out.print(visited[m]+" ");
		}
	}

}
