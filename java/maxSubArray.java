import java.util.*;

public class maxSubArray{
    public static int findMaxSubArray(int x[][]){
	int m= x.length,n= x[0].length;
	int maxLength=0;
	Map<Integer,List<Pos>> numMap= new HashMap<Integer,List<Pos>>();
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
	        Pos p= new Pos(i,j);	
		List<Pos> list = numMap.get(x[i][j]);
		if( list == null){
		    numMap.put(x[i][j],new ArrayList<Pos>(Arrays.asList(p)));	
		} else {
		    for( Pos temp:list){
		        if(p.column >= temp.column){	
		           int subArrayLength=(p.row-temp.row+1)*(p.column-temp.column+1); 				   if( subArrayLength > maxLength )
			        maxLength = subArrayLength;
			}   
		    }
		    list.add(p);  	
		}	
	    }
	}
	return maxLength;	
    }	
    public static void main(String args[]){

	int input[][]={
 	     {15,20,4,40,23},
             {20,20,86,92,14},
             {40,15,10,4,4}
             };
		
	//int input [][] = { {5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5} };
	//int input [][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};	
  	System.out.println("Maximum length of sub array:"+findMaxSubArray(input));	
   }
}
class Pos{
	public int row,column;
	public Pos(int row,int column){
		this.row = row;
                this.column = column;   	
	}
	public String toString(){
	   return "row="+row+":column="+column;		
	}
}
