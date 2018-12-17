package codility3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> numbers 
	  = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

		Iterator<Integer> iterator = numbers.iterator();

		numbers.add(10);
		
		Iterator<Integer> iterator2 = numbers.iterator();
		
		/*List<Integer> result = new LinkedList<>();
		iterator.forEachRemaining(result::add);
		
		List<Integer> result2 = new LinkedList<>();
		iterator2.forEachRemaining(result2::add);
		
		System.out.print(result);
		System.out.println();
		System.out.print(result2);
		System.out.println();*/
		while(iterator.hasNext()) System.out.print("-"+iterator.next());
		System.out.println();
		while(iterator2.hasNext()) System.out.print("-"+iterator2.next());
	}

}
