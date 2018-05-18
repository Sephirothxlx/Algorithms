package algorithm.dynamicprogramming.cutrod;

public class CutRod {
	public int cutRodByRecursion(int[]price,int length) {
		int res=price[length];
		for (int i=1;i<length;i++) {
			res=Math.max(res, price[i]+this.cutRodByRecursion(price, length-i));
		}
		return res;
	}
	
	public int cutRodByDP0(int[] price, int length,int memory[]) {
		if(memory[length]>0)
			return memory[length];
		int res=price[length];
		for(int i=1;i<length;i++) {
			res=Math.max(res, price[i]+this.cutRodByDP0(price, length-i,memory));
		}
		return res;
	}
	
	public int cutRodByDP1(int []price,int length) {
		int[]memory=price;
		for(int i=1;i<=length;i++) {
			//little trick: no need to check the length that is more than half of the rod
			for(int j=1;j<i/2+1;j++) {
				memory[i]=Math.max(memory[i],memory[j]+memory[i-j]);
			}
		}
		return memory[length];
	}
	public int cutRodByDP2(int []price,int length,int []cut) {
		int[]memory=price;
		for(int i=1;i<=length;i++) {
			for(int j=1;j<=i;j++) {
				if(memory[i]<(memory[j]+memory[i-j])) {
					memory[i]=memory[j]+memory[i-j];
					cut[i]=j;
				}
			}
		}
		return memory[length];
	}
	
}
