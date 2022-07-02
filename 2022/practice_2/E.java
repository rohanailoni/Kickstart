import java.util.*;
import java.io.*;
//parcel problem

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
	static int lookout(int[][] m,int x,int y,List<pair>sto){
		int max=Integer.MIN_VALUE;
		int n=sto.size();
		m[x][y]=1;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(m[i][j]!=1){
					int min =Integer.MAX_VALUE;
				for(int k=0;k<n;k++){
					pair p=sto.get(k);
					min=Math.min(Math.abs(i-p.x)+Math.abs(j-p.y), min);
					}
					min=Math.min(Math.abs(i-x)+Math.abs(j-y),min);
					max=Math.max(max,min);
				}
			}
		}
		m[x][y]=0;
		//System.out.println("max"+max+" "+x+" "+y);
		return max==Integer.MIN_VALUE?0:max;
	}
	static int look(int[][] m,List<pair>sto){
		int max=Integer.MIN_VALUE;	
		int n=sto.size();
		int ix=-1;
		int iy=-1;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(m[i][j]!=1){
					int min=Integer.MAX_VALUE;
					for(int k=0;k<n;k++){
						pair p=sto.get(k);
						min=Math.min(min,Math.abs(i-p.x)+Math.abs(j-p.y));
					}	
					if(min>max){
						max=min;
						ix=i;
						iy=j;
						// System.out.println(max);
					}
				}
			}
		}
		if(ix==-1 && iy==-1){
			return 0;
		}
		m[ix][iy]=1;
		sto.add(new pair(ix,iy));
		//System.out.println(Arrays.deepToString(m));
		max=Integer.MIN_VALUE;
		
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(m[i][j]!=1){
					int min=Integer.MAX_VALUE;
					for(int k=0;k<n+1;k++){
						pair p=sto.get(k);
						min=Math.min(min,Math.abs(i-p.x)+Math.abs(j-p.y));
					}	
					max=Math.max(max,min);
				}
			}
		}
		//System.out.println(max);
		return max==Integer.MAX_VALUE?0:max;
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
                // write code here
				int[] arr=string_to_array(in.nextLine().split(" "));
				int r=arr[0];
				int c=arr[1];
				int[][] map=new int[r][c];
				for(int i=0;i<r;i++){	
					map[i]=string_to_array(in.nextLine().split(""));
				}
				// out.println(Arrays.deepToString(map));
				List<pair>store=new ArrayList<>();
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(map[i][j]==1){
							store.add(new pair(i,j));
						}
					}
				}
				int min=Integer.MAX_VALUE;
				//for(int i=0;i<r;i++){
				//	for(int j=0;j<c;j++){
				//		if(map[i][j]!=1){
				//			min=Math.min(min,lookout(map,i, j,store));
				//			//System.out.println(min);
				//		}
				//	}
				//}
				//look(map,store);
				answer.add(Integer.toString(look(map,store)));

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

class pair{
	int x,y;
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
