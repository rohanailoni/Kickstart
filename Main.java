import java.util.*;


public class Main
{
	public static void main(String[] args) {
	    Subjec m1=new Subjec();
		Subjec[] mob=new Subjec[4];
		mob[0]=new Subjec();
		mob[0].set_courseDetails("Java","CSE1007","PE","Cse");
		mob[1]=new Subjec();
		mob[1].set_courseDetails("Python","CSE10001","UE","Cse");
		mob[2]=new Subjec();
		mob[2].set_courseDetails("Adavnce Python","CSE1002","UE","Cse");
        mob[3]=new Subjec();
		mob[3].set_courseDetails("Cloud Computing","CBS3021","PE","Cse");
		
		m1.sort_courseDetails(mob);
        m1.search(mob);
		m1.display(mob);
		
		
	}
}
class Subjec{
    private String Course_Name;
    private String Course_ID;
    private String Course_Type;
    private String Offered_By;
	private int type;
	private Object searchString;
	private int Subjec;
    void set_courseDetails(String name,String id,String type,String by){
        this.Course_Name=name;
        this.Course_ID=id;
        this.Course_Type=type;
        this.Offered_By=by;
    }
    void display(Subjec[] m){
        for(int i=0;i<4;i++){
           System.out.println(m[i].Course_Name);
           System.out.println(m[i].Course_ID);
           System.out.println(m[i].Course_Type);
           System.out.println(m[i].Offered_By);
           System.out.println();
        }
    }
    void search(Subjec[] m){
        int ue=0;
        int pe=0;
        for(int i=0;i<4;i++){
            if(m[i].Course_Type=="PE"){
                pe++;
            }else{
                ue++;
            }
        }
        System.out.println("The number of PE courses are:-"+pe);
        System.out.println("The number of UE courses are:-"+ue);

    }
    void sort_courseDetails(Subjec[] mob){
    	
       
    	 Scanner  in = new Scanner(System.in);
   	  System.out.println("Enter the Subject  name:");
   	  int n  = Subjec,flag =0;
   	      
         String names[] = new String[n];
         for(int i =0 ; i <n ;i++)
        	 names[i] = in.nextLine();
            for(String name: names)
                if(name.contains((CharSequence) searchString)){
                flag = 1; break;
                }
       		  if(flag == 1) 
       			  System.out.println("Name Found");
       		  
       		  else 
       			  System.out.println("Name not Found");
           
       }
    }
