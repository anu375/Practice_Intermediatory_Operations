package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Third 
{
	public static void main(String[] args) 
	{
		List<Product>list = new ArrayList<Product>();
		
		list.add(new Product(1,"Laptop",70000.0));
		list.add(new Product(2,"Phone",18000.0));
		list.add(new Product(3,"IPad",60000.0));
		list.add(new Product(1,"Laptop",70000.0));
		
		list.stream()
		.filter((i)->{return i.price>18000.0;})
		.map((i)->{
				i.name = i.name.toUpperCase();
				return i;
				  })
		.sorted(new productcomparator())
		.forEach((i)->{System.out.println(i);});
	}
}

class Product
{
	int id;
	String name;
	double price;
	
	public Product(int id,String name, double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString()
	{
		return this.id+" "+this.name+" "+this.price;
	}
	
	public int hashCode()
	{
		return Objects.hash(id,name,price);
	}
	
	public boolean equals(Object o)
	{
		Product p = (Product)o;
		return this.id == p.id && this.name.equals(p.name)&& this.price==p.price;
	}
}

class productcomparator implements Comparator<Product>
{
	public int compare(Product p1, Product p2)
	{
		return p2.id - p1.id;
	}
}