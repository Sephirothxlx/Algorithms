package algorithm;

public class ZigZag {
	public String convert(String s, int numRows) {
		String res="";
        if(numRows==1)
            return s;
        StringBuffer[]r=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
        	r[i]=new StringBuffer();
        int row=0,direction=0;
        for(int i=0;i<s.length();i++) {
        	r[row].append(s.charAt(i)+"");
        	if(direction==0) {
        		row++;
        	}else {
        		row--;
        	}
        	if(row==numRows) {
        		row=numRows-2;
        		direction=1;
        	}
            if(row==-1) {
        		row=1;
        		direction=0;
        	}
        }
        for(int i=0;i<numRows;i++) {
        	res+=r[i].toString();
        }
        return res;
    }
	public static void main(String[]args) {
		ZigZag z=new ZigZag();
		System.out.println(z.convert("PAYPALISHIRING", 4));
	}
}
