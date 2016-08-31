public class Sort{

    static void printArray(int a[],int n){
       for(int k=0;k<n;k++){
           System.out.print(a[k]+" ");            
       }
       System.out.println(""); 
    }

    static void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selection_sort(int []a,int n){
        System.out.println("##### Selection sort begin #####");
        for(int i=0;i<n;i++){
            int minindex = i;
            for(int j=i+1;j<n;j++){
                if ( a[j] < a[minindex]) {
                    minindex = j;
                }
            }
            if(minindex > i){
                swap(a,i,minindex);
            }
            printArray(a,n);
        }
        System.out.println("#####  Selection sort end #####");
    }

    public static void insertion_sort(int a[],int n){
        System.out.println("##### Insertion sort begin #####");
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j>0;j--){
                if(a[j] < a[j-1]){
                    swap(a,j,j-1);
                }                
            }
            printArray(a,n);
        }        
        System.out.println("##### Insertion sort end #####");
    }

    public static int partition(int a[],int first,int last){
        int pivot = a[first];
        int i = first +1;
        int j = last;
        while(true){
            while(i<=j && a[i] <= pivot) i++;
            while(j>=i && a[j] >= pivot) j--;

            if(i<j){
                swap(a,i,j);
            } else {
                break;
           }
        } 
        swap(a,first,j);
        return j;               
    }    

    public static void quick_sort(int a[],int start,int end){
        if(start < end){
            int split_point = partition(a,start,end);
            quick_sort(a,start,split_point-1);
            quick_sort(a,split_point+1,end);
        }    

    }


    public static void main(String args[]){
        //int a[] ={ 10,90, 70,40, 110,50,30};
        int a[] ={ 5,6,8,7,0,9,4,3,2,1};
        selection_sort(a.clone(),a.length);
        insertion_sort(a.clone(),a.length);
        int b[] = a.clone();
        quick_sort(b,0,b.length-1);
        printArray(b,b.length);

    }
}
