import java.util.*;
import java.io.*;

public class template{
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
            while(testCases--> 0){
               
                
                int n=Integer.parseInt(in.nextLine());
                String P=in.nextLine();
                int i;
                int ans=0;
                char[] p=P.toCharArray();
                //System.out.println(p+" "+testCases+" "+n);
                for(i=0; i<n;)
                {
                    if(p[i]=='R' || p[i]=='O' || p[i]=='P' || p[i]=='A'){
                        while(i<n && (p[i]=='R' || p[i]=='O' || p[i]=='P' || p[i]=='A')){
                            i++;
                        }
                        ans++;
                    }else{
                        i++;
                    }
                }
                
                for(i=0; i<n;)
                {
                    if(p[i]=='Y' || p[i]=='O' || p[i]=='G' || p[i]=='A'){
                        while(i<n && (p[i]=='Y' || p[i]=='O' || p[i]=='G' || p[i]=='A') && i<n){
                            i++;
                        }
                        ans++;
                    }else{
                        i++;
                    }
                }
                
                for(i=0; i<n;)
                {
                    if(p[i]=='B' || p[i]=='P' || p[i]=='G' || p[i]=='A'){
                        while(i<n && (p[i]=='B' || p[i]=='P' || p[i]=='G' || p[i]=='A') && i<n){
                            i++;
                        }
                        ans++;
                    }else{
                        i++;
                    }
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
            System.out.print(e);
        }
    }
}
// class Req{
//     Character orf;
//     HashSet<Character>req;
//     req(){
//         req=new HashSet<>();
//     }
// }