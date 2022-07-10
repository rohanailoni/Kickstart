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
				int n=Integer.parseInt(in.nextLine());
				int[] image=string_to_array(in.nextLine().split(" "));
				int m=Integer.parseInt(in.nextLine());
				int[] audio=string_to_array(in.nextLine().split(" "));
				int krk=Integer.parseInt(in.nextLine());
				int[] image_pre=new int[n+1];
				int[] audio_pre=new int[m+1];
				image_pre[n-1]=image[n-1];
				for(int i=n-2;i>=0;i--){
					image_pre[i]=image[i]+image_pre[i+1];
				}
				audio_pre[m-1]=audio[m-1];
				for(int j=m-2;j>=0;j--){
					audio_pre[j]=audio[j]+audio_pre[j+1];
				}
				// System.out.println(Arrays.toString(image_pre)+" "+Arrays.toString(audio_pre));
				int[] image_suf=new int[n+1];
				int[] audio_suf=new int[m+1];
				image_suf[0]=image[0];
				audio_suf[0]=audio[0];
				for(int i=1;i<n;i++){
					image_suf[i]=image[i]+image_suf[i-1];
				}
				for(int i=1;i<m;i++){
					audio_suf[i]=audio[i]+audio_suf[i-1];
				}
				//suf means from start;
				//pre means from end;

				// System.out.println(Arrays.toString(image_suf)+" "+Arrays.toString(audio_suf));
				int max=Integer.MIN_VALUE;
				for(int i=0;i<n;i++){
					for(int j=n;j>i && j>=0;j--){
						for(int k=0;k<m;k++){
							for(int l=m;l>k && l>=0;l--){
								if(i+1+k+1+(n-j)+(m-l)==krk){
									int summ=image_suf[i]+image_pre[j]+audio_suf[k]+audio_pre[l];
									// System.out.println(i+" "+j+" "+k+" "+l+" "+summ);

									if(summ>max){
										max=summ;
									}
								}
							}
						}
					}
				}
				answer.add(Integer.toString(max));


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




