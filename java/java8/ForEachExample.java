import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
//import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class ForEachExample {
    public static void main(String args[]){
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            myList.add(i);
        }

        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()){
            System.out.println("Iterator value:"+it.next());
        }
        
        // using anonymous class
        myList.forEach(new Consumer<Integer>(){
           public void accept(Integer t){
                System.out.println("Anonymous class value:"+t);     
           }
        });
    
        // seperating the business logic
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

        example();
    }

public static void example(){
    Map<String,Integer> map1 = new HashMap<String,Integer>();

    map1.put("chirala",523155);
    map1.put("bangalore",560087);
    map1.forEach((k,v) -> System.out.println("Key:"+k +" Value:"+v));

    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.forEach( (item) -> {
        System.out.println(item);
        if (item ==2){
            System.out.println("match found");        
        }
    });   
}

}


/*
   2015
*/

class MyConsumer implements Consumer<Integer>{
    public void accept(Integer t){
        System.out.println("Consumer impl value:"+t);
    }
}
