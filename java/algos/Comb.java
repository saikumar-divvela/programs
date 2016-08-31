public class Comb {


    public static void combutil_int(int a[],int[] data,int start,int end,int index){
       if (index > 0 ){
           for(int k=0;k<index;k++){
                System.out.print(data[k]+" ");     
           }     
          System.out.println(" ");  
        }
       for(int i=start;i<end;i++){
           data[index]= a[i];
           combutil_int(a,data,i+1,end,index+1);
       }
    }

    public static void findcomb_int(int a[],int n){
        int[] data = new int[n];
        combutil_int(a,data,0,n,0);
    }


    public static void combutil_str(char s[],char data[],int start, int end, int index){
        if(index > 0){
            for(int k=0;k<index;k++){
                System.out.print(data[k]+" ");
            }
            System.out.println("");
        }
        for(int i=start;i<end;i++){
            data[index] =  s[i];
            combutil_str(s,data,i+1,end,index+1);
        }
    
    }
    public static void findcomb_str(char s[],int n){
        char[] data = new char[n];
        combutil_str(s,data,0,n,0);
    }

    public static void main(String args[]){
        int a[] = {1,2,3} ;
        findcomb_int(a,3);

        char s[]={'a','b','c'};
        findcomb_str(s,3);
    }
}
