package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;


public class Custom_Limit_Skip 
{
	public static void main(String[] args)
	{
		List<Student_1>list = new ArrayList<Student_1>();
		
		list.add(new Student_1(1,"Swaraj",99.90));
		list.add(new Student_1(2,"Manik",88.90));
		list.add(new Student_1(1,"Swaraj",99.90));
		list.add(new Student_1(3,"Nandini",87.90));
		list.add(new Student_1(4,"Monika",89.90));
		
		list.stream()
		.skip(1)
		.limit(3)
		.distinct()
		/**output
		 * 1 Swaraj 99.9
		   2 Manik 88.9
		   3 Nandini 87.9
		 */
		.sorted()
		.forEach((i)->{System.out.println(i);});
	}
}

class Student_1 implements Comparable<Student_1>
{
	int id;
	String name;
	double marks;
	
	public Student_1(int id, String name, double marks)
	{
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	public int compareTo(Student_1 s)
	{
		return Integer.compare(this.id, s.id);
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" "+this.marks;
	}
	
	public int hashCode()
	{
		return Objects.hash(this.id);
		//return this.id;
	}
	
	public boolean equals(Object obj)
	{
		Student_1 std = (Student_1)obj;
		return this.id == std.id;
	}
}