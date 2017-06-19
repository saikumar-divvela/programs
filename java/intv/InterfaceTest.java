interface InterfaceTest {
    public int a = 10;
    public void test1();

}


class testInterface implements InterfaceTest{

    public static void main(String[] args){

        System.out.println("test interface "+InterfaceTest.a);
        //InterfaceTest.a = 12;
    }

    public void test1(){
        System.out.println("test1 function");
    }

}
