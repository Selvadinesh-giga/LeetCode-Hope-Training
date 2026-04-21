public class Leaders {
    static int[] leaders(int[] arr){    
        int N = arr.length;
        int k=N-1;
        int max=arr[N-1];
        for(int i=N-2; i>=0; i--){
            if(arr[i]>max){
                max=arr[i];
                k--;
                arr[k]=max;
            }
        }
        
        int[] ans = new int[N-k];
        for(int i=0; i<ans.length; i++){
            ans[i]=arr[k++];
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        int ans[] = leaders(arr);
        System.out.println("Output: ");
        for(int i=0; i<ans.length; i++) System.out.print(ans[i]+" ");
        System.out.print("\n");
    }
}