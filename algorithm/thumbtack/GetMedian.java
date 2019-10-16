package algorithm.thumbtack;

public class GetMedian {
	int[]count=new int[10000];
	int totalCount=0;
	int sum=0;
	
	public void add(int i) {
		count[i]++;
		totalCount++;
		sum+=i;
	}
	
	public int getMean() {
		return sum/totalCount;
	}
	
	public int getMedian() {
		int median=totalCount/2;
		if(totalCount%2==0) {
			int temp=0;
			int i=0;
			int left=0;
			for(;i<10000;i++) {
				temp+=count[i];
				if(temp==median) {
					left=i;
					break;
				}else if(temp>median) {
					return i;
				}
			}
			for(i=i+1;i<10000;i++) {
				if(count[i]!=0)
					break;
			}
			return (left+i)/2;
		}else {
			int temp=0;
			int i=0;
			for(;i<10000;i++) {
				temp+=count[i];
				if(temp>=median) {
					break;
				}
			}
			return i;
		}
	}
}
