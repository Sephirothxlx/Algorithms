package algorithm;

import java.util.List;

public class MergeInternal {
	public class Interval {
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

	public List<Interval> merge(List<Interval> intervals) {
		for (int i = 0; i < intervals.size(); i++) {
			int t = i;
			int min = intervals.get(i).start;
			for (int j = i + 1; j < intervals.size(); j++) {
				if (intervals.get(j).start <min) {
					t = j;
					min=intervals.get(j).start;
				}
			}
			if (t != i) {
				Interval temp = intervals.get(i);
				intervals.set(i, intervals.get(t));
				intervals.set(t, temp);
			}
		}
		for (int i = 0; i < intervals.size() - 1;) {
			Interval in = intervals.get(i);
			Interval in2 = intervals.get(i + 1);
			if (in.end >= in2.start) {
				Interval in3 = new Interval(in.start, Math.max(in.end, in2.end));
				intervals.remove(i + 1);
				intervals.set(i, in3);
			} else
				i++;
		}
		return intervals;
	}
}
