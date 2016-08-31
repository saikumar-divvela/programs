public class MaxSubArray{

     public static void solve(int a[]){
         int solution =a[0];
         int max = a[0];
         
         for(int i=0;i<a.length;i++){
             if( (solution + a[i]) > a[i]){
                 solution = solution +a[i];
             } else {
                 solution = a[i];
             }
             if (max < solution){
                 max = solution;
             }
         }
         System.out.println(max);
     }
     public static void main(String []args){
        int []A = {-2,1, -3, 4, -1, 2, 1, -5, 10};
        System.out.println("Hello World");
        solve(A);
     }
}
