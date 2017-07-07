public class TryNoCatch {
    public static int test () throws Exception{
        try {
            System.out.println("In try  block"); 
            //if (1 < 2){
            throw new Exception("error "); // this exception is bipassed as there is no catch block             
            //}
            //return 0;
            //System.exit(0);
        }
        finally {
            System.out.println("In finally block");            
            return 1;
        }
   
    }

    public static void main(String args[]) throws Exception {
        System.out.println("In main");
        System.out.println(test());
    }
}
