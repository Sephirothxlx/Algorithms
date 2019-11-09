package algorithm.expedia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class OA2 {
	int[][]matrix;
	int n=0;
	public int shortestPath(int[] g_from,int[]g_to,int[]g_weight,int x,int y) {
		Set<Integer> set=new HashSet<>();
		for(int i:g_from)
			set.add(i);
		matrix=new int[set.size()][set.size()];
		n=set.size();
		int res=0;
		for(int i=0;i<g_from.length;i++) {
			matrix[g_from[i]-1][g_to[i]-1]=g_weight[i];
			matrix[g_to[i]-1][g_from[i]-1]=g_weight[i];
		}
		res=dijkstra(0,x-1)+dijkstra(x-1,y-1)+dijkstra(y-1,n-1);
		return res;
	}
	
	public int dijkstra(int start,int end) {
		int[]p=new int[n];
		Arrays.fill(p, Integer.MAX_VALUE);
		p[start]=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return p[a]-p[b];
			}
		});
		pq.add(start);
		while(!pq.isEmpty()) {
			int temp=pq.poll();
			PriorityQueue<Integer> pq2=new PriorityQueue<>(new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					return p[a]-p[b];
				}
			});
			for(int j=0;j<n;j++) {
				if(matrix[temp][j]!=0) {
					if(p[temp]+matrix[temp][j]<p[j]) {
						p[j]=p[temp]+matrix[temp][j];
						pq2.add(j);
					}
				}
			}
			pq2.addAll(pq);
			pq=pq2;
		}
		return p[end];
	}
	
	public static void main(String[]args) {
		OA2 o=new OA2();
		int[]g_from=new int[] {1,2,3,4,5,3};
		int[]g_to=new int[] {2,3,4,5,1,5};
		int []g_weight=new int[] {9,11,6,1,4,10};
		System.out.println(o.shortestPath(g_from,g_to,g_weight,2,3));
	}
}
