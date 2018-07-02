class CNSException {
    public static void main(String args[]) throws Exception{
        CloneTest ct = new CloneTest(3);
        CloneTest ct1 = ct.clone();
        System.out.println(ct);
    }
}

class CloneTest {
    private int x;
     
    public CloneTest(int x){
        this.x =x;
    }
    
    public CloneTest clone() throws java.lang.CloneNotSupportedException{
        return (CloneTest) super.clone();
    }
    
}
