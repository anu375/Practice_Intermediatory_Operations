package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Second
{

	public static void main(String[] args)
	{
		List<Teacher>list = new ArrayList<Teacher>();
		list.add(new Teacher(1,"Madhavi","Math",18000.0));
		list.add(new Teacher(2,"Suraj","Chemistry",20000.0));
		list.add(new Teacher(1,"Madhavi","Math",18000.0));
		list.add(new Teacher(3,"Sanavi","Physics",19000.0));
		
		list.stream()
		.filter((i)->{return i.salary>15000.0;})
		.distinct()
		.map((i) -> {
            i.name = i.name.toUpperCase();
            i.department = i.department.toUpperCase();
            return i;
        })
		.sorted(new teachercomparator())
		.forEach((i)->{System.out.println(i);});
	}
}

class Teacher implements Comparable<Teacher>
{
	int id;
	String name;
	String department;
	double salary;
	
	public Teacher(int id, String name, String department, double salary)
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" "+this.department+" "+this.salary;
	}
	
	public int hashCode()
	{
		return this.id;
	}
	
	public boolean equals(Object obj)
	{
		Teacher teacher = (Teacher)obj;
		return this.id == teacher.id;
	}

	public int compareTo(Teacher o) 
	{
		return this.id;
	}
}

class teachercomparator implements Comparator<Teacher>
{
	public int compare(Teacher t1, Teacher t2)
	{
		return t2.id - t1.id; 
	}
}