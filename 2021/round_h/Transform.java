import java.util.*;
import java.io.*;

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
            while(testCases-- > 0){
                String S=in.nextLine();
                String F=in.nextLine();
                int ans=0;
                int min=0;
                for(int i=0;i<S.length();i++){
                    min=Integer.MAX_VALUE;
                    for(int j=0;j<F.length();j++){
                        min=Math.min(min,Math.min(Math.abs(S.charAt(i)-F.charAt(j)), 26-Math.abs(S.charAt(i)-F.charAt(j))));
                    }
                    ans+=min;

                }
                answer.add(Integer.toString(ans));

            }
            int i=0;
            for(String s:answer){
                i++;
                out.println("Case #"+Integer.toString(i)+": "+s);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}