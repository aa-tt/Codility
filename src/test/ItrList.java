package test;

import java.util.ArrayList;
import java.util.List;

public class ItrList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(0);
		list.add(3);
		System.out.println(list);
		for (Integer i : list) {
			if (i == 0) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}
}
