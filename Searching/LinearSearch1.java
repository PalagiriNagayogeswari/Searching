public class LinearSearch1 {
    public static int linearsearch(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr={10,20,30,-10,40,50};
        System.out.println(linearsearch(arr));
        int[] arr1={10,20,30,10,40,50};
        System.out.println(linearsearch(arr1));
    }

}
