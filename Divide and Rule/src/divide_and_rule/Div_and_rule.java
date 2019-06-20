package divide_and_rule;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.Random;
 


public class Div_and_rule {
	
	public  int alg(int k, ArrayList<Integer> list) throws IllegalArgumentException
	{
		
		if( list==null || list.isEmpty()) throw new NullPointerException("lista  nie istnieje");
		
		if(k<1 || k > list.size())
		throw new IllegalArgumentException("podano liczbę spoza dopuszczalnego przedziału");
		
		
		
		ArrayList<Integer> greater = new ArrayList<>();
		
		ArrayList<Integer> smaller = new ArrayList<>();
		
		Random r = new Random();
		int random = r.nextInt(list.size());
		int v = list.get(random);

		for(Iterator<Integer> it = list.iterator(); it.hasNext();)
		{
			Integer i = it.next();
			if (i >v) {
				greater.add(i);
				it.remove();
			}
			else if(i <v) {
				smaller.add(i);
				it.remove();
			}
		}
			if(k <= smaller.size())  
				return alg(k, smaller);
			else if(k > smaller.size() + list.size()) 
				return alg( k -smaller.size()-list.size(),greater);
			else return v;
	}

}
