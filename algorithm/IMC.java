package algorithm;

public class IMC {
	public int getRow(String s){
		String temp1;
        int index1;
        temp1=s.substring(0, s.length()-1);
    	index1=Integer.parseInt(temp1)-1;
        return index1;
	}
	
	public int getColumn(String s){
        char temp2;
        int index2;
    	temp2=s.charAt(s.length()-1);
    	index2=temp2-'A';
        return index2;
	}
	
	public String solution(int N, String S, String T) {
        // write your code in Java SE 8
        int[][]n=new int[N][N];
        String[]ship=S.split(",");
        String[]hit=T.split(" ");
        for(int i=0;i<hit.length;i++){
        	try{
        	n[getRow(hit[i])][getColumn(hit[i])]=1;
        	}catch(Exception e){
        	}
        }
        int a=0,b=0;
        int cellnumber,total,row1,column1,row2,column2;
        String[]cell;
        for(String x:ship){
        	cell=x.split(" ");
        	row1=getRow(cell[0]);
        	column1=getColumn(cell[0]);
        	row2=getRow(cell[1]);
        	column2=getColumn(cell[1]);
        	total=(row2-row1+1)*(column2-column1+1);
        	cellnumber=total;
        	for(int i=row1;i<=row2;i++){
        		for(int j=column1;j<=column2;j++){
        			if(n[i][j]==1)
        				cellnumber--;
        		}
        	}
        	if(cellnumber==0)
        		a++;
        	else if(cellnumber<total)
        		b++;
        }
        return a+","+b;
    }
}
