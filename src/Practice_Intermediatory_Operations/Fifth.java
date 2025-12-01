package Practice_Intermediatory_Operations;

import java.util.List;
import java.util.ArrayList;

public class Fifth
{
	public static void main(String[] args)
	{
		List<Integer>list = new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(13);
		
		list.stream()
		.limit(3).skip(1)
		.forEach((i)->{System.out.println(i);});
	}
}

