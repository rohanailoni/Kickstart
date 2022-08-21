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
			int ca=0;
            while(testCases-- > 0){
                // write code here
				int n=in.nextInt();
				int[] rating=string_to_array(in.nextLine().split(" "));
				int[] copy_rating=rating.clone();
				Arrays.sort(copy_rating);
				HashMap<Integer,Integer>mapping=new HashMap<>();
				for(int i=0;i<n;i++){
					boolean is=false;
					int doub=copy_rating[i]*2;
					if(mapping.containsKey(copy_rating[i])){
						continue;
					}else{
						for(int j=n-1;j>i;j--){
							if(doub>=copy_rating[j]){
								is=true;
								mapping.put(copy_rating[i],copy_rating[j]);
								break;
							}
						}
						if(!is){
							if(i!=0){
								mapping.put(copy_rating[i],copy_rating[i-1]);
							}else{
								mapping.put(copy_rating[i],-1);
							}	
						}
					}
				}
				ca++;
				List<Integer>ans=new ArrayList<>();
				String ss="";
				for(int i=0;i<n-1;i++){

					ss+=Integer.toString(mapping.get(rating[i]))+" ";
				}
				ss+=Integer.toString(mapping.get(rating[n-1]))+" ";

				System.out.println("Case #"+Integer.toString(ca)+": "+ss);
            }
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;

        }
    }
}




