import java.util.*;
import java.io.*;

public class Solution{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    static int[] string_to_array(String[] arr){
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Integer.parseInt(arr[i]);
        }
        return ans;
    }
	static boolean bule_dfs(String[][] arr,int i,int j){
		Queue<obj>pq=new LinkedList<>();
		pq.add(new obj(i,j));
		int n=arr.length;
		boolean[][] visited=new boolean[n][n];
		for(boolean[] r:visited)Arrays.fill(r, false);

		int[][] dir={{-1,0},{1,1},{0,1},{1,0},{1,-1},{0,-1}};
		while(!pq.isEmpty()){
			obj ob=pq.poll();
			for(int k=0;k<dir.length;k++){
				int new_i=ob.i+dir[k][0];
				int new_j=ob.j+dir[k][1];
				if(new_i>-1 && new_j>-1 && new_i<arr.length && new_j<arr.length){
					//System.out.println("IN loop"+new_i+" "+new_j+" "+i+" "+j+pq);
					if(arr[new_i][new_j].equals("B") && !visited[new_i][new_j]){
						if(new_j==arr.length-1){
							return true;

						}
						visited[new_i][new_j]=true;
						pq.add(new obj(new_i,new_j));

					}
				}	
			}
		}
		return false;
	}
    static boolean red_dfs(String[][] arr,int i,int j){
		Queue<obj>pq=new LinkedList<>();
		pq.add(new obj(i,j));
		int n=arr.length;
		boolean[][] visited=new boolean[n][n];
		for(boolean[] r:visited)Arrays.fill(r, false);

		int[][] dir={{-1,0},{1,1},{0,1},{1,0},{1,-1},{0,-1}};
		while(!pq.isEmpty()){
			obj ob=pq.poll();
			for(int k=0;k<dir.length;k++){
				int new_i=ob.i+dir[k][0];
				int new_j=ob.j+dir[k][1];
				if(new_i>-1 && new_j>-1 && new_i<arr.length && new_j<arr.length){
					System.out.println("IN loop "+new_i+" "+new_j+" "+ob.i+" "+ob.j+pq);
					if(arr[new_i][new_j].equals("R") && !visited[new_i][new_j]){
						if(new_i==arr.length-1){
							return true;

						}
						visited[new_i][new_j]=true;
						pq.add(new obj(new_i,new_j));

					}
				}	
			}
		}
		return false;
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();

            while(testCases-- > 0){
                // write code here
				int n=Integer.parseInt(in.nextLine());
				String[][] arr=new String[n][n];
				for(int i=0;i<n;i++){
					arr[i]=in.nextLine().split("");
				}
				int blue_cr=0,red_cr=0;
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(arr[i][j].equals("R")){
							red_cr++;
						}else if(arr[i][j].equals("B")){
							blue_cr++;
						}
					}
				}
				out.print(red_cr+" "+blue_cr);
				if(blue_cr==red_cr-1 || red_cr==blue_cr-1){
					
					
				
				out.print(red_cr+" "+blue_cr);
				int blue_tr=0;
				for(int i=0;i<n;i++){
					//out.println(arr[i][0]);
					if(arr[i][0].equals("B")){
						if(bule_dfs(arr, i, 0)){
							blue_tr++;
						}
						if(blue_tr>1){
							answer.add("Impossible");
							continue;
							
						}
						
						//break;
					}
				}
				if(blue_tr>1){
					continue;
				}
				int red_tr=0;
				for(int i=0;i<arr[0].length;i++){
					if(arr[0][i].equals("R")){
						out.println(red_dfs(arr, 0, i));
						if(red_dfs(arr, 0, i)){
							red_tr++;
						}
						if(red_tr>1){
							answer.add("Impossible");
							continue;
						}
					}
				}
				out.print(red_tr+" "+blue_tr);
				if(red_tr>1){
					continue;
				}
				if(blue_tr==1 && red_tr==1){
					answer.add("Impossible");
				}else if(blue_tr==1 && red_tr==0){
					answer.add("Blue wins");
				}else if(red_tr==1 && blue_tr==0){
					answer.add("Red wins");
				}else if(red_tr==0 && blue_tr==0){
					answer.add("Nobody wins");
				}


				}else{
					answer.add("Impossible");

				}
			}
            int i=0;
            for(String s:answer){
                i++;
                out.println("Case #"+Integer.toString(i)+": "+s);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
			return;
        }
    }
}
class obj{
	int i,j;
	obj(int i,int j){
		this.i=i;
		this.j=j;
	}
}
