import java.util.*;

class CCException {

    public static void main(String args[]){
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        for (Object obj: list) {
            Integer i = (Integer) obj;
            System.out.println(obj);
        }
    }

}
