public class MinCoins{

     public static void solve(int v[],int sum){
         int min[] = new int[sum+1];
         
         for(int i=0;i<=sum;i++){
             min[i] = 9999999;
         }
         min[0] = 0;
         for(int i=1;i<=sum;i++){
             for(int j=0;j<v.length;j++){
                 if( v[j]<=i && min[i-v[j]]+1 <min[i]){
                    min[i] = min[i-v[j]]+1;
                }
             }
         System.out.println("SUM="+i+" ##Coins="+min[i]);    
         }
         
     }
     public static void main(String []args){
        int []a = {5,1};
        int sum=11;
        System.out.println("Hello World");
        solve(a,sum);
     }
}
