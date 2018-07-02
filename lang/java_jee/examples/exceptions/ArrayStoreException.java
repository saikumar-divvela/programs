class ASException {
    
    public static void main(String args[]){
        Object[] a = new Integer[10];
        System.out.println(a.length);
        System.out.println(a[0] instanceof Integer);
        a[0] =  1;
        System.out.println(a[0] instanceof Integer);
        a[1] = 2;
        a[8] = 2.5;
        System.out.println(a[2] instanceof Integer);


    }
}
