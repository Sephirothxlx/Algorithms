package algorithm.tecent;

import java.util.Scanner;

public class T20172 {
	public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String s=in.nextLine();
            char c[]=s.toCharArray();
            int x=0,i=0;
            while(x<c.length){
                if(c[i]-'a'<0){
                    for(int j=i;j<c.length-1;j++){
                        char temp=c[j];
                        c[j]=c[j+1];
                        c[j+1]=temp;
                    }
                }else{
                    i++;
                }
                x++;
            }
            s="";
            for(i=0;i<c.length;i++){
                s+=c[i];
            }
            System.out.println(s);
        }
    }
}

