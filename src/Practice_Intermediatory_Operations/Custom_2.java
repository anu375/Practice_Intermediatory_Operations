package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Custom_2 
{

	public static void main(String[] args)
	{
		List<Emp>list = new ArrayList<Emp>();
		
		list.add(new Emp(1,"Soham","IT",90000.00));
		list.add(new Emp(4,"Sonakshi","IT",60000.00));
		list.add(new Emp(3,"Sakshi","IT",70000.00));
		list.add(new Emp(1,"Soham","IT",90000.00));
		list.add(new Emp(2,"Suraj","IT",80000.00));
		
		list.stream()
		.distinct()
		.sorted(new emp1comparator())
		.limit(2)
		.forEach((i)->{System.out.println(i);});
	}
}

class Emp implements Comparable<Emp>
{
	int id;
	String name;
	String dept;
	double salary;
	
	public Emp(int id,String name, String dept,double salary)
	{
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" "+this.dept+" "+this.salary;
	}
	
	public int compareTo(Emp emp)
	{
		return Integer.compare(this.id, emp.id);
	}
	
	public int hashCode()
	{
		return this.id;
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if(!(obj instanceof Emp))
			return false;
		
		Emp emp = (Emp)obj;
		return this.id == emp.id;
	}
}

class emp1comparator implements Comparator<Emp>
{
	public int compare(Emp emp1,Emp emp2)
	{
		return emp2.id - emp1.id;
	}
}