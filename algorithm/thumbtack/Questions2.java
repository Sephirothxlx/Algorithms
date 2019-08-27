package algorithm.thumbtack;

public class Questions2 {
	public static int convert(String s){
        String[]temp=s.split("[.]");
        String res="";
        if(temp[0].equals("1")){
            return 1000000;
        }else{
            res=temp[1];
            for(int i=0;i<6-temp[1].length();i++){
                res+="0";
            }
            return Integer.parseInt(res);
        }
    }
	
	public static void main(String[]args) {
		System.out.println(convert("0.011"));
		System.out.println(convert("0.00110"));
		System.out.println(convert("0.999990"));
	}
}
