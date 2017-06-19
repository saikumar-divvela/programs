import java.util.HashSet;

public class TestProgram {

    public static void testString(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(" s1 == s2 is:"+s1==s2);
    }

    public static void testIntChar(){
        String s1 = "JournalDev";
        int start =1;
        char end  =5;

        System.out.println(start + end);
        System.out.println(s1.substring(start,end));
    }

    
    public static void testShort(){
        HashSet shortSet = new HashSet();
        for (short i=0; i < 100; i++){
            shortSet.add(i);
            shortSet.remove(i-1);
        }   
        System.out.println(shortSet.size());
    }

    public static void testStrNull(){
        String str = null;
        String str1 = "abc";
        System.out.println(str1.equals("abc") || str.equals(null));        
    }

    public static void main (String args[]){
        System.out.println("Hello World");
        testString();
        testIntChar();
        testShort();
        testStrNull();
    }
}
