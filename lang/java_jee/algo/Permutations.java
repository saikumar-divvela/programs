public class Permutations{

     public static void solve(int v[]){
       permutil(v,0);
     }
     public static void swap(int a[],int i,int j){
         int temp =a[i];
         a[i]=a[j];
         a[j]=temp;
     }
     
     public static void permutil(int v[],int s){
         if ( s==2){
         for(int k=0;k<3;k++){
             System.out.print(v[k]+ " ");
         }
         System.out.println("");
         }
         
         
         for(int i=s;i<v.length;i++){
                swap(v,s,i);
                permutil(v,s+1);
                swap(v,s,i);
             }
 }
     
     
     public static void main(String []args){
        int []a = {1,2,3};
        solve(a); 
     }
}

