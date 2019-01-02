package algorithm.jianzhioffer.string;

/**
 * @author Sephiroth
 * 替换空格
 * 把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符
 * 核心思路是先算出大小 从后往前添加
 * O(N)+O(1)
 */
public class Q5 {
	public static void replace(char[]data,int length){
		int newlen=0;
		for(char x:data)
			if(x==' ')
				newlen+=3;
			else if(x!=0)
				newlen++;
		if(newlen==length)
			return;
		int i=newlen-1;
		int j=length-1;
		while(i>=0&&j>=0){
			char c=data[j--];
			if(c==' '){
				data[i--]='0';
				data[i--]='2';
				data[i--]='%';
			}else
				data[i--]=c;
		}
	}
	
	public static void main(String[]args){
		String s="asdf ds sdf";
		char[]data=new char[100];
		System.arraycopy(s.toCharArray(), 0, data, 0, s.length());
		replace(data,s.length());
		System.out.println(data);
	}
}
