public class SimpleThread1  extends Thread{

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i);        
        }
    }

    public static void main(String args[]){
        Thread th = new Thread(new SimpleThread1());
        th.start();
    }
}
