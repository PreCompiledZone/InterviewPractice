package interview.test.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiThreadingProblem {

	private final static int MAX = 100000;

	private static ConcurrentLinkedQueue<Task> taskQueue;

	private static LinkedBlockingQueue<Result> resultQueue;

	private static class Task {
		int min, max; // Start and end of the range of integers for this task.

		Task(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public void compute() {
			int maxDivisors = 0;
			int whichInt = 0;
			for (int i = min; i < max; i++) {
				int divisors = countDivisors(i);
				if (divisors > maxDivisors) {
					maxDivisors = divisors;
					whichInt = i;
				}
			}
			resultQueue.add(new Result(maxDivisors, whichInt));
		}
	}

	private static class Result {
		int maxDivisorFromTask; // Maximum number of divisors found.
		int intWithMaxFromTask; // Which integer gave that maximum number.

		Result(int maxDivisors, int whichInt) {
			maxDivisorFromTask = maxDivisors;
			intWithMaxFromTask = whichInt;
		}
	}

	private static class CountDivisorsThread extends Thread {
		public void run() {
			while (true) {
				Task task = taskQueue.poll();
				if (task == null)
					break;
				task.compute();
			}
		}
	}

	private static void countDivisorsWithThreads(int numberOfThreads) {

		System.out.println("\nCounting divisors using " + numberOfThreads + " threads...");

		long startTime = System.currentTimeMillis();
		resultQueue = new LinkedBlockingQueue<Result>();

		taskQueue = new ConcurrentLinkedQueue<Task>();
		CountDivisorsThread[] workers = new CountDivisorsThread[numberOfThreads];
		for (int i = 0; i < workers.length; i++)
			workers[i] = new CountDivisorsThread();

		int numberOfTasks = (MAX + 999) / 1000;
		for (int i = 0; i < numberOfTasks; i++) {
			int start = i * 1000 + 1;
			int end = (i + 1) * 1000;
			if (end > MAX)
				end = MAX;
			// System.out.println(start + " " + end); // for testing
			taskQueue.add(new Task(start, end));
		}

		/* Now that the tasks are in the task queue, start the threads. */

		for (int i = 0; i < numberOfThreads; i++)
			workers[i].start();

		int maxDivisorCount = 0; // Over maximum found by any task.
		int intWithMaxDivisorCount = 0; // Which integer gave that maximum?
		for (int i = 0; i < numberOfTasks; i++) {
			try {
				Result result = resultQueue.take();
				if (result.maxDivisorFromTask > maxDivisorCount) { // new maximum.
					maxDivisorCount = result.maxDivisorFromTask;
					intWithMaxDivisorCount = result.intWithMaxFromTask;
				}
			} catch (InterruptedException e) {
			}
		}

		// print result
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(
				"\nThe largest number of divisors " + "for numbers between 1 and " + MAX + " is " + maxDivisorCount);
		System.out.println("An integer with that many divisors is " + intWithMaxDivisorCount);
		System.out.println("Total elapsed time:  " + (elapsedTime / 1000.0) + " seconds.\n");

	} // end countDivisorsWithThreads()

	// count divisors of given number
	private static int countDivisors(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int numberOfThreads = 10;
		
		//countDivisorsWithThreads(numberOfThreads);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(6);
		list.add(7);
		list.add(24);
		list.add(3);
		list.add(80);
		list.add(13);
		
		list.forEach(e->{
			if(e%2 == 0)
				System.out.println(e+" is even number");
			else
				System.out.println(e+" is not even number");
		});
		
		
		
	}

}
