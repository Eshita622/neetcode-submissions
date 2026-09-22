class Solution {
    public boolean isPalindrome(String s) {
       String fixed_str="";
       for(char c: s.toCharArray()){
        if(Character.isDigit(c)|| Character.isLetter(c)){
            fixed_str+=c;
        }
       }
       fixed_str=fixed_str.toLowerCase();
       int a_pointer=0;
       int b_pointer=fixed_str.length()-1;
       while(a_pointer<=b_pointer){
        if(fixed_str.charAt(a_pointer)!=fixed_str.charAt(b_pointer)){
            return false;
        }
        a_pointer+=1;
        b_pointer-=1;
       }
       return true;


    }
}
