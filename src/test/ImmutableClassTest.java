package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ImmutableClassTest {
	public static void main(String[] args) {
		ImmutableClass instance = ImmutableClass.getImmutableClassInstance();
		System.out.println(instance.getName());
		instance.getName().name2 = "Avrohi";
		System.out.println(instance.getName());
		try {
			Constructor<ImmutableClass> ctor1 = ImmutableClass.class.getConstructor(Integer.class);
			Constructor<ImmutableClass> ctor2 = ImmutableClass.class.getConstructor(Name.class);
			instance = ctor1.newInstance(1, new Name("Anunay", "Ajinkya"));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(instance.getName());
	}

}

final class ImmutableClass {
	final private Integer id;
	final private Name name;

	ImmutableClass(Integer id, Name name) {
		this.id = id;
		this.name = name;
	}

	static ImmutableClass getImmutableClassInstance() {
		ImmutableClass instance = new ImmutableClass(1, new Name("Anunay", "Anindya"));
		return instance;
	}

	public Integer getId() {
		return id;
	}

	public Name getName() {
		return this.name.clone();
	}

}

class Name implements Cloneable {
	String name1;
	String name2;

	Name(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
	}

	@Override
	public String toString() {
		return "Name [name1=" + name1 + ", name2=" + name2 + "]";
	}

	@Override
	public Name clone() {
		// return new Name(this.name1, this.name2);
		return this;

	}

}
