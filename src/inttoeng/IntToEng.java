package inttoeng;

import java.util.Scanner;
import java.util.InputMismatchException;

public class IntToEng {

    // メインメソッド
    public static void main(String[] args) {

    	try {
    		Scanner sc = new Scanner(System.in);
    		int input = sc.nextInt();
    		System.out.println(translateEng(input));
    	} catch (InputMismatchException e) {
        	System.out.println("範囲外です");
        }
    }

    // 数値を英訳する変換するメソッド
    public static String translateEng(int n) {
    	String s = "";
    	if(n==0) s = "zero";
 
    	String zeroTo9[]={"","one","two","three","four","five","six","seven","eight","nine"};
    	String tenTo19[]={"ten","eleven","twelve","thirteen","fourteen","fifteen","seventeen","eighteen","nineteen"};
    	String twentyTo90[]={"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    	
        int minus = 0;
        while(n!=0){
        if(n>=1000000000){
        	s+=zeroTo999(n/1000000000,zeroTo9,tenTo19,twentyTo90)+" billion";
        	minus = (n/1000000000)*1000000000;
        }
       	if(n>=1000000&&n<1000000000){
       		s+=zeroTo999(n/1000000,zeroTo9,tenTo19,twentyTo90)+" million";
       		minus = (n/1000000)*1000000;
       	}
        if(n>=1000&&n<1000000){
        	s+=zeroTo999(n/1000,zeroTo9,tenTo19,twentyTo90)+" thousand";
        	minus = (n/1000)*1000;
        }
   
        if(0<n&&n<1000){
        	s+=zeroTo999(n,zeroTo9,tenTo19,twentyTo90);
        	minus=n;
        }
    	n-=minus;
    	if(n!=0) s+=" ";
        }
        return s;
    }
    public static String zeroTo999(int n,String[] zeroToNine,String[] tenToNineteen,String[] twentyToNinety){
    	String s="";
    	int minus = 0;
    	while(n!=0){
    	  if(n>=100&&n<1000){	
          	s+= zeroToNine[n/100]+" hundred";
          	minus=(n/100)*100;
          }
          if(n>=20&&n<100){
       		s+=twentyToNinety[n/10];
       		minus= (n/10)*10;
       	}
      	if(n>=10&&n<20){
      		 s+=tenToNineteen[n%10];
      		 minus= n;
      	 }
      	if(n>0&&n<10){
      		s+=zeroToNine[n];
      		minus= n;
      	}
      	n-=minus;
      	if(n!=0) s+=" ";
    	}
          return s;
    }
}