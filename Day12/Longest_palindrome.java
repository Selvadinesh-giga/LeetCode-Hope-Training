class Longest_palindrome {
    static String longest_palindrome(String str){
        int start=0;
        int end=0;
        int max=0;
        
        for(int i=0; i<str.length(); i++){
            int r=0;
            int l=0;
            if(i > 0 && str.charAt(i)==str.charAt(i-1)){
                l=i-1;
                r=i;
                
            }
            else if(i > 0 && i < str.length()-1 && str.charAt(i-1)==str.charAt(i+1)){
                l=i;
                r=i;
            }
            
            while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
                r++;
                l--;
            }
            
            int len = r - l - 1;
            if(len>max){
                start=l;
                end=r;
                max=len;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=start+1; i<end; i++) sb.append(str.charAt(i));
        return sb.toString();
    }
    public static void main(String[] args){
        String str = "babad";
        System.out.println(longest_palindrome(str));
    }
}