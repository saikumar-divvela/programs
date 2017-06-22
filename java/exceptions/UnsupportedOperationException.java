import java.util.*;

class UOException {

    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Collection<Integer> list1 =  Collections.unmodifiableCollection(list);
        for(Integer i:list1){
            System.out.println(i);
            list1.add(3);
        }        
    }

}
