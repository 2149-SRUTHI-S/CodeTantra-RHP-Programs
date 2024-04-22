//Program to calculate value of nCr using Recursion

import java.util.*;
public class nCr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        System.out.println("nCr : " + ncr(n,r));
    }
    
    private static int ncr(int n, int r){
        int answer = 0;
        if (r==0) 
        answer = 1;
        else 
        answer = ncr(n,r-1) * (n-r+1)/r;
        
        return answer;
    }
}
