package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;

public class First
{

	public static void main(String[] args) 
	{
		List<Student>list = new ArrayList<Student>();
		
		list.add(new Student(1,"Sweta",89));
		list.add(new Student(2,"Suraj",98));
		list.add(new Student(3,"Aniket",79));
		list.add(new Student(1,"Sweta",89));
		list.add(new Student(1,"Madhavi",80));
		
		list.stream()
		.filter((i)->{return i.marks>79;})
		.distinct()
		.map(s -> {
            s.name = s.name.toUpperCase();
            return s;
        })
		.sorted((s1, s2) -> s2.marks - s1.marks)
		.forEach((i)->{System.out.println(i);});
	}
}


class Student
{
	int id;
	String name;
	int marks;
	
	public Student(int id, String name, int marks)
	{
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" "+this.marks;
	}
	
	public int hashCode()
	{
	    return id;
	}
	 
	public boolean equals(Object obj)
	{
		Student s = (Student) obj;
        return this.id == s.id;
	}
}