
public class DFS {
	public static int[] arr;
	public static int top=-1;
	public void push(int a,int b){
		System.out.println();
		System.out.println("Pushed:"+b);
		if(top==a-1){
			System.out.println("Stack overflow");
		}
		else{
			top=top+1;
			arr[top]=b;
		}
	} 

	public int pop(){
		if(top==-1){
			System.out.println("Stack underflow1");
			return 0;
		}
		else{
			int u=top;
			top=top-1;
			return arr[u];
		}
	}

	public int peek(){
		if(top==-1){
			System.out.println("Stack underflow2");
			return 0;
		}
		else{
			return arr[top];
		}
	}

	public void display(){
		if(top==-1){
			System.out.println("Stack underflow");
		}
		else{
			System.out.println("Stack is:");
			for(int i=top;i>=0;i--){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vertex= {0,1,2,3,4,5};
		arr= new int[6];
		int[][] graph= {{100,1,100,100,100,1},{100,100,1,1,100,100},{100,100,100,1,100,100},{100,100,100,100,1,100},{100,100,100,100,100,1},{100,1,100,100,100,100}};
		int[] visited= new int[6];
		int count=0;
		int source= 1;
		DFS st= new DFS();
		st.push(6,source);
		int i=source;
		while(top!=-1){
			int flag=0;
			int check=0;
			for(int j=0;j<6;j++) {
				if(graph[i][j]==1) {
					for(int m=0;m<arr.length;m++) {
						if(arr[m]==j) {
							check=1;
						}
					}
					if (check!=1) {
						st.push(6, j);
						st.display();
						graph[i][j]=100;
						i=j;
						flag=1;
						break;
					}
				}
			}
			if(flag!=1) {
				visited[count]= st.pop();
				count++;
			}
		}
		System.out.println();
		System.out.println("DFS is:");
		for(int k=0;k<6;k++) {
			System.out.print(visited[k]+" ");
		}
	}

}
