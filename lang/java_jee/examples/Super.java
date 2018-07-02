// super can be used to access base class variable, method and constructor

public class Super {

    public Super(){
        super(); // calls super class i.e. Object constructor
        System.out.println("Constructor");
    }

    public static void main(String args[]){
        System.out.println(new Super());
        System.out.println(new Super());
    }
}
