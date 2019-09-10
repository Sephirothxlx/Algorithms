package algorithm.thumbtack.OA;

import java.util.Arrays;

public class Question3 {
	int[][]graph;
	int[] match;
	boolean[]check;
	
	int getMin(String s) {
		String[]temp=s.split(":");
		return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
	}
	
	int userProMatching(int[][] projectsInfo, String[][] projectsTimeRanges, int[][] prosInfo, String[][] prosTimeRanges) {
		int n=projectsInfo.length;
		int m=prosInfo.length;
		graph=new int[n+m][n+m];
		int [] cost=new int[3];
		cost[0]=2;
		cost[1]=4;
		cost[2]=6;
		//preprocess
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int dist=Math.abs(projectsInfo[i][0]-prosInfo[j][0])+Math.abs(projectsInfo[i][1]-prosInfo[j][1]);
				int totalCost=dist+cost[projectsInfo[i][3]];
				if(projectsInfo[i][2]>=prosInfo[j][2]) {
					boolean tag=false;
					for(int x=0;x<projectsTimeRanges[i].length;x++) {
						if(tag)
							break;
						for(int y=0;y<prosTimeRanges[j].length;y++) {
							String[]temp1=projectsTimeRanges[i][x].split("-");
							String[]temp2=prosTimeRanges[j][y].split("-");
							int l=Math.max(getMin(temp1[0]), getMin(temp2[0]));
							int r=Math.min(getMin(temp1[1]), getMin(temp2[1]));
							if(r>=l&&r-l>=totalCost) {
								graph[i][j+n]=1;
								graph[j+n][i]=1;
								tag=true;
								break;
							}
						}
					}
				}
			}
		}
		int res=0;
		match=new int[n+m];
		check=new boolean[n+m];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++) {
			if(match[i]==-1) {
				Arrays.fill(check, false);
				if(dfs(i))
					res++;
			}
		}
		return res;
	}
	
	boolean dfs(int i) {
		for(int j=0;j<graph[i].length;j++) {
			if(graph[i][j]==1&&!check[j]) {
				check[j]=true;
				if(match[j]==-1||dfs(match[j])) {
					match[i]=j;
					match[j]=i;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[]args) {
		Question3 q=new Question3();
		int[][]projectsInfo = {{ 0, 0, 5, 0},
		                {1, 2, 8, 1},
		                {-2, 1, 10, 2}};
		String[][]projectsTimeRanges = {{"08:00-10:30", "11:59-14:00", "20:30-23:05"},
				{"16:30-21:00"},
				{"00:00-23:59"}};
		int [][]prosInfo = {{5, 0, 7},
		            {0, 1, 5},
		            {-1, -1, 8}};
		String[][]prosTimeRanges = {{"10:00-16:06"},
				{"11:50-14:00", "20:30-23:07"},
				{"17:00-23:30"}};
		System.out.println(q.userProMatching(projectsInfo, projectsTimeRanges, prosInfo, prosTimeRanges));
	}
}
