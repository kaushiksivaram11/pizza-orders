package cart;
import java.util.*;
import java.util.Map.Entry;
import java.util.Set;
public class cart
{
	public Map<String,Integer>cart_items = new HashMap<String,Integer>(); 

	public void insert(String s)
	{
		if(cart_items.containsKey(s))
		{
			Integer x=cart_items.get(s);
			cart_items.put(s,x+1);
		}
		else
		cart_items.put(s,1);
	}


	public void delete(String s)
	{
		if(cart_items.containsKey(s))
		{
			Integer x=cart_items.get(s);
			cart_items.remove(s);
			if(x>1)
			cart_items.put(s,x-1);
		}
	}

}