package graphs_in_Java;

import java.util.*;


public class Graph {

	public static void printDFSHelper(int edges[][], int sv,boolean visited[]) {
		System.out.println(sv);
		visited[sv]=true;
		int n = edges.length;
		for(int i=0;i<n;i++) {
			if(edges[sv][i] == 1 && visited[i]==false) {
				printDFSHelper(edges,i,visited);
			}
		}
	}
	
	public static void printDFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				printDFSHelper(edges,i,visited);
			}
		}
		
	}
	
	public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
		Queue<Integer> queue = new LinkedList<>();
		int n=edges.length;
		queue.add(sv);
		visited[sv]=true;
		
		while(!queue.isEmpty()) {
			int front =queue.poll();
			System.out.print(front + " ");
			for(int i=0;i<n;i++) {
				if(edges[front][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public static void printBFS(int [][]edges) {
		boolean[] visited = new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				printBFSHelper(edges,i,visited);
			}
		}
		
	}
	// shortest path can only be found using bfs approach
	public static boolean hasPath(int edges[][], int sv,int ev) {
        int n=edges.length;
        
        if(ev>=n || ev<0){
            return false;
        }
        if(edges[sv][ev]==1){
            return true;
        }
        
        boolean visited[] = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(sv);
		visited[sv]=true;
		
		while(!queue.isEmpty()) {
			int front =queue.poll();
			for(int i=0;i<n;i++) {
				if(edges[front][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
        if(visited[ev]==true){
            return true;
        }
        return false;
	}
	
	//get path dfs
	public static ArrayList<Integer> getPath( int[][] edges ,int start ,int end, boolean[] visited){
		if(start == end) {
			ArrayList<Integer> ansArrayList = new ArrayList<>();
			ansArrayList.add(start);
			return ansArrayList;
		}
		visited[start] = true;
		for(int i=0;i<edges.length;i++) {

			if(edges[start][i]==1 && !visited[i]) {

				ArrayList<Integer> ans = getPath(edges, i, end, visited);
				if(ans!=null) {
					ans.add(start);
					return ans;
				}

			}

		}
		return null;
	}
	
	// get path bfs
	public static ArrayList<Integer> getPathBFS(int[][] edges,int start,int end,boolean[] visited){

		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		queue.add(start);
		visited[start] = true;
		while( !queue.isEmpty() && queue.peek()!=end) {

			int front = queue.poll();
			for(int i=0;i<edges.length;i++) {
				if(!visited[i] && edges[front][i] == 1) {
					queue.add(i);
					visited[i] = true;
					map.put(i, front);
				}
			}

		}
		ArrayList<Integer> ans = new ArrayList<>();
		if(!map.containsKey(end)) {
			return null;
		}
		else {
			ans.add(end);
			int f = map.get(end);
			while(f!=start) {
				ans.add(f);

				f = map.get(f);

			}
			ans.add(start);

		}

		return ans;
	}
	
	public static void isConnectedHelper(int edges[][], int sv,boolean visited[]) {
		visited[sv]=true;
		int n = edges.length;
		for(int i=0;i<n;i++) {
			if(edges[sv][i] == 1 && visited[i]==false) {
				printDFSHelper(edges,i,visited);
			}
		}
	}
    
    public static boolean isConnected(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		isConnectedHelper(edges,0,visited);
        
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
        
                return false;
            }
        }
        return true;
	}
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		int e;
		Scanner s =  new Scanner(System.in);
		n=s.nextInt();
		e=s.nextInt();
		
		int edges[][] = new int[n][n];
		
		for(int i=0;i<e;i++) {
			int fv= s.nextInt(); //first vertex
			int sv = s.nextInt(); // second vertex;
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		
		printDFS(edges);
		printBFS(edges);
	}

}
