import java.util.*;
import java.util.Scanner;

public class Dining
{
	public final static int MAX = 1000;


	public static int factor(HashMap<Integer,Integer> instances, ArrayList<Integer> ps, int mins)
	{
		Collections.sort(ps);
		Collections.reverse(ps);

		int check = ps.get(0);
		int best = 0;

		for(int i = 0; i < ps.size(); i++)
		{
			int occ = instances.get(ps.get(i)); 
			int val = ps.get(i);

			// if the number of occurences is < the value of that number
			if(occ < val/2 && val > best+1)
			{
				// Save the number of minutes spent dividing up the pancakes
				mins += occ;

				// Remove all instances of the value since we divided them up
				instances.remove(val);
				ps.set(i, 0);

				// Add in the new value (val/2) to the hash table with all occ (occ*2)
				if(val % 2 != 0)
				{

					if(instances.containsKey(val/2 +1))
						instances.put(val/2 +1,instances.get(val/2+1)+occ);
					else
						instances.put(val/2 +1,occ);

					if(instances.containsKey(val/2))
						instances.put(val/2,instances.get(val/2)+occ);
					else
						instances.put(val/2,occ);

					ps.add(val/2);
					ps.add(val/2 +1);

				}

				else
				{

					if(instances.containsKey(val/2))
						instances.put(val/2,instances.get(val/2) + occ*2);
					else
						instances.put(val/2,occ*2);

					ps.add(val/2);

				}
			}

			else
			{
				if(best < val)
					best = val;
			}
		}

		Collections.sort(ps);
		int retval = mins+ps.get(ps.size()-1);

		if(check < retval)
			return check;
		return retval;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int mins = 0;


		for(int i = 1; i <= cases; i++)
		{
			HashMap<Integer,Integer> instances = new HashMap<Integer, Integer>();
			ArrayList<Integer> ps = new ArrayList<Integer>();
			int ds = sc.nextInt();

			for(int j = 1; j <= ds; j++)
			{
				int x = sc.nextInt();

				if(instances.containsKey(x))
					instances.put(x,instances.get(x)+1);
				else
				{
					instances.put(x,1);
					ps.add(x);
				}
			}

			int high = factor(instances, ps, mins);
			mins += high;
			System.out.println("Case #" + i + ": " + mins);

			ps.clear();
			instances.clear();

			mins = 0;
		}
		sc.close();
	}
}