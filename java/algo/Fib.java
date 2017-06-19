public class Fib {

    static void doperm(int []a){
        //for(int i=0;
    }

    static int fact (int n){
        if (n== 1) return 1; 
        return n * fact(n-1);
    }
    
    static void fib1(int n) {
        int n1,n2,n3;
        n1 = 0;
        n2 = 1;
        if (n == 0){
            System.out.print(n1);
        }
        if(n >0  ){
            System.out.print(n1+ " "+n2);
        }    
        for(int i=2;i<=n;i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
        }
        System.out.println("");
    }
    
    static int x1=0,x2=1,x3=0;
    static void fib3(int n){
        if( n > 0){
            x3 = x1+ x2;
            x1 = x2;
            x2 = x3;
            System.out.print(" "+x3);
            fib3(n-1);
        }
    }

    static int fib2(int n) {
        if (n == 0 || n ==1) {
            return n;
        } 
        return fib2(n-1) + fib2(n-2);
  
    }

    public static void main(String args[]){
        int []a = {1,2,3,4};
        doperm(a);
        //System.out.println(fact(3));
        fib1(0);
        fib1(1);
        fib1(2);
        fib1(6);

        fib3(2);

        /*
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));    
        System.out.println(fib2(6));
        */
      
    }

}
