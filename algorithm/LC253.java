package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253 {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int minMeetingRooms(Interval[] intervals) {
		if(intervals==null||intervals.length==0)
			return 0;
		Arrays.sort(intervals,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
		PriorityQueue<Interval> q=new PriorityQueue<Interval>(new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.end-o2.end;
			}
		});
		q.add(intervals[0]);
		for(int i=1;i<intervals.length;i++){
			Interval temp=q.poll();
			if(temp.end<intervals[i].start){
				temp.end=intervals[i].end;
			}else{
				q.add(intervals[i]);
			}
			q.add(temp);
		}
		return q.size();
	}
}
