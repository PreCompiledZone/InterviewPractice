package practice.interview.questions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Stack;

public class MergeOverlappingDates {

	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	public static void mergeIntervals(Interval arr[]) {
		// Test if the given set has at least one interval
		if (arr.length <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> stack = new Stack<>();

		// sort the intervals in increasing order of start time
		Arrays.sort(arr);
		
		// push the first interval to stack
		stack.push(arr[0]);

		// Start from the next interval and merge if necessary
		for (int i = 1; i < arr.length; i++) {
			// get interval from stack top
			Interval top = stack.peek();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.end.compareTo(arr[i].start)>0)
				stack.push(arr[i]);

			// Otherwise update the ending time of top if ending of current
			// interval is more
			else if (top.end.compareTo(arr[i].start)<0) {
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}
		}

		// Print contents of stack
		System.out.println("The Merged Intervals are: ");
		while (!stack.isEmpty()) {
			SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
			Interval t = stack.pop();
			System.out.println("[" + sdfo.format(t.start)+ "," + sdfo.format(t.end)+ "] ");
		}
	}

	public static void main(String args[]) throws ParseException {
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(sdfo.parse("2014-01-01"), sdfo.parse("2014-01-30"));
		arr[1] = new Interval(sdfo.parse("2014-01-15"), sdfo.parse("2014-02-15"));
		arr[2] = new Interval(sdfo.parse("2014-03-10"), sdfo.parse("2014-04-15"));
		arr[3] = new Interval(sdfo.parse("2014-04-10"), sdfo.parse("2014-05-15"));
		
		mergeIntervals(arr);
	}
}

class Interval implements Comparable<Interval>{

	Date start, end;

	Interval(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval arg0) {
		// TODO Auto-generated method stub
		return start.compareTo(arg0.start);
	}
}