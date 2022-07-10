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
    static long[] string_to_Longarray(String[] arr){
        long[] ans=new long[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Long.parseLong(arr[i]);
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
                // write code here
				//M caterogires
				//N regions
				int[] arr=string_to_array(in.nextLine().split(" "));
				int N=arr[0];
				int M=arr[1];
				arr=string_to_array(in.nextLine().split(" "));
				Arrays.sort(arr);
				double sum=0;
				for(int i=N-1;i>=0;i--){
					// System.out.println(M+" "+sum+" "+Arrays.toString(arr));
					if(M==1){
						i++;
						if(i%2!=0){
							sum+=arr[i/2];
						}else{
							if(i/2!=0){
								// System.out.println(arr[i/2]+" "+arr[(i/2)-1]);
								sum=sum+(arr[i/2]+arr[(i/2)-1])/(double)2;
								
							}else{
								sum+=arr[i/2];
							}
							
						}
						break;
					}else{
						sum+=arr[i];
						}
					M--;
					}
				answer.add(Double.toString(sum));
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




