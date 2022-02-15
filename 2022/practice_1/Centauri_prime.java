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
				String s=in.nextLine();
				Character[] vow={'A','E','I','O','U','a','e','i','o','u'};
				List<Character>arr=new ArrayList<>(Arrays.asList(vow));
				int n=s.length();
				boolean ailic=false;
				if(arr.contains(s.charAt(n-1))){
					ailic=true;
				}
				if(ailic){
					answer.add(s+" is ruled by "+"Alice.");
				}else{
					if(s.charAt(n-1)=='y' || s.charAt(n-1)=='Y'){
						answer.add(s+" is ruled by "+"nobody.");
					}else{
						answer.add(s+" is ruled by "+"Bob.");
					}
				}
			}

            int i=0;
            for(String s1:answer){
                i++;
                out.println("Case #"+Integer.toString(i)+": "+s1);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}

