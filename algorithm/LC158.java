package algorithm;

public class LC158 {
	char [] buff=new char[4];
	  int lastindex=0;
	  int lastcontent=0;
	  public int read(char[]buf, int n){
	    if(n==0)
	      return 0;
	    if(buf.length==0)
	      return 0;
	    int x=0;
	    while(x<n){
	      if(lastindex<lastcontent){
	        buf[x++]=buff[lastindex++];
	      }else{
	        lastcontent=read4(buff);
	        lastindex=0;
	        if(lastcontent==0)
	          break;
	      }
	    }
	    return x;
	  }
}
