public class Perm{
    
    /*
        For strings find prefix and pass rest of the string. When string length is 0 it means prefix has al required charachers. print it.
        For Strings find start from j =i swap every other digit and permute remaining number. After permute swap back to avoid duplicates

    */

    static int strcount =0;
    static void str_perm_util(String prefix,String s){
        int n= s.length();
        if(n==0){
            System.out.println(prefix);
            strcount++;
        }
        for(int i=0;i<n;i++){
            str_perm_util(prefix+s.charAt(i),s.substring(0,i)+s.substring(i+1,n));
        }
    }

    static void str_show_perm(String s){
        str_perm_util("",s);
        System.out.println(strcount);
    }   

    static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void int_perm_util(int []a,int i,int n){
    
        if(i==n){
            for(int k=0;k<n;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println(" ");
        }

        for(int j=i;j<n;j++){
            swap(a,i,j);
            int_perm_util(a,i+1,n);
            //swap(a,i,j);
        }
    }

    static void int_show_perm(int []a,int n){
        int_perm_util(a,0,n);
    }

    public static void main(String args[]){
        int[] a={1,2,3,4};
        String s="abcd";
        str_show_perm(s);
        int_show_perm(a,4);
    }

}
