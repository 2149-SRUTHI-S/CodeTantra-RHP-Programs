//Recursive function to check if a string is palindrome

import java.util.*;

class Main {
    public static boolean palindrome(String s,int l,int r){
        if(l>=r) 
        return true;
        if(s.charAt(l)!=s.charAt(r)) 
        return false;
        return palindrome(s,l+1,r-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(palindrome(s,0,s.length()-1)){
            System.out.print("Palindrome");
        }
        else{
            System.out.print("Not Palindrome");
        }
    }
}
