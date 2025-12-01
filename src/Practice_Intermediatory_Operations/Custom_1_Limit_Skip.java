package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Custom_1_Limit_Skip
{
	public static void main(String[] args) 
	{
		List<Employee>list = new ArrayList<Employee>();
		
		list.add(new Employee(1,"Mayank","IT",18000.0));
		list.add(new Employee(2,"Manas","HR",18890.0));
		list.add(new Employee(4,"Vedika","HR",27000.0));
		list.add(new Employee(1,"Mayank","IT",18000.0));
		list.add(new Employee(3,"Yog","IT",38000.0));
		
		list.stream()
		.distinct()
		.sorted(new empcomparator())
		.limit(3)
		.skip(1)
		.forEach((i)->{System.out.println(i);});
	}
}

class Employee
{
	int id;
	String name;
	String dept;
	double salary;
	
	public Employee(int id,String name,String dept,double salary)
	{
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" : "+this.dept+" : "+this.salary;
	}
	
	public int hashCode()
	{
		return this.id;
	}
	
	public boolean equals(Object obj)
	{
		Employee emp = (Employee)obj;
		return this.id == emp.id;
	}
}

class empcomparator implements Comparator<Employee>
{
	public int compare(Employee emp1,Employee emp2)
	{
		return emp1.id - emp2.id;
	}
}