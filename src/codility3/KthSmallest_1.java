package codility3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthSmallest_1 {

	// Function to return k'th smallest
	// element in a given array
	public static int kthSmallest(Integer[] arr, int k) {
		// Sort the given array
		Arrays.sort(arr);

		// Return k'th element in
		// the sorted array
		return arr[k - 1];
	}

	// driver program
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
		int k = 4;
		long start = System.nanoTime();
		System.out.println("K'th smallest element is " + kthSmallest(arr, k));
		System.out.printf("execution time  %s", System.nanoTime() - start );
		System.out.println();

  	
  	List<Integer> l = new ArrayList<>(Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList()));
  	start = System.nanoTime();
  	for(int i = 0; i < l.size(); i++) System.out.print(l.get(i));
  	System.out.println();
  	System.out.printf("execution time  %s   for-loop", System.nanoTime() - start );
  	System.out.println();
  	start = System.nanoTime();
  	l.forEach(ele -> System.out.print(ele));
  	System.out.println();
  	System.out.printf("execution time  %s   adv-for-loop", System.nanoTime() - start );
  	System.out.println();
  	start = System.nanoTime();
  	Iterator itr = l.iterator();
  	while(itr.hasNext()) System.out.print(itr.next());
  	System.out.println();
  	System.out.printf("execution time  %s   iterator", System.nanoTime() - start );
  	System.out.println();
  	start = System.nanoTime();
  	l.stream().forEach(ee->System.out.print(ee));
  	System.out.println();
  	System.out.printf("execution time  %s   stream", System.nanoTime() - start );
  	System.out.println();
  	start = System.nanoTime();
  	l.parallelStream().forEach(ee->System.out.print(ee));
  	System.out.println();
  	System.out.printf("execution time  %s   parallel-stream", System.nanoTime() - start );
  	System.out.println();
  	
	}

}
