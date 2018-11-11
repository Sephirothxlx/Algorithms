package algorithm;


public class LC937 {
	public String[] reorderLogFiles(String[] logs) {
		for(int i=0;i<logs.length;i++){
			String[]temp=logs[i].split(" ");
			if(temp[1].charAt(0)-'a'>=0&&temp[1].charAt(0)-'a'<=25){
				for(int j=i;i>0;j--){
					String[]temp2=logs[j].split(" ");
					if(temp2[1].charAt(0)-'a'>=0&&temp2[1].charAt(0)-'a'<=25){
						String c=logs[j].substring(logs[j].indexOf(" ")+1);
						String d=logs[j-1].substring(logs[j-1].indexOf(" ")+1);
						if(c.compareTo(d)<0){
							String s=logs[j];
							logs[j]=logs[j-1];
							logs[j-1]=s;
						}
					}else{
						String s=logs[j];
						logs[j]=logs[j-1];
						logs[j-1]=s;
					}
				}
			}
		}
		return logs;
	}
}
