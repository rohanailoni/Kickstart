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
    int solve(int[] prefix,int[] cons){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cons[0];i++){
            for(int j=i;j<cons[0];j++){
                for(int x=j+1;x<cons[0];x++){
                    for(int y=x;y<cons[0];y++){
                        
                        if(i==0){
                            if(prefix[j]+(prefix[y]-prefix[x-1])==cons[1]){
                                // System.out.println(prefix[y]-prefix[x-1]);;
                                // System.out.println(x+" "+y+" "+i+" "+j+" "+cons[1]);
                                //System.out.println((j-i)+(y-x));
                                min=Math.min(min,(j-i)+(y-x)+2);
                                //return (j-i)+(y-x);
                            }
                        }
                        else if((prefix[j]-prefix[i-1])+(prefix[y]-prefix[x-1])==cons[1]){
                            //System.out.println(x+" "+y+" "+i+" "+j);
                            //System.out.println((j-i)+(y-x));
                            min=Math.min(min,(j-i)+(y-x)+2);
                            //return (j-i)+(y-x);
                        }
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            Solution sol=new Solution();
            while(testCases-- > 0){
                int[] cons=sol.string_to_array(in.nextLine().split(" "));
                
                int[] arr=sol.string_to_array(in.nextLine().split(" "));
                
                int[] prefix=new int[cons[0]];
                prefix[0]=arr[0];
                for(int i=1;i<cons[0];i++){
                    prefix[i]=arr[i]+prefix[i-1]; 
                    //System.out.print(prefix[i]+" ");
                }
               //System.out.println(cons);
                answer.add(Integer.toString(sol.solve(prefix, cons)));

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