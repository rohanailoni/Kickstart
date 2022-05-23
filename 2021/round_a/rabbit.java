import java.util.*;
import java.io.*;
import java.lang.*;

class Solution{
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
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            int[][] directions={{0,-1},{-1,0},{0,1},{1,0}};
            int co=1;
            while(testCases-- > 0){
                int ans=0;
                PriorityQueue<Block>pq=new PriorityQueue<>(new compareblocks());
                String[] arg=in.nextLine().split(" ");
                int m=Integer.parseInt(arg[0]);
                int n=Integer.parseInt(arg[1]);
                int matrix[][] =new int[m][n];
                int max=Integer.MIN_VALUE;
                for(int i=0;i<m;i++){
                    String[] arg1=in.nextLine().split(" ");
                    for(int j=0;j<n;j++){   
                        matrix[i][j]=Integer.parseInt(arg1[j]);
                        max=Math.max(matrix[i][j],max);
                    }

                }
                int[][] visited=new int[m][n];
                for(int i=0;i<m;i++){
                    
                    for(int j=0;j<n;j++){
                        if(matrix[i][j]==max){
                            
                            pq.add(new Block(max, i, j));
                            visited[i][j]=1;
                            break;
                        }
                        
                    }

                }
                int ni;
                int nj;
                
                
                while(!pq.isEmpty()){
                    Block B=pq.poll();
                    
                    for(int[] j:directions){
                        ni=B.i+j[0];
                        nj=B.j+j[1];
                        
                        if(B.i+j[0]<m && B.j+j[1]<n && B.i+j[0]>=0 && B.j+j[1]>=0 && visited[ni][nj]!=1){
                            
                            visited[ni][nj]=1;
                            //System.out.println(ni+" "+nj+" "+B.i+" "+B.j+" "+j[0]+" "+j[1]);
                            
                            if(Math.abs(matrix[ni][nj]-B.n)==1){
                                //System.out.print(matrix[ni][nj]+" "+ni+" "+nj);
                                pq.add(new Block(matrix[ni][nj], ni, nj));
                            }else{
                                int newa=Math.abs(matrix[ni][nj]-B.n)-1;
                                //out.println(newa+" "+ni+" "+nj);
                                ans+=newa;
                                pq.add(new Block(matrix[ni][nj]+newa, ni, nj));
                            }
                            
                            
                        }
                    }
                }
                answer.add("Case #"+Integer.toString(co)+": "+Integer.toString(ans));
                co++;
                
                
                
            }
            for(String s:answer){
                out.println(s);
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Exception");
            return;
        }
    }
}
class Block{
    int n;
    int i;
    int j;
    Block(int n,int i,int j){
        this.n=n;
        this.i=i;
        this.j=j;
    }
}
class compareblocks implements Comparator<Block>{
    @Override
    public int compare(Block b1,Block b2){
        return b2.n-b1.n;
    }
}