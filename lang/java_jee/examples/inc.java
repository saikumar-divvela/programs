 
public class inc {
    public static void main(String... args) {
        flipFlop("hello", 4,  2004);
    }

    private static void flipFlop(String str, int i, Integer iRef) {
        System.out.println(str + " (String, int, Integer)");
    }

    private static void flipFlop(String str, int i, int j) {
        System.out.println(str + " (String, int, int)");
    }

    

}

