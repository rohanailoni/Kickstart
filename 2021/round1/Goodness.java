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
    public int checkgoodeness(String s,int k){
        int min=0;
        int x=0;
        
        int N=s.length();
        //System.out.println(N/2);
        for(int i=0;i<(N/2);i++){
            
            if(s.charAt(i)!= s.charAt(N-i-1)){
                x++;
            }
        }
        //System.out.println(x);
        if(x==k){
            min=0;
        }else if(x>k){
            min=x-k;
        }else{
            min=k-x;
        }

        return min;
    }
    public static void main(String[] args) {
        try {
            int i=1;
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            Solution gd=new Solution();
            List<String> answer=new ArrayList<>();
            while(testCases-- > 0){
                String[] In=in.nextLine().split(" ");
                int K=Integer.parseInt(In[1]);
                String word=in.nextLine();
                int ans=gd.checkgoodeness(word, K);
                String to="Case #"+Integer.toString(i)+": "+Integer.toString(ans);
                answer.add(to);i++;

            }
            for(String s:answer){
                out.println(s);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}