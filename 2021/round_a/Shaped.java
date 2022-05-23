import java.util.*;
import java.io.*;
class Soluiton{
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
            int co=0;
            int up;
            int down;
            int left;
            int right;
            while(testCases-- > 0){

                String[] arg=in.nextLine().split(" ");
                int m=Integer.parseInt(arg[0]);
                int n=Integer.parseInt(arg[1]);
                int matrix[][] =new int[m][n];
                for(int i=0;i<m;i++){
                    String[] arg1=in.nextLine().split(" ");
                    for(int j=0;j<n;j++){   
                        matrix[i][j]=Integer.parseInt(arg1[j]);

                    }

                }
                int ans=0;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(matrix[i][j]==1){
                            up=0;
                            down=0;
                            left=0;
                            right=0;
                            //top+left
                            for(int k=i;k>=0;k--){
                                if(matrix[k][j]==1){
                                    up++;
                                }else{
                                    break;
                                }
                            }
                            for(int k=j;k<n;k++){
                                if(matrix[i][k]==1){
                                    left++;
                                }else{
                                    break;
                                }
                            }
                            if(Math.min(Math.min(up,left),Math.max(up, left)/2)>0){
                                if(up==left){
                                    ans+=Math.min(Math.min(up,left),Math.max(up, left)/2);
                                }else{
                                    ans+=Math.min(Math.min(up,left),Math.max(up, left)/2)-1;
                                }
                                
                            }
                            
                            //down+left
                            for(int k=i;k<m;k++){
                                if(matrix[k][j]==1){
                                    down++;
                                }else{
                                    break;
                                }
                            }
                            
                            if(Math.min(Math.min(down,left),Math.max(down, left)/2)>0){
                                if(down==left){
                                    ans+=Math.min(Math.min(down,left),Math.max(down, left)/2);
                                }else{
                                    ans+=Math.min(Math.min(down,left),Math.max(down, left)/2)-1;
                                }
                                
                            }
                            //top+right
                            
                            for(int k=j;k>=0;k--){
                                if(matrix[i][k]==1){
                                    right++;
                                }else{
                                    break;
                                }
                            }
                            
                            if(Math.min(Math.min(up,right),Math.max(up, right)/2)>0){
                                if(up==right){
                                    ans+=Math.min(Math.min(up,right),Math.max(up, right)/2);
                                }else{
                                    ans+=Math.min(Math.min(up,right),Math.max(up, right)/2)-1;
                                }
                                
                            }
                            //down+right
                            
                            
                            if(Math.min(Math.min(right,down),Math.max(right, down)/2)>0){
                                if(right==down){
                                    ans+=Math.min(Math.min(right,down),Math.max(right, down)/2);
                                }else{
                                    ans+=Math.min(Math.min(right,down),Math.max(right, down)/2)-1;
                                }
                                
                            }

                            //System.out.println(up+" "+down+" "+i+" "+j+" "+ans);
                        }
                        
                    }
                }
                co++;
                answer.add("Case #"+Integer.toString(co)+": "+Integer.toString(ans));
                
                
                
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