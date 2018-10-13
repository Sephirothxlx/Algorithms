package algorithm.tecent;

import java.util.Scanner;

public class T20171 {
	public static int common(String a,String b){
        int max=0;
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    int x=1+common(a.substring(i+1,a.length()),b.substring(j+1,b.length()));
                    if(x>max)
                        max=x;
                }
            }
        }
        return max;
    }
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        StringBuilder sb=new StringBuilder(s);
        String ss=sb.reverse().toString();
        System.out.println(ss);
        System.out.println(s.length()-common(s,ss));
    }
}
