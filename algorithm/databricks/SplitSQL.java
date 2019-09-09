package algorithm.databricks;

import java.util.ArrayList;
import java.util.List;

public class SplitSQL {
    public List<String> find(String s){
        List<String> res=new ArrayList<>();
        char[]c=s.toCharArray();
        int i=0;
        while(i<c.length) {
        	String temp="";
        	boolean quote=false;
        	while(i<c.length&&(c[i]!=';'||quote)) {
        		temp+=c[i];
        		if(c[i]=='"') {
        			quote=!quote;
        		}else if(c[i]=='\\'&&i+1<c.length) {
        			temp+=c[i+1];
        			i++;
        		}
        		i++;
        	}
        	if(temp.length()!=0)
        		res.add(temp);
        	i++;
        }
        return res;
    }
    
    public static void main(String[]args) {
    	String s="select name from courseinfo;; select * from\\\\ \"; \" ;";
    	System.out.println(s.charAt(0));
    }
}
