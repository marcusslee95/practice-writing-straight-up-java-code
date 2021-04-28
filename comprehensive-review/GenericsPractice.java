import java.util.ArrayList;

class MyCustomList<T>{ //it's just a stupid class that is no different from an arraylist... purpose of it's existence is to show example of using generics aka. variable for types
	
	ArrayList<T> list = new ArrayList<>(); 

	public void addElement(T element) {
		list.add(element);
	}

	public void removeElement(T element) {
		list.remove(element);
	}

	public String toString() {
		return list.toString();
	}

	public T get(int index) {
		return list.get(index);
	}
}

public class GenericsPractice {
	public static void main(String[] args) {
		MyCustomList<Integer> integerList = new MyCustomList<>(); //aside: all java collection classes need to hold objects... not primitives... which is why we use object version of int and not plain old int
		integerList.addElement(4);
		integerList.addElement(12);
		integerList.addElement(-33);
		System.out.println(integerList); 

		MyCustomList<String> stringList = new MyCustomList<>(); //showing power of generics... can be flexible in the type 
		stringList.addElement("My Mind~~~ My Mind~~~");
		stringList.addElement("baby take a chance take a chance take a chance");
		stringList.addElement("Thatchuuu");
		System.out.println(stringList); 

		MyCustomList<Boolean> booleanList = new MyCustomList<>(); //showing power of generics... can be flexible in the type 
		booleanList.addElement(true);
		booleanList.addElement(false);
		booleanList.addElement(true);
		System.out.println(booleanList); 
	}
}