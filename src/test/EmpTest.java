package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmpTest {

	public static void main(String[] args) {
		Map<Emp, Object> map = new HashMap<>();
		Emp e1 = new Emp(1, "aa");
		Emp e2 = new Emp(1, "ab");
		map.put(e1, "e1");
		map.put(e2, "e2");
		System.out.println(map.size());
		for (Emp e : map.keySet()) {
			System.out.println(e + "-" + map.get(e));
		}
		Set<Emp> set = new HashSet<>();
		set.add(e1);
		set.add(e2);
		for (Emp e : set) {
			System.out.println(e);
		}
	}

	static class Emp {
		int id;
		String name;

		Emp(int id, String name) {
			this.id = id;
			this.name = name;
		}

		// @Override
		// public int hashCode() {
		// /*final int prime = 31;
		// int result = 1;
		// result = prime * result + id;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());*/
		// return 1;
		// }
		//
		// @Override
		// public boolean equals(Object obj) {
		// /*Emp other = (Emp) obj;
		// if (name.equals(other.name))
		// return true;
		// return false;*/
		// return true;
		// }

		@Override
		public String toString() {
			return "[" + id + "," + name + "]";
		}
	}
}