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
    int[] string_to_array(String[] arr){
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Integer.parseInt(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
				int ans=0,temp=0,sum=0;
				int n=Integer.parseInt(in.nextLine());
				String s=in.nextLine();
				boolean upper=false;
				boolean lower=false;
				boolean digit=false;
				boolean special=false;
				for(int i=0;i<n;i++){
					char c=s.charAt(i);
					if(c-'A' >=0 && c-'A'<=25)upper=true;
					if(c-'a' >=0 && c-'a'<=25)lower=true;
					if(c-'0' >=0 && c-'0'<=25)digit=true;
					if(c=='#' ||c=='@'||c=='*'||c=='&')special=true;

				}
				if(!upper)s+='A';
				if(!lower)s+='a';
				if(!digit)s+='1';
				if(!special)s+='#';
				while(s.length()<7)s+='1';
				answer.add(s);
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

