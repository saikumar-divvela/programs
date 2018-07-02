import java.util.*;

class CMException {
    public static void main(String args[]){
        Collection<Integer> c = new ArrayList<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        Iterator<Integer> iter = c.iterator();
        Object[] iArray1 = c.toArray();    
        Integer[] iArray = c.toArray(new Integer[]{});    
        for(Object x:iArray1){
             System.out.println(x);
        }
        while(iter.hasNext()){
            Integer x = iter.next();
            System.out.println(x);
            if (x == 2){
                iter.remove(); // fine             
            }
            if (x == 3){
                c.add(4); // not fine fail fast
            }
        }
    }
}
