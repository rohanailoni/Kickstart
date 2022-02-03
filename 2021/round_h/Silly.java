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
    void checker(Node root,int A,int B){
				Node temp=root;
				int first;
				int second;
				while(temp!=null){
					
					first=temp.value;
					if(temp.next==null)second=-1;
					else{second=temp.next.value;}
					//System.out.println(list+" "+first+" "+second);
					
					
					
					if(second!=-1 &&first==A && second==B){
						
						Node temp1=temp;
						temp=temp.next.next;//System.out.print(temp.value);
						temp1.next=temp;
						if(second==9){
							temp1.value=0;
						}
						else{
							temp1.value=second+1;
						}
						if(temp!=null)temp.previous=temp1;
						temp=temp1;
						temp=temp.next;
						
					}else{
						temp=temp.next;
					}



				}
	}
	public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
			Solution sl=new Solution();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
                Doublelinkedlist list=new Doublelinkedlist();
                int n=Integer.parseInt(in.nextLine());
                String s=in.nextLine();
                for(int i=0;i<s.length();i++){
                    list.add(Character.getNumericValue(s.charAt(i)));
                }
                sl.checker(list.header.next,0,1);
				sl.checker(list.header.next,1,2);
				sl.checker(list.header.next,2,3);
				sl.checker(list.header.next,3,4);
				sl.checker(list.header.next,4,5);
				sl.checker(list.header.next,5,6);
				sl.checker(list.header.next,6,7);
				sl.checker(list.header.next,7,8);
				sl.checker(list.header.next,8,9);
				sl.checker(list.header.next,9,0);
				
				//System.out.println(list);
				Node temp=list.header.next;
				String ans="";
				while(temp!=null){
					ans+=Integer.toString(temp.value);temp=temp.next;
				}
                answer.add(ans);
                
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
class Node{
    int value;
    Node next;
    Node previous;
    Node(Node next, Node previous, int value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }
    public String toString() {
        return value + "";
    }
}
public class Doublelinkedlist{
    
    public Node header;
    Doublelinkedlist(){
        header = new Node(null, null, 0);
    }
    public Node getNode(int index){
        Node node=header;
        for (int i = 0; i <= index; ++i) {
			node = node.next;
		}

		return node;
    }
    public Node addFirst(int item) {
		Node n = new Node(header.next, header, item);
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;
		return n;
	}
    public Node add(int item) {
		Node end = getNode(size() - 1);
		Node next = new Node(null, end, item);
		end.next = next;
		return next;
	}
    public Node add(int item, int index) {
		
		Node nodeIns = null;

		if (item != 0) {
			Node node = header;

			if (node.next != null) {
				for (int i = 0; i <= index; i++) {
					node = node.next;
				}
			}
			
			nodeIns = new Node(node.next, node, item);
			
			if (node.next != null) {
				node.next.previous = nodeIns;
			}
			node.next = nodeIns;
		}
		return nodeIns;
	}
    public Node deleteFirst() {
		Node temp = getNode(0);
		if (temp != null && temp.next != null) {
			temp.next.previous = header;
			header.next = temp.next;
		} else {
			header.next = null;
		}
		
		return temp;
	}
    public Node deleteLast() {
		Node temp = getNode(size() - 1);
		Node newLast = getNode(size() - 2);
		newLast.next = null;
		return temp;
	}
    public boolean delete(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
		}
		Node toBeRemoved = getNode(index);
		if (toBeRemoved == null)
			return false;
		Node previous = toBeRemoved.previous;
		Node next = toBeRemoved.next;

		previous.next = next;
		if (next != null) {
			next.previous = toBeRemoved.previous;
		}
		toBeRemoved = null;
		return true;
	}
    public int size() {
		int count = 0;
		Node node = header.next;
		while (node != null) {
			++count;
			node = node.next;
		}
		return count;
	}
	public boolean isEmpty() {  
		boolean isEmpty = (size() > 0) ? false : true;
		return isEmpty;
	}
    public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node next = header.next;
		while (next != null) {
			sb.append(next.value + ", ");
			next = next.next;
		}
		String ret = sb.toString();
		if (ret.length() > 1) {
			ret = ret.substring(0, ret.length() - 2);
		}
		return (ret + "]");
	}



}