package aa;

public class test23 {
    public static void main(String[] args) {
        int[] num = {3,4,1,2};
        int n = minNumberdisappered(num);
        System.out.println(n);
    }
    public static int minNumberdisappered (int[] arr) {
        // write code here
        int len = arr.length;
        for(int i=0; i<len; i++){
            int num = arr[i];
            if(num>=0 && num<len && arr[num-1]!=num){
                int change = num-1;
                arr[i] = arr[i]+arr[change]-(arr[change]=arr[i]);
            }
        }
        for(int i=0; i<len; i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
}
