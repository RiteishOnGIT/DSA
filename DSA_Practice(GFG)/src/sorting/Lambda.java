package sorting;

import java.util.ArrayList;
import java.util.Collections;

class Student {
	
	int id;
	String name;
	int marks;
	
	public Student() {
	}
	
	public Student(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	
}





public class Lambda {

	public static void main(String[] args) {
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList.add(new Student(2, "Ritesh", 24332));
		arrayList.add(new Student(3, "Ritesh", 24332));
		arrayList.add(new Student(1, "Ritesh", 24332));
		arrayList.add(new Student(4, "Ritesh", 24332));

		
		Collections.sort(arrayList, (s1, s2)->{
			if(s1.id>s2.id)return 1;
			else if(s2.id>s1.id) {
				return -1;
			}
			else {
				return 0;
			}
		});
		
		System.out.println(arrayList);
		
	}

}
