package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Comparator;

public class Fourth 
{
	public static void main(String[] args)
	{
		List<Car>list = new ArrayList<Car>();
		
		list.add(new Car(1,"Swift","White",150000.0));
		list.add(new Car(2,"Scorpio","Gray",250000.0));
		list.add(new Car(3,"Thar","Black",450000.0));
		list.add(new Car(4,"Fortuner","Gray",350000.0));
		list.add(new Car(1,"Swift","White",150000.0));
		list.add(new Car(5,"Safari","Violet",100000.0));
		
		list.stream()
		.filter((i)->{return i.price>100000.0;})
		
		.map((i)->{
			i.brand = i.brand.toUpperCase();
			i.color = i.color.toUpperCase();
			return i;
			})
		
		.distinct()
		.sorted(new carcomparator())
		.forEach((i)->{System.out.println(i);});
	}
}

class Car
{
	int id;
	String brand;
	String color;
	double price;
	
	Car(int id,String brand,String color,double price)
	{
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public String toString()
	{
		return this.id+" "+this.brand+" "+this.color+" "+this.price;
	}
	
	public int hashCode()
	{
		return Objects.hash(id,brand,color,price);
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if (!(obj instanceof Car)) 
			return false;
		
		Car c = (Car)obj;
		
		return this.id == c.id &&
				this.brand.equals(c.brand)&&
				this.color.equals(c.color)&&
				this.price == c.price;
	}
}

class carcomparator implements Comparator<Car>
{
	public int compare(Car c1, Car c2)
	{
		return c1.id - c2.id;
	}
}