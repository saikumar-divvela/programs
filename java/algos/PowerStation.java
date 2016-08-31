public class PowerStation {
    static long mincost=1234567890;
    static int[] COST = {350,200,100,50};
    static int  N = 4;
    static  int[][]  A={ {0,1,1,0},{1,0,0,1,},{1,0,0,0},{0,1,0,0} };
    
    static void printArray(int[] arr,int n){
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");        
        System.out.println(""); 
    }
    public static long calc_cost(int[] st,int n){
           long cost1 = 0;
           for (int i=0;i<n;i++)
                cost1 = cost1 + COST[st[i]];
           return cost1;
    }
    public static boolean is_allconnected(int[] st,int n){
        boolean[] city_status = new boolean[N];
        for(int i=0;i<n;i++){
            city_status[st[i]] = true;
            for(int j=0;j<N;j++)
                if(A[st[i]][j] == 1)
                    city_status[j] = true;                
        }
        for(int i=0;i<N;i++)
            if (city_status[i] == false) return false;
        return true;
    }
    public static void combutil(int[] data,int start,int end,int index){
       //printArray(data,index);
       if (index > 0 && is_allconnected(data,index)){
           long cost1 = calc_cost(data,index);
           if (mincost > cost1) mincost = cost1;
           System.out.println("All Connected:"+cost1);
           printArray(data,index);
           return ;
       }
       for(int i=start;i<end;i++){
           data[index]= i;
           combutil(data,i+1,end,index+1);
       }
    }
    public static void findcomb(int n){
        int[] data = new int[n];
        combutil(data,0,n,0);
    }
    public static void main(String args[]){
        findcomb(4);
        System.out.println("Min cost:"+mincost);
    }
}
