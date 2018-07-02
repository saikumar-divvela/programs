public class DefaultExample implements it{

    public void test(){
        System.out.println("inside test method");
    }

    public static void main(String args[]){
        System.out.println("Hello World");
        DefaultExample de = new DefaultExample();
        de.printMsg();
        it.showMsg();

        // Anynonmous impelementation of interface
        Runnable r = new Runnable(){
                        public void run(){
                            System.out.println("Inside runnable");        
                        }};

        // Example of lambda expression
        Runnable r1 = ()->System.out.println("Inside runnable r1");        

        //Thread t = new Thread(r);
        //t.start();
        (new Thread(r1)).start();
    
    }

    // comment the following method to use the method in interface
    public void printMsg(){
        System.out.println("printing in default method (class)");
    }
   
}


interface it {
    void test();
    default void printMsg(){
        System.out.println("printing in default method");
    }

    static void showMsg(){
        System.out.println("show msg in static method");
    }
}

