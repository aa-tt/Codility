package test;

public class Inherit {
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.name);
		GrandChild gc = new GrandChild();
		System.out.println(gc.name);
	}

}

class Parent {
	protected String name;

	Parent() {
	}

	Parent(String name) {
		this.name = name;
	}

	{
		name = "Anunay";
	}
}

class Child extends Parent {

}

class GrandChild extends Child {

}