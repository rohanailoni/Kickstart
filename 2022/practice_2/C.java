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
	static long[] sub(long A[],long B[],int n){
		long[] ans =new long[n];
		for(int i=0;i<n;i++){
			ans[i]=Math.abs(A[i]-B[i]);
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
				int[] data=string_to_array(in.nextLine().split(" "));
				String block=in.nextLine();
				int Q=data[1];
				int count=0;
				long[][] cache=new long[data[0]][26];
				long[] temp=new long[26];
				for(int j=0;j<data[0];j++){
					temp[block.charAt(j)-'A']++;
					cache[j]=temp.clone();
				}
				// System.out.println(Arrays.deepToString(cache));

				for(int i=0;i<Q;i++){
					int[] quer=string_to_array(in.nextLine().split(" "));
					int len=(quer[1]-quer[0])+1;
					// int[] cache=new int[26];
					// for(int j=(int)quer[0]-1;j<=quer[1]-1;j++){
					// 		cache[block.charAt(j)-'A']++;
					// }
					int low=quer[0]-2;
					int upper=quer[1]-1;
					if(low==-1){temp=cache[upper];}
					else{temp=sub(cache[low], cache[upper], 26);}
					// System.out.println(Arrays.toString(temp));

					

					if(len%2==0){
						boolean sep=false;
						for(int j=0;j<26;j++){
							if(temp[j]!=0 && temp[j]%2!=0){
								sep=true;
								break;
                            }
						}

						if(!sep){count++;}

					}else{
						boolean single=false;
						boolean sep=false;
						for(int j=0;j<26;j++){
							if(temp[j]!=0 && temp[j]%2!=0 && single==false){
								single=true;	
							}	
							else if(temp[j]!=0 && temp[j]%2!=0 && single==true){
								sep=true;
								single=false;
								break;
							}
						}
						//System.out.println(sep+" "+single+" ");
						if(!sep && single){count++;}

					}

				}
				answer.add(Integer.toString(count));
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


