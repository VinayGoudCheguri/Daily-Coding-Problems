import java.util.Arrays;

public class Problem_21 {

	public static class Interval{
		int start;
		int end;
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	public static int find_min_rooms(Interval[] intervals) {
		int length = intervals.length;
		int start[] = new int[length]; // stores starting time of meetings
		int end[] = new int[length]; // stores ending time of meetings
		for(int i=0;i<length;i++) {
			start[i]=intervals[i].start;
			end[i]=intervals[i].end;
			
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int min_rooms =1;
		int ongoing_meet = 1;
		int i=1,j=0;
		// start[i] indicates no of meetings started till now
		// end[i] indicated no of meetings ended till now
		while(i<length&&j<length) {
			// ith meeting started but jth meeting not ended
			if(start[i]<end[j]) {
				ongoing_meet++;
				i++;
				min_rooms = Math.max(min_rooms, ongoing_meet);
			}
			else {// jth meeting ends before the start of ith meeting
				ongoing_meet--;
				j++;
			}
		}
		return min_rooms;
	}
	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(30,75);
		intervals[1] = new Interval(0, 50);
		intervals[2] = new Interval(60,150);
		int ans = find_min_rooms(intervals);
		System.out.println("Required minimun number of rooms is "+ans);
	}

}
