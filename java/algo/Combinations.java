public class Combinations{

     public static void solve(int v[]){
        int data[] =new int[v.length];
        combutil(v,data,0,v.length,0);
         
     }
     
     public static void combutil(int v[],int data[],int start,int end,int index){
         
         if(index >0){
             for(int i=0;i<index;i++){
                 System.out.print(data[i]+" ");
             }
             System.out.println("");
         }
         
         for(int i=start;i<end;i++){
             data[index] = v[i];
             combutil(v,data,i+1,end,index+1);
         }
     }
     
     public static void main(String []args){
        int []a = {1,2,3};
        solve(a); 
     }
}
